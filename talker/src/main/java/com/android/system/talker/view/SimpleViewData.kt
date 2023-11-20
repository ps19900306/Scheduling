package com.android.system.talker.view

class SimpleViewData(private val title: String? = null, private val end: String? = null) :
    SimpleViewDataI {
    override fun getTitle(): String? {
        return title
    }

    override fun getEnd(): String? {
        return end
    }

}


interface SimpleViewDataI {

    fun getTitle(): String?

    fun getEnd(): String?
}