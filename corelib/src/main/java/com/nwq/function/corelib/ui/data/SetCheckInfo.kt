package com.nwq.function.corelib.ui.data

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.nwq.function.corelib.ui.adapter.SetParameterAdapter
import com.nwq.function.corelib.utils.sp.SP


/**
create by: 86136
create time: 2023/3/21 10:57
Function description:
 */

data class SetCheckInfo(var title: String, var sp: SP<Boolean>) : MultiItemEntity {

    var isCheck by sp

    fun check(boolean: Boolean) {
        isCheck = boolean
    }

    override val itemType: Int = SetParameterAdapter.CHECK_TYPE
}