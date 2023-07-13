package com.nwq.function.corelib.excuter

import android.accessibilityservice.AccessibilityService
import android.graphics.Bitmap
import android.os.Build
import android.view.Display
import androidx.annotation.RequiresApi
import com.nwq.function.corelib.Constant
import com.nwq.function.corelib.click.SimpleClickUtils
import com.nwq.function.corelib.click.task.ClickTask
import com.nwq.function.corelib.img.task.ImgTask
import kotlinx.coroutines.delay
import timber.log.Timber
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
create by: 86136
create time: 2023/5/29 17:54
Function description:这里面放控制逻辑
 */

abstract class BaseController(val acService: AccessibilityService,val endLister: EndLister?=null) {

    var screenBitmap: Bitmap? = null
    var runSwitch = true


    abstract fun startWork()

    fun closeWork() {
        runSwitch = false
    }

    protected suspend fun click(vararg click: ClickTask) {
        click(0, 0, *click)
    }

    protected suspend fun click(task: ImgTask, vararg click: ClickTask) {
        click(task.getOffsetX(), task.getOffsetY(), *click)
    }

    protected suspend fun click(offsetX: Int, offsetY: Int, vararg click: ClickTask) {
        SimpleClickUtils.optClickTasks(acService, offsetX, offsetY, *click)
    }


    protected suspend fun waitImgTask(task: ImgTask, times: Int = 3): Boolean {
        var flag = true
        var count = times
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(Constant.normalClickInterval)) {
                runSwitch = false
                return false
            }
            if (task.verificationRule(screenBitmap!!)) {
                task?.clickArea?.toClickTask()?.let {
                    click(it)
                }
                return true
            }
            count--
        }
        return false
    }

    protected suspend fun waitImgTask2(task: ImgTask, times: Int = 3): Boolean {
        var flag = true
        var count = times
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(Constant.normalClickInterval)) {
                runSwitch = false
                return false
            }
            if (task.verificationRule(screenBitmap!!)) {
                return true
            }else{
                task?.clickArea?.toClickTask()?.let {
                    click(it)
                }
            }
            count--
        }
        return false
    }

    protected suspend fun waitImgNotTask(task: ImgTask, times: Int = 3): Boolean {
        var flag = true
        var count = times
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(Constant.doubleClickInterval)) {
                runSwitch = false
                return false
            }
            if (task.verificationRule(screenBitmap!!)) {
                return true
            }else{
                task?.clickArea?.toClickTask()?.let {
                    click(it)
                }
            }
            count--
        }
        return false
    }


    //如果截图失败则等待二秒后继续截图
    protected suspend fun takeScreen(delayTime: Long=0): Boolean {
        if (delayTime > 0) {
            delay(delayTime)
        }
        var bitmap: Bitmap? = null
        do {
            bitmap = takeScreenShot()
            if (bitmap == null) {
                delay(2000)
            }
        } while (bitmap == null)
        return bitmap.width > bitmap.height
    }


    //获取图片不管高和宽
    protected suspend fun takeScreenBitmap(delayTime: Long=0):Bitmap {
        if (delayTime > 0) {
            delay(delayTime)
        }
        var bitmap: Bitmap? = null
        do {
            bitmap = takeScreenShot()
            if (bitmap == null) {
                delay(2000)
            }
        } while (bitmap == null)
        return bitmap
    }


    //这通过系统获取截图
    @RequiresApi(Build.VERSION_CODES.R)
    private suspend fun takeScreenShot(): Bitmap? = suspendCoroutine {
        screenBitmap?.recycle()
        screenBitmap = null
        Timber.d("recycle takeScreen AccessibilityHelper NWQ_ 2023/3/12");
        acService.takeScreenshot(
            Display.DEFAULT_DISPLAY,
            acService.mainExecutor,
            object : AccessibilityService.TakeScreenshotCallback {
                override fun onSuccess(screenshotResult: AccessibilityService.ScreenshotResult) {
                    val bitmap = Bitmap.wrapHardwareBuffer(
                        screenshotResult.hardwareBuffer, screenshotResult.colorSpace
                    )
                    screenBitmap = bitmap?.copy(Bitmap.Config.ARGB_8888, true)
                    bitmap?.recycle()
                    Timber.d("setScreenBitmap onSuccess AccessibilityHelper NWQ_ 2023/3/12");
                    it.resume(screenBitmap)
                }

                override fun onFailure(i: Int) {
                    Timber.d("  onFailure AccessibilityHelper NWQ_ 2023/3/12");
                    it.resume(null)
                }
            })
    }


    fun Bitmap.isOrientation():Boolean{
        return width>height
    }

    fun pressBackBtn() {
        acService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK)
    }

    fun pressHomeBtn() {
        acService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_HOME)
    }
}