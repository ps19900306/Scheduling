package com.nwq.function.corelib.excuter.star_wars

import android.graphics.Bitmap
import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.excuter.star_wars.data.OptSlotInfo
import com.nwq.function.corelib.img.task.ImgTaskImpl1
import com.nwq.function.corelib.utils.JsonUtil
import com.nwq.function.corelib.utils.sp.SPRepoPrefix
import timber.log.Timber

/**
create by: 86136
create time: 2023/7/17 10:45
Function description:
 */

class BottomDeviceMonitor(val listTop: Array<ImgTaskImpl1>, val listBot: Array<ImgTaskImpl1>) {


    protected val TopOfst = 6//顶部的偏移量
    protected val BotOfst = -1//底部的便宜量

    private val normallyOpenList = mutableListOf<ImgTaskImpl1>()//战斗默认需要打开的设备
    private val reducerList = mutableListOf(listBot[0], listBot[3])//网子默认放的位置
    private val maintenanceEquipment = mutableListOf(listTop[0])//维修设备需要开启的

    private var intervalTime1 = 165 * 1000L
    private val intervalOpenList1 = mutableListOf<OptSlotInfo>()
    private var intervalTime2 = 170 * 1000L
    private val intervalOpenList2 = mutableListOf<OptSlotInfo>()
    private var intervalTime3 = 75 * 1000L
    private val intervalOpenList3 = mutableListOf<OptSlotInfo>()

    private var needOpenReducer = false // 是否该开启网子
    private var lastChangeTime = 0L
    private val openInterval = 30 * 1000L
    private var openMaintenance = true // 是否该维修器材
    private val lastCloseItem = mutableListOf<ImgTaskImpl1>()
    private val lastClickArea = mutableListOf<CoordinateArea>()
    private var flag = 1  // 第一次取对比值 第二次才根据对进行开关
    private val maxAbnormal = 10
    private var abnormalRecords = maxAbnormal // 如果多次需要开启网子 可能就是卡脚本了

    //设置需要常开的设备
    private fun setNormallyOpenList(list: List<Int>) {
        setList(list, normallyOpenList)
    }

    private fun setReducerList(list: List<Int>) {
        setList(list, reducerList)
    }

    private fun setMaintenanceEquipment(list: List<Int>) {
        setList(list, maintenanceEquipment)
    }

    private fun setOpenList1(list: List<Int>) {
        setList2(list, intervalOpenList1, intervalTime1)
    }

    private fun setOpenList2(list: List<Int>) {
        setList2(list, intervalOpenList2, intervalTime2)
    }

    private fun setOpenList3(list: List<Int>) {
        setList2(list, intervalOpenList3, intervalTime3)
    }

    init {
        val spReo = SPRepoPrefix.getNowSPRepo()
        //后面这里由外部读取数据进行初始化
        val wholeBattleOpenList = JsonUtil.anyToJsonObject(spReo.wholeBattleList) ?: listOf<Int>()
        val roundBattleOpenList = JsonUtil.anyToJsonObject(spReo.roundBattleList) ?: listOf<Int>()

        setNormallyOpenList(mutableListOf<Int>().apply {
            addAll(wholeBattleOpenList)
            addAll(roundBattleOpenList)
        })

        var isCatchFoodSp = spReo.isCatchFood
        if (!isCatchFoodSp) {
            reducerList.clear()
        }

        JsonUtil.anyToJsonObject<List<Int>>(spReo.timeOnList1)?.let {
            setOpenList1(it)
        }
        JsonUtil.anyToJsonObject<List<Int>>(spReo.timeOnList2)?.let {
            setOpenList2(it)
        }
        JsonUtil.anyToJsonObject<List<Int>>(spReo.timeOnList3)?.let {
            setOpenList3(it)
        }

        Timber.d("init ${intervalOpenList1.size}  ${intervalOpenList2.size} ${intervalOpenList3.size} NWQ_ 2023/7/23");

    }


    private fun setList(list: List<Int>, mutableList: MutableList<ImgTaskImpl1>) {
        mutableList.clear()
        list.forEach { index ->
            if (index < TopOfst) {
                listBot.getOrNull(index)?.let {
                    if (!mutableList.contains(it)) mutableList.add(it)
                }
            } else {
                listTop.getOrNull(index - TopOfst - 1)?.let {
                    if (!mutableList.contains(it)) mutableList.add(it)
                }
            }
        }
    }

    private fun setList2(list: List<Int>, mutableList: MutableList<OptSlotInfo>, interval: Long) {
        mutableList.clear()
        list.forEach { p ->
            val task = if (p < TopOfst) {
                listBot.getOrNull(p)
            } else {
                listTop.getOrNull(p - TopOfst - 1)
            }
            task?.clickArea?.let { are ->
                mutableList.add(OptSlotInfo(are, 0, interval))
            }

        }
    }

    fun isNeedAbnormal(): Boolean {
        return abnormalRecords < 1
    }

    //设置开启网子
    fun closeReducer() {
        needOpenReducer = false
    }

    fun openReducer() {
        needOpenReducer = true
    }

    fun clearData() {
        flag == 1
        abnormalRecords = maxAbnormal
    }

    //设置开启维修设备
    fun setStartMaintenance(b: Boolean) {
        if (b == openMaintenance) { //一致 不处理
            return
        } else {
            openMaintenance = b
        }
    }

    //这里是需要点击的区域
    suspend fun updateInfo(bitmap: Bitmap): List<CoordinateArea>? {
        flag++
        //第一次先记录开启状态，方便二次确认
        if (flag % 2 == 0) {
            lastCloseItem.clear()
            normallyOpenList.forEach {
                if (!it.verificationRule(bitmap)) {
                    lastCloseItem.add(it)
                }
            }
            reducerList.forEach {
                if (!it.verificationRule(bitmap)) {
                    lastCloseItem.add(it)
                }
            }
            maintenanceEquipment.forEach {
                if (!it.verificationRule(bitmap)) {
                    lastCloseItem.add(it)
                }
            }
            return null
        }


        //这个根据上次结果二次确认后
        val nowClickList = mutableListOf<ImgTaskImpl1>()
        //开启常开
        normallyOpenList.forEach {
            if (!it.verificationRule(bitmap)) {
                if (lastCloseItem.contains(it)) {//如果二次都是关闭的则进行打开
                    nowClickList.add(it)
                }
            }
        }

        //开启维修设备
        if (openMaintenance) {
            maintenanceEquipment.forEach {
                if (!it.verificationRule(bitmap)) {
                    if (lastCloseItem.contains(it) && (System.currentTimeMillis() - lastChangeTime) > openInterval) {
                        nowClickList.add(it)
                        lastChangeTime = System.currentTimeMillis()
                    }
                }
            }
        } else {
            maintenanceEquipment.forEach {
                if (it.verificationRule(bitmap)) {//这里判断是开启的
                    if (!lastCloseItem.contains(it) && (System.currentTimeMillis() - lastChangeTime) > openInterval) {//这里判断是之前未打开
                        nowClickList.add(it)
                        lastChangeTime = System.currentTimeMillis()
                    }
                }
            }
        }

        //开启网子
        if (needOpenReducer) {
            Timber.d("checkOpen needOpenReducer NWQ_ 2023/7/24");
            reducerList.forEach {
                if (!it.verificationRule(bitmap)) {
                    if (lastCloseItem.contains(it)) {//如果二次都是关闭的则进行打开
                        nowClickList.add(it)
                        needOpenReducer = false
                    }
                } else if (!lastCloseItem.contains(it)) {
                    needOpenReducer = false
                }
            }
        }

        val clickAreaList = mutableListOf<CoordinateArea>()
        nowClickList.forEach {
            it.clickArea?.let {
                clickAreaList.add(it)
            }
        }
        //这里不管定时开的设备，只管关键设备
        if (clickAreaList.find { lastClickArea.contains(it) } == null) {//这里表示点击效果无效
            abnormalRecords = maxAbnormal
        } else {
            abnormalRecords--
        }


        val tempList = lastClickArea
        lastClickArea.clear()
        lastClickArea.addAll(clickAreaList)

        var nowTime = System.currentTimeMillis()
        checkTimeOn(nowTime, intervalOpenList1, clickAreaList)
        checkTimeOn(nowTime, intervalOpenList2, clickAreaList)
        checkTimeOn(nowTime, intervalOpenList3, clickAreaList)



        return clickAreaList.filter { !tempList.contains(it) } //这里上次点击的区域这次不进行再次点击
    }


    protected fun checkTimeOn(
        nowtime: Long,
        positionList: List<OptSlotInfo>,
        needCheckOpenList: MutableList<CoordinateArea>,
    ) {
        var lastItemOpenTime = 0L //这里只取第一个为标准，不然会导致多设备不好用
        positionList.forEachIndexed { p, d ->
            if (p == 0) {
                if (nowtime - d.lastOpenedTime > d.selfInterval) {
                    needCheckOpenList.add(d.clickArea)
                    d.lastOpenedTime = nowtime
                }
                lastItemOpenTime = d.lastOpenedTime
            } else if ((nowtime - lastItemOpenTime) in d.offsetInterval * p..d.offsetInterval * (p + 1) && nowtime - d.lastOpenedTime > d.selfInterval) {
                needCheckOpenList.add(d.clickArea)
                d.lastOpenedTime = nowtime
            }
        }

    }
}