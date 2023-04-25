package com.nwq.function.scheduling.core_code.click

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.annotation.SuppressLint
import android.graphics.Path
import android.util.Half.round
import com.nwq.function.scheduling.core_code.Area
import com.nwq.function.scheduling.core_code.Coordinate
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import timber.log.Timber
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.system.measureTimeMillis


/**
create by: 86136
create time: 2023/2/24 15:58
Function description:
 */

@SuppressLint("StaticFieldLeak")
object MoveClickUtils {
    lateinit var aService: AccessibilityService
    private val du = Math.PI / 180  //用于计算角度的
    private var isComplete = true //表示之前的是否已经结束了
    private val directionList = mutableListOf<MoveDirection>()
    private val clickTaskList = mutableListOf<ClickTask>()
    private val timeUnit
        get() = (250 * (Math.random() * 0.4 + 0.8)).toLong()
    private val centerArea = Area(540, 540, 50, 50)//开始点击的中心位置
    private val slidingLength
        get() = (1 + Math.random() * 0.1 - 0.05) * 300  //这里获取随机的滑动长度


    //强行发布新的指令会导致原来的指令失效
    fun publishMoveDirection(
        vararg moveDirection: MoveDirection,
        clear: Boolean = false,
        interrupt: Boolean = false
    ) {
        if (clear)
            directionList.clear()

        directionList.addAll(moveDirection)
        if (interrupt || isComplete) {
            editPushInstruction()
        }
    }


    //强行发布新的指令会导致原来的指令失效
    fun publishClickTask(
        vararg clickTask: ClickTask,
        clear: Boolean = false,
        interrupt: Boolean = false
    ) {
        if (clear)
            clickTaskList.clear()

        clickTaskList.addAll(clickTask)
        if (interrupt || isComplete) {
            editPushInstruction()
        }
    }


    private fun editPushInstruction() {
        val moveList = mutableListOf<ClickTask>()
        buildMoveTask(moveList)
        val clickList = clickTaskList.toList()
        clickTaskList.clear()
        executeClickTasks(moveList, clickList)
    }


    private fun buildMoveTask(
        list: MutableList<ClickTask>,
        count: Int = (Math.random() * 5 + 8).toInt()
    ) {
        var counter = count
        val startCoordinate = getStartCoordinate()
        val coordinateList = mutableListOf<Coordinate>()
        var lastType = DirectionType.NONE
        coordinateList.add(startCoordinate)
        var flag = true
        while (directionList.isNotEmpty() && counter > 0 && flag) {
            val data = directionList[0]
            data.number = data.number - 1
            val type = data.directionType
            if (lastType == DirectionType.NONE || lastType == type || Math.abs(type - lastType) <= 2 || Math.abs(
                    type - lastType
                ) == DirectionType.BOTTOM_LEFT - DirectionType.LEFT
            ) {
                lastType=type
                counter--
                val c = getEndCoordinate(data.directionType, startCoordinate, slidingLength)
                coordinateList.add(c)
                if (directionList[0].number <= 0) {
                    directionList.remove(data)
                }
            } else {
                flag = false
            }
        }
        val task = ClickTask(coordinateList, 0, (count - counter) * timeUnit)
        list.add(task)
        if (!flag) {
            buildMoveTask(list, counter)
        }
    }


    private fun getStartCoordinate(): Coordinate {
        val x = centerArea.x + centerArea.with * Math.random()
        val y = centerArea.y + centerArea.height * Math.random()
        return Coordinate(x, y)
    }

    private fun getEndCoordinate(
        type: Int,
        startPs: Coordinate,
        slidingLength: Double
    ): Coordinate {
        val offset = Math.random() * 4 - 2
        var offsetX = slidingLength
        var offsetY = 0.0

        when (type) {
            DirectionType.RIGHT -> {
                Timber.d("RIGHT getEndCoordinate MoveUtils NWQ_ 2023/4/24");
                offsetX = Math.cos((0 + offset) * du)
                offsetY = Math.sin((0 + offset) * du)
            }
            DirectionType.BOTTOM_RIGHT -> {
                Timber.d("BOTTOM_RIGHT getEndCoordinate MoveUtils NWQ_ 2023/4/24");
                offsetX = Math.cos((45 + offset) * du)
                offsetY = Math.sin((45 + offset) * du)
            }
            DirectionType.BOTTOM -> {
                Timber.d("BOTTOM getEndCoordinate MoveUtils NWQ_ 2023/4/24");
                offsetX = Math.cos((90 + offset) * du)
                offsetY = Math.sin((90 + offset) * du)
            }
            DirectionType.BOTTOM_LEFT -> {
                Timber.d("BOTTOM_LEFT getEndCoordinate MoveUtils NWQ_ 2023/4/24");
                offsetX = Math.cos((135 + offset) * du)
                offsetY = Math.sin((135 + offset) * du)
            }
            DirectionType.LEFT -> {
                Timber.d("LEFT getEndCoordinate MoveUtils NWQ_ 2023/4/24");
                offsetX = Math.cos((180 + offset) * du)
                offsetY = Math.sin((180 + offset) * du)
            }
            DirectionType.TOP_LEFT -> {
                Timber.d("TOP_LEFT getEndCoordinate MoveUtils NWQ_ 2023/4/24");
                offsetX = Math.cos((225 + offset) * du)
                offsetY = Math.sin((225 + offset) * du)
            }
            DirectionType.TOP -> {
                Timber.d("TOP getEndCoordinate MoveUtils NWQ_ 2023/4/24");
                offsetX = Math.cos((270 + offset) * du)
                offsetY = Math.sin((270 + offset) * du)
            }
            DirectionType.TOP_RIGHT -> {
                Timber.d("TOP_RIGHT getEndCoordinate MoveUtils NWQ_ 2023/4/24");
                offsetX = Math.cos((315 + offset) * du)
                offsetY = Math.sin((315 + offset) * du)
            }
        }


        val x = startPs.x + offsetX * slidingLength
        val y = startPs.y + offsetY * slidingLength

        val z = Math.sqrt(offsetX * offsetX + offsetY * offsetY)

        val asin = Math.asin(offsetY / z) / Math.PI * 180
        val cos = Math.cos(offsetX / z) / Math.PI * 180

        val atan2 = Math.atan2(offsetY * slidingLength, offsetX * slidingLength)
        val tan = Math.atan((offsetY * slidingLength) / (offsetX * slidingLength))
        Timber.d(" ${offsetY / offsetX}  atan2:$atan2 tan:$tan asin:$asin cos:$cos test2 MainActivity NWQ_ 2023/4/25");

        return Coordinate(x, y)
    }


    private fun executeClickTasks(moveList: List<ClickTask>, clickList: List<ClickTask>) {
        val builder = GestureDescription.Builder()
        var timeTemp = 0L
        moveList.forEach { task ->
            val path = Path()
            task.coordinates.forEachIndexed { i, d ->
                if (i == 0) {
                    path.moveTo(d.x, d.y)
                } else {
                    path.lineTo(d.x, d.y)
                }
            }
            builder.addStroke(
                GestureDescription.StrokeDescription(
                    path, task.delayTime + timeTemp + 100, task.duration
                )
            )
            timeTemp += task.delayTime + task.duration + 100
        }

        timeTemp = 0L
        clickList.forEach { task ->
            val path = Path()
            task.coordinates.forEachIndexed { i, d ->
                if (i == 0) {
                    path.moveTo(d.x, d.y)
                } else {
                    path.lineTo(d.x, d.y)
                }
            }
            builder.addStroke(
                GestureDescription.StrokeDescription(
                    path, task.delayTime + timeTemp, task.duration
                )
            )
            timeTemp += task.delayTime + task.duration
        }

        val gesture = builder.build()
        isComplete = !aService.dispatchGesture(
            gesture, object : AccessibilityService.GestureResultCallback() {
                override fun onCancelled(gestureDescription: GestureDescription) {
                    super.onCancelled(gestureDescription)
                    isComplete = true
                    Timber.d("执行结果 onCancelled MoveUtils NWQ_ 2023/4/23");
                }

                override fun onCompleted(gestureDescription: GestureDescription) {
                    super.onCompleted(gestureDescription)
                    Timber.d("执行结果 onCompleted MoveUtils NWQ_ 2023/4/23");
                    isComplete = true
                }
            }, null
        )

    }


}