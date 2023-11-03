package com.nwq.function.autocodeapp.function

import android.content.ClipData
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.expand.runOnUI
import com.luck.picture.lib.decoration.GridSpacingItemDecoration
import com.nwq.function.autocodeapp.R
import com.nwq.function.autocodeapp.adapter.FeatureKeyAdapter
import com.nwq.function.autocodeapp.adapter.FunctionItemAdapter
import com.nwq.function.autocodeapp.adapter.FunctionItemAdapter.Companion.BUTTON_TYPE
import com.nwq.function.autocodeapp.adapter.FunctionItemAdapter.Companion.CHECK_TYPE
import com.nwq.function.autocodeapp.adapter.FunctionItemAdapter.Companion.EDIT_TEXT_TYPE
import com.nwq.function.autocodeapp.data.FeatureCoordinatePoint
import com.nwq.function.autocodeapp.data.FeaturePointKey
import com.nwq.function.autocodeapp.data.FunctionItemInfo
import com.nwq.function.autocodeapp.databinding.PartImgFeatureBinding
import com.nwq.function.autocodeapp.function.OptCmd.Companion.ADD_FEATURE_KEY
import com.nwq.function.autocodeapp.function.OptCmd.Companion.ADD_POINT
import com.nwq.function.autocodeapp.function.OptCmd.Companion.DELETE_POINT
import com.nwq.function.autocodeapp.function.OptCmd.Companion.FILTER_OUT_AREAS
import com.nwq.function.autocodeapp.function.OptCmd.Companion.FIND_IMAGE_AREA
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.StringBuilder

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
    private var useBackground = true
    private var takePointCount: Int = 0
    private var minStep: Int = 0
    private var useInverseValue = false //true 背景点取相对颜色的反值， false 使用自己的颜色特性
    private var useOffsetValue = true //true 底色进行取差值
    private var allPointKey = true//true 对全部的点规则生成特诊该规则
    private var sortByX = false//true 对全部的点规则生成特诊该规则
    private var findImageArea: CoordinateArea? = null
    private var filterOutArea: CoordinateArea? = null
    private val functionItemList by lazy {
        mutableListOf(
            FunctionItemInfo(R.string.auto_exc, BUTTON_TYPE),
            FunctionItemInfo(R.string.auto_code, BUTTON_TYPE),
            FunctionItemInfo(R.string.find_the_image_area, BUTTON_TYPE),
            FunctionItemInfo(R.string.filter_out_areas, BUTTON_TYPE),//这个还有问题
            FunctionItemInfo(R.string.merge, BUTTON_TYPE),
            FunctionItemInfo(R.string.background, BUTTON_TYPE),
            FunctionItemInfo(R.string.all_point_key, CHECK_TYPE, allPointKey),
            FunctionItemInfo(R.string.useBackground, CHECK_TYPE, useBackground),
            FunctionItemInfo(R.string.inverse_value, CHECK_TYPE, useInverseValue),
            FunctionItemInfo(R.string.offset_value, CHECK_TYPE, useOffsetValue),
            FunctionItemInfo(R.string.sort_by_x, CHECK_TYPE, sortByX),
            FunctionItemInfo(R.string.feature, CHECK_TYPE, showFeature),
            FunctionItemInfo(R.string.boundary, CHECK_TYPE, showBoundary),
            FunctionItemInfo(R.string.take_point_interval, EDIT_TEXT_TYPE),
            FunctionItemInfo(R.string.mini_steps, EDIT_TEXT_TYPE),
            FunctionItemInfo(R.string.add, BUTTON_TYPE),
            FunctionItemInfo(R.string.delete, BUTTON_TYPE),
            FunctionItemInfo(R.string.add_point, BUTTON_TYPE),
            FunctionItemInfo(R.string.delete_point, BUTTON_TYPE),
            FunctionItemInfo(R.string.preview, BUTTON_TYPE),
            FunctionItemInfo(R.string.full_screen, BUTTON_TYPE),
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
        mFunctionItemAdapter = FunctionItemAdapter(functionItemList) { i, S ->
            when (i) {
                R.string.take_point_interval -> {
                    takePointCount = S.toIntOrNull() ?: 0
                }
                R.string.mini_steps -> {
                    minStep = S.toIntOrNull() ?: 0
                    if (minStep > 0) mBaseImgProcess.minStep = minStep
                }
            }
        }
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
                    mBaseImgProcess.autoExc(
                        useBackground,
                        takePointCount,
                        allPointKey,
                        useInverseValue || useOffsetValue
                    )
                }
                R.string.auto_code -> {
                    generateCode()
                    val list = mBaseImgProcess.getPreview(showFeature, showBoundary, useBackground)
                    mOptLister.showPoint(list.map { CoordinatePoint(it.x + startX, it.y + startY) })
                }
                R.string.find_the_image_area -> {
                    mOptLister.requestArea(FIND_IMAGE_AREA)
                }
                R.string.filter_out_areas -> {
                    mOptLister.requestArea(FILTER_OUT_AREAS)
                }
                R.string.full_screen -> {
                    mOptLister.fullScreen()
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
                R.string.offset_value -> {
                    data.isCheck = !data.isCheck
                    useOffsetValue = data.isCheck
                    mFunctionItemAdapter.notifyItemChanged(position)
                }
                R.string.sort_by_x -> {
                    data.isCheck = !data.isCheck
                    sortByX = data.isCheck
                    mFunctionItemAdapter.notifyItemChanged(position)
                }
                R.string.all_point_key -> {
                    data.isCheck = !data.isCheck
                    allPointKey = data.isCheck
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
            FILTER_OUT_AREAS -> {
                filterOutArea = area.getOrNull(0)
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

    private fun removeArea(area: CoordinateArea) {

    }

    override fun generateCode() {
        val codeStr = if (findImageArea == null) {
            builderImgTaskImpl1()
        } else {
            builderFindImgTask()
        }
        val clipData = ClipData.newPlainText("autoCode", codeStr)
        mOptLister.getClipboardManager().setPrimaryClip(clipData)
    }


    private fun builderFindImgTask(): String {
        val datums = mBaseImgProcess.getDatumPoint(1)//用于找开始的点
        val points = mBaseImgProcess.getKeyPoint()
        //这里进行代码生成
        val stringBuilder = StringBuilder()
        stringBuilder.append("val isOpenTask by lazy {  \n")
        stringBuilder.append("val tag = \"isOpen\" \n")
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


    private val tempMap = HashMap<FeaturePointKey, String>()
    private val tempMap2 = HashMap<FeaturePointKey, String>()

    //这里是构造固定找图
    private fun builderImgTaskImpl1(): String {
        val datums = mBaseImgProcess.getDatumPoint(1)//用于找开始的点
        val points = mBaseImgProcess.getKeyPoint()
        if (sortByX) {
            val tempLIST = points.sortedByDescending {
                it.x
            }
            points.clear()
            points.addAll(tempLIST)
        }


        tempMap.clear()
        tempMap2.clear()
        //这里进行代码生成
        val stringBuilder = StringBuilder()
        stringBuilder.append("val isOpenTask by lazy {  \n")
        stringBuilder.append("val tag = \"isOpen\" \n")

        var number = 0
        points.forEach {
            if (tempMap[it.mFeaturePointKey!!] == null) {
                if (it.mFeaturePointKey?.colorRuleRatioImpl != null) {
                    val oKey = it.mFeaturePointKey!!.colorRuleRatioImpl!!
                    number++
                    val tempStr =
                        "val ruleRatio$number =  ColorRuleRatioImpl.getSimple(" + " ${oKey.maxRed},${oKey.minRed},${oKey.maxGreen},${oKey.minGreen},${oKey.maxBlue},${oKey.minBlue},\n" + " ${oKey.redToGreenMax}F,${oKey.redToGreenMin}F,${oKey.redToBlueMax}F,${oKey.redToGreenMin}F,${oKey.greenToBlueMax}F, ${oKey.greenToBlueMin}F)\n"
                    stringBuilder.append(tempStr)
                    tempMap[it.mFeaturePointKey!!] = "ruleRatio$number"
                }
//                else if(!useInverseValue || it.mFeaturePointKey?.isChecked?:false){
//                    val oKey = it.mFeaturePointKey!!.colorRuleRatioImpl!!
//                    number++
//                    val tempStr =
//                        "val ruleRatio$number =  ColorRuleRatioImpl.getSimple(" + " ${oKey.maxRed},${oKey.minRed},${oKey.maxGreen},${oKey.minGreen},${oKey.maxBlue},${oKey.minBlue},\n" + " ${oKey.redToGreenMax}F,${oKey.redToGreenMin}F,${oKey.redToBlueMax}F,${oKey.redToGreenMin}F,${oKey.greenToBlueMax}F, ${oKey.greenToBlueMin}F)\n"
//                    stringBuilder.append(tempStr)
//                    tempMap[it.mFeaturePointKey!!] = "ruleRatio$number"
//                }
            }

            if (useInverseValue && tempMap2[it.mFeaturePointKey!!] == null && it.mFeaturePointKey?.isChecked ?: false) {
                if (it.mFeaturePointKey?.colorRuleRatioImpl != null) {
                    val oKey = it.mFeaturePointKey!!.colorRuleRatioImpl!!
                    number++
                    val tempStr =
                        "val ruleRatio$number =  ColorRuleRatioUnImpl.getSimple(" + " ${oKey.maxRed},${oKey.minRed},${oKey.maxGreen},${oKey.minGreen},${oKey.maxBlue},${oKey.minBlue},\n" + " ${oKey.redToGreenMax}F,${oKey.redToGreenMin}F,${oKey.redToBlueMax}F,${oKey.redToGreenMin}F,${oKey.greenToBlueMax}F, ${oKey.greenToBlueMin}F)\n"
                    stringBuilder.append(tempStr)
                    tempMap2[it.mFeaturePointKey!!] = "ruleRatio$number"
                } else {
                    val oKey = it.mFeaturePointKey!!
                    number++
                    val tempStr =
                        "val ruleRatio$number = ColorRuleRatioUnImpl.getSimple(" + " ${oKey.maxRed},${oKey.minRed},${oKey.maxGreen},${oKey.minGreen},${oKey.maxBlue},${oKey.minBlue},\n" + " ${oKey.maxRToG}F,${oKey.minRToG}F,${oKey.maxRToB}F,${oKey.minRToB}F,${oKey.maxGToB}F, ${oKey.minGToB}F) \n"
                    stringBuilder.append(tempStr)
                    tempMap2[it.mFeaturePointKey!!] = "ruleRatio$number"
                }
            }
        }

        if (datums.isNullOrEmpty()) {
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
                if(useOffsetValue  && it.mDirectorPoint!=null){
                    "pointList.add(${it.toColorRuleStr(useInverseValue,useOffsetValue)})\n"
                }else{
                    "pointList.add(PointRule(CoordinatePoint(${startX + it.x}, ${startY + it.y}), ${
                        it.toColorRuleStr(useInverseValue,useOffsetValue)
                    }))\n"
                }
            )
        }
        stringBuilder.append(" ImgTaskImpl1(pointList, tag, correctPositionModel)   \n")
        stringBuilder.append("}  \n")
        return stringBuilder.toString()
    }

    private fun getOffset(a: Int, b: Int): Int {
        val d = a - b
        return if (d < -90) {
            -30
        } else if (d < -60) {
            -20
        } else if (d < -30) {
            -15
        } else if (d < 0) {
            -10
        } else if (d > 90) {
            30
        } else if (d > 60) {
            20
        } else if (d > 30) {
            15
        } else {
            10
        }
    }

    fun FeatureCoordinatePoint.toColorRuleStr(
        notValue: Boolean = false, offsetValue: Boolean = true
    ): String {
        return if (offsetValue && mDirectorPoint != null) {
            val redD = getOffset(mDirectorPoint!!.red, red)
            val greenD = getOffset(mDirectorPoint!!.green, green)
            val blueD  = getOffset(mDirectorPoint!!.blue, blue)
            val sx= this@ImgFeatureExtractionFunction.startX
            val sy= this@ImgFeatureExtractionFunction.startY
            "TwoPointRule(CoordinatePoint(${sx + mDirectorPoint!!.x}, ${sy + mDirectorPoint!!.y}),CoordinatePoint(${sx + x}, ${sy + y}), CompareDifferenceRuleImpl.getSimple($redD,$greenD,$blueD))"
        } else if (notValue && mDirectorPointKey != null) {
            if (mDirectorPointKey?.colorRuleRatioImpl != null) {
                val oKey = mDirectorPointKey!!.colorRuleRatioImpl!!
                (tempMap2[mDirectorPointKey!!]
                    ?: ("ColorRuleRatioUnImpl.getSimple(" + " ${oKey.maxRed},${oKey.minRed},${oKey.maxGreen},${oKey.minGreen},${oKey.maxBlue},${oKey.minBlue},\n" + " ${oKey.redToGreenMax}F,${oKey.redToGreenMin}F,${oKey.redToBlueMax}F,${oKey.redToGreenMin}F,${oKey.greenToBlueMax}F, ${oKey.greenToBlueMin}F)")) + "\n //red$red green$green blue$blue blockNumber${this.blockNumber}\n"
            } else {
                val oKey = mDirectorPointKey!!
                (tempMap2[mDirectorPointKey!!]
                    ?: ("ColorRuleRatioUnImpl.getSimple(" + " ${oKey.maxRed},${oKey.minRed},${oKey.maxGreen},${oKey.minGreen},${oKey.maxBlue},${oKey.minBlue},\n" + " ${oKey.maxRToG}F,${oKey.minRToG}F,${oKey.maxRToB}F,${oKey.minRToB}F,${oKey.maxGToB}F, ${oKey.minGToB}F)")) + "\n //red$red green$green blue$blue blockNumber${this.blockNumber}\n"
            }
        } else {
            if (mFeaturePointKey?.colorRuleRatioImpl != null) {
                val oKey = mFeaturePointKey!!.colorRuleRatioImpl!!
                (tempMap[mFeaturePointKey!!]
                    ?: ("ColorRuleRatioImpl.getSimple(" + " ${oKey.maxRed},${oKey.minRed},${oKey.maxGreen},${oKey.minGreen},${oKey.maxBlue},${oKey.minBlue},\n" + " ${oKey.redToGreenMax}F,${oKey.redToGreenMin}F,${oKey.redToBlueMax}F,${oKey.redToGreenMin}F,${oKey.greenToBlueMax}F, ${oKey.greenToBlueMin}F)")) + "\n //red$red green$green blue$blue blockNumber${this.blockNumber}\n"
            } else {
                "ColorRuleRatioImpl.getSimple(${red},${green},${blue})"
            }
        }
    }


}