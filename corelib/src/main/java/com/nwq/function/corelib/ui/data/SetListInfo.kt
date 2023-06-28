package com.nwq.function.corelib.ui.data


import com.chad.library.adapter.base.entity.MultiItemEntity
import com.nwq.function.corelib.ui.adapter.SetParameterAdapter
import com.nwq.function.corelib.utils.JsonUtil
import com.nwq.function.corelib.utils.sp.SP


/**
create by: 86136
create time: 2023/3/21 10:57
Function description:
 */

data class SetListInfo(var title: String, var sp: SP<String>) : MultiItemEntity {

    var listStr by sp

    val list by lazy {
        JsonUtil.anyToJsonObject(listStr) ?: mutableListOf<Int>()
    }


    fun addData(str: String) {
        str.toIntOrNull()?.let {
            list.add(it)
            listStr = JsonUtil.objectToString(list)
        }
    }

    fun clearData() {
        list.clear()
        listStr = JsonUtil.objectToString(list)
    }

    override val itemType: Int = SetParameterAdapter.LIST_TYPE
}