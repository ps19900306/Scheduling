package com.nwq.function.corelib.auto_code.ui.adapter

import android.widget.Button
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.nwq.function.corelib.R
import com.nwq.function.corelib.auto_code.ui.data.FunctionItemInfo

/**
create by: 86136
create time: 2023/5/30 14:02
Function description:
 */

class FunctionItemAdapter(list: MutableList<FunctionItemInfo>) :
    BaseMultiItemQuickAdapter<FunctionItemInfo, BaseViewHolder>(list) {


    companion object {
        const val CHECK_TYPE = 1
        const val BUTTON_TYPE = 2
    }

    init {
        addItemType(CHECK_TYPE, R.layout.item_check)
        addItemType(BUTTON_TYPE, R.layout.item_button)

    }

    override fun convert(holder: BaseViewHolder, item: FunctionItemInfo) {
        when(holder.itemViewType){
            CHECK_TYPE->{
                holder.setText(R.id.cBox,item.strId)
            }
            BUTTON_TYPE->{
                holder.setText(R.id.btn,item.strId)
            }
        }
    }


}