package com.nwq.function.corelib.excuter.star_wars

import android.accessibilityservice.AccessibilityService
import com.nwq.function.corelib.Constant
import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.auto_code.ui.data.FeatureCoordinatePoint
import com.nwq.function.corelib.auto_code.ui.data.FeaturePointKey
import com.nwq.function.corelib.excuter.BaseController
import com.nwq.function.corelib.excuter.EndLister
import com.nwq.function.corelib.img.pcheck.PointRules
import com.nwq.function.corelib.img.rule.ColorRuleImpl
import com.nwq.function.corelib.img.rule.ColorRuleRatioImpl
import com.nwq.function.corelib.img.task.HpTaskImpl
import com.nwq.function.corelib.img.task.ImgTaskImpl1
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

class GetColorController(acService: AccessibilityService, endLister: EndLister? = null) :
    BaseController(acService, endLister) {

    var colorMaps = mutableMapOf<FeaturePointKey, MutableList<FeatureCoordinatePoint>>()
    val featureKeyList = mutableListOf<FeaturePointKey>()

    override fun startWork(pressBackHome: Boolean) {
        GlobalScope.launch(Dispatchers.Default) {
            delay(10000)
            getColor(StarWarEnvironment.isShowLeftDialogBox)
            endLister?.onEndLister()
        }
    }


    suspend fun testTask(task: ImgTaskImpl1) {
        var flag = true
        var count = 40
        featureKeyList.clear()
        while (flag && count > 0 && runSwitch) {
            val bitmap = takeScreenBitmap(Constant.fastClickInterval)
            if (bitmap.isOrientation()) {
                task.check()
            } else {//这里没有横屏所以
                flag = false
            }
        }
    }


    suspend fun getColor(task: ImgTaskImpl1) {
        val pointList = mutableListOf<CoordinatePoint>()
        task.iprList.forEach {
            val rule = it.getColorRule()
            if (rule is ColorRuleRatioImpl || rule is ColorRuleImpl || it is PointRules) {
                pointList.add(it.getCoordinatePoint())
            }
        }

        var flag = true
        var count = 40
        featureKeyList.clear()
        while (flag && count > 0 && runSwitch) {
            val bitmap = takeScreenBitmap(Constant.fastClickInterval)
            task.verificationRule(bitmap)
            if (bitmap.isOrientation()) {
                pointList.forEach {
                    var intN = bitmap.getPixel(it.xI, it.yI)
                    groupPoint(FeatureCoordinatePoint(0, 0, intN), intN)
                }
            } else {//这里没有横屏所以
                if (featureKeyList.isNotEmpty()) {
                    var number = 0
                    var stringBuilder = StringBuilder()
                    colorMaps.forEach { key, value ->
                        allMaxRange(key, value)
                        val oKey = key.colorRuleRatioImpl!!
                        number++
                        val tempStr =
                            "val ruleRatio$number =  ColorRuleRatioImpl.getSimple(" + " ${oKey.maxRed},${oKey.minRed},${oKey.maxGreen},${oKey.minGreen},${oKey.maxBlue},${oKey.minBlue},\n" + " ${oKey.redToGreenMax}F,${oKey.redToGreenMin}F,${oKey.redToBlueMax}F,${oKey.redToGreenMin}F,${oKey.greenToBlueMax}F, ${oKey.greenToBlueMin}F)\n"
                        stringBuilder.append(tempStr)
                    }
                    Timber.i("${stringBuilder.toString()}  result NWQQ_ 2023/7/23");
                    featureKeyList.clear()
                    colorMaps.clear()
                    flag = false
                }
            }
        }
    }


    override suspend fun generalControlMethod() {
        var flag = true
        var count = 40
        featureKeyList.clear()
        while (flag && count > 0 && runSwitch) {
            val bitmap = takeScreenBitmap(Constant.fastClickInterval)
            if (bitmap.isOrientation()) {
                var intN = bitmap.getPixel(888, 531)
                groupPoint(FeatureCoordinatePoint(0, 0, intN), intN)

                intN = bitmap.getPixel(913, 530)
                groupPoint(FeatureCoordinatePoint(0, 0, intN), intN)

                intN = bitmap.getPixel(936, 531)
                groupPoint(FeatureCoordinatePoint(0, 0, intN), intN)

            } else {//这里没有横屏所以
                if (featureKeyList.isNotEmpty()) {
                    var number = 0
                    var stringBuilder = StringBuilder()
                    colorMaps.forEach { key, value ->
                        allMaxRange(key, value)
                        val oKey = key.colorRuleRatioImpl!!
                        number++
                        val tempStr =
                            "val ruleRatio$number =  ColorRuleRatioImpl.getSimple(" + " ${oKey.maxRed},${oKey.minRed},${oKey.maxGreen},${oKey.minGreen},${oKey.maxBlue},${oKey.minBlue},\n" + " ${oKey.redToGreenMax}F,${oKey.redToGreenMin}F,${oKey.redToBlueMax}F,${oKey.redToGreenMin}F,${oKey.greenToBlueMax}F, ${oKey.greenToBlueMin}F)\n"
                        stringBuilder.append(tempStr)
                    }
                    Timber.i("${stringBuilder.toString()}  result NWQQ_ 2023/7/23");
                    featureKeyList.clear()
                    colorMaps.clear()
                    flag = false
                }
            }
        }
    }

    private fun groupPoint(point: FeatureCoordinatePoint, colorInt: Int) {
        val key = featureKeyList.find { it.isInRange(point) }
        if (key != null) {
            point.mFeaturePointKey = key
            colorMaps[key]?.add(point)
        } else {
            var newKey = FeaturePointKey(colorInt)
            point.mFeaturePointKey = newKey
            val list = mutableListOf<FeatureCoordinatePoint>()
            list.add(point)
            featureKeyList.add(newKey)
            colorMaps[newKey] = list
        }
    }


    private fun allMaxRange(key: FeaturePointKey, list: List<FeatureCoordinatePoint>) {
        var maxRed = 0
        var minRed = 255
        var maxGreen = 0
        var minGreen = 255
        var maxBlue = 0
        var minBlue = 255

        var maxRToG = 0F
        var minRToG = 255F
        var maxRToB = 0F
        var minRToB = 255F
        var maxGToB = 0F
        var minGToB = 255F

        list.forEach {
            maxRed = Math.max(it.red, maxRed)
            minRed = Math.min(it.red, minRed)
            maxGreen = Math.max(it.green, maxGreen)
            minGreen = Math.min(it.green, minGreen)
            maxBlue = Math.max(it.blue, maxBlue)
            minBlue = Math.min(it.blue, minBlue)

            maxRToG = Math.max(it.red.toFloat() / it.green.toFloat(), maxRToG)
            minRToG = Math.min(it.red.toFloat() / it.green.toFloat(), minRToG)
            maxRToB = Math.max(it.red.toFloat() / it.blue.toFloat(), maxRToB)
            minRToB = Math.min(it.red.toFloat() / it.blue.toFloat(), minRToB)
            maxGToB = Math.max(it.green.toFloat() / it.blue.toFloat(), maxGToB)
            minGToB = Math.min(it.green.toFloat() / it.blue.toFloat(), minGToB)
        }

        val maxD = 1.05
        val minD = 0.9
        val data = ColorRuleRatioImpl(
            (maxRed * maxD).toInt(),
            (minRed * minD).toInt(),
            (maxGreen * maxD).toInt(),
            (minGreen * minD).toInt(),
            (maxBlue * maxD).toInt(),
            (minBlue * minD).toInt(),
            (maxRToG * maxD).toFloat(),
            (minRToG * minD).toFloat(),
            (maxRToB * maxD).toFloat(),
            (minRToB * minD).toFloat(),
            (maxGToB * maxD).toFloat(),
            (minGToB * minD).toFloat(),
        )
        key.colorRuleRatioImpl = data
    }


    fun  getColorResult(){
        val ruleRatio1 =  ColorRuleRatioImpl.getSimple( 140,95,144,99,148,99,
            1.0594594F,0.82956517F,1.078125F,0.82956517F,1.078125F, 0.8723077F)
        val ruleRatio2 =  ColorRuleRatioImpl.getSimple( 96,79,139,116,214,180,
            0.7406976F,0.6F,0.47537315F,0.6F,0.68955225F, 0.56911767F)

    }
}