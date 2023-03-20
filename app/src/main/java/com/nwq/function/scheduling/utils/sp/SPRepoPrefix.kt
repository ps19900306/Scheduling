package com.nwq.function.scheduling.utils.sp

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

    //战斗的
    var fightBaseLocation by SP(prefix + SpConstant.BASE_LOCATION, 0)
    var lastCompleteTimeSP by SP(prefix + SpConstant.LAST_COMPLETE_TIME, 0L)
    var resistanceModeSP by SP(prefix + SpConstant.CRESISTANCE_MODE, false)
    var isPickupBoxSP by SP(prefix + SpConstant.IS_PICKUP_BOX, false)
    var isCatchFoodSp by SP(prefix + SpConstant.IS_CATCH_FOOD, true)
    var timeOnList1SP by SP(prefix + SpConstant.TIME_ON_LIST1, "[11,12]")
    var timeOnList2SP by SP(prefix + SpConstant.TIME_ON_LIST2, "")
    var timeOnList3SP by SP(prefix + SpConstant.TIME_ON_LIST3, "[10]")
    var wholeBattleListSP by SP(prefix + SpConstant.WHOLE_BATTLE_LIST, "[1,8]")
    var roundBattleListSP by SP(prefix + SpConstant.ROUND_BATTLE_LIST, "[4,5]")
    var lastRefreshTimeSp by SP(prefix + SpConstant.LAST_REFRESH_TIME, 0L)//上次刷新
    var lastPickUpTaskTimeSp by SP(prefix + SpConstant.LAST_PICKUP_TASK_TIME, 0L)//上次截取任务
    var lastBackSpaceStation by SP(prefix + SpConstant.LAST_PICKUP_TASK_TIME, 0L)


    //收菜的
    var celestialResourcesSP by SP(prefix + SpConstant.CELESTIAL_RESOURCES_LIST, "")
    var resourcesBaseLocationSP by SP(prefix + SpConstant.RESOURCES_BASE_LOCATION, 0)
    var openHarvestVegetablesSP by SP(prefix + SpConstant.OPEN_HARVEST_VEGETABLES, false)
    var resourcesAddTimeSP by SP(prefix + SpConstant.RESOURCES_ADD_TIME, 0L)
    var resourcesCollectTimeSP by SP(prefix + SpConstant.RESOURCES_ADD_COLLECT, 0L)


    //采矿的
    var miningBaseLocationSP by SP(prefix + SpConstant.MINING_BASE_LOCATION, 0)
    var miningGunListSP by SP(prefix + SpConstant.MINING_GUN_LIST, "[11,12]")
    var miningInertiaListSP by SP(prefix + SpConstant.MINING_INERTIA_LIST, "[11,12]")//皮球
    var miningStabilizerListSP by SP(prefix + SpConstant.MINING_STABILIZER_LIST, "[11,12]")//圣光


}