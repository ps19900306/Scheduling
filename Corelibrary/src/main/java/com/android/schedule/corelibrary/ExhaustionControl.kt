package com.android.schedule.corelibrary

import androidx.annotation.IntDef

/**
create by: 86136
create time: 2023/8/31 15:25
Function description:
 */

class ExhaustionControl {


    private val FULL_STATE = 1
    private val SLIGHT_EXHAUSTION = 2
    private val SOME_EXHAUSTION = 4
    private val VERY_EXHAUSTING = 8 //触发这个点的时候就必须要休息
    private val NEED_REST = 16 //触发这个点的时候就必须要休息

    private var FULL_STATE_TIME = 1 * SetConstant.Hour
    private var SLIGHT_EXHAUSTION_TIME = 2 * SetConstant.Hour
    private var SOME_EXHAUSTION_TIME = 1 * SetConstant.Hour
    private var VERY_EXHAUSTING_TIME = 0.5 * SetConstant.Hour//触发这个点的时候就必须要休息
    private val MAXWORKERTIME = 8 * SetConstant.Hour//最大工作时间

    private var Coefficient = 1.0   //每次休息后会越来越容易疲惫

    private var NOW_STATE = FULL_STATE


    private var startTime = System.currentTimeMillis()
    private var stepStartTime = System.currentTimeMillis()

    //更新状态
    private fun updateStatus() {
        var nowTime = System.currentTimeMillis()
        when (NOW_STATE) {
            FULL_STATE -> {
                if (nowTime - stepStartTime >= FULL_STATE_TIME) {
                    NOW_STATE = SLIGHT_EXHAUSTION
                    stepStartTime = System.currentTimeMillis()
                }
            }
            SLIGHT_EXHAUSTION -> {
                if (nowTime - stepStartTime >= SLIGHT_EXHAUSTION_TIME) {
                    NOW_STATE = SOME_EXHAUSTION
                    stepStartTime = System.currentTimeMillis()
                }
            }
            SOME_EXHAUSTION -> {
                if (nowTime - stepStartTime >= SOME_EXHAUSTION_TIME) {
                    NOW_STATE = VERY_EXHAUSTING
                    stepStartTime = System.currentTimeMillis()
                }
            }
            VERY_EXHAUSTING -> {
                if (nowTime - stepStartTime >= VERY_EXHAUSTING_TIME) {
                    NOW_STATE = NEED_REST
                    stepStartTime = System.currentTimeMillis()
                }
            }
        }
    }




    @IntDef(
        DirectionType.LEFT,//原点必须为右上角

        DirectionType.RIGHT,//原点必须为左上角

        DirectionType.TOP,//原点必须为左边下角

        DirectionType.BOTTOM,//原点必须为左边上角

        DirectionType.TOP_LEFT,//

        DirectionType.TOP_RIGHT,//

        DirectionType.BOTTOM_LEFT,//

        DirectionType.BOTTOM_RIGHT,//

        DirectionType.NONE,//
    )
    annotation class DirectionType() {
        companion object {
            const val LEFT = 1
            const val TOP_LEFT = 2
            const val TOP = 3
            const val TOP_RIGHT = 4
            const val RIGHT = 5
            const val BOTTOM_RIGHT = 6
            const val BOTTOM = 7
            const val BOTTOM_LEFT = 8
            const val NONE = -1
        }
    }


}