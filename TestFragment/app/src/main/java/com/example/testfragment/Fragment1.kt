package com.example.testfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testfragment.databinding.Fragment1Binding


class Fragment1 : Fragment() {


    companion object{
        private const val TEXT_STRING = "TEXT_STRING"
        fun createFragment(text:String):Fragment1{
            val bundle = Bundle()
            bundle.putString(TEXT_STRING,text)
            return Fragment1().apply {
                arguments = bundle
            }
        }
    }

    private val binding:Fragment1Binding by lazy {
        Fragment1Binding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        setText()
        setCount(arguments?.getString(TEXT_STRING)?.toInt())





        return  binding.root
    }


    private fun setText(){
        binding.f1.text = arguments?.getString(TEXT_STRING).toString()
    }

    fun setCount(count:Int?){
        binding.containerF1.removeAllViews()
        if (count != null) {
            for (i in 0 until count.toInt()){
                val widget = Widget(requireContext())
                widget.setText(i.toString())
                binding.containerF1.addView(widget)
            }
        }
    }


}