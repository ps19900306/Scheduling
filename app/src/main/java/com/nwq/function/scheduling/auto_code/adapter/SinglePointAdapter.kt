package com.nwq.function.scheduling.auto_code.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nwq.function.scheduling.auto_code.data.SinglePointColorValue
import com.nwq.function.scheduling.databinding.ItemSinglePointBinding
import com.nwq.function.scheduling.utils.singleClick

class SinglePointAdapter() : RecyclerView.Adapter<SinglePointViewHolder>() {

    var list = mutableListOf<SinglePointColorValue>()

    fun setData(data: MutableList<SinglePointColorValue>) {
        list = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SinglePointViewHolder {
        val binding = ItemSinglePointBinding.inflate(LayoutInflater.from(parent.context))
        return SinglePointViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SinglePointViewHolder, position: Int) {
        list.getOrNull(position)?.let {
            holder.binding.tv.text = it.toString()
            holder.binding.view.setBackgroundColor(Color.rgb(it.red, it.green, it.blue))
            holder.binding.deleteBtn.singleClick {
                list.removeAt(position)
                notifyItemRemoved(position)
            }
        }
    }
}

public class SinglePointViewHolder(val binding: ItemSinglePointBinding) :
    RecyclerView.ViewHolder(binding.root) {}



