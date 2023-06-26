package com.nwq.function.corelib.auto_code.ui.funciton

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
import com.nwq.function.corelib.auto_code.ui.data.FeatureCoordinatePoint
import com.nwq.function.corelib.auto_code.ui.data.FunctionItemInfo
import com.nwq.function.corelib.auto_code.ui.funciton.OptCmd.Companion.ADD_AREA
import com.nwq.function.corelib.auto_code.ui.funciton.OptCmd.Companion.ADD_FEATURE_KEY
import com.nwq.function.corelib.auto_code.ui.funciton.OptCmd.Companion.ADD_POINT
import com.nwq.function.corelib.auto_code.ui.funciton.OptCmd.Companion.DELETE_POINT
import com.nwq.function.corelib.auto_code.ui.funciton.OptCmd.Companion.FIND_IMAGE_AREA
import com.nwq.function.corelib.databinding.PartImgFeatureBinding
import com.nwq.function.corelib.img.pcheck.IPR
import com.nwq.function.corelib.img.pcheck.PointRule
import com.nwq.function.corelib.img.rule.ColorIdentificationRule
import com.nwq.function.corelib.img.rule.ColorRuleRatioImpl
import com.nwq.function.corelib.img.rule.ColorRuleRatioUnImpl
import com.nwq.function.corelib.img.task.CorrectPositionModel
import com.nwq.function.corelib.img.task.FindImgTask
import com.nwq.function.corelib.img.task.ImgTaskImpl1
import com.nwq.function.corelib.utils.runOnUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.StringBuilder
import kotlin.math.min

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
    val mOptLister: OptLister,
) : FunctionBlock {


    constructor(
        coordinateAre: CoordinateArea,
        imgArray: List<IntArray>,
        binding: PartImgFeatureBinding,
        mOptLister: OptLister
    ) : this(
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
    private var showFeature = true
    private var showBoundary = false
    private var useBackground = false
    private var useInverseValue = false //true 背景点取相对颜色的反值， false 使用自己的颜色特性
    private var findImageArea: CoordinateArea? = null
    private val functionItemList by lazy {
        mutableListOf(
            FunctionItemInfo(R.string.add, BUTTON_TYPE),
            FunctionItemInfo(R.string.delete, BUTTON_TYPE),
            FunctionItemInfo(R.string.add_point, BUTTON_TYPE),
            FunctionItemInfo(R.string.delete_point, BUTTON_TYPE),
            FunctionItemInfo(R.string.auto_exc, BUTTON_TYPE),
            FunctionItemInfo(R.string.find_the_image_area, BUTTON_TYPE),
            FunctionItemInfo(R.string.auto_code, BUTTON_TYPE),
            FunctionItemInfo(R.string.preview, BUTTON_TYPE),
            FunctionItemInfo(R.string.merge, BUTTON_TYPE),
            FunctionItemInfo(R.string.background, BUTTON_TYPE),
            FunctionItemInfo(R.string.useBackground, CHECK_TYPE, useBackground),
            FunctionItemInfo(R.string.inverse_value, CHECK_TYPE, useInverseValue),
            FunctionItemInfo(R.string.feature, CHECK_TYPE, showFeature),
            FunctionItemInfo(R.string.boundary, CHECK_TYPE, showBoundary),
        )
    }


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
                    mBaseImgProcess.autoExc(useBackground)
                }
                R.string.find_the_image_area -> {
                    mOptLister.requestArea(FIND_IMAGE_AREA)
                }
                R.string.auto_code -> {
                    generateCode()
                }
                R.string.preview -> {
                    val list = mBaseImgProcess.getPreview(showFeature, showBoundary, useBackground)
                    mOptLister.showPoint(list.map { CoordinatePoint(it.x + startX, it.y + startY) })
                }
                R.string.merge -> {
                    mBaseImgProcess.mergeKey()
                    mFeatureKeyAdapter =
                        FeatureKeyAdapter(mBaseImgProcess.featureKeyList, mBaseImgProcess.colorMaps)
                    binding.feRecycler.adapter = mFeatureKeyAdapter
                }
                R.string.useBackground -> {
                    data.isCheck = !data.isCheck
                    useBackground = data.isCheck
                    mFunctionItemAdapter.notifyItemChanged(position)
                }
                R.string.inverse_value -> {
                    data.isCheck = !data.isCheck
                    useInverseValue = data.isCheck
                    mFunctionItemAdapter.notifyItemChanged(position)
                }
                R.string.background -> {
                    mBaseImgProcess.setDarkestFeature()
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
                binding.feRecycler.adapter = mFeatureKeyAdapter
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
            FIND_IMAGE_AREA -> {
                findImageArea = area.getOrNull(0)
            }
        }
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


    override fun generateCode() {
        val codeStr = if (findImageArea == null) {
            builderImgTaskImpl1()
        } else {
            builderFindImgTask()
        }
    }


    private fun builderFindImgTask(): String {
        val datums = mBaseImgProcess.getDatumPoint(1)//用于找开始的点
        val points = mBaseImgProcess.getKeyPoint()
        //这里进行代码生成
        val stringBuilder = StringBuilder()
        stringBuilder.append("val isOpenTask by lazy {  \n")
        stringBuilder.append("val tag = isOpen \n")
        datums?.getOrNull(0) ?: points[0].let {
            stringBuilder.append(
                "val keyPoint = PointRule(CoordinatePoint(${startX + it.x}, ${startY + it.y}), ${it.toColorRuleStr()})\n"
            )
        }
        with(findImageArea!!) {
            stringBuilder.append("val findArea = CoordinateArea($x,$y,$with,$height)\n")
        }
        stringBuilder.append(" val pointList = mutableListOf<IPR>()\n")
        points.forEach {
            stringBuilder.append(
                "pointList.add(PointRule(CoordinatePoint(${startX + it.x}, ${startY + it.y}), ${
                    it.toColorRuleStr(useInverseValue)
                }))\n"
            )
        }
        stringBuilder.append("ImgTaskImpl1(keyPoint, findArea, pointList,tag)   \n")
        stringBuilder.append(" }  \n")
        return stringBuilder.toString()
    }


    //这里是构造固定找图
    private fun builderImgTaskImpl1(): String {
        val datums = mBaseImgProcess.getDatumPoint(1)//用于找开始的点
        val points = mBaseImgProcess.getKeyPoint()

        //这里进行代码生成
        val stringBuilder = StringBuilder()
        stringBuilder.append("val isOpenTask by lazy {  \n")
        stringBuilder.append("val tag = isOpen \n")
        if (datums == null) {
            stringBuilder.append("val correctPositionModel = null \n")
        } else {
            stringBuilder.append("val list = mutableListOf<PointRule>()   \n")
            datums.forEach {
                stringBuilder.append(
                    "list.add(PointRule(CoordinatePoint(${startX + it.x}, ${startY + it.y}), ${
                        it.toColorRuleStr()
                    }))\n"
                )
            }
            stringBuilder.append("val correctPositionModel =CorrectPositionModel(list, tag, 3, 3, false)\n")
        }

        stringBuilder.append(" val pointList = mutableListOf<IPR>()\n")
        points.forEach {
            stringBuilder.append(
                "pointList.add(PointRule(CoordinatePoint(${startX + it.x}, ${startY + it.y}), ${
                    it.toColorRuleStr(useInverseValue)
                }))\n"
            )
        }
        stringBuilder.append(" ImgTaskImpl1(pointList, tag, correctPositionModel)   \n")
        stringBuilder.append("}  \n")
        return stringBuilder.toString()
    }

    fun FeatureCoordinatePoint.toColorRuleStr(notValue: Boolean = false): String {
        if (notValue && mDirectorPointKey != null) {
            val oKey = mDirectorPointKey!!
            return "ColorRuleRatioUnImpl.getSimple(\n" +
                    " ${oKey.maxRed},${oKey.minRed},${oKey.maxGreen},${oKey.minGreen},${oKey.maxBlue},${oKey.minBlue},\n" +
                    " ${oKey.maxRToG},${oKey.minRToG},${oKey.maxRToB},${oKey.minRToB},${oKey.maxGToB}, ${oKey.minGToB} )"
        } else {
            val maxValue = Math.max(Math.max(red, green), blue)
            val range = if (maxValue > 200) {
                15
            } else if (maxValue > 150) {
                25
            } else if (maxValue > 110) {
                30
            } else if (maxValue > 80) {
                20
            } else {
                15
            }
            var maxRed = red + range
            var minRed = red - range
            var maxGreen = green + range
            var minGreen = green - range
            var maxBlue = blue + range
            var minBlue = blue - range


            var rToG = red.toFloat() / green.toFloat()
            var rToB = red.toFloat() / blue.toFloat()
            var gToB = green.toFloat() / blue.toFloat()

            val rangRatio = 0.1F
            var maxRToG = rToG * (1 + rangRatio)
            var minRToG = rToG * (1 - rangRatio)
            var maxRToB = rToB * (1 + rangRatio)
            var minRToB = rToB * (1 - rangRatio)
            var maxGToB = gToB * (1 + rangRatio)
            var minGToB = gToB * (1 - rangRatio)
            return "ColorRuleRatioImpl.getSimple(\n" +
                    " $maxRed,$minRed,$maxGreen,$minGreen,$maxBlue,$minBlue,\n" +
                    " $maxRToG,$minRToG,$maxRToB,$minRToB,$maxGToB,$minGToB )"
        }
    }


}