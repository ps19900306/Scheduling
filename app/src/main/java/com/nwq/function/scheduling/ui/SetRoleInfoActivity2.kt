package com.nwq.function.scheduling.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.google.gson.Gson
import com.nwq.function.scheduling.databinding.ActivityGetColorBinding
import com.nwq.function.scheduling.databinding.ActivitySetRoleInfo2Binding
import com.nwq.function.scheduling.utils.BroadcastUtils
import com.nwq.function.scheduling.utils.JsonUtil
import com.nwq.function.scheduling.utils.singleClick
import com.nwq.function.scheduling.utils.sp.SP
import com.nwq.function.scheduling.utils.sp.SPRepo
import com.nwq.function.scheduling.utils.sp.SpConstant

class SetRoleInfoActivity2 : AppCompatActivity() {

    companion object{
        fun startSetRole(role:String,context: Context){
            val intent =Intent(context,SetRoleInfoActivity2::class.java)
            SPRepo.role=role
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

    val list1: MutableList<Int> by lazy {
        JsonUtil.anyToJsonObject(timeOnList1SP) ?: mutableListOf()
    }
    val list2: MutableList<Int> by lazy {
        JsonUtil.anyToJsonObject(timeOnList2SP) ?: mutableListOf()
    }
    val list3: MutableList<Int> by lazy {
        JsonUtil.anyToJsonObject(timeOnList3SP) ?: mutableListOf()
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
        bind.pickupCheckTv.setOnCheckedChangeListener { buttonView, isChecked ->
            isCatchFoodSp = isChecked
        }
        //111
        bind.list1Btn.singleClick {
            bind.list1Edit.text.toString().toIntOrNull()?.let {
                if(!list1.contains(it)){
                    list1.add(it)
                    timeOnList1SP = JsonUtil.objectToString(list1)
                    bind.list1TitleTv.text = timeOnList1SP
                }
            }
        }
        bind.list1ClearBtn.singleClick {
            list1.clear()
            timeOnList1SP =""
            bind.list1TitleTv.text =""
        }

        //222
        bind.list2Btn.singleClick {
            bind.list2Edit.text.toString().toIntOrNull()?.let {
                if(!list2.contains(it)){
                    list2.add(it)
                    timeOnList2SP = JsonUtil.objectToString(list2)
                    bind.list2TitleTv.text = timeOnList2SP
                }
            }
        }
        bind.list2ClearBtn.singleClick {
            list2.clear()
            timeOnList2SP =""
            bind.list2TitleTv.text =""
        }
        //333
        bind.list3Btn.singleClick {
            bind.list3Edit.text.toString().toIntOrNull()?.let {
                if(!list3.contains(it)){
                    list3.add(it)
                    timeOnList3SP = JsonUtil.objectToString(list3)
                    bind.list3TitleTv.text = timeOnList3SP
                }
            }
        }
        bind.list3ClearBtn.singleClick {
            list3.clear()
            timeOnList3SP =""
            bind.list3TitleTv.text =""
        }
    }

    fun initData() {
        bind.resistanceModeCheckTv.isChecked = resistanceModeSP
        bind.pickupCheckTv.isChecked = isPickupBoxSP
        bind.catchFoodCheckBox.isChecked = isCatchFoodSp
        bind.baseLocationEdit.setText("$baseLocationSP")
        bind.list1TitleTv.text = timeOnList1SP
        bind.list2TitleTv.text  = timeOnList2SP
        bind.list3TitleTv.text  = timeOnList3SP
    }

}