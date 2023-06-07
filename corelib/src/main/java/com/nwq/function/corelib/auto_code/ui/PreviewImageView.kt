package com.nwq.function.corelib.auto_code.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color.red
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import com.nwq.function.corelib.R
import com.nwq.function.corelib.area.CoordinateArea
import com.nwq.function.corelib.area.CoordinatePoint

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

    //单区域预览
    var oblongArea: CoordinateArea? = null


    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.PreviewImageView)
        dotSize = typedArray.getDimension(R.styleable.PreviewImageView_dotSize, 1F)
        val dotColor = typedArray.getColor(
            R.styleable.PreviewImageView_dotColor, ContextCompat.getColor(context, R.color.red)
        )
        val oblongSize = typedArray.getDimension(R.styleable.PreviewImageView_oblongSize, 1F)
        val oblongColor = typedArray.getColor(
            R.styleable.PreviewImageView_oblongColor, ContextCompat.getColor(context, R.color.black)
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


    fun addArea(coordinate: CoordinateArea): Boolean {
        if (!areaList.contains(coordinate)) {
            areaList.add(coordinate)
            invalidate()
            return true
        }
        return false
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

    fun setPointList(list:List<CoordinatePoint>){
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
            canvas.drawCircle(it.x, it.y, dotSize, mDotPaint)
        }
        areaList.forEach {
            canvas.drawRect(
                it.x.toFloat(),
                it.y.toFloat(),
                (it.x + it.width).toFloat(),
                (it.y + it.height).toFloat(),
                oblongPaint
            )
        }
        oblongArea?.let {
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