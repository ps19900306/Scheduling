package com.system.android.myimdemoapplication

import android.util.Log
import com.tencent.imsdk.v2.V2TIMSDKListener
import com.tencent.imsdk.v2.V2TIMUserFullInfo

class AppTIMSDKListener: V2TIMSDKListener() {


    override fun onConnecting() {
        Log.i("nwq_","onConnecting")
    }

    override fun onConnectSuccess() {
        Log.i("nwq_","onConnectSuccess")
    }

    override fun onConnectFailed(code: Int, error: String?) {
        Log.i("nwq_","$code $error")
    }

    override fun onKickedOffline() {

    }

    override fun onUserSigExpired() {

    }

    override fun onSelfInfoUpdated(info: V2TIMUserFullInfo?) {}
}