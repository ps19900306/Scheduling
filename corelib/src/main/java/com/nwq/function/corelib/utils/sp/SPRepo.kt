package com.nwq.function.corelib.utils.sp

import com.nwq.function.corelib.utils.sp.SpConstant.CONTINUE_TO_THE_NEXT
import com.nwq.function.corelib.utils.sp.SpConstant.PREFIX_ROLE1
import com.nwq.function.corelib.utils.sp.SpConstant.ROLE


object SPRepo {

    var continueToTheNext by SP(CONTINUE_TO_THE_NEXT, false)
    var role by SP(ROLE, PREFIX_ROLE1)

}