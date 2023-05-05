package com.nwq.function.scheduling.auto_code.ui

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.view.MotionEvent.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.*
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.luck.picture.lib.basic.PictureSelector
import com.luck.picture.lib.config.SelectMimeType
import com.luck.picture.lib.entity.LocalMedia
import com.luck.picture.lib.interfaces.OnResultCallbackListener
import com.nwq.function.scheduling.auto_code.adapter.SinglePointAdapter
import com.nwq.function.scheduling.auto_code.adapter.TwoPointAdapter
import com.nwq.function.scheduling.auto_code.task.MultiPointColorTask
import com.nwq.function.scheduling.auto_code.utils.AutoUtils
import com.nwq.function.scheduling.core_code.Area
import com.nwq.function.scheduling.core_code.Coordinate
import com.nwq.function.scheduling.databinding.ActivityAutoCodeBinding
import com.nwq.function.scheduling.utils.singleClick
import timber.log.Timber


class AutoCodeActivity : AppCompatActivity() {

    lateinit var bind: ActivityAutoCodeBinding
    private lateinit var mBitmap: Bitmap
    private lateinit var mBitmapName: String
    private var nowMode = normalMode

    val mSinglePointAdapter = SinglePointAdapter()
    val mTwoPointAdapter = TwoPointAdapter()
    val mConcatAdapter = ConcatAdapter(mSinglePointAdapter, mTwoPointAdapter)

    private var mMultiPointColorTask: MultiPointColorTask? = null
    val manager: ClipboardManager by lazy {
        getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    }

    companion object {
        val normalMode = 1   //普通模式
        val previewMode = 2   //预览模式
        val singlePonitHighestSingleMode = 11  //单点单值色值最高模式
        val singlePonitHighestAllMode = 12  //单点全部色值最高模式
        val singlePonitLowestAllMode = 13  //单点全部色值最低模式
        val twoPonitGrayscaleMode = 21    //双点对比模式
        val twoPonitTransparentMode = 22    //双点对比模式
        val searchScopeMode = 31       //点击区域边框模式
        val alongMode = 32      //点击区域边框模式
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
            PictureSelector.create(this).openSystemGallery(SelectMimeType.ofImage())
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
            if (TextUtils.isEmpty(methodName)) {
                return@singleClick
            }
            mMultiPointColorTask = MultiPointColorTask(methodName, mBitmapName, null)
            mSinglePointAdapter.setData(mMultiPointColorTask!!.singlePointList)
            mTwoPointAdapter.setData(mMultiPointColorTask!!.twoPointColorValue)
            nowMode = previewMode
            bind.normalUiGroup.isGone = true
            bind.previewUiGroup.isVisible = true
        }


        bind.singleBtn.singleClick {
            bind.operateUiView.setShowFlag(true)
            nowMode = singlePonitHighestSingleMode
            bind.previewUiGroup.isGone = true
        }

        bind.singleBtn2.singleClick {
            bind.operateUiView.setShowFlag(true)
            nowMode = singlePonitHighestAllMode
            bind.previewUiGroup.isGone = true
        }

        bind.singleBtn3.singleClick {
            bind.operateUiView.setShowFlag(true)
            nowMode = singlePonitLowestAllMode
            bind.previewUiGroup.isGone = true
        }

        bind.recycler.adapter = mConcatAdapter
        bind.recycler.layoutManager = LinearLayoutManager(this)

        bind.twoBtn.singleClick {
            bind.operateUiView.setShowFlag(true)
            nowMode = twoPonitGrayscaleMode
            bind.previewUiGroup.isGone = true
        }
        bind.twoBtn2.singleClick {
            bind.operateUiView.setShowFlag(true)
            nowMode = twoPonitTransparentMode
            bind.previewUiGroup.isGone = true
        }

        bind.areaBtn.singleClick {
            bind.operateUiView.setShowFlag(true)
            nowMode = alongMode
            bind.previewUiGroup.isGone = true
        }

        bind.searchScopeBtn.singleClick {
            bind.operateUiView.setShowFlag(true)
            nowMode = searchScopeMode
            bind.previewUiGroup.isGone = true
        }

        bind.accomplishBtn.singleClick {
            bind.previewUiGroup.isGone = true
            bind.normalUiGroup.isVisible = true
            nowMode = normalMode
            bind.operateUiView.setShowFlag(false)
            mMultiPointColorTask?.buildResultString()?.let {
                bind.resultTv.text = it
                val clipData = ClipData.newPlainText("autoCode", it)
                manager.setPrimaryClip(clipData)
                bind.operateUiView.clearAllData()
                Timber.d("$it ResultString AutoCodeActivity NWQ_ 2023/4/14");
            }
        }

        bind.accomplishBtn2.singleClick {
            bind.previewUiGroup.isGone = true
            bind.normalUiGroup.isVisible = true
            nowMode = normalMode
            bind.operateUiView.setShowFlag(false)
            mMultiPointColorTask?.buildJudeLengthStr()?.let {
                bind.resultTv.text = it
                val clipData = ClipData.newPlainText("autoCode", it)
                manager.setPrimaryClip(clipData)
                bind.operateUiView.clearAllData()
                Timber.d("$it ResultString AutoCodeActivity NWQ_ 2023/4/14");
            }
        }
    }


    override fun onBackPressed() {
        if (nowMode in 10..40) {
            nowMode = previewMode
            bind.previewUiGroup.isVisible = true
            bind.operateUiView.setShowFlag(false)
            mMultiPointColorTask?.let {
                mSinglePointAdapter.setData(it.singlePointList)
                mTwoPointAdapter.setData(it.twoPointColorValue)
            }

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
        when (ev.action) {
            ACTION_UP -> {
                Timber.d("ACTION_UP onTouchEvent AutoCodeActivity NWQ_ 2023/5/4");
            }
            ACTION_SCROLL -> {
                Timber.d("ACTION_SCROLL onTouchEvent AutoCodeActivity NWQ_ 2023/5/4");
            }
            ACTION_DOWN -> {
                Timber.d("ACTION_DOWN onTouchEvent AutoCodeActivity NWQ_ 2023/5/4");
            }
            ACTION_MOVE -> {
                Timber.d("ACTION_MOVE onTouchEvent AutoCodeActivity NWQ_ 2023/5/4");
            }
            else->{
                Timber.d("else ${ev.action} onTouchEvent AutoCodeActivity NWQ_ 2023/5/4");
            }
        }

        when (nowMode) {
            singlePonitHighestSingleMode -> {
                if (ev.action == ACTION_UP) {
                    var coordinate = Coordinate(ev.x.toInt(), ev.y.toInt())
                    val resultCoordinate =
                        AutoUtils.findPointByHighestSingle(coordinate, mBitmap, getRange())
                            ?: coordinate
                    Timber.d("coordinate: ${coordinate.x.toInt()} ${coordinate.y.toInt()} resultCoordinate: ${resultCoordinate.x.toInt()} ${resultCoordinate.y.toInt()}   onTouchEvent AutoCodeActivity NWQ_ 2023/4/16");
                    if (bind.operateUiView.addDot(resultCoordinate)) {
                        mMultiPointColorTask?.addSinglePoint(
                            resultCoordinate,
                            mBitmap.getPixel(resultCoordinate.x.toInt(), resultCoordinate.y.toInt())
                        )
                    }
                }
            }
            singlePonitHighestAllMode -> {
                if (ev.action == ACTION_UP) {
                    var coordinate = Coordinate(ev.x.toInt(), ev.y.toInt())
                    val resultCoordinate =
                        AutoUtils.findPointByHighestAll(coordinate, mBitmap, getRange())
                            ?: coordinate

                    if (bind.operateUiView.addDot(resultCoordinate)) {
                        mMultiPointColorTask?.addSinglePoint(
                            resultCoordinate,
                            mBitmap.getPixel(resultCoordinate.x.toInt(), resultCoordinate.y.toInt())
                        )
                    }

                }
            }
            singlePonitLowestAllMode -> {
                if (ev.action == ACTION_UP) {
                    var coordinate = Coordinate(ev.x.toInt(), ev.y.toInt())
                    val resultCoordinate =
                        AutoUtils.findPointByLowestAll(coordinate, mBitmap, getRange())
                            ?: coordinate
                    if (bind.operateUiView.addDot(resultCoordinate)) {
                        mMultiPointColorTask?.addSinglePoint(
                            resultCoordinate,
                            mBitmap.getPixel(resultCoordinate.x.toInt(), resultCoordinate.y.toInt())
                        )
                    }
                }
            }
            twoPonitGrayscaleMode -> {
                if (ev.action == ACTION_UP) {
                    var coordinate = Coordinate(ev.x.toInt(), ev.y.toInt())
                    val resultCoordinate =
                        AutoUtils.findPointByHighestSingle(coordinate, mBitmap, getRange())
                            ?: coordinate
                    if (bind.operateUiView.addDot(coordinate)) {
                        mMultiPointColorTask?.addTwoPoint(
                            coordinate,
                            mBitmap.getPixel(
                                resultCoordinate.x.toInt(),
                                resultCoordinate.y.toInt()
                            ),
                            true
                        )
                    }
                }
            }
            twoPonitTransparentMode -> {
                if (ev.action == ACTION_UP) {
                    var coordinate = Coordinate(ev.x.toInt(), ev.y.toInt())
                    val resultCoordinate =
                        AutoUtils.findPointByHighestSingle(coordinate, mBitmap, getRange())
                            ?: coordinate
                    if (bind.operateUiView.addDot(coordinate)) {
                        mMultiPointColorTask?.addTwoPoint(
                            coordinate,
                            mBitmap.getPixel(
                                resultCoordinate.x.toInt(),
                                resultCoordinate.y.toInt()
                            ),
                            false
                        )
                    }
                }
            }
            searchScopeMode -> {
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
                        mMultiPointColorTask?.searchScopeArea = area
                    }
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

    private fun getRange(): Int {
        return bind.editTextNumber.text.toString().toIntOrNull() ?: 2
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        return super.dispatchTouchEvent(ev)
    }


}