package com.android.schedule.corelibrary.area

import com.android.schedule.corelibrary.SetConstant
import com.android.schedule.corelibrary.utils.L


/**
create by: 86136
create time: 2023/5/5 10:47
Function description:
 */

class ChunkCoordinateArea(
    x: Int,
    y: Int,
    width: Int,
    height: Int,
    var rowNumbr: Int = 1,//行数
    var columnNumbr: Int = 1,//列数
) : CoordinateArea(x, y, width, height, false) {


}