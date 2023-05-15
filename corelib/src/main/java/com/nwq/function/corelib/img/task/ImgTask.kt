package com.nwq.function.corelib.img.task

import com.nwq.function.corelib.BasicTask
import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.img.rule.ColorIdentificationRule

abstract class ImgTask(val pointList: List<CoordinatePoint>,val ruleList:List<ColorIdentificationRule>) : BasicTask {


}