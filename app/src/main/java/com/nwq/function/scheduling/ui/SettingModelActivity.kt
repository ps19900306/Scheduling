package com.nwq.function.scheduling.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.nwq.function.scheduling.databinding.ActivitySettingModelBinding
import com.nwq.function.scheduling.ui.adapter.SetParameterAdapter
import com.nwq.function.scheduling.ui.data.SetCheckInfo
import com.nwq.function.scheduling.ui.data.SetListInfo
import com.nwq.function.scheduling.ui.data.SetPositionInfo
import com.nwq.function.scheduling.utils.sp.SPRepo
import com.nwq.function.scheduling.utils.sp.SPRepoPrefix

class SettingModelActivity : AppCompatActivity() {


    companion object {
        fun startSettingModel(role: String, context: Context) {
            val intent = Intent(context, SettingModelActivity::class.java)
            SPRepo.role = role
            context.startActivity(intent)
        }
    }

    lateinit var bind: ActivitySettingModelBinding
    lateinit var adapter: SetParameterAdapter

    val repo by lazy { SPRepoPrefix.getNowSPRepo() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivitySettingModelBinding.inflate(LayoutInflater.from(this))
        setContentView(bind.root)
        adapter = SetParameterAdapter(getList())
        bind.recyclerView.adapter = adapter
    }


    private fun getList(): MutableList<MultiItemEntity> {
        val list = mutableListOf<MultiItemEntity>()
        list.add(SetCheckInfo("是否拾取箱子", repo.isPickupBoxSP))
        list.add(SetPositionInfo("战斗基地坐标", repo.fightBaseLocationSP))
        list.add(SetListInfo("timeOnList1", repo.timeOnList1SP))
        return list
    }

}