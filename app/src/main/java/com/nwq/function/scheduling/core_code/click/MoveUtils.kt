package com.nwq.function.scheduling.core_code.click

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.annotation.SuppressLint
import android.graphics.Path
import com.nwq.function.scheduling.core_code.Area
import com.nwq.function.scheduling.core_code.Coordinate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


/**
create by: 86136
create time: 2023/2/24 15:58
Function description:
 */

@SuppressLint("StaticFieldLeak")
object MoveUtils {

    private lateinit var startCoordinate: Coordinate
    private lateinit var endCoordinate: Coordinate
    private lateinit var aService: AccessibilityService

    private var isComplete = true //表示之前的是否已经结束了

    private var defaultCount = 10 //如果不传默认保持多久
    private var counter = defaultCount
    private var lastType = DirectionType.NONE
    private var nowType = DirectionType.NONE

    private val du = Math.PI / 180  //用于计算角度的
    private val _channelRefreshList = Channel<Long>()
    private val centerArea = Area(0, 0, 100, 100)
    private val slidingLength
        get() = (Math.random() * 0.14 - 0.07) * 200  //这里获取随机的滑动长度
    private var estimateCompleteTime = 0L  //获取延迟时间
    private var suspendDelayTime = 0L  //挂起时间
    private val getSwipeTime
        get() = (500 * (Math.random() * 0.3 + 0.9)).toLong()

    private val longPressTimeUnit
        get() = (500 * (Math.random() * 0.2 + 1)).toLong()

    private val longPressDelayTime
        get() = (50 * (Math.random() * 0.4 + 0.6)).toLong()

    private fun getLongPressTime(): Long {
        return if (counter >= 4) {
            when ((Math.random() * 3).toInt()) {
                0 -> {
                    counter -= 2
                    longPressTimeUnit * 2
                }
                1 -> {
                    counter -= 3
                    longPressTimeUnit * 3
                }
                else -> {
                    counter -= 4
                    longPressTimeUnit * 4
                }
            }
        } else if (counter == 3) {
            counter -= 3
            longPressTimeUnit * 3
        } else {
            counter -= 2
            longPressTimeUnit * 2
        }
    }

    init {
        GlobalScope.launch(Dispatchers.IO) {
            _channelRefreshList.receiveAsFlow().collectLatest {
                delay(suspendDelayTime)
                if (isComplete) {//如果上次的手势已经完成了
                    if (counter > 0) {
                        startCoordinate = getStartCoordinate()
                        val swipeTime = getSwipeTime
                        val longPressTime = getLongPressTime()
                        val delayTime = longPressDelayTime
                        val length = slidingLength
                        val endCoordinate1 = getEndCoordinate(nowType, startCoordinate, length)
                        endCoordinate = getEndCoordinate(nowType, startCoordinate, length)
                        val clickTask =
                            ClickTask(listOf(startCoordinate, endCoordinate1), 0, swipeTime)
                        val clickTask2 = ClickTask(
                            listOf(endCoordinate1, endCoordinate),
                            swipeTime - delayTime,
                            longPressTime
                        )
                        val cosTime = swipeTime + longPressTime - delayTime
                        suspendDelayTime = cosTime - 200
                        val nowTime = System.currentTimeMillis()
                        estimateCompleteTime = nowTime + cosTime
                        lastType = nowType
                        optClickTasks(clickTask, clickTask2)
                        _channelRefreshList.trySend(nowTime)
                    }
                } else if (lastType == nowType && counter > 0) {
                    val length = slidingLength
                    val endCoordinate1 = getEndCoordinate(nowType, startCoordinate, length)
                    val delayTime =
                        estimateCompleteTime - System.currentTimeMillis() - longPressDelayTime
                    val longPressTime = getLongPressTime()
                    val clickTask =
                        ClickTask(listOf(endCoordinate, endCoordinate1), delayTime, longPressTime)
                    endCoordinate = endCoordinate1
                    val cosTime = delayTime + longPressTime
                    suspendDelayTime = cosTime - 200
                    val nowTime = System.currentTimeMillis()
                    estimateCompleteTime = nowTime + cosTime
                    optClickTasks(clickTask)
                    _channelRefreshList.trySend(nowTime)
                } else if (lastType != nowType && counter > 0) {

                }
            }
        }
    }

    private fun moveCommand(type: Int, count: Int = defaultCount) {
        nowType = type
        counter = count
        if (isComplete) {
            _channelRefreshList.trySend(System.currentTimeMillis())
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
                offsetX = Math.cos((0 + offset) * du)
                offsetY = Math.sin((0 + offset) * du)
            }
            DirectionType.TOP_RIGHT -> {
                offsetX = Math.cos((45 + offset) * du)
                offsetY = Math.sin((45 + offset) * du)
            }
            DirectionType.TOP -> {
                offsetX = Math.cos((90 + offset) * du)
                offsetY = Math.sin((90 + offset) * du)
            }
            DirectionType.TOP_LEFT -> {
                offsetX = Math.cos((135 + offset) * du)
                offsetY = Math.sin((135 + offset) * du)
            }
            DirectionType.LEFT -> {
                offsetX = Math.cos((180 + offset) * du)
                offsetY = Math.sin((180 + offset) * du)
            }
            DirectionType.BOTTOM_LEFT -> {
                offsetX = Math.cos((225 + offset) * du)
                offsetY = Math.sin((225 + offset) * du)
            }
            DirectionType.BOTTOM -> {
                offsetX = Math.cos((270 + offset) * du)
                offsetY = Math.sin((270 + offset) * du)
            }
            DirectionType.BOTTOM_RIGHT -> {
                offsetX = Math.cos((315 + offset) * du)
                offsetY = Math.sin((315 + offset) * du)
            }
        }
        val x = startPs.x + offsetX
        val y = startPs.y + offsetY
        return Coordinate(x, y)
    }


    suspend fun optSlideTask(aService: AccessibilityService, slideScreenTask: SlideScreenTask) {
        optClickTasks(slideScreenTask.convertToClick())
    }


    suspend fun optClickTasks(vararg clickTask: ClickTask) {
        val builder = GestureDescription.Builder()
        clickTask.forEach { task ->
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
                    path, task.delayTime, task.duration
                )
            )
        }

        val gesture = builder.build()
        isComplete = !aService.dispatchGesture(
            gesture, object : AccessibilityService.GestureResultCallback() {
                override fun onCancelled(gestureDescription: GestureDescription) {
                    super.onCancelled(gestureDescription)
                    isComplete = true
                    if (nowType != lastType)
                        _channelRefreshList.trySend(System.currentTimeMillis())
                }

                override fun onCompleted(gestureDescription: GestureDescription) {
                    super.onCompleted(gestureDescription)
                    isComplete = true
                    if (nowType != lastType)
                        _channelRefreshList.trySend(System.currentTimeMillis())
                }
            }, null
        )
    }


}