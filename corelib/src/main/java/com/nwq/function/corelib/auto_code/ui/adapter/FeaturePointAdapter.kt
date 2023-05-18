package com.nwq.function.corelib.auto_code.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nwq.function.corelib.auto_code.FeatureCoordinatePoint
import com.nwq.function.corelib.auto_code.FeaturePointKey
import com.nwq.function.corelib.databinding.ItemFeatureKeyBinding

/**
create by: 86136
create time: 2023/5/18 10:36
Function description:
 */

class FeaturePointAdapter(var list: List<FeatureCoordinatePoint>) :
    RecyclerView.Adapter<FeatureKeyViewHolder>() {


    fun updateList(data: List<FeatureCoordinatePoint>) {
        list = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeatureKeyViewHolder {
        val binding = ItemFeatureKeyBinding.inflate(LayoutInflater.from(parent.context))
        return FeatureKeyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeatureKeyViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return list.size
    }
}

public class FeaturePointViewHolder(val binding: ItemFeatureKeyBinding) :
    RecyclerView.ViewHolder(binding.root) {

}