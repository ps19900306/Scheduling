package com.nwq.function.autocodeapp

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.expand.singleClick
import com.luck.picture.lib.basic.PictureSelector
import com.luck.picture.lib.config.SelectMimeType
import com.luck.picture.lib.decoration.GridSpacingItemDecoration
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.interfaces.OnResultCallbackListener
import com.nwq.function.autocodeapp.adapter.FunctionItemAdapter
import com.nwq.function.autocodeapp.adapter.FunctionItemAdapter.Companion.BUTTON_TYPE
import com.nwq.function.autocodeapp.data.FunctionItemInfo
import com.nwq.function.autocodeapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    lateinit var bind: ActivityMainBinding

    private lateinit var mFunctionItemAdapter: FunctionItemAdapter
    private val functionList by lazy {
        mutableListOf(
            FunctionItemInfo(R.string.full_screen, BUTTON_TYPE),
            FunctionItemInfo(R.string.select_picture, BUTTON_TYPE),
            FunctionItemInfo(R.string.select_critical_area, BUTTON_TYPE),
            FunctionItemInfo(R.string.preview, BUTTON_TYPE),
            FunctionItemInfo(R.string.image_feature_extraction, BUTTON_TYPE),
            FunctionItemInfo(R.string.characters_feature_extraction, BUTTON_TYPE),
            FunctionItemInfo(R.string.shadow_feature_extraction, BUTTON_TYPE),

            FunctionItemInfo(R.string.add_rectangle_click_are, BUTTON_TYPE),
            FunctionItemInfo(R.string.add_circular_click_are, BUTTON_TYPE),

            )
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

        bind = ActivityMainBinding.inflate(LayoutInflater.from(this))

        initIndex(controller)
        setContentView(bind.root)

        viewModel.srcBitmap?.let {
            bind.allImg.setImageBitmap(it)
        }

        bind.btnOk.singleClick {
            when (nowMode) {
                R.string.select_critical_area->{
                    bind.functionGroup.isVisible = true
                    bind.btnOk.isVisible = false
                    nowMode = NORMAL_MODE
                }
            }
        }
    }



    private fun initIndex(controller: WindowInsetsControllerCompat) {
        val spanCount = 3
        val sd = GridSpacingItemDecoration(spanCount, 8, true)
        bind.functionRecycler.layoutManager = GridLayoutManager(this, spanCount)
        mFunctionItemAdapter = FunctionItemAdapter(functionList)
        bind.functionRecycler.adapter = mFunctionItemAdapter
        bind.functionRecycler.addItemDecoration(sd)

        mFunctionItemAdapter.setOnItemClickListener { adapter, view, position ->
            val data = functionList[position]
            when (data.strId) {
                R.string.full_screen -> {
                    controller.hide(WindowInsetsCompat.Type.statusBars()) // 状态栏隐藏
                    controller.hide(WindowInsetsCompat.Type.navigationBars())
                }
                R.string.select_picture -> {
                    PictureSelector.create(this).openSystemGallery(SelectMimeType.ofImage())
                        .forSystemResult(object : OnResultCallbackListener<LocalMedia?> {
                            override fun onResult(result: ArrayList<LocalMedia?>?) {
                                result?.getOrNull(0)?.let {
                                    val opts = BitmapFactory.Options()
                                    opts.outConfig = Bitmap.Config.ARGB_8888
                                    opts.inMutable = true
                                    BitmapFactory.decodeFile(it.realPath, opts)?.let {
                                        viewModel.srcBitmap = it
                                        bind.allImg.setImageBitmap(it)
                                    }
                                }
                            }

                            override fun onCancel() {}
                        })
                }
                R.string.select_critical_area -> {//这里选择关键区域
                    bind.functionGroup.isVisible = false
                    bind.btnOk.isVisible=true
                    nowMode= R.string.select_critical_area
                }
                R.string.preview->{

                }

                R.string.image_feature_extraction -> {

                }
                R.string.characters_feature_extraction -> {

                }
                R.string.shadow_feature_extraction -> {

                }
                R.string.add_rectangle_click_are -> {//矩形点击区域

                }
                R.string.add_circular_click_are -> {//点击圆形区域

                }

            }
        }
    }




    companion object {
        val NORMAL_MODE = Int.MAX_VALUE   //普通模式
    }

    /**
     * 这个是进行点和区域选取的
     */
    private var starX = 1F
    private var starY = 1F
    private var isFirst = true
    private var nowMode = NORMAL_MODE

    override fun onTouchEvent(ev: MotionEvent): Boolean {
        if(nowMode == NORMAL_MODE){
            return super.onTouchEvent(ev)
        }
        when (nowMode) {
            R.string.select_critical_area->{
                if (isFirst) {
                    if (ev.action == MotionEvent.ACTION_DOWN) {
                        starX = ev.x
                        starY = ev.y
                        isFirst = false
                    }
                } else {
                    if (ev.action == MotionEvent.ACTION_MOVE) {
                        val coordinateArea= createCoordinateArea(starX, starY, ev.x, ev.y)
                        bind.previewView.setArea(coordinateArea)
                    } else if (ev.action == MotionEvent.ACTION_UP) {
                        val coordinateArea= createCoordinateArea(starX, starY, ev.x, ev.y)
                        bind.previewView.setArea(null)
                        bind.previewView.addArea(coordinateArea)
                        viewModel.coordinateArea = coordinateArea
                        isFirst = true
                    }
                }
            }
        }
        return super.onTouchEvent(ev)
    }


    private fun createCoordinateArea(x1: Float, y1: Float, x2: Float, y2: Float):CoordinateArea {
        return  if(x1+x1 > x2+y2){
            CoordinateArea(x2,y2,x1,y1)
        }else{
            CoordinateArea(x1,y1, x2,y2)
        }
    }


}



