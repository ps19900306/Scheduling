package com.nwq.function.corelib.img.task

import com.nwq.function.corelib.BasicTask
import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.img.pcheck.IPR
import com.nwq.function.corelib.img.rule.ColorIdentificationRule

/**
 * 不能实列化
 */
abstract class ImgTask(val iprList: List<IPR>, val tag: String) : BasicTask {

    protected var offsetX: Int = 0 //发现图片成功的时候X偏差值
    protected var offsetY: Int = 0 //发现图片成功的时候Y偏差值

    protected var hasCorrect = false


    fun isCorrect(): Boolean {
        return hasCorrect
    }


    open fun correctCoordinate(ofsX: Int, ofsY: Int) {
        if (!hasCorrect) {
            hasCorrect = true
            offsetX = ofsX
            offsetY = ofsY
        }
    }


}