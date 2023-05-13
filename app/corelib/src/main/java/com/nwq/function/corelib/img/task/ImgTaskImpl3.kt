package com.nwq.function.corelib.img.task

import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.img.rule.ColorIdentificationRule

/**
create by: 86136
create time: 2023/5/13 14:22
Function description:
这个用于判断进度条血条的
 */
class ImgTaskImpl3(
    pointList: List<CoordinatePoint>,
    ruleList: List<ColorIdentificationRule>,
) : ImgTask(pointList, ruleList) {

    constructor(pointList: List<CoordinatePoint>, redRule: ColorIdentificationRule) : this(
        pointList,
        listOf(redRule)
    )

    constructor(
        pointList: List<CoordinatePoint>,
        redRule: ColorIdentificationRule,
        emptyRule: ColorIdentificationRule
    ) : this(
        pointList,
        listOf(redRule, emptyRule)
    )


}