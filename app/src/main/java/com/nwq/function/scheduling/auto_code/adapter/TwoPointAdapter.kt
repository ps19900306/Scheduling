package com.nwq.function.scheduling.auto_code.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nwq.function.scheduling.auto_code.data.SinglePointColorValue
import com.nwq.function.scheduling.auto_code.data.TwoPointColorValue
import com.nwq.function.scheduling.databinding.ItemSinglePointBinding
import com.nwq.function.scheduling.databinding.ItemTwoPointBinding
import com.nwq.function.scheduling.utils.singleClick

class TwoPointAdapter() : RecyclerView.Adapter<TwoPointViewHolder>() {

    var list = mutableListOf<TwoPointColorValue>()

    fun setData(data: MutableList<TwoPointColorValue>) {
        list=data
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TwoPointViewHolder {
        val binding = ItemTwoPointBinding.inflate(LayoutInflater.from(parent.context))
        return TwoPointViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TwoPointViewHolder, position: Int) {
        list.getOrNull(position)?.let {
            holder.binding.tv1.text = it.point1.toString()
            holder.binding.view1.setBackgroundColor(
                Color.rgb(
                    it.point1.red, it.point1.green, it.point1.blue
                )
            )
            holder.binding.tv2.text = it.point2.toString()
            holder.binding.view2.setBackgroundColor(
                Color.rgb(
                    it.point2.red, it.point2.green, it.point2.blue
                )
            )
            holder.binding.deleteBtn.singleClick {
                list.removeAt(position)
                notifyItemRemoved(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}

public class TwoPointViewHolder(val binding: ItemTwoPointBinding) :
    RecyclerView.ViewHolder(binding.root) {}




