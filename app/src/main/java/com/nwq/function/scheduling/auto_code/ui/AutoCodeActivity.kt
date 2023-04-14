package com.nwq.function.scheduling.auto_code.ui

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.view.MotionEvent.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.*
import com.luck.picture.lib.basic.PictureSelector
import com.luck.picture.lib.config.SelectMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.interfaces.OnResultCallbackListener
import com.nwq.function.scheduling.auto_code.task.MultiPointColorTask
import com.nwq.function.scheduling.core_code.Area
import com.nwq.function.scheduling.core_code.Coordinate
import com.nwq.function.scheduling.databinding.ActivityAutoCodeBinding
import com.nwq.function.scheduling.utils.FileUtils
import com.nwq.function.scheduling.utils.singleClick
import timber.log.Timber


class AutoCodeActivity : AppCompatActivity() {

    lateinit var bind: ActivityAutoCodeBinding
    private lateinit var mBitmap: Bitmap
    private lateinit var mBitmapName: String
    private var nowMode = normalMode
    private var mMultiPointColorTask: MultiPointColorTask? = null

    companion object {
        val normalMode = 1   //普通模式
        val previewMode = 2   //预览模式
        val singlePonitMode = 11  //单点模式
        val twoPonitMode = 12     //双点对比模式
        val alongMode = 13       //边框模式
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.hide(WindowInsetsCompat.Type.statusBars()) // 状态栏隐藏
        controller.hide(WindowInsetsCompat.Type.navigationBars())
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val params = window.attributes
        params.layoutInDisplayCutoutMode =
            WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
        window.attributes = params

        bind = ActivityAutoCodeBinding.inflate(LayoutInflater.from(this))
        setContentView(bind.root)

        bind.selectedImgBtn.singleClick {
            PictureSelector.create(this)
                .openSystemGallery(SelectMimeType.ofImage())
                .forSystemResult(object : OnResultCallbackListener<LocalMedia?> {
                    override fun onResult(result: ArrayList<LocalMedia?>?) {
                        result?.getOrNull(0)?.let {
                            mBitmapName = it.fileName
                            val opts = BitmapFactory.Options()
                            opts.outConfig = Bitmap.Config.ARGB_8888
                            opts.inMutable = true
                            BitmapFactory.decodeFile(it.realPath, opts)?.let {
                                mBitmap = it
                                bind.negativeImg.setImageBitmap(mBitmap)
                            }
                        }
                    }

                    override fun onCancel() {}
                })
        }

        bind.fullButton.singleClick {
            controller.hide(WindowInsetsCompat.Type.statusBars()) // 状态栏隐藏
            controller.hide(WindowInsetsCompat.Type.navigationBars())
        }


        bind.startBtn.singleClick {
            val methodName = bind.methodEdit.text.toString().trim()
            val describeInfo = bind.describeEdit.text.toString().trim()
            if (TextUtils.isEmpty(methodName)) {
                return@singleClick
            }
            mMultiPointColorTask = MultiPointColorTask(methodName, mBitmapName, describeInfo)
            nowMode = previewMode
            bind.normalUiGroup.isGone = true
            bind.previewUiGroup.isVisible = true
        }


        bind.singleBtn.singleClick {
            bind.operateUiView.setShowFlag(true)
            nowMode = singlePonitMode
            bind.previewUiGroup.isGone = true
        }

        bind.twoBtn.singleClick {
            bind.operateUiView.setShowFlag(true)
            nowMode = twoPonitMode
            bind.previewUiGroup.isGone = true
        }

        bind.areaBtn.singleClick {
            bind.operateUiView.setShowFlag(true)
            nowMode = alongMode
            bind.previewUiGroup.isGone = true
        }

        bind.accomplishBtn.singleClick {
            bind.previewUiGroup.isGone = true
            bind.normalUiGroup.isVisible = true
            nowMode = normalMode
            bind.operateUiView.setShowFlag(false)
            mMultiPointColorTask?.buildResultString()?.let {
                bind.resultTv.text = it
                FileUtils.writeFile(it)
                Timber.d("$it ResultString AutoCodeActivity NWQ_ 2023/4/14");
            }
        }
    }


    override fun onBackPressed() {
        if (nowMode in 10..20) {
            nowMode = previewMode
            bind.previewUiGroup.isVisible = true
            bind.operateUiView.setShowFlag(false)
        } else {
            super.onBackPressed()
        }
    }


    override fun onResume() {
        super.onResume()
    }

    private var starX = 1F
    private var starY = 1F
    private var isFirst = true

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        when (nowMode) {
            singlePonitMode -> {
                if (ev.action == ACTION_UP) {
                    val int = mBitmap.getPixel(ev.x.toInt(), ev.y.toInt())
                    val coordinate = Coordinate(ev.x.toInt(), ev.y.toInt())
                    bind.operateUiView.addDot(coordinate)
                    mMultiPointColorTask?.addSinglePoint(coordinate, int)
                }
            }
            twoPonitMode -> {
                if (ev.action == ACTION_UP) {
                    val int = mBitmap.getPixel(ev.x.toInt(), ev.y.toInt())
                    val coordinate = Coordinate(ev.x.toInt(), ev.y.toInt())
                    bind.operateUiView.addDot(coordinate)
                    mMultiPointColorTask?.addTwoPoint(coordinate, int)
                }
            }
            alongMode -> {
                if (isFirst) {
                    if (ev.action == ACTION_DOWN) {
                        starX = ev.x
                        starY = ev.y
                        isFirst = false
                    }
                } else {
                    if (ev.action == ACTION_MOVE) {
                        bind.operateUiView.setArea(Area(starX, starY, ev.x, ev.y))
                    } else if (ev.action == ACTION_UP) {
                        val area = Area(starX, starY, ev.x, ev.y)
                        bind.operateUiView.setArea(area)
                        isFirst = true
                        mMultiPointColorTask?.clickArea = area
                    }
                }
            }
        }
        return super.onTouchEvent(ev)
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        return super.dispatchTouchEvent(ev)
    }


}