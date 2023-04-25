package com.nwq.function.scheduling.executer.test

import android.os.Bundle
import android.view.accessibility.AccessibilityNodeInfo
import com.nwq.function.scheduling.core_code.SwipeArea
import com.nwq.function.scheduling.core_code.click.DirectionType
import com.nwq.function.scheduling.core_code.click.MoveClickUtils
import com.nwq.function.scheduling.core_code.click.MoveDirection
import com.nwq.function.scheduling.core_code.contract.AccessibilityHelper
import com.nwq.function.scheduling.executer.base.TravelController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.util.*

/**
create by: 86136
create time: 2023/3/1 10:59
Function description:
 */

class ClickTestController(helper: AccessibilityHelper) : TravelController(helper, { true }) {


    override suspend fun generalControlMethod() {
        //testGetColor()
        randMoveTest()

        withContext(Dispatchers.IO) {

        }


    }

    suspend fun moveLeft() {
        flow {
            emit(10)
        }.flowOn(Dispatchers.IO)
            .onStart {

            }.catch {

            }.onCompletion {

            }.onEach {

            }

    }

    suspend fun randMoveTest() {
        MoveClickUtils.aService = helper.acService
        delay(5000)
        for (i in 0..20) {
            MoveClickUtils.publishMoveDirection(
                MoveDirection((Math.random() * 8 + 1).toInt(), (Math.random() * 8 + 1).toInt()),
                MoveDirection((Math.random() * 8 + 1).toInt(), (Math.random() * 8 + 1).toInt()),
                MoveDirection((Math.random() * 8 + 1).toInt(), (Math.random() * 8 + 1).toInt()),
                MoveDirection((Math.random() * 8 + 1).toInt(), (Math.random() * 8 + 1).toInt()),
            )
            delay(3000)
        }
    }


    suspend fun randClickTest() {
        helper.takeScreen()
        for (i in 0 until 10000) {
            val value = Math.random()
            if (value < 0.001) {
                helper.pressBackBtn()
                Timber.d("pressBackBtn testClick ClickTestController NWQ_ 2023/3/12");
            } else if (value < 0.9) {
                val sx = Math.random() * getBitmapWith()
                val sy = (Math.random() * 0.9 + 0.1) * getBitmapHeight()
                val ex = Math.random() * getBitmapWith()
                val ey = (Math.random() * 0.9 + 0.1) * getBitmapHeight()
                helper.swipe(SwipeArea(sx, sy, ex, ey).toClickTask(2))
            } else if (value < 0.2) {
                val x = Math.random() * getBitmapWith()
                val y = (Math.random() * 0.9 + 0.1) * getBitmapHeight()
                click(x.toFloat(), y.toFloat())
                Timber.d("x:$x y:$y  testClick ClickTestController NWQ_ 2023/3/12");
            } else {
                helper.getAccessibilityNodeInfo()?.let {
                    val info = getRandAccessibilityNodeInfo(it)
                    if (info.isEditable) {
                        val arguments = Bundle();
                        val str = getRandomString((Math.random() * 3 + 1).toInt())
                        arguments.putCharSequence(
                            AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE,
                            str
                        )
                        info.performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, arguments)
                    } else {
                        info.performAction(AccessibilityNodeInfo.ACTION_CLICK)
                    }
                }
                Timber.d("操作空间  testClick ClickTestController NWQ_ 2023/3/12");
            }

            delay(300)
        }
    }

    fun getRandAccessibilityNodeInfo(root: AccessibilityNodeInfo): AccessibilityNodeInfo {
        val value = Math.random()
        val info = root.getChild((Math.random() * root.childCount).toInt())
        return if (value > 0.8) {
            info
        } else if (info.childCount > 0) {
            getRandAccessibilityNodeInfo(info)
        } else if (value < 0.2) {
            getRandAccessibilityNodeInfo(root)
        } else {
            info
        }
    }

    fun getRandomString(length: Int): String? {
        val str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        val random = Random()
        val sb = StringBuffer()
        for (i in 0 until length) {
            val number: Int = random.nextInt(62)
            sb.append(str[number])
        }
        return sb.toString()
    }


    suspend fun testGetColor() {
        delay(3000)
        for (i in 0 until 100) {
            helper.takeScreen()
            val x = (Math.random() * getBitmapWith()).toFloat()
            val y = (Math.random() * getBitmapHeight()).toFloat()
            val color = getColor(x.toInt(), y.toInt())
            Timber.d(
                "x:$x y:$y color:${
                    color?.toArgb().toString()
                }  testGetColor ClickTestController NWQ_ 2023/3/12"
            );
            delay(500)
        }
    }

    suspend fun testClick() {
        for (i in 0 until 10) {
            val x = (Math.random() * getBitmapWith()).toFloat()
            val y = (Math.random() * getBitmapHeight()).toFloat()
            click(x, y)
            Timber.d("x:$x y:$y  testClick ClickTestController NWQ_ 2023/3/12");
            delay(500)
        }
    }

    suspend fun testSlide() {
        delay(3000)
        Timber.d("With:${getBitmapWith()} Height:${getBitmapHeight()}  testSlide ClickTestController NWQ_ 2023/3/12");
        for (i in 0 until 10) {
            val x = ((Math.random() * 0.4 + 0.3) * getBitmapWith()).toFloat()
            val y = ((Math.random() * 0.4 + 0.2) * getBitmapHeight()).toFloat()
            Timber.d("x:$x y:$y  testSlide ClickTestController NWQ_ 2023/3/12");
            slide(
                x, y, ((Math.random() * 0.2 + 0.1) * getBitmapWith()).toInt(),
                ((Math.random() * 0.2 + 0.1) * getBitmapHeight()).toInt(),
                DirectionType.LEFT,
            )
            delay(500)
        }
    }


}