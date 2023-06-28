package com.nwq.function.corelib.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.nwq.function.corelib.databinding.ActivitySetRoleInfo2Binding
import com.nwq.function.corelib.utils.JsonUtil
import com.nwq.function.corelib.utils.singleClick
import com.nwq.function.corelib.utils.sp.SP
import com.nwq.function.corelib.utils.sp.SPRepo
import com.nwq.function.corelib.utils.sp.SPRepoPrefix
import com.nwq.function.corelib.utils.sp.SpConstant

class SetRoleInfoActivity2 : AppCompatActivity() {

    companion object {
        fun startSetRole(role: String, context: Context) {
            val intent = Intent(context, SetRoleInfoActivity2::class.java)
            SPRepo.role = role
            context.startActivity(intent)
        }
    }

    lateinit var bind: ActivitySetRoleInfo2Binding
    val prefixRole by lazy { SPRepo.role }

    var resistanceModeSP by SP(prefixRole + SpConstant.CRESISTANCE_MODE, false)
    var isPickupBoxSP by SP(prefixRole + SpConstant.IS_PICKUP_BOX, false)
    var isCatchFoodSp by SP(prefixRole + SpConstant.IS_CATCH_FOOD, true)
    var baseLocationSP by SP(prefixRole + SpConstant.BASE_LOCATION, 0)
    var timeOnList1SP by SP(prefixRole + SpConstant.TIME_ON_LIST1, "[11,12]")
    var timeOnList2SP by SP(prefixRole + SpConstant.TIME_ON_LIST2, "")
    var timeOnList3SP by SP(prefixRole + SpConstant.TIME_ON_LIST3, "[10]")
    var wholeBattleListSP by SP(prefixRole + SpConstant.WHOLE_BATTLE_LIST, "[1,8]")
    var roundBattleListSP by SP(prefixRole + SpConstant.ROUND_BATTLE_LIST, "[4,5]")
    var celestialResourcesSP by SP(prefixRole + SpConstant.CELESTIAL_RESOURCES_LIST, "")
    var resourcesBaseLocationSP by SP(prefixRole + SpConstant.RESOURCES_BASE_LOCATION, 0)
    var openHarvestVegetablesSP by SP(prefixRole + SpConstant.OPEN_HARVEST_VEGETABLES, false)

    val list1: MutableList<Int> by lazy {
        JsonUtil.anyToJsonObject(timeOnList1SP) ?: mutableListOf()
    }
    val list2: MutableList<Int> by lazy {
        JsonUtil.anyToJsonObject(timeOnList2SP) ?: mutableListOf()
    }
    val list3: MutableList<Int> by lazy {
        JsonUtil.anyToJsonObject(timeOnList3SP) ?: mutableListOf()
    }
    val wholeList: MutableList<Int> by lazy {
        JsonUtil.anyToJsonObject(wholeBattleListSP) ?: mutableListOf()
    }
    val roundList: MutableList<Int> by lazy {
        JsonUtil.anyToJsonObject(roundBattleListSP) ?: mutableListOf()
    }
    val celestialResourcesList: MutableList<Int> by lazy {
        JsonUtil.anyToJsonObject(celestialResourcesSP) ?: mutableListOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivitySetRoleInfo2Binding.inflate(LayoutInflater.from(this))
        setContentView(bind.root)
        initData()
        initClick()
    }

    fun initClick() {
        bind.resistanceModeCheckTv.setOnCheckedChangeListener { buttonView, isChecked ->
            resistanceModeSP = isChecked
        }
        bind.pickupCheckTv.setOnCheckedChangeListener { buttonView, isChecked ->
            isPickupBoxSP = isChecked
        }
        bind.catchFoodCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            isCatchFoodSp = isChecked
        }
        bind.baseLocationBtn.singleClick {
            bind.baseLocationEdit.text.toString().toIntOrNull()?.let {
                bind.baseLocationEdit.setText("")
                bind.baseLocationTitleTv.setText("$it")
                baseLocationSP = it
            }
        }
        //111
        bind.list1Btn.singleClick {
            bind.list1Edit.text.toString().toIntOrNull()?.let {
                if (!list1.contains(it)) {
                    list1.add(it)
                    timeOnList1SP = JsonUtil.objectToString(list1)
                    bind.list1TitleTv.text = timeOnList1SP
                    bind.list1Edit.setText("")
                }
            }
        }
        bind.list1ClearBtn.singleClick {
            list1.clear()
            timeOnList1SP = ""
            bind.list1TitleTv.text = ""
        }

        //222
        bind.list2Btn.singleClick {
            bind.list2Edit.text.toString().toIntOrNull()?.let {
                if (!list2.contains(it)) {
                    list2.add(it)
                    timeOnList2SP = JsonUtil.objectToString(list2)
                    bind.list2TitleTv.text = timeOnList2SP
                    bind.list2Edit.setText("")
                }
            }
        }
        bind.list2ClearBtn.singleClick {
            list2.clear()
            timeOnList2SP = ""
            bind.list2TitleTv.text = ""
        }
        //333
        bind.list3Btn.singleClick {
            bind.list3Edit.text.toString().toIntOrNull()?.let {
                if (!list3.contains(it)) {
                    list3.add(it)
                    timeOnList3SP = JsonUtil.objectToString(list3)
                    bind.list3TitleTv.text = timeOnList3SP
                    bind.list3Edit.setText("")
                }
            }
        }
        bind.list3ClearBtn.singleClick {
            list3.clear()
            timeOnList3SP = ""
            bind.list3TitleTv.text = ""
        }
        //whole
        bind.wholeBattleBtn.singleClick {
            bind.wholeBattleEdit.text.toString().toIntOrNull()?.let {
                if (!wholeList.contains(it)) {
                    wholeList.add(it)
                    wholeBattleListSP = JsonUtil.objectToString(wholeList)
                    bind.wholeBattleTitleTv.text = wholeBattleListSP
                    bind.wholeBattleEdit.setText("")
                }
            }
        }
        bind.wholeBattleClearBtn.singleClick {
            wholeList.clear()
            wholeBattleListSP = ""
            bind.wholeBattleTitleTv.text = ""
        }
        //round
        bind.roundBattleBtn.singleClick {
            bind.roundBattleEdit.text.toString().toIntOrNull()?.let {
                if (!roundList.contains(it)) {
                    roundList.add(it)
                    roundBattleListSP = JsonUtil.objectToString(roundList)
                    bind.roundBattleTitleTv.text = roundBattleListSP
                    bind.roundBattleEdit.setText("")
                }
            }
        }
        bind.roundBattleClearBtn.singleClick {
            roundList.clear()
            roundBattleListSP = ""
            bind.roundBattleTitleTv.text = ""
        }
        //celestialResources
        bind.celestialResourcesBtn.singleClick {
            bind.celestialResourcesEdit.text.toString().toIntOrNull()?.let {
                celestialResourcesList.add(it)
                celestialResourcesSP = JsonUtil.objectToString(celestialResourcesList)
                bind.celestialResourcesTitleTv.text = celestialResourcesSP
                bind.celestialResourcesEdit.setText("")
            }
        }
        bind.celestialResourcesClearBtn.singleClick {
            celestialResourcesList.clear()
            celestialResourcesSP = ""
            bind.celestialResourcesTitleTv.text = ""
        }

        //设置收菜基地坐标
        bind.resourceBaseLocationBtn.singleClick {
            bind.resourceBaseLocationEdit.text.toString().toIntOrNull()?.let {
                resourcesBaseLocationSP = it
                bind.resourceBaseLocationEdit.setText("")
                bind.resourceBaseLocationTitleTv.text = it.toString()
            }
        }

        bind.resourceBaseCheckTv.singleClick {
            openHarvestVegetablesSP = it.isChecked
        }

        bind.fightModeCheck.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                SPRepoPrefix.getNowSPRepo().nowSelectMode = SpConstant.FIGHT_MODEL
            } else {
                SPRepoPrefix.getNowSPRepo().nowSelectMode = SpConstant.MINER_MODEL
            }
        }
    }

    fun initData() {
        bind.resistanceModeCheckTv.isChecked = resistanceModeSP
        bind.pickupCheckTv.isChecked = isPickupBoxSP
        bind.catchFoodCheckBox.isChecked = isCatchFoodSp
        bind.baseLocationTitleTv.text = "$baseLocationSP"
        bind.list1TitleTv.text = timeOnList1SP
        bind.list2TitleTv.text = timeOnList2SP
        bind.list3TitleTv.text = timeOnList3SP
        bind.wholeBattleTitleTv.text = wholeBattleListSP
        bind.roundBattleTitleTv.text = roundBattleListSP
        bind.celestialResourcesTitleTv.text = celestialResourcesSP
        bind.resourceBaseLocationTitleTv.text = "$resourcesBaseLocationSP"
        bind.resourceBaseCheckTv.isChecked = openHarvestVegetablesSP
        bind.fightModeCheck.isChecked =
            SPRepoPrefix.getNowSPRepo().nowSelectMode == SpConstant.FIGHT_MODEL
    }




}