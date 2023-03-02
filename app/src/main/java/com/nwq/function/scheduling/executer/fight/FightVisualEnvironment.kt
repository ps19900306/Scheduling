package com.nwq.function.scheduling.executer.fight

import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.core_code.img.ImgUtils
import com.nwq.function.scheduling.executer.base.VisualEnvironment
import com.nwq.function.scheduling.executer.fight.rule.AllOver110Rule
import com.nwq.function.scheduling.executer.fight.rule.AllLess50Rule

/**
create by: 86136
create time: 2023/2/28 10:37
Function description:
所有需要进行图片判断的方法都需要放到这个里面
 */

class FightVisualEnvironment(helper: AccessibilityHelper) : VisualEnvironment(helper) {


    //是否有全部锁定按钮
    fun hasGroupLock(): Boolean {
        val list = listOf(
            verificationTask(1439f, 687f, AllOver110Rule()),
            verificationTask(1439f, 675f, AllOver110Rule()),
            verificationTask(1439f, 689f, AllOver110Rule()),
            verificationTask(1437f, 672f, AllLess50Rule()),
            verificationTask(1443f, 682f, AllLess50Rule()),
            verificationTask(1437f, 692f, AllLess50Rule()),
        )
        return ImgUtils.performPointsColorVerification(
            list, screenBitmap, 0
        )
    }

    fun hasTarget(index: Int) {

    }


    fun getTagNumber() {

    }


}