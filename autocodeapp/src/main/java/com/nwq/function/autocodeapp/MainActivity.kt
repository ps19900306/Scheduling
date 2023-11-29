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
import com.android.schedule.corelibrary.area.CoordinateLine
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.expand.singleClick
import com.android.schedule.corelibrary.img.color_rule.ColorRuleRatioImpl
import com.android.schedule.corelibrary.img.color_rule.CompareDifferenceRuleImpl
import com.android.schedule.corelibrary.img.img_rule.CorrectPositionModel
import com.android.schedule.corelibrary.img.img_rule.FindImgTask
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
            FunctionItemInfo(R.string.find_image_area, BUTTON_TYPE),

            FunctionItemInfo(R.string.preview, BUTTON_TYPE),

            FunctionItemInfo(R.string.merge, BUTTON_TYPE),
            FunctionItemInfo(R.string.image_feature_extraction, BUTTON_TYPE),
            FunctionItemInfo(R.string.characters_feature_extraction, BUTTON_TYPE),
            FunctionItemInfo(R.string.shadow_feature_extraction, BUTTON_TYPE),
            FunctionItemInfo(R.string.rich_color_image_recognition, BUTTON_TYPE),
            FunctionItemInfo(R.string.calculate_space, BUTTON_TYPE),



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
                    bind.optGroup.isVisible = false
                    nowMode = NORMAL_MODE
                    viewModel.preprocessData()
                }
                R.string.find_image_area->{
                    bind.functionGroup.isVisible = true
                    bind.optGroup.isVisible = false
                    nowMode = NORMAL_MODE
                    viewModel.findArea = bind.previewView.oblongArea
                }
                R.string.preview -> {
                    bind.functionGroup.isVisible = true
                    bind.optGroup.isVisible = false
                    nowMode = NORMAL_MODE
                }
                R.string.calculate_space->{
                    bind.functionGroup.isVisible = true
                    bind.optGroup.isVisible = false
                    nowMode = NORMAL_MODE
                    viewModel.builderClickArea(bind.previewView.oblongArea,bind.previewView.lineList)
                }
                R.string.add_rectangle_click_are->{
                    bind.functionGroup.isVisible = true
                    bind.optGroup.isVisible = false
                    nowMode = NORMAL_MODE
                    viewModel.builderClickArea(bind.previewView.oblongArea,bind.previewView.lineList)
                }
                R.string.add_circular_click_are->{
                    bind.functionGroup.isVisible = true
                    bind.optGroup.isVisible = false
                    nowMode = NORMAL_MODE
                    viewModel.builderClickArea(bind.previewView.oblongArea,bind.previewView.lineList)
                }
            }
        }

        bind.addBtn.singleClick {
            when (nowMode) {
                R.string.calculate_space ->{
                    bind.previewView.oblongLine?.let {
                        it.distance  = bind.edit.text.toString().toIntOrNull()?:1
                        bind.previewView.addLine(it)
                    }
                }
                R.string.add_rectangle_click_are ->{
                    nowMode= R.string.calculate_space
                }
                R.string.add_circular_click_are ->{
                    nowMode= R.string.calculate_space
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
                R.string.find_image_area->{
                    bind.functionGroup.isVisible = false
                    bind.btnOk.isVisible = true
                    nowMode = R.string.find_image_area
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
                    viewModel.autoCodeNormalImg(bind.previewView)
                }

                R.string.shadow_feature_extraction -> {

                }

                R.string.rich_color_image_recognition->{
                    viewModel.autoCodeNormalRichImg(bind.previewView)
                }
                R.string.calculate_space->{
                    bind.previewView.setArea(null)
                    bind.previewView.clearLine()
                    bind.functionGroup.isVisible = false
                    bind.optGroup.isVisible = true
                    bind.previewView.invalidate()
                    nowMode = R.string.calculate_space
                }

                R.string.add_rectangle_click_are -> {//矩形点击区域
                    bind.previewView.setArea(null)
                    bind.previewView.clearLine()
                    bind.functionGroup.isVisible = false
                    bind.optGroup.isVisible = true
                    bind.previewView.invalidate()
                    nowMode = R.string.add_rectangle_click_are
                }

                R.string.add_circular_click_are -> {//点击圆形区域
                    bind.previewView.setArea(null)
                    bind.previewView.clearLine()
                    bind.functionGroup.isVisible = false
                    bind.optGroup.isVisible = true
                    bind.previewView.invalidate()
                    nowMode = R.string.add_circular_click_are
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
            R.string.select_critical_area,R.string.find_image_area-> {
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
                        bind.previewView.setArea(coordinateArea)

                        if(R.string.select_critical_area == nowMode){
                            viewModel.coordinateArea = coordinateArea
                        }
                        isFirst = true
                    }
                }
            }
            R.string.calculate_space -> {
                if (isFirst) {
                    if (ev.action == MotionEvent.ACTION_DOWN) {
                        starX = ev.x
                        starY = ev.y
                        isFirst = false
                    }
                } else {
                    if (ev.action == MotionEvent.ACTION_MOVE) {
                        val coordinateLine = CoordinateLine(CoordinatePoint(starX, starY),CoordinatePoint(ev.x, ev.y) )
                        bind.previewView.setLine(coordinateLine)
                    } else if (ev.action == MotionEvent.ACTION_UP) {
                        val coordinateLine = CoordinateLine(CoordinatePoint(starX, starY),CoordinatePoint(ev.x, ev.y) )
                        bind.previewView.setLine(coordinateLine)
                        isFirst = true
                    }
                }
            }
            R.string.add_rectangle_click_are->{
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
                        bind.previewView.setArea(coordinateArea)
                        viewModel.coordinateArea = coordinateArea
                        isFirst = true
                    }
                }
            }
            R.string.add_circular_click_are->{
                if (isFirst) {
                    if (ev.action == MotionEvent.ACTION_DOWN) {
                        starX = ev.x
                        starY = ev.y
                        isFirst = false
                    }
                } else {
                    if (ev.action == MotionEvent.ACTION_MOVE) {
                        val coordinateArea = createCoordinateArea(starX, starY, ev.x, ev.y,true)
                        bind.previewView.setArea(coordinateArea)
                    } else if (ev.action == MotionEvent.ACTION_UP) {
                        val coordinateArea = createCoordinateArea(starX, starY, ev.x, ev.y,true)
                        bind.previewView.setArea(coordinateArea)
                        viewModel.coordinateArea = coordinateArea
                        isFirst = true
                    }
                }
            }

        }
        return super.onTouchEvent(ev)
    }


    private fun createCoordinateArea(x1: Float, y1: Float, x2: Float, y2: Float,b: Boolean = false): CoordinateArea {
        return if (x1 + y1 > x2 + y2) {
            CoordinateArea(x2, y2, x1, y1,b)
        } else {
            CoordinateArea(x1, y1, x2, y2,b)
        }
    }


    val isOpenTask by lazy {
        val tag = "isOpen"
        val list = mutableListOf<PointRule>()
        PointRule(CoordinatePoint(139, 47), ColorRuleRatioImpl.getSimple(225,234,233))
        // sequenceNumber:0 blockNumber: 0  positionType:2
        val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(143, 47), ColorRuleRatioImpl.getSimple(228,234,234))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(139, 50), ColorRuleRatioImpl.getSimple(225,234,233))
            // sequenceNumber:8 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(151, 47), ColorRuleRatioImpl.getSimple(226,235,232))
            // sequenceNumber:16 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(146, 48), ColorRuleRatioImpl.getSimple(226,235,234))
            // sequenceNumber:16 blockNumber: 0  positionType:3
        )
        pointList.add(PointRule(CoordinatePoint(159, 47), ColorRuleRatioImpl.getSimple(226,235,234))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(154, 48), ColorRuleRatioImpl.getSimple(228,234,234))
            // sequenceNumber:24 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(167, 47), ColorRuleRatioImpl.getSimple(227,236,235))
            // sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(162, 48), ColorRuleRatioImpl.getSimple(227,236,235))
            // sequenceNumber:32 blockNumber: 0  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(171, 48), ColorRuleRatioImpl.getSimple(227,236,235))
            // sequenceNumber:41 blockNumber: 0  positionType:2
        )
        pointList.add(TwoPointRule(CoordinatePoint(159, 47),CoordinatePoint(159, 43), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:24sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(139, 59), ColorRuleRatioImpl.getSimple(225,234,233))
            // sequenceNumber:0 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(143, 59), ColorRuleRatioImpl.getSimple(228,234,234))
            // sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(140, 60), ColorRuleRatioImpl.getSimple(228,233,236))
            // sequenceNumber:8 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(151, 59), ColorRuleRatioImpl.getSimple(226,235,232))
            // sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(148, 60), ColorRuleRatioImpl.getSimple(226,235,230))
            // sequenceNumber:16 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(159, 59), ColorRuleRatioImpl.getSimple(226,235,234))
            // sequenceNumber:24 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(156, 60), ColorRuleRatioImpl.getSimple(226,235,234))
            // sequenceNumber:24 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(167, 59), ColorRuleRatioImpl.getSimple(227,236,233))
            // sequenceNumber:32 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(164, 60), ColorRuleRatioImpl.getSimple(227,236,233))
            // sequenceNumber:32 blockNumber: 1  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(172, 59), ColorRuleRatioImpl.getSimple(226,236,235))
            // sequenceNumber:40 blockNumber: 1  positionType:2
        )
        pointList.add(TwoPointRule(CoordinatePoint(159, 59),CoordinatePoint(159, 55), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:24sequenceNumber blockNumber: $1  positionType:$1
        )
        pointList.add(PointRule(CoordinatePoint(139, 70), ColorRuleRatioImpl.getSimple(225,234,233))
            // sequenceNumber:0 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(143, 70), ColorRuleRatioImpl.getSimple(226,235,232))
            // sequenceNumber:8 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(139, 73), ColorRuleRatioImpl.getSimple(224,234,233))
            // sequenceNumber:8 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(150, 73), ColorRuleRatioImpl.getSimple(225,234,233))
            // sequenceNumber:16 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(145, 73), ColorRuleRatioImpl.getSimple(226,235,232))
            // sequenceNumber:16 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(158, 73), ColorRuleRatioImpl.getSimple(225,235,234))
            // sequenceNumber:24 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(153, 73), ColorRuleRatioImpl.getSimple(225,235,234))
            // sequenceNumber:24 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(166, 73), ColorRuleRatioImpl.getSimple(226,235,234))
            // sequenceNumber:32 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(161, 73), ColorRuleRatioImpl.getSimple(225,235,234))
            // sequenceNumber:32 blockNumber: 2  positionType:2
        )
        pointList.add(PointRule(CoordinatePoint(171, 73), ColorRuleRatioImpl.getSimple(226,236,235))
            // sequenceNumber:41 blockNumber: 2  positionType:2
        )
        pointList.add(TwoPointRule(CoordinatePoint(158, 73),CoordinatePoint(158, 77), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:24sequenceNumber blockNumber: $2  positionType:$2
        )
        ImgTaskImpl1(pointList, tag, correctPositionModel)
    }








    val isOpen22Task by lazy {
        val tag = "isOpen"
        val pr  = PointRule(CoordinatePoint(483, 683), ColorRuleRatioImpl.getSimple(146,146,148))
        // sequenceNumber:0 blockNumber: 0  positionType:0
        val findArea = CoordinateArea(465,180,39,776)
        val pointList = mutableListOf<IPR>()
        pointList.add(PointRule(CoordinatePoint(487, 688), ColorRuleRatioImpl.getSimple(170,171,173))
            // sequenceNumber:8 blockNumber: 0  positionType:1
        )
        pointList.add(PointRule(CoordinatePoint(476, 695), ColorRuleRatioImpl.getSimple(155,156,158))
            // sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(484, 695), ColorRuleRatioImpl.getSimple(153,154,156))
            // sequenceNumber:16 blockNumber: 0  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(491, 695), ColorRuleRatioImpl.getSimple(161,161,163))
            // sequenceNumber:23 blockNumber: 0  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(476, 695),CoordinatePoint(477, 693), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:16sequenceNumber blockNumber: $0  positionType:$0
        )
        pointList.add(PointRule(CoordinatePoint(484, 697), ColorRuleRatioImpl.getSimple(125,126,128))
            // sequenceNumber:0 blockNumber: 4  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(479, 704), ColorRuleRatioImpl.getSimple(145,145,145))
            // sequenceNumber:8 blockNumber: 4  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(479, 704),CoordinatePoint(479, 701), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:8sequenceNumber blockNumber: $4  positionType:$4
        )
        pointList.add(PointRule(CoordinatePoint(485, 702), ColorRuleRatioImpl.getSimple(125,126,128))
            // sequenceNumber:0 blockNumber: 7  positionType:0
        )
        pointList.add(PointRule(CoordinatePoint(491, 704), ColorRuleRatioImpl.getSimple(157,157,159))
            // sequenceNumber:7 blockNumber: 7  positionType:0
        )
        pointList.add(TwoPointRule(CoordinatePoint(491, 704),CoordinatePoint(491, 707), CompareDifferenceRuleImpl.getSimple(30,30,30)) // sequenceNumber:7sequenceNumber blockNumber: $7  positionType:$7
        )
        FindImgTask(pr, findArea,pointList, tag)
    }





}



