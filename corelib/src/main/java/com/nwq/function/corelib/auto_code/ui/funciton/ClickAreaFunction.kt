package com.nwq.function.corelib.auto_code.ui.funciton

import androidx.recyclerview.widget.GridLayoutManager
import com.luck.picture.lib.decoration.GridSpacingItemDecoration
import com.nwq.function.corelib.R
import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.auto_code.FunctionBlock
import com.nwq.function.corelib.auto_code.ui.adapter.FunctionItemAdapter
import com.nwq.function.corelib.auto_code.ui.data.FunctionItemInfo
import com.nwq.function.corelib.databinding.PartClickAreaBinding

class ClickAreaFunction(val binding: PartClickAreaBinding, val mOptLister: OptLister) :
    FunctionBlock {

    private val context = binding.root.context
    private lateinit var mFunctionItemAdapter: FunctionItemAdapter
    private val functionItemList by lazy {
        mutableListOf(
            FunctionItemInfo(R.string.add, FunctionItemAdapter.BUTTON_TYPE),
            FunctionItemInfo(R.string.delete, FunctionItemAdapter.BUTTON_TYPE),
            FunctionItemInfo(R.string.auto_code, FunctionItemAdapter.BUTTON_TYPE),
        )
    }

    init {
        initOpt()
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
                    mOptLister.optPoint(OptCmd.ADD_FEATURE_KEY)
                }
                R.string.delete -> {
                    //     mBaseImgProcess.deleteSelectFeatureKey()
                }
                R.string.auto_code -> {
                    generateCode()
                }
                R.string.preview -> {

                }
            }
        }

    }


    override fun optPoint(cmd: Int, vararg coordinatePoint: CoordinatePoint) {

    }

    override fun optArea(cmd: Int, vararg area: CoordinateArea) {
        when (cmd) {
            OptCmd.ADD_AREA -> {

            }
        }
    }

    override fun generateCode() {

    }

    override fun hideView() {

    }

    override fun showView() {

    }
}