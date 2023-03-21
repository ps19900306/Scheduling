package com.nwq.function.scheduling.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.nwq.function.scheduling.R
import com.nwq.function.scheduling.databinding.ItemSetCheckBinding
import com.nwq.function.scheduling.databinding.ItemSetIntBinding
import com.nwq.function.scheduling.databinding.ItemSetListBinding
import com.nwq.function.scheduling.ui.data.SetCheckInfo
import com.nwq.function.scheduling.ui.data.SetListInfo
import com.nwq.function.scheduling.ui.data.SetPositionInfo
import com.nwq.function.scheduling.utils.singleClick

/**
create by: 86136
create time: 2023/3/21 10:30
Function description:
 */

class SetParameterAdapter(list: MutableList<MultiItemEntity>) :
    BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder>(list) {

    companion object {
        const val CHECK_TYPE = 1
        const val INT_TYPE = 2
        const val LIST_TYPE = 3
    }

    init {
        addItemType(CHECK_TYPE, R.layout.item_set_check)
        addItemType(INT_TYPE, R.layout.item_set_int)
        addItemType(LIST_TYPE, R.layout.item_set_list)
    }

    override fun convert(holder: BaseViewHolder, item: MultiItemEntity) {
        when (item) {
            is SetCheckInfo -> {
                val bind = ItemSetCheckBinding.bind(holder.itemView)
                bind.checkbox.setOnCheckedChangeListener { compoundButton, b -> item.check(b) }
                bind.checkbox.text = item.title
                bind.checkbox.isChecked = item.isCheck
            }
            is SetPositionInfo -> {
                val bind = ItemSetIntBinding.bind(holder.itemView)
                bind.okBtn.singleClick {
                    bind.contentEdit.text.toString().let {
                        item.addData(it)
                        bind.titleTv.text = it
                    }
                    bind.contentEdit.setText("")
                }
                bind.contentEdit.setHint(item.title)
                bind.titleTv.text = item.position.toString()
            }
            is SetListInfo -> {
                val bind = ItemSetListBinding.bind(holder.itemView)
                bind.okBtn.singleClick {
                    bind.contentEdit.text.toString().let {
                        item.addData(it)
                        bind.titleTv.text = item.listStr
                    }
                    bind.contentEdit.setText("")
                }
                bind.clearBtn.singleClick {
                    item.clearData()
                    bind.titleTv.text = item.listStr
                }
                bind.contentEdit.setHint(item.title)
                bind.titleTv.text = item.listStr
            }
        }
    }
}