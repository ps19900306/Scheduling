package com.nwq.function.autocodeapp

import android.content.ClipboardManager
import android.content.Context

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
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.expand.singleClick
import com.android.schedule.corelibrary.img.color_rule.ColorRuleRatioImpl
import com.android.schedule.corelibrary.img.color_rule.CompareDifferenceRuleImpl
import com.android.schedule.corelibrary.img.img_rule.CorrectPositionModel
import com.android.schedule.corelibrary.img.img_rule.ImgTaskImpl1
import com.android.schedule.corelibrary.img.point_rule.IPR
import com.android.schedule.corelibrary.img.point_rule.PointRule
import com.android.schedule.corelibrary.img.point_rule.TwoPointRule
import com.android.schedule.corelibrary.utils.ContextUtil
import com.luck.picture.lib.basic.PictureSelector
import com.luck.picture.lib.config.SelectMimeType
import com.luck.picture.lib.decoration.GridSpacingItemDecoration
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.interfaces.OnResultCallbackListener
import com.nwq.function.autocodeapp.adapter.FeatureKeyAdapter
import com.nwq.function.autocodeapp.adapter.FunctionItemAdapter
import com.nwq.function.autocodeapp.adapter.FunctionItemAdapter.Companion.BUTTON_TYPE
import com.nwq.function.autocodeapp.data.FunctionItemInfo
import com.nwq.function.autocodeapp.databinding.ActivityMainBinding


class MainActivity() : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    lateinit var bind: ActivityMainBinding

    val manager: ClipboardManager by lazy {
        getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    }


    private lateinit var mFunctionItemAdapter: FunctionItemAdapter
    private val functionList by lazy {
        mutableListOf(
            FunctionItemInfo(R.string.full_screen, BUTTON_TYPE),
            FunctionItemInfo(R.string.select_picture, BUTTON_TYPE),
            FunctionItemInfo(R.string.select_critical_area, BUTTON_TYPE),
            FunctionItemInfo(R.string.preview, BUTTON_TYPE),

            FunctionItemInfo(R.string.merge, BUTTON_TYPE),
            FunctionItemInfo(R.string.image_feature_extraction, BUTTON_TYPE),
            FunctionItemInfo(R.string.characters_feature_extraction, BUTTON_TYPE),
            FunctionItemInfo(R.string.shadow_feature_extraction, BUTTON_TYPE),

            FunctionItemInfo(R.string.add_rectangle_click_are, BUTTON_TYPE),
            FunctionItemInfo(R.string.add_circular_click_are, BUTTON_TYPE),
            FunctionItemInfo(R.string.background, BUTTON_TYPE),

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

        viewModel.manager = manager
        ContextUtil.context = applicationContext
        initIndex(controller)
        setContentView(bind.root)

        viewModel.srcBitmap?.let {
            bind.allImg.setImageBitmap(it)
        }

        bind.btnOk.singleClick {
            when (nowMode) {
                R.string.select_critical_area -> {
                    bind.functionGroup.isVisible = true
                    bind.btnOk.isVisible = false
                    nowMode = NORMAL_MODE
                    viewModel.preprocessData()
                }

                R.string.preview -> {
                    bind.functionGroup.isVisible = true
                    bind.btnOk.isVisible = false
                    nowMode = NORMAL_MODE
                }
            }
        }
        viewModel.featureKeyLiveData.observe(this) {
            val mFeatureKeyAdapter =
                FeatureKeyAdapter(viewModel.featureKeyList, viewModel.colorMaps)
            bind.colorRecycler.adapter = mFeatureKeyAdapter
        }


    }


    private fun initIndex(controller: WindowInsetsControllerCompat) {
        val spanCount = 3
        val sd = GridSpacingItemDecoration(spanCount, 8, true)
        //统一处理二个显示的数据
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
                    bind.btnOk.isVisible = true
                    nowMode = R.string.select_critical_area
                }

                R.string.preview -> {
                    bind.functionGroup.isVisible = false
                    bind.btnOk.isVisible = true
                    bind.previewView.invalidate()
                    nowMode = R.string.preview
                }

                R.string.merge -> {
                    viewModel.mergeKey()
                }

                R.string.image_feature_extraction -> {
                    viewModel.autoCodeNormalImg(bind.previewView)
                }

                R.string.characters_feature_extraction -> {

                }

                R.string.shadow_feature_extraction -> {

                }

                R.string.add_rectangle_click_are -> {//矩形点击区域

                }

                R.string.add_circular_click_are -> {//点击圆形区域

                }

                R.string.background->{
                    viewModel.setDarkestFeature()
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
        if (nowMode == NORMAL_MODE) {
            return super.onTouchEvent(ev)
        }
        when (nowMode) {
            R.string.select_critical_area -> {
                if (isFirst) {
                    if (ev.action == MotionEvent.ACTION_DOWN) {
                        starX = ev.x
                        starY = ev.y
                        isFirst = false
                    }
                } else {
                    if (ev.action == MotionEvent.ACTION_MOVE) {
                        val coordinateArea = createCoordinateArea(starX, starY, ev.x, ev.y)
                        bind.previewView.setArea(coordinateArea)
                    } else if (ev.action == MotionEvent.ACTION_UP) {
                        val coordinateArea = createCoordinateArea(starX, starY, ev.x, ev.y)
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


    private fun createCoordinateArea(x1: Float, y1: Float, x2: Float, y2: Float): CoordinateArea {
        return if (x1 + y1 > x2 + y2) {
            CoordinateArea(x2, y2, x1, y1)
        } else {
            CoordinateArea(x1, y1, x2, y2)
        }
    }


    val isOpenTask by lazy {
        val tag = "isOpen"
        val list = mutableListOf<PointRule>()
        PointRule(CoordinatePoint(139, 48), ColorRuleRatioImpl.getSimple(225,234,233))
        // sequenceNumber:0 blockNumber: 0  positionType:2
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(143, 48), ColorRuleRatioImpl.getSimple(226,235,234))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(139, 49), ColorRuleRatioImpl.getSimple(225,234,233))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(151, 47), ColorRuleRatioImpl.getSimple(226,235,232))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(147, 47), ColorRuleRatioImpl.getSimple(226,235,232))
            // sequenceNumber:16 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(159, 47), ColorRuleRatioImpl.getSimple(226,235,234))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(155, 47), ColorRuleRatioImpl.getSimple(226,235,234))
            // sequenceNumber:24 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(170, 47), ColorRuleRatioImpl.getSimple(227,236,235))
            // sequenceNumber:38 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(137, 58), ColorRuleRatioImpl.getSimple(217,240,234))
            // sequenceNumber:0 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(143, 58), ColorRuleRatioImpl.getSimple(224,236,234))
            // sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(141, 61), ColorRuleRatioImpl.getSimple(224,236,236))
            // sequenceNumber:8 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(151, 58), ColorRuleRatioImpl.getSimple(221,236,233))
            // sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(149, 61), ColorRuleRatioImpl.getSimple(222,237,232))
            // sequenceNumber:16 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(159, 58), ColorRuleRatioImpl.getSimple(222,237,234))
            // sequenceNumber:24 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(157, 61), ColorRuleRatioImpl.getSimple(222,237,234))
            // sequenceNumber:24 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(173, 59), ColorRuleRatioImpl.getSimple(220,235,232))
            // sequenceNumber:38 blockNumber: 1  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(137, 68), ColorRuleRatioImpl.getSimple(215,240,236))
            // sequenceNumber:0 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(143, 68), ColorRuleRatioImpl.getSimple(219,238,234))
            // sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(138, 74), ColorRuleRatioImpl.getSimple(217,233,230))
            // sequenceNumber:8 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(150, 71), ColorRuleRatioImpl.getSimple(221,237,234))
            // sequenceNumber:16 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(146, 74), ColorRuleRatioImpl.getSimple(221,231,230))
            // sequenceNumber:16 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(158, 71), ColorRuleRatioImpl.getSimple(221,237,234))
            // sequenceNumber:24 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(154, 74), ColorRuleRatioImpl.getSimple(221,231,232))
            // sequenceNumber:24 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(166, 71), ColorRuleRatioImpl.getSimple(222,238,235))
            // sequenceNumber:32 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(162, 74), ColorRuleRatioImpl.getSimple(222,232,233))
            // sequenceNumber:32 blockNumber: 2  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(173, 72), ColorRuleRatioImpl.getSimple(217,236,232))
            // sequenceNumber:39 blockNumber: 2  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(139, 48),CoordinatePoint(139, 43), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:0sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(TwoPointRule(CoordinatePoint(159, 58),CoordinatePoint(159, 54), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:24sequenceNumber blockNumber: $1  positionType:$1
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }






}



