package com.nwq.function.corelib.auto_code.ui.funciton

import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import com.nwq.function.corelib.auto_code.FunctionBlock
import com.nwq.function.corelib.auto_code.ui.adapter.FeatureKeyAdapter
import com.nwq.function.corelib.auto_code.ui.adapter.FunctionItemAdapter
import com.nwq.function.corelib.auto_code.ui.data.FeaturePointKey
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
    private lateinit var mFunctionItemAdapter: FunctionItemAdapter



    private fun autoFindTargetColor(colorInt: Int) {

    }

    override fun addFeatureKey(vararg colorInt: Int) {
        mBaseImgProcess.addFeatureKey(*colorInt)
    }


}