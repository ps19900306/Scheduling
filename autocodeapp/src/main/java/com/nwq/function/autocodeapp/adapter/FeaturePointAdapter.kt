package com.nwq.function.autocodeapp.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.nwq.function.autocodeapp.data.FeatureCoordinatePoint
import com.nwq.function.autocodeapp.databinding.ItemFeaturePointBinding


/**
create by: 86136
create time: 2023/5/18 10:36
Function description:
 */

class FeaturePointAdapter(var list: List<FeatureCoordinatePoint>) :
    RecyclerView.Adapter<FeaturePointViewHolder>() {


    fun updateList(data: List<FeatureCoordinatePoint>) {
        list = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturePointViewHolder {
        val binding = ItemFeaturePointBinding.inflate(LayoutInflater.from(parent.context))
        return FeaturePointViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeaturePointViewHolder, position: Int) {
        holder.bindData(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

public class FeaturePointViewHolder(val binding: ItemFeaturePointBinding) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.keyCb.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                getFeaturePoint()?.let {
                    it.isIdentificationKey = b
                }
            }
        }
    }


    fun bindData(data: FeatureCoordinatePoint) {
        binding.root.tag = data
        binding.keyCb.isChecked = data.isIdentificationKey
        binding.colorView.setBackgroundColor(Color.rgb(data.red, data.green, data.blue))
        binding.colorRgbTv.text = "${data.red}：${data.green}：${data.blue}"
        binding.attributeText.text =
            "x:${data.x},y:${data.y} ${if (data.isInternal()) "内部点" else "外部点"}"
    }

    private fun getFeaturePoint(): FeatureCoordinatePoint? {
        val featurePoint = binding.root.tag
        return if (featurePoint is FeatureCoordinatePoint) {
            featurePoint
        } else {
            null
        }
    }
}