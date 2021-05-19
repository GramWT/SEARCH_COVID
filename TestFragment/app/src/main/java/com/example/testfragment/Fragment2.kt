package com.example.testfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testfragment.databinding.Fragment2Binding


class Fragment2 : Fragment() {

    companion object{
        private const val TEXT_STRING  = "TEXT_STRING"
        fun createFragment(text:String):Fragment2{
            val bundle = Bundle().apply {
                putString(TEXT_STRING,text)
            }

            return Fragment2().apply {
                arguments = bundle
            }
        }
    }


    private val binding:Fragment2Binding by lazy { Fragment2Binding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


            binding.f2.text = arguments?.getString(TEXT_STRING)

        return binding.root
    }


}