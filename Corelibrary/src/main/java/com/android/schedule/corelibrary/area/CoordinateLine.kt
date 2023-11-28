package com.android.schedule.corelibrary.area

import com.android.schedule.corelibrary.SetConstant
/**
create by: 86136
create time: 2023/5/5 10:43
Function description:
这里不用INT,这样生成的坐标带小数，触发点击更好用
 */
open class CoordinateLine(var startP: CoordinatePoint,  var endP: CoordinatePoint,var distance:Int =1 )