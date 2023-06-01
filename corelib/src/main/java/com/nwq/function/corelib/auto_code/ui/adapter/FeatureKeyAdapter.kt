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

class FeatureKeyAdapter(val list: List<FeaturePointKey>,  val map: MutableMap<FeaturePointKey, MutableList<FeatureCoordinatePoint>>) :
    RecyclerView.Adapter<FeatureKeyViewHolder>() {

    companion object {
        val key1 = 1
        val key2 = 2
    }

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

    init {
        binding.expandBtn.singleClick {
            getFeaturePointKey()?.let {
                if (it.isExpend) {
                    getFeaturePointList()?.let { list ->
                        binding.pointRecycler.isVisible = list.isNotEmpty()
                    } ?: let {
                        binding.pointRecycler.isVisible = false
                    }
                } else {
                    binding.pointRecycler.isVisible = false
                }
            }
        }

        binding.keyCb.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                getFeaturePointKey()?.let {
                    it.isChecked = b
                }
            }
        }

        binding.pointRecycler.adapter = mFeaturePointAdapter
    }


    fun bindData(featurePointKey: FeaturePointKey, list: List<FeatureCoordinatePoint>?) {
        binding.root.setTag(FeatureKeyAdapter.key1, featurePointKey)
        binding.root.setTag(FeatureKeyAdapter.key2, list)
        binding.keyCb.isChecked = featurePointKey.isChecked
        binding.colorView.setBackgroundColor(featurePointKey.colorInt)
        binding.colorRgbTv.text =
            "${featurePointKey.red}：${featurePointKey.green}：${featurePointKey.blue}"
        list?.let { mFeaturePointAdapter.updateList(it) }
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
        val featurePointKey = binding.root.getTag(FeatureKeyAdapter.key1)
        return if (featurePointKey is FeaturePointKey) {
            featurePointKey
        } else {
            null
        }
    }

    private fun getFeaturePointList(): List<*>? {
        val featurePointList = binding.root.getTag(FeatureKeyAdapter.key2)
        return if (featurePointList is List<*>) {
            featurePointList
        } else {
            null
        }
    }

}