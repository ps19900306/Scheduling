package com.nwq.function.corelib.auto_code.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nwq.function.corelib.auto_code.FeatureCoordinatePoint
import com.nwq.function.corelib.auto_code.FeaturePointKey
import com.nwq.function.corelib.databinding.PartImgFeatureBinding

/**
create by: 86136
create time: 2023/5/17 15:40
Function description:
 */

class FeatureKeyAdapter(val map: HashMap<FeaturePointKey, MutableList<FeatureCoordinatePoint>>) :
    RecyclerView.Adapter<FeatureKeyViewHolder>() {

    companion object {
        val key1 = 1
        val key2 = 2
    }

    var list = map.keys.toList()

    fun updateData() {
        list = map.keys.toList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeatureKeyViewHolder {
        val binding = PartImgFeatureBinding.inflate(LayoutInflater.from(parent.context))
        return FeatureKeyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeatureKeyViewHolder, position: Int) {
        list.getOrNull(position)?.let { featurePointKey ->
            holder.binding.root.setTag(key1, featurePointKey)
            map.get(featurePointKey)?.let { pointList ->
                holder.binding.root.setTag(key2, pointList)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}

public class FeatureKeyViewHolder(val binding: PartImgFeatureBinding) :
    RecyclerView.ViewHolder(binding.root) {

    init {

    }

}