package com.example.covidsearchproject

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.annotation.AttrRes
import com.example.covidsearchproject.Model.Report
import com.example.covidsearchproject.databinding.CovidLayoutBinding

class WidgetCOVIDLayout @JvmOverloads constructor(
    context: Context,
    attrs:AttributeSet? = null,
    @AttrRes defStyleAttr:Int = 0
):androidx.constraintlayout.widget.ConstraintLayout(context, attrs, defStyleAttr) {

    private val nameText:TextView
    private val province:TextView
    private val deathsCount:TextView
    private val confirmed:TextView
    private val recovered:TextView

    init {
        val binding = CovidLayoutBinding.inflate(
            LayoutInflater.from(context),
            this,
            true
        )

        nameText = binding.nameText
        province = binding.provinceText
        deathsCount = binding.deathsCount
        confirmed = binding.confirmedText
        recovered = binding.recoveredText
    }

    fun setInit(report: Report){
        setName(report.region?.name.toString())
        setProvince(report.region?.province.toString())
        setDeathsCount(report.deaths.toString())
        setConfirmed(report.confirmed.toString())
        setRecovered(report.recovered.toString())
    }

    private fun setName(text:String){
        nameText.text = text
    }

    private fun setProvince(text: String){
        province.text = text
    }

    private fun setDeathsCount(count:String){
        deathsCount.text = count
    }

    private fun setConfirmed(string: String){
        confirmed.text = string
    }

    private fun setRecovered(string: String){
        recovered.text = string
    }

}