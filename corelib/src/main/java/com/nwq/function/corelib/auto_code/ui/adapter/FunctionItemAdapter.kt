package com.nwq.function.corelib.auto_code.ui.adapter

import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
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

class FunctionItemAdapter(
    list: MutableList<FunctionItemInfo>,
    val textChange: ((id: Int, str: String) -> Unit)?=null
) :
    BaseMultiItemQuickAdapter<FunctionItemInfo, BaseViewHolder>(list) {


    companion object {
        const val CHECK_TYPE = 1
        const val BUTTON_TYPE = 2
        const val EDIT_TEXT_TYPE = 3
    }

    init {
        addItemType(CHECK_TYPE, R.layout.item_check)
        addItemType(BUTTON_TYPE, R.layout.item_button)
        addItemType(EDIT_TEXT_TYPE, R.layout.item_edit_text)
    }

    override fun convert(holder: BaseViewHolder, item: FunctionItemInfo) {
        when (holder.itemViewType) {
            CHECK_TYPE -> {
                holder.setText(R.id.cBox, item.strId)
                holder.getView<CheckBox>(R.id.cBox).isChecked = item.isCheck
            }
            BUTTON_TYPE -> {
                holder.setText(R.id.btn, item.strId)
            }
            EDIT_TEXT_TYPE -> {
                holder.getView<EditText>(R.id.edit).let { view ->
                    view.setHint(item.strId)
                    view.tag = item.strId
                    view.addTextChangedListener {
                        val str = it?.toString() ?: ""
                        val id = view.tag as Int
                        textChange?.invoke(id, str)
                    }
                }

            }
        }
    }


}