package com.nwq.function.corelib.auto_code.ui.funciton

import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import androidx.recyclerview.widget.GridLayoutManager
import com.luck.picture.lib.decoration.GridSpacingItemDecoration
import com.nwq.function.corelib.R
import com.nwq.function.corelib.auto_code.FunctionBlock
import com.nwq.function.corelib.auto_code.ui.adapter.FeatureKeyAdapter
import com.nwq.function.corelib.auto_code.ui.adapter.FunctionItemAdapter
import com.nwq.function.corelib.auto_code.ui.adapter.FunctionItemAdapter.Companion.BUTTON_TYPE
import com.nwq.function.corelib.auto_code.ui.adapter.FunctionItemAdapter.Companion.CHECK_TYPE
import com.nwq.function.corelib.auto_code.ui.data.FeaturePointKey
import com.nwq.function.corelib.auto_code.ui.data.FunctionItemInfo
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
    val binding: PartImgFeatureBinding
) : FunctionBlock {

    private val mBaseImgProcess = BaseImgProcess(imgArray, with, height)

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
            when (functionItemList[position].strId) {
                R.string.add->{

                }
                R.string.delete->{

                }
                R.string.add_point->{

                }
                R.string.delete_point->{

                }
                R.string.auto_exc->{

                }
                R.string.auto_code->{

                }
                R.string.preview->{

                }
                R.string.feature->{

                }
                R.string.boundary->{

                }
            }
        }

    }


    private fun initFeature() {
         GlobalScope.launch(Dispatchers.Default) {
             mBaseImgProcess.preprocessData()
             runOnUI {
                 mFeatureKeyAdapter = FeatureKeyAdapter(mBaseImgProcess.featureKeyList,mBaseImgProcess.colorMaps)
             }
         }

    }


    private fun autoFindTargetColor(colorInt: Int) {

    }


    override fun addFeatureKey(vararg colorInt: Int) {
        mBaseImgProcess.addFeatureKey(*colorInt)
    }


}