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
import com.nwq.function.scheduling.ui.data.SetIntInfo
import com.nwq.function.scheduling.utils.sp.SPRepoPrefix
import com.nwq.function.scheduling.utils.sp.SpConstant


class SettingModelActivity : AppCompatActivity() {


    companion object {

        private const val SET_TYPE = "set_type"
        fun startSettingModel(type: Int, context: Context) {
            val intent = Intent(context, SettingModelActivity::class.java)
            intent.putExtra(SET_TYPE, type)
            context.startActivity(intent)
        }
    }

    lateinit var bind: ActivitySettingModelBinding
    lateinit var adapter: SetParameterAdapter
    var type: Int = 0
    val repo by lazy { SPRepoPrefix.getNowSPRepo() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivitySettingModelBinding.inflate(LayoutInflater.from(this))
        setContentView(bind.root)
        type = intent.getIntExtra(SET_TYPE, 0)
        adapter = SetParameterAdapter(getList())
        bind.recyclerView.adapter = adapter
    }


    private fun getList(): MutableList<MultiItemEntity> {
        val list = mutableListOf<MultiItemEntity>()
        when (type) {
            SpConstant.MINER_MODEL -> {
                list.addAll(minerList)
                list.addAll(vegetableList)
            }
            SpConstant.FIGHT_MODEL -> {
                list.addAll(fightList)
                list.addAll(vegetableList)
            }
            SpConstant.FUBEN_MODEL -> {
                list.addAll(fuBentList)
            }
        }
        return list
    }

    val fightList by lazy {
        listOf(
            SetCheckInfo("开启网子", repo.isCatchFoodSP),
            SetCheckInfo("拾取箱子", repo.isPickupBoxSP),
            SetCheckInfo("盾抗", repo.resistanceModeSP),
            SetIntInfo("际遇基地", repo.fightBaseLocationSP),
            SetListInfo("整个战斗", repo.wholeBattleListSP),
            SetListInfo("单个回合", repo.roundBattleListSP),
            SetListInfo("List1:165", repo.timeOnList1SP),
            SetListInfo("List2:1700", repo.timeOnList2SP),
            SetListInfo("List3:75", repo.timeOnList3SP),
            SetCheckInfo("是否有军团任务", repo.hasLegionnairesSP),
        )
    }

    val fuBentList by lazy {
        listOf(
            SetCheckInfo("开启网子", repo.isCatchFoodFSP),
            SetCheckInfo("是否有推子", repo.isHasPropellerFSP),
            SetCheckInfo("盾抗", repo.resistanceModeFSP),
            SetListInfo("整个战斗", repo.wholeBattleListFSP),
            SetListInfo("单个回合", repo.roundBattleListFSP),
            SetListInfo("List1:165", repo.timeOnList1FSP),
            SetListInfo("List2:1700", repo.timeOnList2FSP),
            SetListInfo("List3:75", repo.timeOnList3FSP),
        )
    }

    val vegetableList by lazy {
        listOf(
            SetCheckInfo("开启收菜", repo.openHarvestVegetablesSP),
            SetCheckInfo("是否换船", repo.transferShipSP),
            SetIntInfo("收菜基地", repo.resourcesBaseLocationSP),
            SetIntInfo("收集间隔/hour", repo.collectIntervalSP),
            SetIntInfo("添加间隔/hour", repo.addIntervalSP),
            SetListInfo("收菜行星列表", repo.celestialResourcesSP),
            )
    }

    val minerList by lazy {
        listOf(
            SetIntInfo("采矿基地", repo.miningBaseLocationSP),
            SetListInfo("矿枪", repo.miningGunListSP),
            SetListInfo("皮球", repo.miningInertiaListSP),
            SetListInfo("圣光", repo.miningStabilizerListSP),
        )
    }
}