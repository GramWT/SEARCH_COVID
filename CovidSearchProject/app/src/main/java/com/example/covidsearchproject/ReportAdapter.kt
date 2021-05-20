package com.example.covidsearchproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covidsearchproject.Model.Report
import com.example.covidsearchproject.databinding.ReportRowBinding
import kotlinx.android.synthetic.main.report_row.view.*

class ReportAdapter(private var reportList:List<Report>) : RecyclerView.Adapter<ReportAdapter.MyViewHolder>() {


    private lateinit var binding: ReportRowBinding

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ReportRowBinding.inflate(LayoutInflater.from(parent.context))

        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = reportList[position]
        holder.itemView.region_textView.text = currentItem.region?.name.toString()
        holder.itemView.province_textView.text = currentItem.region?.province.toString()
        holder.itemView.confirmed_textView.text = currentItem.confirmed
        holder.itemView.recovered_textView.text = currentItem.recovered
        holder.itemView.deaths_textView.text = currentItem.deaths
    }

    override fun getItemCount(): Int {
        return reportList.size
    }

    fun setData(report:List<Report>){
        this.reportList = report
        notifyDataSetChanged()
    }

}