package com.android.system.talker.im

import com.tencent.imsdk.v2.V2TIMGroupMemberInfo
import com.tencent.imsdk.v2.V2TIMSimpleMsgListener
import com.tencent.imsdk.v2.V2TIMUserInfo

object AppMsgListener : V2TIMSimpleMsgListener() {

    //接受普通消息
    override fun onRecvC2CTextMessage(msgID: String?, sender: V2TIMUserInfo?, text: String?) {

    }

    override fun onRecvC2CCustomMessage(
        msgID: String?,
        sender: V2TIMUserInfo?,
        customData: ByteArray?
    ) {

    }

    override fun onRecvGroupTextMessage(
        msgID: String?,
        groupID: String?,
        sender: V2TIMGroupMemberInfo?,
        text: String?
    ) {

    }

    override fun onRecvGroupCustomMessage(
        msgID: String?,
        groupID: String?,
        sender: V2TIMGroupMemberInfo?,
        customData: ByteArray?
    ) {

    }
}