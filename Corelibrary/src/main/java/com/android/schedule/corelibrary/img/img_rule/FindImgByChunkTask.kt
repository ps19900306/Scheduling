package com.android.schedule.corelibrary.img.img_rule

import android.graphics.Bitmap
import com.android.schedule.corelibrary.area.ChunkCoordinateArea
import com.android.schedule.corelibrary.area.CoordinateArea
import com.android.schedule.corelibrary.area.CoordinatePoint
import com.android.schedule.corelibrary.img.point_rule.IPR
import com.android.schedule.corelibrary.img.point_rule.PointRule
import kotlin.math.abs

//这个是分区块找图的
class FindImgByChunkTask(
    pr: PointRule, //这个是识别到第一个点的     这个点选取很关键
    findArea: CoordinateArea, //初始图片的寻找范围
    iprList: List<IPR>, tag: String,
) : FindImgTask(pr, findArea, iprList, tag) {

    var rows = 1
    var columns = 1

    var isNearest = true  //
    var notRepeatCount = 5
    private var lastChunkArea: ChunkCoordinateArea? = null
    private val recordPointList = mutableListOf<CoordinatePoint>()


    private val areaList by lazy {
        val list = mutableListOf<ChunkCoordinateArea>()
        if (rows <= 1 && columns <= 1) {

        } else if (rows <= 1) {
            val partWith = findArea.width / columns
            for (i in 0 until columns) {
                list.add(
                    ChunkCoordinateArea(
                        findArea.x + partWith,
                        findArea.y,
                        partWith,
                        findArea.height,
                        1,
                        i + 1
                    )
                )
            }
        } else if (columns <= 1) {
            val partHeight = findArea.height / rows
            for (i in 0 until rows) {
                list.add(
                    ChunkCoordinateArea(
                        findArea.x,
                        findArea.y + partHeight,
                        findArea.width,
                        partHeight,
                        i + 1,
                        1
                    )
                )
            }
        } else {
            val partWith = findArea.width / columns
            val partHeight = findArea.height / rows
            for (i in 0 until columns) {
                for (j in 0 until rows) {
                    list.add(
                        ChunkCoordinateArea(
                            findArea.x + partWith,
                            findArea.y + partHeight,
                            partWith,
                            partHeight,
                            j + 1,
                            i + 1
                        )
                    )
                }
            }
        }
        list
    }


    override suspend fun verificationRule(bitmap: Bitmap?): Boolean {
        if (bitmap == null) {
            return false
        }
        return if (areaList.isEmpty()) {
            findImgByColor(bitmap, findArea)
        } else {
            if (isNearest && lastChunkArea != null) {
                areaList.sortBy {
                    abs(lastChunkArea!!.columnNumbr - it.columnNumbr) + abs(
                        lastChunkArea!!.rowNumbr - it.rowNumbr
                    )
                }
            }
            val result = areaList.find { findImgByColor(bitmap, it) }
            if (notRepeatCount > 0 && (result != lastChunkArea || recordPointList.size >= notRepeatCount)) {
                recordPointList.clear()
            }
            lastChunkArea = result
            lastChunkArea != null
        }
    }

    override fun setImgKeyPoint(coordinatePoint: CoordinatePoint) {
        findImgPoint = coordinatePoint
        if (notRepeatCount > 0)
            recordPointList.add(coordinatePoint)
    }

    //
    protected override fun needIgnoredPoint(coordinatePoint: CoordinatePoint): Boolean {
        return if (notRepeatCount > 0) {
            recordPointList.find {
                5 < abs(it.xI - coordinatePoint.xI) + abs(coordinatePoint.yI - it.yI)
            } == null
        } else {
            false
        }
    }


}