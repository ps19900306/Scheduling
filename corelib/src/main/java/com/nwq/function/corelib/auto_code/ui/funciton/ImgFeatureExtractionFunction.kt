package com.nwq.function.corelib.auto_code.ui.funciton

import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.luck.picture.lib.decoration.GridSpacingItemDecoration
import com.nwq.function.corelib.R
import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.auto_code.FunctionBlock
import com.nwq.function.corelib.auto_code.ui.adapter.FeatureKeyAdapter
import com.nwq.function.corelib.auto_code.ui.adapter.FunctionItemAdapter
import com.nwq.function.corelib.auto_code.ui.adapter.FunctionItemAdapter.Companion.BUTTON_TYPE
import com.nwq.function.corelib.auto_code.ui.adapter.FunctionItemAdapter.Companion.CHECK_TYPE
import com.nwq.function.corelib.auto_code.ui.data.FeaturePointKey
import com.nwq.function.corelib.auto_code.ui.data.FunctionItemInfo
import com.nwq.function.corelib.auto_code.ui.funciton.OptCmd.Companion.ADD_FEATURE_KEY
import com.nwq.function.corelib.auto_code.ui.funciton.OptCmd.Companion.ADD_POINT
import com.nwq.function.corelib.auto_code.ui.funciton.OptCmd.Companion.DELETE_POINT
import com.nwq.function.corelib.databinding.PartImgFeatureBinding
import com.nwq.function.corelib.utils.runOnUI
import com.nwq.function.corelib.utils.singleClick
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
create by: 86136
create time: 2023/5/16 9:34
Function description:
 */

class ImgFeatureExtractionFunction(
    val startX: Int,
    val startY: Int,
    val with: Int,
    val height: Int,
    val imgArray: List<IntArray>,
    val binding: PartImgFeatureBinding,
    val mOptLister: OptLister
) : FunctionBlock {


    constructor(
        coordinateAre: CoordinateArea,
        imgArray: List<IntArray>,
        binding: PartImgFeatureBinding,
        mOptLister: OptLister
    )
            : this(
        coordinateAre.x,
        coordinateAre.y,
        coordinateAre.width,
        coordinateAre.height,
        imgArray,
        binding,
        mOptLister
    )

    private val mBaseImgProcess = BaseImgProcess(with, height, imgArray)

    private lateinit var mFeatureKeyAdapter: FeatureKeyAdapter
    private lateinit var mFunctionItemAdapter: FunctionItemAdapter
    private val context = binding.root.context

    private val functionItemList by lazy {
        mutableListOf(
            FunctionItemInfo(R.string.add, BUTTON_TYPE),
            FunctionItemInfo(R.string.delete, BUTTON_TYPE),
            FunctionItemInfo(R.string.add_point, BUTTON_TYPE),
            FunctionItemInfo(R.string.delete_point, BUTTON_TYPE),
            FunctionItemInfo(R.string.auto_exc, BUTTON_TYPE),
            FunctionItemInfo(R.string.auto_code, BUTTON_TYPE),
            FunctionItemInfo(R.string.preview, BUTTON_TYPE),
            FunctionItemInfo(R.string.feature, CHECK_TYPE),
            FunctionItemInfo(R.string.boundary, CHECK_TYPE),
        )
    }

    private var showFeature = false
    private var showBoundary = false

    init {
        initOpt()
        initFeature()
    }


    private fun initOpt() {

        val spanCount = 3
        val sd = GridSpacingItemDecoration(spanCount, 8, true)
        binding.optRecycler.layoutManager = GridLayoutManager(context, spanCount)
        mFunctionItemAdapter = FunctionItemAdapter(functionItemList)
        binding.optRecycler.adapter = mFunctionItemAdapter
        binding.optRecycler.addItemDecoration(sd)

        mFunctionItemAdapter.setOnItemClickListener { adapter, view, position ->
            val data = functionItemList[position]
            when (data.strId) {
                R.string.add -> {
                    mOptLister.optPoint(ADD_FEATURE_KEY)
                }
                R.string.delete -> {
                    mBaseImgProcess.deleteSelectFeatureKey()
                }
                R.string.add_point -> {
                    mOptLister.optPoint(ADD_POINT)
                }
                R.string.delete_point -> {
                    mOptLister.optPoint(DELETE_POINT)
                }
                R.string.auto_exc -> {
                    mBaseImgProcess.autoExc()
                }
                R.string.auto_code -> {
                    generateCode()
                }
                R.string.preview -> {
                    val list = mBaseImgProcess.getPreview(showFeature, showBoundary)
                    mOptLister.showPoint(list.map { CoordinatePoint(it.x + startX, it.y + startY) })
                }
                R.string.feature -> {
                    data.isCheck = !data.isCheck
                    showFeature = data.isCheck
                    mFunctionItemAdapter.notifyItemChanged(position)
                }
                R.string.boundary -> {
                    data.isCheck = !data.isCheck
                    showBoundary = data.isCheck
                    mFunctionItemAdapter.notifyItemChanged(position)
                }
            }
        }

    }


    private fun initFeature() {
        GlobalScope.launch(Dispatchers.Default) {
            mBaseImgProcess.preprocessData()
            runOnUI {
                mFeatureKeyAdapter =
                    FeatureKeyAdapter(mBaseImgProcess.featureKeyList, mBaseImgProcess.colorMaps)
            }
        }

    }


    override suspend fun addFeatureKey(vararg colorInt: Int) {
        mBaseImgProcess.addFeatureKey(*colorInt)
    }

    override fun optPoint(cmd: Int, vararg coordinatePoint: CoordinatePoint) {
        when (cmd) {
            ADD_POINT -> {
                addFeaturePoint(*coordinatePoint)
            }
            DELETE_POINT -> {
                deleteFeaturePoint(*coordinatePoint)
            }
            ADD_FEATURE_KEY -> {
                addFeatureKey(*coordinatePoint)
            }
        }
    }

    override fun optArea(cmd: Int, vararg area: CoordinateArea) {
        when (cmd) {

        }
    }


    override fun generateCode() {

    }

    override fun hideView() {
        binding.root.isGone = true
    }

    override fun showView() {
        binding.root.isVisible = true
    }

    private fun addFeatureKey(vararg coordinatePoint: CoordinatePoint) {
        val colors = coordinatePoint.map { mOptLister.getPointColor(it.xI, it.yI) }
        mBaseImgProcess.addFeatureKey(*colors.toIntArray())
    }


    private fun addFeaturePoint(vararg coordinatePoint: CoordinatePoint) {
        coordinatePoint.forEach {
            mBaseImgProcess.addFeaturePoint(it.xI - startX, it.yI - startY)
        }
    }

    private fun deleteFeaturePoint(vararg coordinatePoint: CoordinatePoint) {
        coordinatePoint.forEach {
            mBaseImgProcess.deleteFeaturePoint(it.xI - startX, it.yI - startY)
        }
    }
}