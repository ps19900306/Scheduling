package com.nwq.function.corelib.auto_code

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.WindowManager
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.luck.picture.lib.basic.PictureSelector
import com.luck.picture.lib.config.SelectMimeType
import com.luck.picture.lib.decoration.GridSpacingItemDecoration
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.interfaces.OnResultCallbackListener
import com.nwq.function.corelib.R
import com.nwq.function.corelib.auto_code.ui.adapter.FunctionItemAdapter
import com.nwq.function.corelib.auto_code.ui.adapter.FunctionItemAdapter.Companion.BUTTON_TYPE
import com.nwq.function.corelib.auto_code.ui.data.FunctionItemInfo
import com.nwq.function.corelib.auto_code.ui.funciton.OptCmd
import com.nwq.function.corelib.databinding.ActivityAutoCodeBinding
import com.nwq.function.corelib.utils.singleClick

class AutoCodeActivity : AppCompatActivity() {

    companion object {
        val NORMAL_MODE = 1   //普通模式
        val PREVIEW_MODE = 2   //预览模式
        val FUNCTION_MODE = 3  //功能模式
    }

    lateinit var bind: ActivityAutoCodeBinding
    private lateinit var mBitmap: Bitmap

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

        initIndex(controller)
    }


    /**
     * 这个是开始设备的页面
     */
    private lateinit var mFunctionItemAdapter: FunctionItemAdapter
    private val functionList by lazy {
        mutableListOf(FunctionItemInfo(R.string.image_feature_extraction, BUTTON_TYPE))
    }

    private fun initIndex(controller: WindowInsetsControllerCompat) {
        bind.indexLayout.fullButton.singleClick {
            controller.hide(WindowInsetsCompat.Type.statusBars()) // 状态栏隐藏
            controller.hide(WindowInsetsCompat.Type.navigationBars())
        }

        bind.indexLayout.selectedImgBtn.singleClick {
            PictureSelector.create(this).openSystemGallery(SelectMimeType.ofImage())
                .forSystemResult(object : OnResultCallbackListener<LocalMedia?> {
                    override fun onResult(result: ArrayList<LocalMedia?>?) {
                        result?.getOrNull(0)?.let {
                            val opts = BitmapFactory.Options()
                            opts.outConfig = Bitmap.Config.ARGB_8888
                            opts.inMutable = true
                            BitmapFactory.decodeFile(it.realPath, opts)?.let {
                                mBitmap = it
                                bind.allImg.setImageBitmap(mBitmap)
                            }
                        }
                    }

                    override fun onCancel() {}
                })
        }


        val spanCount = 3
        val sd = GridSpacingItemDecoration(spanCount, 8, true)
        bind.indexLayout.functionRecycler.layoutManager = GridLayoutManager(this, spanCount)
        mFunctionItemAdapter = FunctionItemAdapter(functionList)
        bind.indexLayout.functionRecycler.adapter = mFunctionItemAdapter
        bind.indexLayout.functionRecycler.addItemDecoration(sd)

        mFunctionItemAdapter.setOnItemClickListener { adapter, view, position ->
            val data = functionList[position]
            when (data.strId) {
                R.string.image_feature_extraction -> {

                }
            }
        }

    }

    /**
     * 这个是开始设备的页面
     */
    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return super.onTouchEvent(ev)
    }



    private var mFunctionBlock: FunctionBlock? = null


}