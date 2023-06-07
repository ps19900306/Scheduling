package com.nwq.function.corelib.auto_code

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.WindowManager
import androidx.core.view.*
import androidx.recyclerview.widget.GridLayoutManager
import com.luck.picture.lib.basic.PictureSelector
import com.luck.picture.lib.config.SelectMimeType
import com.luck.picture.lib.decoration.GridSpacingItemDecoration
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.interfaces.OnResultCallbackListener
import com.nwq.function.corelib.R
import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.auto_code.ui.adapter.FunctionItemAdapter
import com.nwq.function.corelib.auto_code.ui.adapter.FunctionItemAdapter.Companion.BUTTON_TYPE
import com.nwq.function.corelib.auto_code.ui.data.FunctionItemInfo
import com.nwq.function.corelib.auto_code.ui.funciton.ImgFeatureExtractionFunction
import com.nwq.function.corelib.auto_code.ui.funciton.OptLister
import com.nwq.function.corelib.databinding.ActivityAutoCodeBinding
import com.nwq.function.corelib.utils.singleClick

class AutoCodeActivity : AppCompatActivity(), OptLister {

    companion object {
        val NORMAL_MODE = 1   //普通模式
        val PREVIEW_MODE = 2   //预览模式
        val FUNCTION_MODE = 3  //功能模式

        val CREATE_IMAGE_FEATURE = 11


        val OPT_POINT = 101
        val OPT_AREA = 102
    }

    lateinit var bind: ActivityAutoCodeBinding
    private lateinit var mBitmap: Bitmap
    private var nowMode = NORMAL_MODE

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
        initCoordinateColor()
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
            bind.indexLayout.root.isGone = true
            when (data.strId) {
                R.string.image_feature_extraction -> {
                    nowMode = CREATE_IMAGE_FEATURE
                }
            }
        }

    }

    /**
     * 这个是进行点和区域选取的
     */
    private var starX = 1F
    private var starY = 1F
    private var isFirst = true
    override fun onTouchEvent(ev: MotionEvent): Boolean {
        when (nowMode) {
            CREATE_IMAGE_FEATURE -> {
                if (isFirst) {
                    if (ev.action == MotionEvent.ACTION_DOWN) {
                        starX = ev.x
                        starY = ev.y
                        isFirst = false
                    }
                } else {
                    if (ev.action == MotionEvent.ACTION_MOVE) {
                        bind.previewView.setArea(CoordinateArea(starX, starY, ev.x, ev.y))
                    } else if (ev.action == MotionEvent.ACTION_UP) {
                        bind.previewView.setArea(CoordinateArea(starX, starY, ev.x, ev.y))
                        isFirst = true
                    }
                }
            }
            OPT_POINT -> {
                if (ev.action == MotionEvent.ACTION_UP) {
                    bind.previewView.addDot(CoordinatePoint(ev.x, ev.y))
                }
            }
            OPT_AREA -> {
                if (isFirst) {
                    if (ev.action == MotionEvent.ACTION_DOWN) {
                        starX = ev.x
                        starY = ev.y
                        isFirst = false
                    }
                } else {
                    if (ev.action == MotionEvent.ACTION_MOVE) {
                        bind.previewView.setArea(CoordinateArea(starX, starY, ev.x, ev.y))
                    } else if (ev.action == MotionEvent.ACTION_UP) {
                        bind.previewView.setArea(null)
                        bind.previewView.addArea(CoordinateArea(starX, starY, ev.x, ev.y))
                        isFirst = true
                    }
                }
            }
        }

        return super.onTouchEvent(ev)
    }


    private fun initCoordinateColor() {
        bind.okTv.singleClick {
            when (nowMode) {
                CREATE_IMAGE_FEATURE -> {
                    bind.previewView.oblongArea?.let { coordinateArea ->
                        mFunctionBlock = ImgFeatureExtractionFunction(
                            coordinateArea,
                            coordinateArea.getBitmapPixList(mBitmap),
                            bind.imgFeatureLayout,
                            this
                        )
                        bind.previewView.setArea(null)
                        mFunctionBlock?.showView()
                        bind.okTv.isGone = true
                        nowMode = FUNCTION_MODE
                    }
                }
                OPT_POINT -> {
                    if (bind.previewView.dotList.isNotEmpty()) {
                        mFunctionBlock?.optPoint(cmdInt, *bind.previewView.dotList.toTypedArray())
                        mFunctionBlock?.showView()
                        bind.okTv.isGone = true
                        nowMode = FUNCTION_MODE
                    }
                }
                OPT_AREA -> {
                    if (bind.previewView.areaList.isNotEmpty()) {
                        mFunctionBlock?.optArea(cmdInt, *bind.previewView.areaList.toTypedArray())
                        mFunctionBlock?.showView()
                        bind.okTv.isGone = true
                        nowMode = FUNCTION_MODE
                    }
                }
            }
        }
    }


    private var cmdInt = 0

    /***
     * 这个是暴露给
     */
    override fun optPoint(cmd: Int) {
        mFunctionBlock?.hideView()
        nowMode = OPT_POINT
        bind.okTv.isVisible = true
        bind.previewView.clearPoint()
        cmdInt = cmd
    }

    override fun requestArea(cmd: Int) {
        mFunctionBlock?.hideView()
        nowMode = OPT_AREA
        bind.okTv.isVisible = true
        bind.previewView.clearArea()
        cmdInt = cmd
    }


    override fun showPoint(list: List<CoordinatePoint>) {
        mFunctionBlock?.hideView()
        bind.previewView.setPointList(list)
    }

    override fun getPointColor(x: Int, y: Int): Int {
        return mBitmap.getPixel(x, y)
    }

    override fun getPointColor(x: Int, y: Int, width: Int, height: Int): IntArray {
        val array = IntArray(width * height)
        mBitmap.getPixels(array, 0, width, x, y, width, height)
        return array
    }


    private var mFunctionBlock: FunctionBlock? = null

}