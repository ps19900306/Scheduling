package com.nwq.function.autocodeapp

import android.content.ClipboardManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.projection.MediaProjectionManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.WindowManager
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.area.CoordinateLine
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.controller.ImageTakeUtils
import com.android.schedule.corelibrary.expand.runOnUI
import com.android.schedule.corelibrary.expand.singleClick
import com.android.schedule.corelibrary.utils.ContextUtil
import com.android.schedule.corelibrary.utils.L
import com.android.schedule.corelibrary.utils.NwqCallBack
import com.android.schedule.corelibrary.xiaomi.XiaoMiEnvironment
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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.nio.ByteBuffer


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
            // FunctionItemInfo(R.string.select_picture, BUTTON_TYPE),
            FunctionItemInfo(R.string.start_screen, BUTTON_TYPE),

            FunctionItemInfo(R.string.select_critical_area, BUTTON_TYPE),
            FunctionItemInfo(R.string.find_image_area, BUTTON_TYPE),
            FunctionItemInfo(R.string.clear_find_image_area, BUTTON_TYPE),


            FunctionItemInfo(R.string.preview, BUTTON_TYPE),
            FunctionItemInfo(R.string.preview1, BUTTON_TYPE),


            FunctionItemInfo(R.string.merge, BUTTON_TYPE),
            FunctionItemInfo(R.string.image_feature_extraction, BUTTON_TYPE),
            FunctionItemInfo(R.string.characters_feature_extraction, BUTTON_TYPE),
            FunctionItemInfo(R.string.all_feature_extraction, BUTTON_TYPE),
            FunctionItemInfo(R.string.shadow_feature_extraction, BUTTON_TYPE),
            FunctionItemInfo(R.string.rich_color_image_recognition, BUTTON_TYPE),
            FunctionItemInfo(R.string.calculate_space, BUTTON_TYPE),


            FunctionItemInfo(R.string.add_rectangle_click_are, BUTTON_TYPE),
            FunctionItemInfo(R.string.add_circular_click_are, BUTTON_TYPE),
            FunctionItemInfo(R.string.background, BUTTON_TYPE),
            FunctionItemInfo(R.string.test_pick_up_points, BUTTON_TYPE),


            //      FunctionItemInfo(R.string.test_pick_up_points1, BUTTON_TYPE),

            FunctionItemInfo(R.string.take_img, BUTTON_TYPE),
            FunctionItemInfo(R.string.replace_img, BUTTON_TYPE),

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

                R.string.find_image_area -> {
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

                R.string.preview1 -> {
                    bind.functionGroup.isVisible = true
                    bind.optGroup.isVisible = false
                    nowMode = NORMAL_MODE
                }

                R.string.calculate_space -> {
                    bind.functionGroup.isVisible = true
                    bind.optGroup.isVisible = false
                    nowMode = NORMAL_MODE

                    if (bind.previewView.oblongArea == null && bind.previewView.lineList.isEmpty() && bind.previewView.oblongLine != null) {
                        bind.previewView.oblongLine!!.distance = 1
                        viewModel.builderClickArea(
                            bind.previewView.oblongArea,
                            listOf(bind.previewView.oblongLine!!)
                        )
                    } else {
                        viewModel.builderClickArea(
                            bind.previewView.oblongArea,
                            bind.previewView.lineList
                        )
                    }
                }

                R.string.add_rectangle_click_are -> {
                    bind.functionGroup.isVisible = true
                    bind.optGroup.isVisible = false
                    nowMode = NORMAL_MODE
                    viewModel.builderClickArea(
                        bind.previewView.oblongArea,
                        bind.previewView.lineList
                    )
                }

                R.string.add_circular_click_are -> {
                    bind.functionGroup.isVisible = true
                    bind.optGroup.isVisible = false
                    nowMode = NORMAL_MODE
                    viewModel.builderClickArea(
                        bind.previewView.oblongArea,
                        bind.previewView.lineList
                    )
                }

            }
        }

        bind.addBtn.singleClick {
            when (nowMode) {
                R.string.calculate_space -> {
                    bind.previewView.oblongLine?.let {
                        it.distance = bind.edit.text.toString().toIntOrNull() ?: 1
                        bind.previewView.addLine(it)
                    }
                }

                R.string.add_rectangle_click_are -> {
                    bind.edit.isVisible = true
                    nowMode = R.string.calculate_space
                }

                R.string.add_circular_click_are -> {
                    bind.edit.isVisible = true
                    nowMode = R.string.calculate_space
                }
            }
        }

        viewModel.featureKeyLiveData.observe(this) {
            val mFeatureKeyAdapter =
                FeatureKeyAdapter(viewModel.featureKeyList, viewModel.colorMaps)
            bind.colorRecycler.adapter = mFeatureKeyAdapter
        }
    }


    private val requestDataLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                result.data?.let {
                    ImageTakeUtils.startRecord(
                        mMediaProjectionManager!!, result.resultCode, it,
                        Handler(Looper.getMainLooper()), resources.displayMetrics
                    )
                }
            }
        }


    private var mMediaProjectionManager: MediaProjectionManager? = null
    private val REQUEST_MEDIA_PROJECTION = 124
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

                R.string.start_screen -> {
                    mMediaProjectionManager =
                        getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager?;
                    mMediaProjectionManager?.createScreenCaptureIntent()?.let {
                        requestDataLauncher.launch(it)
                    }
                }

                R.string.select_critical_area -> {//这里选择关键区域
                    bind.functionGroup.isVisible = false
                    bind.btnOk.isVisible = true
                    nowMode = R.string.select_critical_area
                }

                R.string.find_image_area -> {
                    bind.functionGroup.isVisible = false
                    bind.btnOk.isVisible = true
                    nowMode = R.string.find_image_area
                }

                R.string.clear_find_image_area -> {
                    viewModel.findArea = null
                }

                R.string.preview -> {
                    bind.previewView.setWatchDotList(listOf())
                    bind.functionGroup.isVisible = false
                    bind.btnOk.isVisible = true
                    bind.previewView.invalidate()
                    nowMode = R.string.preview
                }

                R.string.preview1 -> {
                    bind.functionGroup.isVisible = false
                    bind.btnOk.isVisible = true
                    val list = mutableListOf<CoordinatePoint>()
                    viewModel.colorMaps.forEach { t, u ->
                        if (t.isChecked) {
                            u.forEach {
                                list.add(CoordinatePoint(it.x, it.y))
                            }
                        }
                    }
                    bind.previewView.setWatchDotList(list)
                    bind.previewView.invalidate()
                    nowMode = R.string.preview1
                }

                R.string.merge -> {
                    viewModel.mergeKey()
                }

                R.string.image_feature_extraction -> {
                    viewModel.autoCodeNormalImg(
                        bind.previewView,
                        false,
                        bind.taskNameEdit.text.toString()
                    )
                    bind.taskNameEdit.setText("")
                }

                R.string.characters_feature_extraction -> {
                    viewModel.autoCodeNormalImg(
                        bind.previewView,
                        true,
                        bind.taskNameEdit.text.toString()
                    )
                    bind.taskNameEdit.setText("")
                }

                R.string.all_feature_extraction -> {
                    viewModel.allFeatureExtraction(
                        bind.previewView,
                        true,
                        bind.taskNameEdit.text.toString()
                    )
                    bind.taskNameEdit.setText("")
                }

                R.string.shadow_feature_extraction -> {

                }

                R.string.rich_color_image_recognition -> {
                    viewModel.autoCodeNormalRichImg(bind.previewView)
                }

                R.string.calculate_space -> {
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
                    bind.edit.isGone = true
                    bind.previewView.invalidate()
                    nowMode = R.string.add_rectangle_click_are
                }

                R.string.add_circular_click_are -> {//点击圆形区域
                    bind.previewView.setArea(null)
                    bind.previewView.clearLine()
                    bind.functionGroup.isVisible = false
                    bind.optGroup.isVisible = true
                    bind.edit.isGone = true
                    bind.previewView.invalidate()
                    nowMode = R.string.add_circular_click_are
                }

                R.string.background -> {
                    viewModel.setDarkestFeature()
                }

                R.string.test_pick_up_points -> {
                    checkCode()
                }

                R.string.take_img -> {
                    issueInstructionsImg()
                }

                R.string.replace_img -> {
                    viewModel.srcBitmap?.let {
                        bind.allImg.setImageBitmap(it)
                    }
                }

                R.string.test_pick_up_points1 -> {
                    PictureSelector.create(this).openSystemGallery(SelectMimeType.ofImage())
                        .forSystemResult(object : OnResultCallbackListener<LocalMedia?> {
                            override fun onResult(result: ArrayList<LocalMedia?>?) {
                                val list = mutableListOf<Bitmap>()
                                result?.forEach {
                                    it?.let {
                                        val opts = BitmapFactory.Options()
                                        opts.outConfig = Bitmap.Config.ARGB_8888
                                        opts.inMutable = true
                                        BitmapFactory.decodeFile(it.realPath, opts)?.let {
                                            list.add(it)
                                        }
                                    }
                                }
                                checkCodeMulImg(list)
                            }

                            override fun onCancel() {}
                        })
                }

            }
        }
    }


    //desX:420 desY:0  distance1 desX:846 desY:3  distance2desX:1266 desY:7  distance3
    val standardDistance = 422

    companion object {
        val NORMAL_MODE = Int.MAX_VALUE   //普通模式
        const val Intent_Filter_TAG = "schedule.autocode.img"
        const val TAKE_IMG = "take_img"
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
            R.string.select_critical_area, R.string.find_image_area -> {
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

                        if (R.string.select_critical_area == nowMode) {
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
                        val coordinateLine = CoordinateLine(
                            CoordinatePoint(starX, starY),
                            CoordinatePoint(ev.x, ev.y)
                        )
                        bind.previewView.setLine(coordinateLine)
                    } else if (ev.action == MotionEvent.ACTION_UP) {
                        val coordinateLine = CoordinateLine(
                            CoordinatePoint(starX, starY),
                            CoordinatePoint(ev.x, ev.y)
                        )
                        bind.previewView.setLine(coordinateLine)
                        isFirst = true
                    }
                }
            }

            R.string.add_rectangle_click_are -> {
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

            R.string.add_circular_click_are -> {
                if (isFirst) {
                    if (ev.action == MotionEvent.ACTION_DOWN) {
                        starX = ev.x
                        starY = ev.y
                        isFirst = false
                    }
                } else {
                    if (ev.action == MotionEvent.ACTION_MOVE) {
                        val coordinateArea = createCoordinateArea(starX, starY, ev.x, ev.y, true)
                        bind.previewView.setArea(coordinateArea)
                    } else if (ev.action == MotionEvent.ACTION_UP) {
                        val coordinateArea = createCoordinateArea(starX, starY, ev.x, ev.y, true)
                        bind.previewView.setArea(coordinateArea)
                        viewModel.coordinateArea = coordinateArea
                        isFirst = true
                    }
                }
            }

        }
        return super.onTouchEvent(ev)
    }


    private fun createCoordinateArea(
        x1: Float,
        y1: Float,
        x2: Float,
        y2: Float,
        b: Boolean = false
    ): CoordinateArea {
        return if (x1 + y1 > x2 + y2) {
            CoordinateArea(x2, y2, x1, y1, b)
        } else {
            CoordinateArea(x1, y1, x2, y2, b)
        }
    }


    private fun checkCode() {
        val en = StarWarEnvironment()
        viewModel.srcBitmap?.let {
            lifecycleScope.launch(Dispatchers.IO) {
//                en.isVegetableShipList.forEach { task->
//                    if (task.verificationRule(it)) {
//                        runOnUI {
//                            bind.previewView.clearPoint()
//                            bind.previewView.clearArea()
//                            val offsetX = task.getOffsetX()
//                            val offsetY = task.getOffsetY()
//                            task.iprList.forEach {
//                                it.getCoordinatePoint().apply {
//                                    bind.previewView.addDot(CoordinatePoint(xI + offsetX, yI + offsetY))
//                                }
//                            }
//                            L.t("找到图片 ${task.tag} offsetX$offsetX  offsetY$offsetY")
//                        }
//                    }else{
//                        L.t("验证失败 ${task.tag}")
//                    }
//                }


//                val clickArea = en.isOpenTask
//                val task = if (en.isOpenShipMenu2Task.verificationRule(it)) {
//                    en.isOpenTask.copyOffset("修正的",en.isOpenShipMenu2Task.getOffsetX(),en.isOpenShipMenu2Task.getOffsetY())
//                } else {
//                    en.isOpenTask
//                }


                val task = XiaoMiEnvironment.isChangWankaTask
                task.logColor(it)
                task.clickArea = XiaoMiEnvironment.homeGameCenterArea
                if (task.verificationRule(it)) {
                    runOnUI {
                        bind.previewView.clearPoint()
                        bind.previewView.clearArea()
                        val offsetX = task.getOffsetX()
                        val offsetY = task.getOffsetY()
                        task.iprList.forEach {
                            it.getCoordinatePoint().apply {
                                bind.previewView.addDot(CoordinatePoint(xI + offsetX, yI + offsetY))
                            }
                        }
                        L.t("找到图片 offsetX$offsetX  offsetY$offsetY")
                        task.clickArea?.let {
                            bind.previewView.addArea(it.copyOffset(offsetX, offsetY))
                        }
                    }
                } else {
                    L.t("验证失败")
                }
            }
        }
    }

    private fun checkCodeMulImg(list: MutableList<Bitmap>) {
        val en = StarWarEnvironment()
        lifecycleScope.launch(Dispatchers.IO) {
            var faildIndex = -1;
            list.forEachIndexed { index, bitmap ->
                val task = en.isCloseAiTask
                if (!task.verificationRule(bitmap)) {
                    L.t("index  验证失败")
                    faildIndex = faildIndex
                } else {
                    L.t("index  验证通过")
                }
            }
            if (faildIndex >= 0) {
                runOnUI {
                    list.getOrNull(faildIndex)?.let {
                        viewModel.srcBitmap = it
                        bind.allImg.setImageBitmap(it)
                    }
                }
            } else {
                L.t("index  验证通过")
            }
        }
    }


    private val onTakeIng =
        NwqCallBack<Bitmap?> { t ->
            L.t("截图成功")
            if (t == null) {
                L.t("图片为空")
            } else {
                // viewModel.srcBitmap?.recycle()
                viewModel.srcBitmap = t
            }
        }


    private fun issueInstructionsImg() {
        ImgOpt.getbitmap = onTakeIng
        if (ImgOpt.takeBitmap != null) {
            L.t("发布截图指令")
            ImgOpt.takeBitmap?.onCallBack(true)
        } else {
            L.t("发布截图指令 ImgOpt.takeBitmap==null")
        }
    }

}



