package com.android.system.talker.im.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.schedule.corelibrary.expand.singleClick
import com.android.schedule.corelibrary.utils.L
import com.android.system.talker.R
import com.android.system.talker.databinding.FragmentSecondBinding
import com.android.system.talker.view.SimpleViewAdapter
import com.android.system.talker.view.SimpleViewData
import com.tencent.imsdk.v2.V2TIMFriendAddApplication
import com.tencent.imsdk.v2.V2TIMFriendInfo
import com.tencent.imsdk.v2.V2TIMFriendOperationResult
import com.tencent.imsdk.v2.V2TIMFriendshipListener
import com.tencent.imsdk.v2.V2TIMManager
import com.tencent.imsdk.v2.V2TIMValueCallback


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ConversationDetailFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sessionBtn.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }


        binding.AddFriendBtn.singleClick {
            binding.userIdEdt.text.toString().let {
                addFriend(it)
            }
        }

        refreshFriend()

        V2TIMManager.getFriendshipManager().setFriendListener(object : V2TIMFriendshipListener() {

//            override fun onError(code: Int, desc: String?) {
//                L.i("imsdk failure, code: $code desc: $desc");
//            }
//
//            override fun onSuccess(result: V2TIMFriendOperationResult) {
//                L.i("imsdk getFriendList   success ");
//            }
        })
    }


    fun addFriend(userId:String){
        val application = V2TIMFriendAddApplication(userId)
        application.setAddType(V2TIMFriendInfo.V2TIM_FRIEND_TYPE_BOTH);
        V2TIMManager.getFriendshipManager()
            .addFriend(application, object : V2TIMValueCallback<V2TIMFriendOperationResult?> {
                override fun onSuccess(v2TIMFriendOperationResult: V2TIMFriendOperationResult?) {
                    L.i("imsdk addFriend   success ");
                    refreshFriend()
                }

                override fun onError(code: Int, desc: String) {
                    L.i("imsdk addFriend failure, code: $code desc: $desc");
                }
            })
    }



    fun refreshFriend(){
        V2TIMManager.getFriendshipManager()
            .getFriendList(object : V2TIMValueCallback<List<V2TIMFriendInfo>> {
                override fun onError(code: Int, desc: String?) {
                    L.i("imsdk failure, code: $code desc: $desc");
                }

                override fun onSuccess(list: List<V2TIMFriendInfo>?) {
                    list?.map { SimpleViewData(it.userID) }?.let {
                        binding.recyclerview.adapter = SimpleViewAdapter(it){

                        }
                    }

                }
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}