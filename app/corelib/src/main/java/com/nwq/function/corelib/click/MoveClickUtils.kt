package com.nwq.function.corelib.click

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.annotation.SuppressLint
import android.graphics.Path
import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.area.CoordinatePoint
import com.nwq.function.corelib.area.DirectionType
import com.nwq.function.corelib.area.MoveDirection
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow


@SuppressLint("StaticFieldLeak")
object MoveClickUtils {

    lateinit var aService: AccessibilityService
    private val du = Math.PI / 180  //用于计算角度的
    private var isComplete = true //表示之前的是否已经结束了
    private val directionList = mutableListOf<MoveDirection>()//移动操作的
    private val clickTaskList = mutableListOf<ClickTask>()//点击操作的
    private val continuousClickTaskList = mutableListOf<ContinuousClickTask>()//持续点击事件


    private val timeUnit
        get() = (300 * (Math.random() * 0.4 + 0.8)).toLong()
    private val moveTimeUnit
        get() = (300 * (Math.random() * 0.4 + 0.8)).toLong()

    private val centerArea = CoordinateArea(540, 540, 50, 50)//开始点击的中心位置


    private val slidingLength
        get() = (1 + Math.random() * 0.1 - 0.05) * 200  //这里获取随机的滑动长度
    private val _channelRefreshList = Channel<Long>(Channel.CONFLATED)

    private var job: Job? = null
    var cancelDescription: GestureDescription.StrokeDescription? = null


    //强行发布新的指令会导致原来的指令失效
    fun publishClickTask(
        vararg clickTask: ClickTask,
        clear: Boolean = false,
        interrupt: Boolean = false
    ) {
        if (clear)
            clickTaskList.clear()

        initJob()
        clickTaskList.addAll(clickTask)
        if (interrupt) {
            editPushInstruction()
        } else {
            _channelRefreshList.trySend(System.currentTimeMillis())
        }
    }

    //强行发布新的指令会导致原来的指令失效
    fun publishMoveDirection(
        vararg moveDirection: MoveDirection,
        clear: Boolean = false,
        interrupt: Boolean = false
    ) {
        if (clear)
            directionList.clear()

        initJob()
        directionList.addAll(moveDirection)
        if (interrupt) {
            editPushInstruction()
        } else {
            _channelRefreshList.trySend(System.currentTimeMillis())
        }
    }


    fun stopAll() {
        cancelJob()
        overPress()
    }

    private fun editPushInstruction() {
        if (directionList.isEmpty() && clickTaskList.isEmpty())
            return

        val descriptionList = mutableListOf<GestureDescription.StrokeDescription>()
        val costTime = buildMoveTask(descriptionList)
        buildClickTask(descriptionList, costTime)

        if (descriptionList.isEmpty()) {
            editPushInstruction()
        } else {
            val builder = GestureDescription.Builder()
            descriptionList.forEach {
                builder.addStroke(it)
            }
            val gesture = builder.build()
            isComplete = !aService.dispatchGesture(
                gesture, object : AccessibilityService.GestureResultCallback() {
                    override fun onCancelled(gestureDescription: GestureDescription) {
                        super.onCancelled(gestureDescription)
                        overPress()
                        _channelRefreshList.trySend(System.currentTimeMillis())
                        isComplete = true
                    }

                    override fun onCompleted(gestureDescription: GestureDescription) {
                        super.onCompleted(gestureDescription)
                        overPress()
                        _channelRefreshList.trySend(System.currentTimeMillis())
                        isComplete = true
                    }
                }, null
            )
            if (isComplete) {
                _channelRefreshList.trySend(System.currentTimeMillis())
            }
        }
    }


    private fun buildMoveTask(
        list: MutableList<GestureDescription.StrokeDescription>,
    ): Long {
        var costTime = 0L
        directionList.getOrNull(0)?.let {
            val startCoordinate = getStartCoordinate()
            val endCoordinate = getEndCoordinate(it.directionType, startCoordinate, slidingLength)
            val path1 = Path()
            path1.moveTo(startCoordinate.x, startCoordinate.y)
            path1.lineTo(endCoordinate.x, endCoordinate.y)
            val moveTime = moveTimeUnit
            val moveDescription = GestureDescription.StrokeDescription(path1, 0, moveTime, true)

            val endCoordinate2 = getEndCoordinate(it.directionType, startCoordinate, slidingLength)
            val path2 = Path()
            path2.moveTo(endCoordinate.x, endCoordinate.y)
            path2.lineTo(endCoordinate2.x, endCoordinate2.y)
            val pressTime = timeUnit * it.number
            cancelDescription = moveDescription.continueStroke(path2, 0, pressTime, false)
            list.add(moveDescription)

            directionList.remove(it)
            costTime = moveTime + pressTime
        }
        return costTime
    }


    private fun buildClickTask(
        list: MutableList<GestureDescription.StrokeDescription>,
        maxTime: Long
    ) {
        val iterator = clickTaskList.iterator()
        while (iterator.hasNext()) {
            val item = iterator.next()
            val totalTime = item.delayTime + item.duration
            if (totalTime < maxTime) {
                val path = Path()
                item.coordinates.forEachIndexed { i, d ->
                    if (i == 0) {
                        path.moveTo(d.x, d.y)
                    } else {
                        path.lineTo(d.x, d.y)
                    }
                }
                list.add(
                    GestureDescription.StrokeDescription(
                        path, item.delayTime, item.duration
                    )
                )
                iterator.remove()
            } else {
                item.delayTime = item.delayTime - maxTime
                if (item.delayTime < 0) {
                    item.delayTime = 0
                }
            }
        }
    }


    private fun getStartCoordinate(): CoordinatePoint {
        val x = centerArea.x + centerArea.with * Math.random()
        val y = centerArea.y + centerArea.height * Math.random()
        return CoordinatePoint(x, y)
    }

    private fun getEndCoordinate(
        type: Int,
        startPs: CoordinatePoint,
        slidingLength: Double
    ): CoordinatePoint {
        val offset = Math.random() * 10 - 5
        var offsetX = slidingLength
        var offsetY = 0.0

        when (type) {
            DirectionType.RIGHT -> {
                offsetX = Math.cos((0 + offset) * du)
                offsetY = Math.sin((0 + offset) * du)
            }
            DirectionType.BOTTOM_RIGHT -> {
                offsetX = Math.cos((45 + offset) * du)
                offsetY = Math.sin((45 + offset) * du)
            }
            DirectionType.BOTTOM -> {
                offsetX = Math.cos((90 + offset) * du)
                offsetY = Math.sin((90 + offset) * du)
            }
            DirectionType.BOTTOM_LEFT -> {
                offsetX = Math.cos((135 + offset) * du)
                offsetY = Math.sin((135 + offset) * du)
            }
            DirectionType.LEFT -> {
                offsetX = Math.cos((180 + offset) * du)
                offsetY = Math.sin((180 + offset) * du)
            }
            DirectionType.TOP_LEFT -> {
                offsetX = Math.cos((225 + offset) * du)
                offsetY = Math.sin((225 + offset) * du)
            }
            DirectionType.TOP -> {
                offsetX = Math.cos((270 + offset) * du)
                offsetY = Math.sin((270 + offset) * du)
            }
            DirectionType.TOP_RIGHT -> {
                offsetX = Math.cos((315 + offset) * du)
                offsetY = Math.sin((315 + offset) * du)
            }
        }

        val x = startPs.x + offsetX * slidingLength
        val y = startPs.y + offsetY * slidingLength

        return CoordinatePoint(x, y)
    }

    private fun overPress() {
        cancelDescription?.let {
            aService.dispatchGesture(
                GestureDescription.Builder().addStroke(it).build(), null, null
            )
        }
        cancelDescription = null
    }

    private fun initJob() {
        if (job == null) {
            job = GlobalScope.launch(Dispatchers.Default) {
                _channelRefreshList.receiveAsFlow().collectLatest {
                    delay(200)
                    if (isComplete)
                        editPushInstruction()
                }
            }
        }
    }

    private fun cancelJob() {
        job?.cancel()
    }
}