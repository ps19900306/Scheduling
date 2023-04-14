package com.nwq.function.scheduling.auto_code.ui

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.*
import android.view.MotionEvent.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.luck.picture.lib.basic.PictureSelector
import com.luck.picture.lib.config.SelectMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.interfaces.OnResultCallbackListener
import com.nwq.function.scheduling.core_code.Area
import com.nwq.function.scheduling.core_code.Coordinate
import com.nwq.function.scheduling.databinding.ActivityAutoCodeBinding
import com.nwq.function.scheduling.utils.singleClick
import timber.log.Timber


class AutoCodeActivity : AppCompatActivity() {

    lateinit var bind: ActivityAutoCodeBinding
    private lateinit var mBitmap: Bitmap
    private lateinit var mBitmapName: String


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
    }

    override fun onResume() {
        super.onResume()
    }


    private var starX = 1F
    private var starY = 1F
    private var isFirst = true


    override fun onTouchEvent(ev: MotionEvent): Boolean {
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
                bind.operateUiView.setArea(Area(starX, starY, ev.x, ev.y))
                isFirst = true
            }
        }

//        val int = mBitmap.getPixel(ev.x.toInt(), ev.y.toInt())
//        Timber.d("x:${ev.x} y:${ev.y}   red:${int.red}  green:${int.green}  blue:${int.blue} onTouchEvent AutoCodeActivity NWQ_ 2023/4/14");
//        bind.operateUiView.addDot(Coordinate(ev.x.toInt(), ev.y.toInt()))
        return super.onTouchEvent(ev)
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        return super.dispatchTouchEvent(ev)
    }


}