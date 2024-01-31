package com.android.system.calendar.ui.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.android.schedule.corelibrary.expand.singleClick
import com.android.system.calendar.R
import com.android.system.calendar.database.RoleDb
import com.android.system.calendar.databinding.ItemRoleListBinding

class RoleListAdapter(
    var selectID: Long,
    val list: List<RoleDb>,
    val updata: (role: RoleDb) -> Unit,
    val onModifyClick: (roleId: Long) -> Unit,
    val onSelectClick: (roleId: Long) -> Unit,
    val onAddClick: () -> Unit,
) : RecyclerView.Adapter<RoleListAdapter.RoleViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoleViewHolder {
        val b = ItemRoleListBinding.inflate(LayoutInflater.from(parent.context))
        return RoleViewHolder(b)
    }

    override fun getItemCount(): Int {
        return if (list.size <= 3) {
            list.size + 1
        } else {
            list.size
        }
    }

    override fun onBindViewHolder(holder: RoleViewHolder, position: Int) {
        if (list.size == 4) {
            list.getOrNull(position)?.let {
                initNormal(holder, it)
            }
        } else {
            if(position==0){
                holder.bind.addBtn.isVisible = true
                holder.bind.normalGroup.isGone = true
                holder.bind.addBtn.singleClick {
                    onAddClick.invoke()
                }
                holder.bind.root.setBackgroundColor(ContextCompat.getColor(holder.bind.root.context, R.color.white))
            }else{
                list.getOrNull(position-1)?.let {
                    initNormal(holder, it)
                }
            }
        }
    }

    private fun initNormal(holder: RoleViewHolder, data: RoleDb) {
        holder.bind.tv.text = data.roleName ?: "角色${data.roleLoginPostion}"

        if (data.id == selectID) {
            holder.bind.root.setBackgroundColor(
                ContextCompat.getColor(
                    holder.bind.root.context,
                    R.color.select_user
                )
            )
        } else {
            holder.bind.root.setBackgroundColor(
                ContextCompat.getColor(
                    holder.bind.root.context,
                    R.color.white
                )
            )
        }
        holder.bind.cb.isChecked = data.isChecked
        holder.bind.modifyBtn.singleClick {
            data.id.let { onModifyClick.invoke(it) }
        }
        holder.bind.root.singleClick {
            data.id.let {
                selectID = it
                onSelectClick.invoke(it)
                notifyDataSetChanged()
            }
        }
        holder.bind.cb.setOnCheckedChangeListener { buttonView, isChecked ->
            data.isChecked = isChecked
            updata.invoke(data)
        }
    }


    class RoleViewHolder(val bind: ItemRoleListBinding) : RecyclerView.ViewHolder(bind.root)
}

