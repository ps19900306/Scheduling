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
import com.android.system.talker.databinding.FragmentGroupListBinding
import com.android.system.talker.view.SimpleViewAdapter
import com.android.system.talker.view.SimpleViewData
import com.tencent.imsdk.v2.V2TIMFriendAddApplication
import com.tencent.imsdk.v2.V2TIMFriendInfo
import com.tencent.imsdk.v2.V2TIMFriendOperationResult
import com.tencent.imsdk.v2.V2TIMFriendshipListener
import com.tencent.imsdk.v2.V2TIMGroupApplicationResult
import com.tencent.imsdk.v2.V2TIMManager
import com.tencent.imsdk.v2.V2TIMValueCallback


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class GroupListFragment : Fragment() {

    private var _binding: FragmentGroupListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGroupListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sessionBtn.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }


        binding.AddFriendBtn.singleClick {
            binding.userIdEdt.text.toString().let {
                createGroup(it)
            }
        }

        refreshGroupList()

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





    fun createGroup(groupId: String) {
        V2TIMManager.getInstance().createGroup(V2TIMManager.GROUP_TYPE_WORK,
            null,
            groupId,
            object : V2TIMValueCallback<String> {
                override fun onError(code: Int, desc: String?) {
                    L.i("imsdk createGroup failure, code: $code desc: $desc");
                }

                override fun onSuccess(p0: String?) {
                    L.i("imsdk createGroup  Success");
                    refreshGroupList()
                }

            })
    }


    fun refreshGroupList() {
        V2TIMManager.getGroupManager()
            .getGroupApplicationList(object : V2TIMValueCallback<V2TIMGroupApplicationResult> {
                override fun onError(code: Int, desc: String?) {
                    L.i("imsdk getGroupApplicationList failure, code: $code desc: $desc");
                }

                override fun onSuccess(result: V2TIMGroupApplicationResult?) {
                    L.i("imsdk getGroupApplicationList  Success");
                    result?.groupApplicationList?.map { SimpleViewData(it.groupID) }?.let {
                        binding.recyclerview.adapter = SimpleViewAdapter(it) {

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