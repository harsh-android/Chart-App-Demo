package com.example.testapp.PieChart

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.databinding.ActivityPieChartBinding
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry


class PieChartActivity : AppCompatActivity() {

    lateinit var binding : ActivityPieChartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPieChartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showPieChart()

    }

    private fun showPieChart() {
        val pieEntries = ArrayList<PieEntry>()
        val label = "type"

        //initializing data
        val typeAmountMap: MutableMap<String, Int> = HashMap()
        typeAmountMap["Toys"] = 200
        typeAmountMap["Snacks"] = 230
        typeAmountMap["Clothes"] = 100
        typeAmountMap["Stationary"] = 500
        typeAmountMap["Phone"] = 50

        //initializing colors for the entries
        val colors = ArrayList<Int>()
        colors.add(Color.parseColor("#304567"))
        colors.add(Color.parseColor("#309967"))
        colors.add(Color.parseColor("#476567"))
        colors.add(Color.parseColor("#890567"))
        colors.add(Color.parseColor("#a35567"))
        colors.add(Color.parseColor("#ff5f67"))
        colors.add(Color.parseColor("#3ca567"))

        //input data and fit data into pie chart entry
        for (type in typeAmountMap.keys) {
            pieEntries.add(PieEntry(typeAmountMap[type]!!.toFloat(), type))
        }

        //collecting the entries with label name
        val pieDataSet = PieDataSet(pieEntries, label)
        //setting text size of the value
        pieDataSet.valueTextSize = 12f
        //providing color list for coloring different entries
        pieDataSet.colors = colors
        //grouping the data set from entry to chart
        val pieData = PieData(pieDataSet)
        //showing the value of the entries, default true if not set
        pieData.setDrawValues(true)
        binding.pieChart.setData(pieData)
        binding.pieChart.invalidate()
    }
}