package com.asity.tech.native_android_designs

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.asity.tech.native_android_designs.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSettingsBinding.inflate(inflater, container, false)

        startAnimation(true)
        binding.refreshLayout.setOnRefreshListener {

            // Your code goes here
            // In this code, we are just changing the text in the
            // textbox

            // This line is important as it explicitly refreshes only once
            // If "true" it implicitly refreshes forever
            startAnimation(false)
            startAnimation(true)
            //Toast.makeText(context,"Here..........",Toast.LENGTH_LONG).show()
            binding.refreshLayout.isRefreshing = false
        }
        return binding.root
    }
    private fun startAnimation(flag: Boolean) {
        setVisibility(binding.relativeLayout, 3,flag)
        setVisibility(binding.account, 4,flag)
        setVisibility(binding.chats, 5,flag)
        setVisibility(binding.notifications, 6,flag)
        setVisibility(binding.storageAndData, 7,flag)
        setVisibility(binding.help, 8,flag)
        setVisibility(binding.inviteAFriend, 9,flag)
        setVisibility(binding.textView,10,flag)
        setVisibility(binding.imageView,11,flag)
    }

    private fun setVisibility(view: View, int: Long, flag: Boolean) {
        if (flag) {
            val animationFadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in)
            Handler().postDelayed({
                view.visibility = View.VISIBLE
                view.startAnimation(animationFadeIn)
            }, 200 * int)

        } else {
            view.visibility = View.INVISIBLE
        }
    }
}