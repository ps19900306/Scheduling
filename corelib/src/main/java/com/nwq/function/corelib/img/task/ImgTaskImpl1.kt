package com.nwq.function.corelib.img.task


import com.nwq.function.corelib.img.pcheck.IPR

/**
create by: 86136
create time: 2023/5/13 14:22
Function description:
固定点找图，成功后会记录偏差值，以优化流程
 */
class ImgTaskImpl1(
    iprList: List<IPR>,
    tag: String,
    val xRange: Int = 0, //初始图片的寻找范围，
    val yRange: Int = 0, //初始图片的寻找范围，
    val faultTolerance: Boolean = (xRange > 0 || yRange > 0), //如果全部是内部点的旧不进行容错处理了
) : ImgTask(iprList, tag) {

    init {
        if (xRange == 0 || yRange == 0) {
            hasCorrect = true
        }
    }

    constructor(iprList: List<IPR>, tag: String, range: Int) : this(iprList, tag, range, range)

}