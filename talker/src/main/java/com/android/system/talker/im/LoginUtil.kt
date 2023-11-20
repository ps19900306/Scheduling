package com.system.android.myimdemoapplication


import android.content.Context
import com.android.schedule.corelibrary.utils.L
import com.android.system.talker.im.AppMsgListener
import com.android.system.talker.im.GenerateTestUserSig
import com.tencent.imsdk.v2.V2TIMCallback
import com.tencent.imsdk.v2.V2TIMManager
import com.tencent.imsdk.v2.V2TIMSDKConfig


object LoginUtil {

    private final val appId = 1400413721
    private final val secretKey = "217e6f197a5c6f57bd906ce8c39c586da847844eb6cb95ce11cf52f330cb538a"

    fun init(context: Context) {
        // 初始化 config 对象
        // 初始化 config 对象
        val config = V2TIMSDKConfig()
        // 指定 log 输出级别
        // 指定 log 输出级别
        config.setLogLevel(V2TIMSDKConfig.V2TIM_LOG_INFO)
        V2TIMManager.getInstance().initSDK(context, appId, config, AppTIMSDKListener())
    }

    fun unInit() {
        V2TIMManager.getInstance().unInitSDK()
    }


    fun loginIm(userID: String = "test1",onNext:()->Unit) {
        val userSig = GenerateTestUserSig.genTestUserSig(userID)
        V2TIMManager.getInstance().login(userID,userSig,object : V2TIMCallback{
            override fun onError(p0: Int, p1: String?) {
                L.i("onError $p0 $p1")
            }

            override fun onSuccess() {
                L.i("onSuccess")
                onNext.invoke()
            }
        })

        V2TIMManager.getInstance().addSimpleMsgListener(AppMsgListener);
    }



}