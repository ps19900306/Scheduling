package com.nwq.function.corelib.excuter

import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.img.pcheck.IPR
import com.nwq.function.corelib.img.pcheck.PointRule
import com.nwq.function.corelib.img.task.CorrectPositionModel
import com.nwq.function.corelib.img.task.ImgTaskImpl1

/**
create by: 86136
create time: 2023/5/30 9:56
Function description:
所有的图片识别，点击区域全部使用lazy缓存
 */
class BaseEnvironment {

    private val isOpenTask by lazy {
        val tag = "isOpen"

        val pointList = mutableListOf<PointRule>()
        val correctModel = CorrectPositionModel(pointList, tag, 1, 1)

        val iprList = mutableListOf<IPR>()
        ImgTaskImpl1(iprList, tag, correctModel)
    }

    private val openArea by lazy {
        CoordinateArea(1, 1, 1, 1, 0, 0)
    }

}