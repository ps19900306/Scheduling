package com.nwq.function.autocodeapp.data

import com.chad.library.adapter.base.entity.MultiItemEntity

data class FunctionItemInfo(val strId:Int, override val itemType: Int,var isCheck:Boolean = false): MultiItemEntity
