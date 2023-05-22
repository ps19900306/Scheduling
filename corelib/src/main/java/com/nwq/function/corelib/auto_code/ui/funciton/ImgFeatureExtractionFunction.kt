package com.nwq.function.corelib.auto_code.ui.funciton

import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import com.nwq.function.corelib.auto_code.FunctionBlock
import com.nwq.function.corelib.auto_code.ui.adapter.FeatureKeyAdapter
import com.nwq.function.corelib.databinding.PartImgFeatureBinding
import com.nwq.function.corelib.utils.singleClick

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
    val binding: PartImgFeatureBinding
) : FunctionBlock {

    private val mBaseImgProcess = BaseImgProcess(imgArray,with,height)

    private lateinit var mFeatureKeyAdapter: FeatureKeyAdapter

    init {
        binding.recycler.adapter = mFeatureKeyAdapter
        binding.addBtn.singleClick {

        }
        binding.addPointBtn.singleClick {

        }
        binding.deletePointBtn.singleClick {

        }
    }


    private fun autoFindTargetColor(colorInt: Int) {

    }

    //单点选取平均色
    override fun addFeatureKey(colorInt: Int) {
    }

    //多点选择平均色
    override fun addFeatureKey(colorInt: IntArray) {
        var redTotal = 0
        var greenTotal = 0
        var blueTotal = 0
        colorInt.forEach {
            redTotal += it.red
            greenTotal += it.green
            blueTotal += it.blue
        }
//        targetColorMap.put(
//            FeaturePointKey(
//                redTotal / colorInt.size,
//                greenTotal / colorInt.size,
//                blueTotal / colorInt.size
//            ), mutableListOf()
//        )
    }














}