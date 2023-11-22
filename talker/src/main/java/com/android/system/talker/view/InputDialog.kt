package com.android.system.talker.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.android.schedule.corelibrary.expand.singleClick
import com.android.system.talker.databinding.DialogInputBinding

class InputDialog(val next: (s: String) -> Unit) : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val bind = DialogInputBinding.inflate(inflater)

        bind.button.singleClick {
            next.invoke(bind.editText.text.toString())
        }
        return bind.root
    }
}