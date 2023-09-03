package com.android.schedule.corelibrary.exhaustion

import com.android.schedule.corelibrary.SetConstant
import com.android.schedule.corelibrary.click.ClickArea
import com.android.schedule.corelibrary.click.ClickTask

/**
create by: 86136
create time: 2023/8/31 15:25
Function description:
 */

object ExhaustionControl : BasicExhaustion() {


    private var FULL_STATE_TIME = 30 * SetConstant.MINUTE
    private var SLIGHT_EXHAUSTION_TIME = 2 * SetConstant.Hour
    private var SOME_EXHAUSTION_TIME = 1 * SetConstant.Hour
    private var VERY_EXHAUSTING_TIME = 30 * SetConstant.MINUTE//触发这个点的时候就必须要休息
    private val MAXWORKERTIME = 8 * SetConstant.Hour//最大工作时间

    private var Coefficient = 1.0   //每次休息后会越来越容易疲惫

    private var NOW_STATE = FULL_STATE

    private val RestBasicTime = 30 * SetConstant.MINUTE

    private var startTime = System.currentTimeMillis()
    private var stepStartTime = System.currentTimeMillis()

    //更新状态
    override fun updateStatus() {
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

    override fun onRestComplete() {
        startTime = System.currentTimeMillis()
        stepStartTime = System.currentTimeMillis()

        val flag = Math.random() * 0.2 + 0.6

        FULL_STATE_TIME = (flag * FULL_STATE_TIME).toLong()
        SLIGHT_EXHAUSTION_TIME = (flag * SLIGHT_EXHAUSTION_TIME).toLong()
        SOME_EXHAUSTION_TIME = (flag * SOME_EXHAUSTION_TIME).toLong()
        VERY_EXHAUSTING_TIME = (flag * VERY_EXHAUSTING_TIME).toLong() //触发这个点的时候就必须要休息

        Coefficient *= flag
    }

    //是否进行休息
    override fun whetherToRest(): Long {
        if (NOW_STATE == FULL_STATE || NOW_STATE == SLIGHT_EXHAUSTION) {
            return 0L
        }
        if (NOW_STATE == NEED_REST) {
            return getRestTime()
        }
        val random = Math.random()
        if (SOME_EXHAUSTION == NOW_STATE && random > 0.8) {
            return getRestTime()
        }
        if (random > 0.4) {
            return getRestTime()
        }
        return 0L
    }

    override fun getRestTime(): Long {
        val random = Math.random()
        return ((1.5 - random * 0.5) * RestBasicTime).toLong()
    }

    override fun getClickDuration(): Long {
        return when (getOptStatusType()) {
            OptStatusType.PRECISION -> {
                (Math.random() * 60 + 40).toLong()
            }
            OptStatusType.CARELESS -> {
                (Math.random() * 100 + 30).toLong()
            }
            OptStatusType.REDUNDANCY -> {
                (Math.random() * 50 + 100).toLong()
            }
            OptStatusType.BLUNDER, OptStatusType.FAILURE -> {
                (Math.random() * 100 + 50).toLong()
            }
            else -> {
                super.getClickDuration()
            }
        }
    }

    override fun getClickInterval(): Long {
        return when (getOptStatusType()) {
            OptStatusType.PRECISION -> {
                (Math.random() * 200 + 300).toLong()
            }
            OptStatusType.CARELESS -> {
                (Math.random() * 2000 + 1000).toLong()
            }
            OptStatusType.REDUNDANCY -> {
                (Math.random() * 8000 + 4000).toLong()
            }
            OptStatusType.BLUNDER, OptStatusType.FAILURE -> {
                (Math.random() * 20000 + 5000).toLong()
            }
            else -> {
                super.getClickDuration()
            }
        }
    }


    //这里根据状态获取不同操作精度
    override fun getOptStatusType(): Int {
        val random = Math.random()
        return when (NOW_STATE) {
            FULL_STATE -> {
                if (random > 0.8) {
                    OptStatusType.CARELESS
                } else if (random > 0.99) {
                    OptStatusType.REDUNDANCY
                } else {
                    OptStatusType.PRECISION
                }
            }
            SLIGHT_EXHAUSTION -> {
                if (random > 0.65) {
                    OptStatusType.CARELESS
                } else if (random > 0.95) {
                    OptStatusType.REDUNDANCY
                } else if (random > 0.98) {
                    OptStatusType.BLUNDER
                } else if (random > 0.995) {
                    OptStatusType.FAILURE
                } else {
                    OptStatusType.PRECISION
                }
            }
            SOME_EXHAUSTION -> {
                if (random > 0.5) {
                    OptStatusType.CARELESS
                } else if (random > 0.9) {
                    OptStatusType.REDUNDANCY
                } else if (random > 0.95) {
                    OptStatusType.BLUNDER
                } else if (random > 0.99) {
                    OptStatusType.FAILURE
                } else {
                    OptStatusType.PRECISION
                }
            }
            VERY_EXHAUSTING -> {
                if (random > 0.3) {
                    OptStatusType.CARELESS
                } else if (random > 0.8) {
                    OptStatusType.REDUNDANCY
                } else if (random > 0.95) {
                    OptStatusType.BLUNDER
                } else if (random > 0.99) {
                    OptStatusType.FAILURE
                } else {
                    OptStatusType.PRECISION
                }
            }
            else -> {
                OptStatusType.PRECISION
            }
        }
    }


    fun areaToClickTask(
        list: List<ClickArea>,
        offsetX: Int = 0,
        offsetY: Int = 0,
        canMiss: Boolean = false
    ): List<ClickTask> {
        val resultList = mutableListOf<ClickTask>()
        var delayTime = 0L
        list.forEach {
            if (canMiss && getOptStatusType() < OptStatusType.FAILURE) {
                val task = it.toClickTask(delayTime, offsetX, offsetY)
                delayTime = delayTime + task.delayTime + task.duration
                resultList.add(task)
            }
        }
        return resultList
    }

}