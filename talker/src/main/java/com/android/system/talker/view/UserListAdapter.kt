package com.android.system.talker.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.android.schedule.corelibrary.expand.singleClick
import com.android.system.talker.R
import com.android.system.talker.database.UserDao
import com.android.system.talker.database.UserDb
import com.android.system.talker.databinding.ItemSimpleViewBinding
import com.android.system.talker.databinding.ItemUserListBinding

class UserListAdapter(
    var selectID:Long,
    val list: List<UserDb>,
    val updata: (userDb: UserDb) -> Unit,
    val onModifyClick: (userId: Long) -> Unit,
    val onSelectClick: (userId: Long) -> Unit,
    val onAddClick: () -> Unit,
) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val b = ItemUserListBinding.inflate(LayoutInflater.from(parent.context))
        return UserViewHolder(b)
    }

    override fun getItemCount(): Int {
        return list.size + 1
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        if (position == 0) {
            holder.bind.addBtn.isVisible = true
            holder.bind.normalGroup.isGone = true
            holder.bind.addBtn.singleClick {
                onAddClick.invoke()
            }
            holder.bind.root.setBackgroundColor(ContextCompat.getColor(holder.bind.root.context, R.color.white))
        } else {
            list.getOrNull(position - 1)?.let { data ->
                holder.bind.tv.text = data.sccoutStr

                if(data.id==selectID){
                    holder.bind.root.setBackgroundColor(ContextCompat.getColor(holder.bind.root.context, R.color.select_user))
                }else{
                    holder.bind.root.setBackgroundColor(ContextCompat.getColor(holder.bind.root.context, R.color.white))
                }

                holder.bind.cb.isChecked = data.isChecked
                holder.bind.modifyBtn.singleClick {
                    data.id?.let { onModifyClick.invoke(it) }
                }
                holder.bind.root.singleClick {
                    data.id?.let {
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
        }
    }

    class UserViewHolder(val bind: ItemUserListBinding) : RecyclerView.ViewHolder(bind.root)


}