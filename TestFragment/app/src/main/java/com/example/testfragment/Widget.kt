package com.example.testfragment

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.annotation.AttrRes
import com.example.testfragment.databinding.WidgetTextBinding

class Widget @JvmOverloads constructor(
    context: Context,
    attrs:AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0
):androidx.constraintlayout.widget.ConstraintLayout(context,
attrs,defStyleAttr) {

    private val textWidget :TextView

    init {
        val binding = WidgetTextBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )


        textWidget = binding.textWidget
    }

    fun setText(text:String){
        textWidget.text = text
    }
}