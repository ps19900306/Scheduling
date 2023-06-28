package com.nwq.function.corelib.ui.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.nwq.function.corelib.R
import com.nwq.function.corelib.databinding.ItemSetCheckBinding
import com.nwq.function.corelib.ui.data.SelectModelInfo

/**
create by: 86136
create time: 2023/3/21 16:36
Function description:
 */

class SelectModelAdapter(data: MutableList<SelectModelInfo>) :
    BaseQuickAdapter<SelectModelInfo, BaseViewHolder>(R.layout.item_set_check, data) {


    init {
        addChildClickViewIds(R.id.checkbox)
    }

    var selectMode = 0

    fun changeSelect(type: Int) {
        if (type != selectMode) {
            selectMode = type
        }
        notifyDataSetChanged()
    }

    override fun convert(holder: BaseViewHolder, item: SelectModelInfo) {
        val bind = ItemSetCheckBinding.bind(holder.itemView)
        bind.checkbox.text = item.title
        bind.checkbox.isChecked = item.typeModel == selectMode
    }

}