package com.nwq.function.scheduling.core_code.click

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.annotation.SuppressLint
import android.graphics.Path
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
object MoveUtils {

    private lateinit var startCoordinate: Coordinate
    private lateinit var endCoordinate: Coordinate
    lateinit var aService: AccessibilityService

    private var isComplete = true //表示之前的是否已经结束了

    private var defaultCount = 10 //如果不传默认保持多久
    private var counter = defaultCount
    private var lastType = DirectionType.NONE
    private var nowType = DirectionType.NONE

    private val du = Math.PI / 180  //用于计算角度的
    private val _channelRefreshList = Channel<Long>(Channel.CONFLATED)
    private val centerArea = Area(540, 540, 50, 50)
    private val slidingLength
        get() = (1 + Math.random() * 0.14 - 0.07) * 300  //这里获取随机的滑动长度
    private var estimateCompleteTime = 0L  //获取延迟时间
    private var suspendDelayTime = 0L  //挂起时间
    private val getSwipeTime
        get() = (300 * (Math.random() * 0.3 + 1)).toLong()

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
        val de = GlobalScope.async {


        }
        de.cancel()

        val job = GlobalScope.launch(Dispatchers.Default) {
            _channelRefreshList.receiveAsFlow().collectLatest {
                Timber.d("接受流${suspendDelayTime} lastType:$lastType nowType:$nowType MoveUtils NWQ_ 2023/4/23");
                //             delay(suspendDelayTime)
                if (isComplete) {//如果上次的手势已经完成了
                    if (counter > 0) {
                        Timber.d("从新开始 MoveUtils NWQ_ 2023/4/23");
                        startCoordinate = getStartCoordinate()
                        val swipeTime = getSwipeTime
                        val longPressTime = getLongPressTime()
                        val delayTime = longPressDelayTime
                        val length = slidingLength

                        val list = mutableListOf<Coordinate>()
                        list.add(startCoordinate)
                        for (i in 0..10) {
                            list.add(
                                getEndCoordinate(
                                    (Math.random() * 8 + 1).toInt(),
                                    startCoordinate,
                                    length
                                )
                            )
                        }

                        // endCoordinate = getEndCoordinate(nowType, startCoordinate, length)
                        val clickTask =
                            ClickTask(list, 0, getSwipeTime * 10)
//                        val clickTask2 = ClickTask(
//                            listOf(endCoordinate1, endCoordinate),
//                            swipeTime - delayTime,
//                            longPressTime
//                        )
//                        val cosTime = swipeTime + longPressTime - delayTime
//                        suspendDelayTime = cosTime - 200
//                        val nowTime = System.currentTimeMillis()
//                        estimateCompleteTime = nowTime + cosTime
//                        lastType = nowType
                        optClickTasks(clickTask)
                        _channelRefreshList.trySend(System.currentTimeMillis())
                        Timber.d("继续任务 $suspendDelayTime  MoveUtils NWQ_ 2023/4/23");
                    }
                }
//                else if (lastType == nowType && counter > 0) {
//                    Timber.d("继续方向  MoveUtils NWQ_ 2023/4/23");
//                    val length = slidingLength
//                    val endCoordinate1 = getEndCoordinate(nowType, startCoordinate, length)
//                    val delayTime =
//                        estimateCompleteTime - System.currentTimeMillis() - longPressDelayTime
//                    val longPressTime = getLongPressTime()
//
//
//                    val clickTask =
//                        ClickTask(listOf(endCoordinate, endCoordinate1), 0, longPressTime)
//                    endCoordinate = endCoordinate1
//                    val cosTime = longPressTime
//                    suspendDelayTime = cosTime - 200
//                    val nowTime = System.currentTimeMillis()
//                    estimateCompleteTime = nowTime + cosTime
//
//
//                    delay(delayTime)
//                    optClickTasks(clickTask)
//                    _channelRefreshList.trySend(nowTime)
//                    Timber.d("继续任务 $suspendDelayTime MoveUtils NWQ_ 2023/4/23");
//                } else {
//                    Timber.d("进行等待  MoveUtils NWQ_ 2023/4/23");
//                }
            }
        }
        job.cancel()
    }

    fun moveCommand(type: Int, count: Int = defaultCount) {
        Timber.d("发布新任务 moveCommand MoveUtils NWQ_ 2023/4/23");
        nowType = type
        counter = count
        suspendDelayTime = 0
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
        return Coordinate(x, y)
    }


    fun optClickTasks(vararg clickTask: ClickTask) {
        Timber.d("生成手势 optClickTasks MoveUtils NWQ_ 2023/4/23");
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
            // builder.setDisplayId(12)
        }

        val gesture = builder.build()
        isComplete = !aService.dispatchGesture(
            gesture, object : AccessibilityService.GestureResultCallback() {
                override fun onCancelled(gestureDescription: GestureDescription) {
                    super.onCancelled(gestureDescription)
                    isComplete = true
                    Timber.d("执行结果 onCancelled MoveUtils NWQ_ 2023/4/23");
                    if (counter > 0)
                        _channelRefreshList.trySend(System.currentTimeMillis())
                }

                override fun onCompleted(gestureDescription: GestureDescription) {
                    super.onCompleted(gestureDescription)
                    Timber.d("执行结果 onCompleted MoveUtils NWQ_ 2023/4/23");
                    isComplete = true
                    if (counter > 0)
                        _channelRefreshList.trySend(System.currentTimeMillis())
                }
            }, null
        )
    }


    fun asyncTest2() {
        print("start")
        GlobalScope.launch {
            val time = measureTimeMillis { //计算执行时间
                val deferredOne: Deferred<Int> = async() {
                    delay(2000)
                    print("asyncOne")
                    100//这里返回值为100
                }

                val deferredTwo: Deferred<Int> = async {
                    delay(3000)
                    print("asyncTwo")
                    200//这里返回值为200
                }

                val deferredThr: Deferred<Int> = async {
                    delay(4000)
                    print("asyncThr")
                    300//这里返回值为300
                }

                //等待所有需要结果的协程完成获取执行结果
                val result = deferredOne.await() + deferredTwo.await() + deferredThr.await()
                print("result == $result")
            }
            print("耗时 $time ms")
        }
        print("end")
    }


}