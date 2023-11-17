package com.android.system.talker.im.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.schedule.corelibrary.utils.L
import com.android.system.talker.R
import com.android.system.talker.databinding.FragmentFirstBinding
import com.tencent.imsdk.v2.V2TIMConversationResult
import com.tencent.imsdk.v2.V2TIMManager
import com.tencent.imsdk.v2.V2TIMValueCallback


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.friendBtn.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        V2TIMManager.getConversationManager().getConversationList(0, Integer.MAX_VALUE,
            object : V2TIMValueCallback<V2TIMConversationResult> {
                override fun onError(code: Int, desc: String?) {
                    L.i("imsdk failure, code: $code desc: $desc");
                }

                override fun onSuccess(v2TIMConversationResult: V2TIMConversationResult) {
                    L.i("imsdk getConversationList   success ");
                    val nextSeq: Long = v2TIMConversationResult.getNextSeq()
                    val v2TIMConversationList = v2TIMConversationResult.conversationList
                    for (v2TIMConversation in v2TIMConversationList) {
                        Log.i("imsdk", "success showName:" + v2TIMConversation.showName)
                    }
                }
            }
        )
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}