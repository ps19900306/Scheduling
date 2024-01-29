package com.android.system.calendar.excuter

import android.accessibilityservice.AccessibilityService
import com.android.schedule.corelibrary.controller.TurnBaseController
import com.android.system.calendar.constant.BaiYeType
import com.android.system.calendar.constant.DungeonOrdinaryType
import com.android.system.calendar.excuter.nomarl.BaiYeFunction
import com.android.system.calendar.excuter.nomarl.BangMerchantFunction
import com.android.system.calendar.excuter.nomarl.BangTaskFunction
import com.android.system.calendar.excuter.nomarl.DailyGiftFunction
import com.android.system.calendar.excuter.nomarl.DungeonOrdinaryFunction
import com.android.system.calendar.excuter.nomarl.ImageEnvironment
import com.android.system.calendar.excuter.nomarl.MountainsRiversPaintingFunction
import com.android.system.calendar.excuter.nomarl.ShiMenFunction
import com.android.system.calendar.excuter.nomarl.TransportTreasureFunction
import com.android.system.calendar.excuter.nomarl.TreasureMapFunction
import com.android.system.calendar.excuter.nomarl.XunLongFenJinFunction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MasterControl(acService: AccessibilityService) : TurnBaseController(acService) {


    private var job: Job? = null
    val en = ImageEnvironment()

    override fun start() {
        job?.cancel()
        job = GlobalScope.launch(Dispatchers.IO) {
            OriginFunction(acService).startTheProcess()

//            DungeonOrdinaryFunction(acService,en, mutableListOf(
//                DungeonOrdinaryType.TIAN_NING_SHI,
//                DungeonOrdinaryType.YAN_ZI_WU,
//                DungeonOrdinaryType.MAN_TUO_SHAN)
//            ).startFunction()
//            ShiMenFunction(acService,en).startFunction()
//            BangTaskFunction(acService,en).startFunction()
//            MountainsRiversPaintingFunction(acService,en).startFunction()
//            TreasureMapFunction(acService,en).startFunction()
        }
    }


    fun startOrigin() {
        job?.cancel()
        job = GlobalScope.launch(Dispatchers.IO) {
            OriginFunction(acService).startTheProcess()
        }
    }


    fun startDaily() {
        job?.cancel()
        job = GlobalScope.launch(Dispatchers.IO) {
            for(i in 2..3){
                if(i!=2){
                    BangMerchantFunction(acService, en).let {
                        it.switchRole(i)
                        it.startFunction()
                    }
                }else{
                    BangMerchantFunction(acService, en).startFunction()
                }
                BangTaskFunction(acService, en).startFunction()
                MountainsRiversPaintingFunction(acService, en).startFunction()
                TreasureMapFunction(acService, en).startFunction()
                XunLongFenJinFunction(acService, en).startFunction()
            }
        }
    }

    //YAO pass
    //Mu Fail
    //DIAO pass
    //JINpass
    fun startShiMen() {
        job?.cancel()
        job = GlobalScope.launch(Dispatchers.IO) {
            DailyGiftFunction(acService, en).startFunction()
           // BaiYeFunction(BaiYeType.MU_KE,0,0,  acService, en).startFunction()
        }
    }

    fun startDungeon() {
        job?.cancel()
        job = GlobalScope.launch(Dispatchers.IO) {
            DungeonOrdinaryFunction(
                acService, en, mutableListOf(
                    DungeonOrdinaryType.QIN_HUAI,
                    DungeonOrdinaryType.MAN_TUO_SHAN,
                    DungeonOrdinaryType.TIAN_NING_SHI,
                )
            ).startFunction()
        }
    }


    fun startTransport(){
        job?.cancel()
        job = GlobalScope.launch(Dispatchers.IO) {
            for(i in 1..3){
                if(i!=1){
                    TransportTreasureFunction(acService, en).let {
                        it.switchRole(i)
                        it.startFunction()
                    }
                }else{
                    TransportTreasureFunction(acService, en).startFunction()
                }
            }

        }
    }


    fun stop() {
        job?.cancel()
    }
}