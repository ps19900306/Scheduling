package com.nwq.function.scheduling.utils.sp

import com.nwq.function.scheduling.utils.sp.SpConstant.FIGHT_MODEL

class SPRepoPrefix(val prefix: String) {

    companion object {
        private val list = mutableListOf<SPRepoPrefix>()

        fun getSPRepo(prefix: String): SPRepoPrefix {
            return list.find { it.prefix == prefix } ?: SPRepoPrefix(prefix)
        }

        fun getNowSPRepo(): SPRepoPrefix {
            return list.find { it.prefix == SPRepo.role } ?: SPRepoPrefix(SPRepo.role)
        }
    }

    val nowSelectModeSP = SP(prefix + SpConstant.NOW_SELECT_MODE, FIGHT_MODEL)
    var nowSelectMode by nowSelectModeSP
    var dailytaskstime by SP(prefix + SpConstant.DAILY_TASKS_TIME, 0L)

    //战斗的
    val fightBaseLocationSP = SP(prefix + SpConstant.BASE_LOCATION, 0)
    var fightBaseLocation by fightBaseLocationSP

    val lastCompleteTimeSP = SP(prefix + SpConstant.LAST_COMPLETE_TIME, 0L)
    var lastCompleteTime by lastCompleteTimeSP

    val resistanceModeSP = SP(prefix + SpConstant.CRESISTANCE_MODE, false)
    var resistanceMode by resistanceModeSP

    val isPickupBoxSP = SP(prefix + SpConstant.IS_PICKUP_BOX, false)
    var isPickupBox by isPickupBoxSP

    val isCatchFoodSP = SP(prefix + SpConstant.IS_CATCH_FOOD, true)
    var isCatchFood by isCatchFoodSP

    val timeOnList1SP = SP(prefix + SpConstant.TIME_ON_LIST1, "[11,12]")
    var timeOnList1 by timeOnList1SP

    val timeOnList2SP = SP(prefix + SpConstant.TIME_ON_LIST2, "")
    var timeOnList2 by timeOnList2SP

    val timeOnList3SP = SP(prefix + SpConstant.TIME_ON_LIST3, "[10]")
    var timeOnList3 by timeOnList3SP

    val wholeBattleListSP = SP(prefix + SpConstant.WHOLE_BATTLE_LIST, "[1,8]")
    var wholeBattleList by wholeBattleListSP

    val roundBattleListSP = SP(prefix + SpConstant.ROUND_BATTLE_LIST, "[4,5]")
    var roundBattleList by roundBattleListSP

    val lastRefreshTimeSP = SP(prefix + SpConstant.LAST_REFRESH_TIME, 0L)//上次刷新
    var lastRefreshTime by lastRefreshTimeSP

    val lastPickUpTaskTimeSP = SP(prefix + SpConstant.LAST_PICKUP_TASK_TIME, 0L)//上次截取任务
    var lastPickUpTaskTime by lastPickUpTaskTimeSP

    val lastBackSpaceStationSP = SP(prefix + SpConstant.LAST_PICKUP_TASK_TIME, 0L)
    var lastBackSpaceStation by lastBackSpaceStationSP

    val hasLegionnairesSP = SP(prefix + SpConstant.HAS_LEGIONNAIRES, false)
    var hasLegionnaires by hasLegionnairesSP


    //收菜的
    val celestialResourcesSP = SP(prefix + SpConstant.CELESTIAL_RESOURCES_LIST, "")
    var celestialResources by celestialResourcesSP

    val resourcesBaseLocationSP = SP(prefix + SpConstant.RESOURCES_BASE_LOCATION, 0)
    var resourcesBaseLocation by resourcesBaseLocationSP

    val openHarvestVegetablesSP = SP(prefix + SpConstant.OPEN_HARVEST_VEGETABLES, false)
    var openHarvestVegetables by openHarvestVegetablesSP

    val transferShipSP = SP(prefix + SpConstant.TRANSFER_SHIP, true)
    var transferShip by transferShipSP


    val resourcesAddTimeSP = SP(prefix + SpConstant.RESOURCES_ADD_TIME, 0L)
    var resourcesAddTime by resourcesAddTimeSP

    val resourcesCollectTimeSP = SP(prefix + SpConstant.RESOURCES_ADD_COLLECT, 0L)
    var resourcesCollectTime by resourcesCollectTimeSP

    val collectIntervalSP = SP(prefix + SpConstant.COLLECT_INTERVAL, 72)
    var collectInterval by collectIntervalSP

    val addIntervalSP = SP(prefix + SpConstant.ADD_INTERVAL, 12)
    var addInterval by addIntervalSP

    //采矿的
    val miningBaseLocationSP = SP(prefix + SpConstant.MINING_BASE_LOCATION, 0)
    var miningBaseLocation by miningBaseLocationSP

    val miningGunListSP = SP(prefix + SpConstant.MINING_GUN_LIST, "[3,4,5]")
    var miningGunList by miningGunListSP

    val miningInertiaListSP = SP(prefix + SpConstant.MINING_INERTIA_LIST, "[0]")//皮球
    var miningInertiaList by miningInertiaListSP

    val miningStabilizerListSP = SP(prefix + SpConstant.MINING_STABILIZER_LIST, "[10,11,12]")//圣光
    var miningStabilizerList by miningStabilizerListSP


    //副本

    val resistanceModeFSP = SP(prefix + SpConstant.F_CRESISTANCE_MODE, false)
    var resistanceModeF by resistanceModeFSP

    val isHasPropellerFSP = SP(prefix + SpConstant.F_IS_HAS_propeller, true)
    var isHasPropellerF by isHasPropellerFSP

    val isCatchFoodFSP = SP(prefix + SpConstant.F_IS_CATCH_FOOD, true)
    var isCatchFoodF by isCatchFoodFSP

    val timeOnList1FSP = SP(prefix + SpConstant.F_TIME_ON_LIST1, "[11,12]")
    var timeOnList1F by timeOnList1FSP

    val timeOnList2FSP = SP(prefix + SpConstant.F_TIME_ON_LIST2, "")
    var timeOnList2F by timeOnList2FSP

    val timeOnList3FSP = SP(prefix + SpConstant.F_TIME_ON_LIST3, "[10]")
    var timeOnList3F by timeOnList3FSP

    val wholeBattleListFSP = SP(prefix + SpConstant.F_WHOLE_BATTLE_LIST, "[1,8]")
    var wholeBattleListF by wholeBattleListFSP

    val roundBattleListFSP = SP(prefix + SpConstant.F_ROUND_BATTLE_LIST, "[4,5]")
    var roundBattleListF by roundBattleListFSP


}