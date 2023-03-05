package com.nwq.function.scheduling.utils.sp

import com.nwq.function.scheduling.utils.sp.SpConstant.LAST_PICKUP_TASK_TIME
import com.nwq.function.scheduling.utils.sp.SpConstant.LAST_REFRESH_TIME
import com.nwq.function.scheduling.utils.sp.SpConstant.ROLE1_ROUND_BATTLE_OPEN
import com.nwq.function.scheduling.utils.sp.SpConstant.ROLE1_TIME_ON_LIST1
import com.nwq.function.scheduling.utils.sp.SpConstant.ROLE1_TIME_ON_LIST2
import com.nwq.function.scheduling.utils.sp.SpConstant.ROLE1_TIME_ON_LIST3
import com.nwq.function.scheduling.utils.sp.SpConstant.ROLE1_WHOLE_BATTLE_OPEN
import com.nwq.function.scheduling.utils.sp.SpConstant.ROLE2_ROUND_BATTLE_OPEN
import com.nwq.function.scheduling.utils.sp.SpConstant.ROLE2_TIME_ON_LIST1
import com.nwq.function.scheduling.utils.sp.SpConstant.ROLE2_TIME_ON_LIST2
import com.nwq.function.scheduling.utils.sp.SpConstant.ROLE2_TIME_ON_LIST3
import com.nwq.function.scheduling.utils.sp.SpConstant.ROLE2_WHOLE_BATTLE_OPEN

object SPRepo {
    var lastRefreshTimeSp by SP(LAST_REFRESH_TIME, 0L)
    var lastPickUpTaskTimeSp by SP(LAST_PICKUP_TASK_TIME, 0L)

    var role1WholeBattleOpenby by SP(ROLE1_WHOLE_BATTLE_OPEN, "")
    var role1RoundBattleOpen  by SP(ROLE1_ROUND_BATTLE_OPEN, "")
    var role1TimeOnList1 by SP(ROLE1_TIME_ON_LIST1, "")
    var role1TimeOnList2 by SP(ROLE1_TIME_ON_LIST2, "")
    var role1TimeOnList3 by SP(ROLE1_TIME_ON_LIST3, "")

    var role2WholeBattleOpenby by SP(ROLE2_WHOLE_BATTLE_OPEN, "")
    var role2RoundBattleOpen  by SP(ROLE2_ROUND_BATTLE_OPEN, "")
    var role2TimeOnList1 by SP(ROLE2_TIME_ON_LIST1, "")
    var role2TimeOnList2 by SP(ROLE2_TIME_ON_LIST2, "")
    var role2TimeOnList3 by SP(ROLE2_TIME_ON_LIST3, "")


}