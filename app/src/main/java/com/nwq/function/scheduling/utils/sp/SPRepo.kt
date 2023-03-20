package com.nwq.function.scheduling.utils.sp

import com.nwq.function.scheduling.utils.sp.SpConstant.CONTINUE_TO_THE_NEXT
import com.nwq.function.scheduling.utils.sp.SpConstant.LAST_PICKUP_TASK_TIME
import com.nwq.function.scheduling.utils.sp.SpConstant.LAST_REFRESH_TIME
import com.nwq.function.scheduling.utils.sp.SpConstant.PREFIX_ROLE1
import com.nwq.function.scheduling.utils.sp.SpConstant.ROLE

object SPRepo {

    var continueToTheNext by SP(CONTINUE_TO_THE_NEXT, false)
    var role by SP(ROLE, PREFIX_ROLE1)

}