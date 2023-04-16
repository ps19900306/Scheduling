package com.nwq.function.scheduling.auto_code.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.nwq.function.scheduling.R
import com.nwq.function.scheduling.core_code.Area
import com.nwq.function.scheduling.core_code.Coordinate

/**
create by: 86136
create time: 2023/4/10 11:23
Function description:
 */

class OperateUiView(context: Context, attrs: AttributeSet?) : View(context, attrs) {


    constructor (context: Context) : this(context, null)

    private val mDotPaint: Paint  //用来画点的
    private val oblongPaint: Paint //用来画长方形的
    private val dotSize: Float
    private val dotList = mutableListOf<Coordinate>()
    private var oblongArea: Area? = null
    private var showFlag = true


    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.OperateUiView)
        dotSize = typedArray.getDimension(R.styleable.OperateUiView_dotSize, 1F)
        val dotColor = typedArray.getColor(
            R.styleable.OperateUiView_dotColor, ContextCompat.getColor(context, R.color.red)
        )
        val oblongSize = typedArray.getDimension(R.styleable.OperateUiView_oblongSize, 1F)
        val oblongColor = typedArray.getColor(
            R.styleable.OperateUiView_oblongColor, ContextCompat.getColor(context, R.color.black)
        )
        mDotPaint = Paint()
        mDotPaint.color = dotColor


        oblongPaint = Paint()
        oblongPaint.color = oblongColor
        oblongPaint.strokeWidth = oblongSize
        oblongPaint.setStyle(Paint.Style.STROKE)
    }

    fun addDot(coordinate: Coordinate) {
        if (!dotList.contains(coordinate)) {
            dotList.add(coordinate)
            invalidate()
        }
    }

    fun removeDot(coordinate: Coordinate) {
        if (dotList.contains(coordinate)) {
            dotList.remove(coordinate)
            invalidate()
        }
    }

    fun clearAllData() {
        dotList.clear()
        oblongArea = null
    }

    fun setArea(area: Area?) {
        oblongArea = area
        invalidate()
    }

    fun setShowFlag(boolean: Boolean) {
        if (boolean != showFlag) {
            showFlag = boolean
            invalidate()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (!showFlag) {
            return
        }
        dotList.forEach {
            canvas.drawCircle(it.x, it.y, dotSize, mDotPaint)
        }
        oblongArea?.let {
            canvas.drawRect(
                it.x.toFloat(),
                it.y.toFloat(),
                (it.x + it.with).toFloat(),
                (it.y + it.height).toFloat(),
                oblongPaint
            )
        }
    }
}