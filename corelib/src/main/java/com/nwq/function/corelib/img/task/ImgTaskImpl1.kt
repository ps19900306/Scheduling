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
    xRange: Int = 0, //初始图片的寻找范围，
    yRange: Int = 0 //初始图片的寻找范围，
) : ImgTask(iprList, tag) {

    constructor(iprList: List<IPR>, tag: String, range: Int) : this(iprList, tag, range, range)
}