package com.asity.tech.design2

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.viewpager2.widget.ViewPager2
import com.asity.tech.design2.databinding.FragmentPage1Binding
import com.asity.tech.design2.databinding.FragmentPage2Binding

class page2Fragment : Fragment() {
    private var _binding: FragmentPage2Binding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPage2Binding.inflate(inflater, container, false)

        //startAnimation(false)
        startAnimation(true)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.imageView4.setOnClickListener {
            viewPager?.currentItem = 2
        }

        binding.imageView5.setOnClickListener {
            viewPager?.currentItem = 0
        }

        return binding.root
    }

    /*override fun onResume() {
        super.onResume()
        startAnimation(true)
    }

    override fun onPause() {
        super.onPause()
        startAnimation(false)
    }*/

    fun startAnimation(flag: Boolean) {
        setVisibility(binding.imageView4, 1,flag)
        setVisibility(binding.imageView5, 1,flag)
        setVisibility(binding.textView, 2,flag)
        setVisibility(binding.textView2, 3,flag)
        setVisibility(binding.button, 4,flag)
    }

    fun setVisibility(view: View, int: Long, flag: Boolean) {
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