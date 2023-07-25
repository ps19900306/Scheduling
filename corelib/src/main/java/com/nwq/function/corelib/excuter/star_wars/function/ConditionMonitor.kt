package com.nwq.function.corelib.excuter.star_wars.function

import com.nwq.function.corelib.img.task.ImgTask


/**
create by: 86136
create time: 2023/7/25 15:17
Function description:这个是进行狂态监控的
onRoundStart  每一轮开始
onRoundEnd    每一轮结束
onImgUpdate   每获取倒一张新图片
 */
class ConditionMonitor(
    val onRoundStart: Array<ImgTask>,
    val onRoundEnd: Array<ImgTask>,
    val onImgUpdate: Array<ImgTask>
) {
    
}