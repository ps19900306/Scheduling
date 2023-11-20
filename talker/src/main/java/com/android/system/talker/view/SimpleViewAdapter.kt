package com.android.system.talker.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.schedule.corelibrary.expand.singleClick
import com.android.system.talker.databinding.ItemSimpleViewBinding

class SimpleViewAdapter(
    val list: List<SimpleViewData>, val onClick: (item: SimpleViewData) -> Unit
) : RecyclerView.Adapter<SimpleViewAdapter.SimpleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        val b = ItemSimpleViewBinding.inflate(LayoutInflater.from(parent.context))
        return SimpleViewHolder(b)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        list.getOrNull(position)?.let { data ->
            holder.bindData(data)
            holder.bind.root.singleClick {
                onClick.invoke(data)
            }
        }
    }


    class SimpleViewHolder(val bind: ItemSimpleViewBinding) : RecyclerView.ViewHolder(bind.root) {

        fun bindData(data: SimpleViewData) {
            data.getTitle()?.let {
                bind.itemTitleTv.text = it
            }
            data.getEnd()?.let {
                bind.itemEndTv.text = it
            }
        }
    }
}