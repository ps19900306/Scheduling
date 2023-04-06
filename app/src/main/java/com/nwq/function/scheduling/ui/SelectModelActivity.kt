package com.nwq.function.scheduling.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.nwq.function.scheduling.databinding.ActivitySelectModelBinding
import com.nwq.function.scheduling.ui.adapter.SelectModelAdapter
import com.nwq.function.scheduling.ui.data.SelectModelInfo
import com.nwq.function.scheduling.utils.sp.SPRepo
import com.nwq.function.scheduling.utils.sp.SPRepoPrefix
import com.nwq.function.scheduling.utils.sp.SpConstant

class SelectModelActivity : AppCompatActivity() {


    companion object {
        fun startSelectSet(role: String, context: Context) {
            val intent = Intent(context, SelectModelActivity::class.java)
            SPRepo.role = role
            context.startActivity(intent)
        }
    }

    lateinit var bind: ActivitySelectModelBinding
    val repo by lazy { SPRepoPrefix.getNowSPRepo() }
    lateinit var adapter: SelectModelAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivitySelectModelBinding.inflate(LayoutInflater.from(this))
        setContentView(bind.root)
        adapter = SelectModelAdapter(getList())
        adapter.selectMode = repo.nowSelectMode
        bind.recyclerView.adapter = adapter
        adapter.setOnItemClickListener { a, v, p ->
            adapter.data.getOrNull(p)?.let {
                SettingModelActivity.startSettingModel(it.typeModel, this)
            }
        }

        adapter.setOnItemChildClickListener { a, v, p ->
            adapter.data.getOrNull(p)?.let {
                adapter.changeSelect(it.typeModel)
                repo.nowSelectMode = it.typeModel
            }
        }

    }

    private fun getList(): MutableList<SelectModelInfo> {
        val list = mutableListOf<SelectModelInfo>()
        list.add(SelectModelInfo("际遇模式", SpConstant.FIGHT_MODEL))
        list.add(SelectModelInfo("采矿模式", SpConstant.MINER_MODEL))
        list.add(SelectModelInfo("收菜模式", SpConstant.VEGETABLES_MODEL))
        list.add(SelectModelInfo("副本普通成员模式", SpConstant.DUNGEON_ORDINARY_MODEL))
        list.add(SelectModelInfo("副本领导模式", SpConstant.DUNGEON_LEAD_MODEL))
        return list
    }
}