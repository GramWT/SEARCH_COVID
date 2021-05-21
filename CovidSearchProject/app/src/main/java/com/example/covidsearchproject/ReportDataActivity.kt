package com.example.covidsearchproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.covidsearchproject.Model.Report
import com.example.covidsearchproject.databinding.ActivityReportDataBinding

class ReportDataActivity : AppCompatActivity() {


    companion object{
        const val DATA_MODEL = "DATA_MODEL"
        fun createIntent(context: Context,report: Report):Intent{
            return Intent(context, ReportDataActivity::class.java).apply {
              putExtra(DATA_MODEL,report)
            }
        }
    }

    private val binding:ActivityReportDataBinding by lazy {
        ActivityReportDataBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val report: Report? = intent.getParcelableExtra<Report>(DATA_MODEL)

        binding.regionText.text = report?.region?.name
        binding.provinceText.text = report?.region?.province
        binding.confirmedText.text = report?.confirmed
        binding.recoveredText.text = report?.recovered
        binding.deathsText.text = report?.deaths

    }
}