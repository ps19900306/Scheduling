package com.nwq.function.corelib.auto_code.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.nwq.function.corelib.auto_code.ui.data.FeatureCoordinatePoint
import com.nwq.function.corelib.auto_code.ui.data.FeaturePointKey
import com.nwq.function.corelib.databinding.ItemFeatureKeyBinding
import com.nwq.function.corelib.utils.singleClick


/**
create by: 86136
create time: 2023/5/17 15:40
Function description:
 */

class FeatureKeyAdapter(
    val list: List<FeaturePointKey>,
    val map: MutableMap<FeaturePointKey, MutableList<FeatureCoordinatePoint>>
) :
    RecyclerView.Adapter<FeatureKeyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeatureKeyViewHolder {
        val binding = ItemFeatureKeyBinding.inflate(LayoutInflater.from(parent.context))
        return FeatureKeyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeatureKeyViewHolder, position: Int) {
        list.getOrNull(position)?.let { featurePointKey ->
            holder.bindData(featurePointKey, map[featurePointKey])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}

public class FeatureKeyViewHolder(val binding: ItemFeatureKeyBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private val mFeaturePointAdapter by lazy {
        FeaturePointAdapter(listOf())
    }

    private var list: List<FeatureCoordinatePoint>? = null


    init {
//        binding.expandBtn.singleClick {
//            getFeaturePointKey()?.let {
//                it.isExpend = !it.isExpend
//                if (it.isExpend) {
//                    getFeaturePointList()?.let { list ->
//                        binding.pointRecycler.isVisible = list.isNotEmpty()
//                        //这里设置未重要的
//                        var pointList = list?.filter { it.isIdentificationKey }
//                        if (pointList.isNullOrEmpty()) {
//                            pointList = list?.filter { it.isBoundary() }
//                        }
//                        if (pointList.isNotEmpty() == true) {
//                            mFeaturePointAdapter.updateList(pointList)
//                        }
//                    } ?: let {
//                        binding.pointRecycler.isVisible = false
//                    }
//                } else {
//                    binding.pointRecycler.isVisible = false
//                }
//            }
//        }

        binding.keyCb.setOnCheckedChangeListener { compoundButton, b ->
            getFeaturePointKey()?.let {
                it.isChecked = b
            }
        }

        binding.pointRecycler.adapter = mFeaturePointAdapter
    }


    fun bindData(featurePointKey: FeaturePointKey, list: List<FeatureCoordinatePoint>?) {
        binding.root.tag = featurePointKey
        this.list = list
        binding.keyCb.isChecked = featurePointKey.isChecked
        binding.colorView.setBackgroundColor(featurePointKey.colorInt)
        binding.colorRgbTv.text =
            "${featurePointKey.red}：${featurePointKey.green}：${featurePointKey.blue}"

        binding.attributeText.text =
            "T:${list?.size ?: 0} K:${list?.filter { it.isIdentificationKey }?.size ?: 0}"

        //这里设置未重要的
        var pointList = list?.filter { it.isIdentificationKey }
        if (pointList.isNullOrEmpty()) {
            pointList = list?.filter { it.isBoundary() }
        }
        if (pointList?.isNotEmpty() == true) {
            mFeaturePointAdapter.updateList(pointList)
        }

        binding.pointRecycler.adapter = mFeaturePointAdapter
        if (featurePointKey.isExpend) {
            list?.let { list ->
                binding.pointRecycler.isVisible = list.isNotEmpty()
            } ?: let {
                binding.pointRecycler.isVisible = false
            }
        } else {
            binding.pointRecycler.isVisible = false
        }
    }

    private fun getFeaturePointKey(): FeaturePointKey? {
        val featurePointKey = binding.root.tag
        return if (featurePointKey is FeaturePointKey) {
            featurePointKey
        } else {
            null
        }
    }

    private fun getFeaturePointList(): List<FeatureCoordinatePoint>? {
        return list
    }

}