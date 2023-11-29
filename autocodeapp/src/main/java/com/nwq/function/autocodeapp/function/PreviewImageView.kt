package com.nwq.function.autocodeapp.function

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.area.CoordinateLine
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.click.ClickArea
import com.nwq.function.autocodeapp.R

/**
create by: 86136
create time: 2023/5/22 14:51
Function description:
 */
class PreviewImageView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    constructor (context: Context) : this(context, null)


    private var showFlag = true

    private val mDotPaint: Paint  //用来画点的
    private val oblongPaint: Paint //用来画长方形的
    private val dotSize: Float

    val dotList = mutableListOf<CoordinatePoint>()
    var areaList = mutableListOf<CoordinateArea>()
    var lineList = mutableListOf<CoordinateLine>()

    //单区域预览
    var oblongArea: CoordinateArea? = null

    //单区域预览
    var oblongLine: CoordinateLine? = null

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.PreviewImageView)
        dotSize = typedArray.getDimension(R.styleable.PreviewImageView_dotSize, 1F)
        val dotColor = typedArray.getColor(
            R.styleable.PreviewImageView_dotColor, ContextCompat.getColor(context, R.color.red)
        )
        val oblongSize = typedArray.getDimension(R.styleable.PreviewImageView_oblongSize, 1F)
        val oblongColor = typedArray.getColor(
            R.styleable.PreviewImageView_oblongColor, ContextCompat.getColor(context, R.color.green)
        )
        mDotPaint = Paint()
        mDotPaint.color = dotColor


        oblongPaint = Paint()
        oblongPaint.color = oblongColor
        oblongPaint.strokeWidth = oblongSize
        oblongPaint.setStyle(Paint.Style.STROKE)
    }

    fun setArea(area: CoordinateArea?) {
        oblongArea = area
        invalidate()
    }

    fun setLine(line: CoordinateLine?) {
        oblongLine = line
        invalidate()
    }

    fun addArea(coordinate: CoordinateArea): Boolean {
        if (!areaList.contains(coordinate)) {
            areaList.add(coordinate)
            invalidate()
            return true
        }
        return false
    }

    fun addLine(line: CoordinateLine): Boolean {
        if (!lineList.contains(line)) {
            lineList.add(line)
            invalidate()
            return true
        }
        return false
    }

    fun clearLine() {
        oblongLine = null
        lineList.clear()
    }

    fun removeArea(coordinate: CoordinateArea) {
        if (areaList.contains(coordinate)) {
            areaList.remove(coordinate)
            invalidate()
        }
    }

    fun clearArea() {
        areaList.clear()
    }


    fun addDot(coordinate: CoordinatePoint): Boolean {
        if (!dotList.contains(coordinate)) {
            dotList.add(coordinate)
            invalidate()
            return true
        }
        return false
    }

    fun removeDot(coordinate: CoordinatePoint) {
        if (dotList.contains(coordinate)) {
            dotList.remove(coordinate)
            invalidate()
        }
    }

    fun clearPoint() {
        dotList.clear()
    }

    fun setPointList(list: List<CoordinatePoint>) {
        dotList.clear()
        dotList.addAll(list)
        invalidate()
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (!showFlag) {
            return
        }
        dotList.forEach {
            canvas.drawCircle(it.xF, it.yF, dotSize, mDotPaint)
        }
        areaList.forEach {
            if (it.isRound) {
                canvas.drawCircle(
                    it.xF, it.yF,
                    Math.min(
                        (it.x + it.width).toFloat(), (it.y + it.height).toFloat()
                    ),
                    oblongPaint,
                )
            } else {
                canvas.drawRect(
                    it.x.toFloat(),
                    it.y.toFloat(),
                    (it.x + it.width).toFloat(),
                    (it.y + it.height).toFloat(),
                    oblongPaint
                )
            }
        }
        lineList.forEach { line ->
            canvas.drawLine(line.startP.xF, line.startP.yF, line.endP.xF, line.endP.yF, oblongPaint)
        }

        oblongLine?.let { line ->
            canvas.drawLine(line.startP.xF, line.startP.yF, line.endP.xF, line.endP.yF, oblongPaint)
        }

        oblongArea?.let {
            if (it.isRound) {
                canvas.drawCircle(
                    it.x.toFloat() + it.width / 2,
                    it.y.toFloat() + it.height / 2,
                    (it.width.coerceAtMost(it.height) / 2).toFloat(),
                    oblongPaint
                )
            } else {
                canvas.drawRect(
                    it.x.toFloat(),
                    it.y.toFloat(),
                    (it.x + it.width).toFloat(),
                    (it.y + it.height).toFloat(),
                    oblongPaint
                )
            }

        }
    }




}