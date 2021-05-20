package com.example.covidsearchproject

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covidsearchproject.Model.Region
import com.example.covidsearchproject.Model.Report
import com.example.covidsearchproject.databinding.ActivityMainBinding
import dmax.dialog.SpotsDialog
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    lateinit var dialog: AlertDialog
    private var gridLayoutManager: GridLayoutManager? = null

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textView2.setOnClickListener {
            val intent = Intent(this,Map::class.java)
            startActivity(intent)
        }

        var data: MutableList<Report>
        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()
        binding.searchButton.setOnClickListener {
            var url = "https://covid-19-statistics.p.rapidapi.com/reports?date=${binding.yearText.text}-${binding.monthText.text}-${binding.dayText.text}&region_name=${binding.regionText.text}"

            GlobalScope.launch {

                data = setJson(url)


                runOnUiThread {

                    val adapter = ReportAdapter(data)
                    binding.reportRecycleView.adapter = adapter
                    binding.reportRecycleView.hasFixedSize()
                    gridLayoutManager =
                        GridLayoutManager(this@MainActivity, 1, LinearLayoutManager.VERTICAL, false)
                    binding.reportRecycleView.layoutManager = gridLayoutManager

                }
            }
        }






    }

    private suspend fun setJson(URL:String):MutableList<Report> {
        delay(3000L)
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(URL)
            .get()
            .addHeader("x-rapidapi-key", "0369a88e85msh257fb4ca405d81ep1c1982jsnbec30a7823ee")
            .addHeader("x-rapidapi-host", "covid-19-statistics.p.rapidapi.com")
            .build()

        val response = client.newCall(request).execute()
        val dataModel = response.body()?.string()
        val jsonObject = JSONObject(dataModel)


        val count = jsonObject.getJSONArray("data").length()

        var reportData = mutableListOf<Report>()

        for (i in 0 until count) {
            val item = jsonObject.getJSONArray("data")[i].toString()
            val reportFile = JSONObject(item)
            val regionCount = reportFile.getString("region")
            val regionFile = JSONObject(regionCount)
            val report = Report(
                reportFile.getString("date"),
                reportFile.getString("confirmed"),
                reportFile.getString("deaths"),
                reportFile.getString("recovered"),
                reportFile.getString("confirmed_diff"),
                reportFile.getString("deaths_diff"),
                reportFile.getString("recovered_diff"),
                reportFile.getString("last_update"),
                reportFile.getString("active"),
                reportFile.getString("active_diff"),
                reportFile.getString("fatality_rate"),
                Region(regionFile.getString("iso"),
                       regionFile.getString("name"),
                       regionFile.getString("province"),
                       regionFile.getString("lat"),
                       regionFile.getString("long"))
            )

            reportData.add(i,report)
        }

        return reportData


    }
}