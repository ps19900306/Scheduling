package com.nwq.function.corelib.img.task

import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.img.pcheck.IPR
import com.nwq.function.corelib.img.rule.ColorIdentificationRule

/**
create by: 86136
create time: 2023/5/13 14:22
Function description:
固定点找图，成功后会记录偏差值，以优化流程
 */
class ImgTaskImpl1(
    iprList: List<IPR>,
    range: Int = 0 //初始图片的寻找范围，
) : ImgTask(iprList) {


}