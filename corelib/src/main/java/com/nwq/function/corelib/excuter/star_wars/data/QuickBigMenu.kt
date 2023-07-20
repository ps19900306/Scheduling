package com.nwq.function.corelib.excuter.star_wars.data

import androidx.annotation.IntDef
import java.lang.annotation.RetentionPolicy

@IntDef(
    QuickBigMenu.WAREHOUSE_BIG_MUNU_P,//原点必须为右上角

    QuickBigMenu.TASK_BIG_MUNU_P,//原点必须为左上角

    QuickBigMenu.PLANETARY_ORE_MUNU_P,//原点必须为左边下角
)
annotation class QuickBigMenu {
    companion object {
        const val WAREHOUSE_BIG_MUNU_P = 1//仓库
        const val TASK_BIG_MUNU_P = 2 //际遇任务
        const val PLANETARY_ORE_MUNU_P = 3 //行星菜

    }
}


