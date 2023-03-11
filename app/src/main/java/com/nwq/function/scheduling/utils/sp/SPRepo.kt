package com.nwq.function.scheduling.utils.sp

import com.nwq.function.scheduling.utils.sp.SpConstant.LAST_PICKUP_TASK_TIME
import com.nwq.function.scheduling.utils.sp.SpConstant.LAST_REFRESH_TIME
import com.nwq.function.scheduling.utils.sp.SpConstant.PREFIX_ROLE1
import com.nwq.function.scheduling.utils.sp.SpConstant.ROLE

object SPRepo {
    var lastRefreshTimeSp by SP(LAST_REFRESH_TIME, 0L)
    var lastPickUpTaskTimeSp by SP(LAST_PICKUP_TASK_TIME, 0L)
    var lastBackSpaceStation by SP(LAST_PICKUP_TASK_TIME, 0L)

    var role by SP(ROLE,PREFIX_ROLE1)
}