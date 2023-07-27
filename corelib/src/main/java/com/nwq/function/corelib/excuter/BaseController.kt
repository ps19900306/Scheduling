package com.nwq.function.corelib.excuter

import android.accessibilityservice.AccessibilityService
import android.graphics.Bitmap
import android.os.Build
import android.view.Display
import androidx.annotation.RequiresApi
import com.nwq.function.corelib.Constant
import com.nwq.function.corelib.Constant.clickIntervals
import com.nwq.function.corelib.Constant.fastClickInterval
import com.nwq.function.corelib.Constant.normalClickInterval
import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.click.SimpleClickUtils
import com.nwq.function.corelib.click.task.ClickTask
import com.nwq.function.corelib.img.task.BasicImgTask
import com.nwq.function.corelib.img.task.ImgTask
import com.nwq.function.corelib.img.task.ImgTaskImpl1
import kotlinx.coroutines.delay
import timber.log.Timber
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

/**
create by: 86136
create time: 2023/5/29 17:54
Function description:这里面放控制逻辑
 */

abstract class BaseController(
    val acService: AccessibilityService,
    val endLister: EndLister? = null
) {

    var screenBitmap: Bitmap? = null
    var runSwitch = true
    private val waitTaskTime = 5

    abstract fun startWork(pressBackHome: Boolean = false)

    abstract suspend fun generalControlMethod()

    fun closeWork() {
        runSwitch = false
    }

    protected suspend fun click(coordinateArea: CoordinateArea?) {
        coordinateArea?.let {
            click(it.toClickTask())
        }
    }

    protected suspend fun click(
        listArea: List<CoordinateArea>?,
        offsetX: Int = 0,
        offsetY: Int = 0
    ) {
        if (listArea.isNullOrEmpty())
            return
        var delayTime = 0L
        var clickTime = 0L
        val clickList = listArea.map {
            if (clickTime > 0) {
                delayTime += clickTime + fastClickInterval
            }
            clickTime = clickIntervals
            ClickTask(listOf(it.coordinate), delayTime, clickTime)
        }
        SimpleClickUtils.optClickTasks(acService, offsetX, offsetY, *(clickList.toTypedArray()))
    }

    protected suspend fun click(vararg click: ClickTask) {
        click(0, 0, *click)
    }

    protected suspend fun click(task: ImgTask) {
        task?.getOfsArea()?.clickA()
    }

    protected suspend fun click(task: ImgTask, vararg click: ClickTask) {
        click(task.getOffsetX(), task.getOffsetY(), *click)
    }

    protected suspend fun click(offsetX: Int, offsetY: Int, vararg click: ClickTask) {
        SimpleClickUtils.optClickTasks(acService, offsetX, offsetY, *click)
    }


    protected suspend fun waitImgTask(task: ImgTask, times: Int = waitTaskTime): Boolean {
        var flag = true
        var count = times
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(Constant.normalClickInterval)) {
                runSwitch = false
                return false
            }
            if (task.verificationRule(screenBitmap!!)) {
                task.getOfsArea()?.toClickTask()?.let {
                    click(it)
                }
                return true
            }
            count--
        }
        return false
    }

    protected suspend fun waitImgTask(
        task: ImgTask,
        coordinateArea: CoordinateArea?,
        times: Int = waitTaskTime
    ): Boolean {
        var flag = true
        var count = times
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(Constant.normalClickInterval)) {
                runSwitch = false
                return false
            }
            if (task.verificationRule(screenBitmap!!)) {
                coordinateArea?.toClickTask()?.let {
                    click(it)
                }
                return true
            }
            count--
        }
        return false
    }


    protected suspend fun waitImgTask2(task: ImgTask, times: Int = waitTaskTime): Boolean {
        var flag = true
        var count = times
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(Constant.normalClickInterval)) {
                runSwitch = false
                return false
            }
            if (task.verificationRule(screenBitmap!!)) {
                return true
            } else {
                task.getOfsArea()?.toClickTask()?.let {
                    click(it)
                }
            }
            count--
        }
        return false
    }

    protected suspend fun waitImgTask2(
        task: BasicImgTask,
        coordinateArea: CoordinateArea?,
        times: Int = waitTaskTime
    ): Boolean {
        var flag = true
        var count = times
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(normalClickInterval)) {
                runSwitch = false
                return false
            }
            if (task.verificationRule(screenBitmap!!)) {
                return true
            } else {
                coordinateArea?.toClickTask()?.let {
                    click(it)
                }
            }
            count--
        }
        return false
    }



    protected suspend fun waitImgNotTask(task: ImgTask, times: Int = waitTaskTime): Boolean {
        return waitImgNotTask(task, task.clickArea, times)
    }

    protected suspend fun waitImgNotTask(
        task: ImgTask,
        coordinateArea: CoordinateArea?,
        times: Int = waitTaskTime
    ): Boolean {
        var flag = true
        var count = times
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(Constant.doubleClickInterval)) {
                runSwitch = false
                return false
            }
            if (!task.verificationRule(screenBitmap!!)) {
                return true
            } else {
                coordinateArea?.toClickTask()?.let {
                    click(it)
                }
            }
            count--
        }
        return false
    }

    protected suspend fun waitImgTaskList(
        taskList: Array<ImgTaskImpl1>,
        times: Int = waitTaskTime
    ): List<Int> {
        val list = mutableListOf<Int>()
        var flag = true
        var count = times
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(Constant.doubleClickInterval)) {
                runSwitch = false
                return list
            }
            taskList.forEachIndexed { index, imgTask ->
                if (imgTask.verificationRule(screenBitmap)) {
                    list.add(index)
                }
            }
            if (list.isNotEmpty()) {
                flag = false
            }
            count--
        }
        return list
    }

    protected suspend fun waitImgTask1List2(
        tasks: List<ImgTask>,
        coordinateArea: CoordinateArea?,
        times: Int = waitTaskTime
    ): Boolean {
        var flag = true
        var count = times
        while (flag && count > 0 && runSwitch) {
            if (!takeScreen(Constant.normalClickInterval)) {
                runSwitch = false
                return false
            }
            if (tasks.find { it.verificationRule(screenBitmap!!) } != null) {
                return true
            } else {
                coordinateArea?.toClickTask()?.let {
                    click(it)
                }
            }
            count--
        }
        return false
    }


    //如果截图失败则等待二秒后继续截图
    protected suspend fun takeScreen(delayTime: Long = 0): Boolean {
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
    protected suspend fun takeScreenBitmap(delayTime: Long = 0): Bitmap {
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
        //Timber.d("recycle takeScreen BaseController NWQ_ 2023/3/12");
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
               //     Timber.d("setScreenBitmap onSuccess BaseController NWQ_ 2023/3/12");
                    screenshotResult.hardwareBuffer.close()
                    it.resume(screenBitmap)

                }

                override fun onFailure(i: Int) {
                    Timber.d("  onFailure BaseController NWQ_ 2023/3/12");
                    it.resume(null)
                }
            })
    }


    fun Bitmap.isOrientation(): Boolean {
        return width > height
    }

    fun pressBackBtn() {
        acService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK)
    }

    fun pressHomeBtn() {
        acService.performGlobalAction(AccessibilityService.GLOBAL_ACTION_HOME)
    }

    suspend fun BasicImgTask.check():Boolean{
        return this.verificationRule(screenBitmap)
    }

    suspend fun CoordinateArea.clickA():Unit{
              click(this)
    }


}