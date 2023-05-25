package com.example.testapp.BarChart

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.testapp.databinding.ActivityBarChartBinding
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.github.mikephil.charting.model.GradientColor


class BarChartActivity : AppCompatActivity() {

    lateinit var binding : ActivityBarChartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBarChartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setChart()

    }

    private fun setChart() {
        binding.chart.setDrawBarShadow(false)
        binding.chart.setDrawValueAboveBar(true)
        binding.chart.getDescription().setEnabled(false)
        binding.chart.setMaxVisibleValueCount(60)
        binding.chart.setPinchZoom(false)
        binding.chart.setDrawGridBackground(false)
        val l: Legend = binding.chart.getLegend()
        l.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.LEFT
        l.orientation = Legend.LegendOrientation.HORIZONTAL
        l.setDrawInside(false)
        l.form = Legend.LegendForm.SQUARE
        l.formSize = 9f
        l.textSize = 11f
        l.xEntrySpace = 4f
        setData(4,12f)
    }

    private fun setData(count: Int, range: Float) {
        val values = ArrayList<BarEntry>()

        values.add(BarEntry(1f,10f))
        values.add(BarEntry(2f,15f))
        values.add(BarEntry(3f,2f))
        values.add(BarEntry(4f,23f))
        values.add(BarEntry(5f,8f))
        values.add(BarEntry(6f,78f))
        values.add(BarEntry(7f,54f))

        val set1: BarDataSet
        if (binding.chart.getData() != null &&
            binding.chart.getData().getDataSetCount() > 0
        ) {
            set1 = binding.chart.getData().getDataSetByIndex(0) as BarDataSet
            set1.values = values
            binding.chart.getData().notifyDataChanged()
            binding.chart.notifyDataSetChanged()
        } else {
            set1 = BarDataSet(values, "The year 2017")
            set1.setDrawIcons(false)
            val startColor1 = ContextCompat.getColor(this, R.color.holo_orange_light)
            val startColor2 = ContextCompat.getColor(this, R.color.holo_blue_light)
            val startColor3 = ContextCompat.getColor(this, R.color.holo_orange_light)
            val startColor4 = ContextCompat.getColor(this, R.color.holo_green_light)
            val startColor5 = ContextCompat.getColor(this, R.color.holo_red_light)
            val endColor1 = ContextCompat.getColor(this, R.color.holo_blue_dark)
            val endColor2 = ContextCompat.getColor(this, R.color.holo_purple)
            val endColor3 = ContextCompat.getColor(this, R.color.holo_green_dark)
            val endColor4 = ContextCompat.getColor(this, R.color.holo_red_dark)
            val endColor5 = ContextCompat.getColor(this, R.color.holo_orange_dark)
            val gradientFills: MutableList<GradientColor> = ArrayList()
            gradientFills.add(GradientColor(startColor1, endColor1))
            gradientFills.add(GradientColor(startColor2, endColor2))
            gradientFills.add(GradientColor(startColor3, endColor3))
            gradientFills.add(GradientColor(startColor4, endColor4))
            gradientFills.add(GradientColor(startColor5, endColor5))
            set1.gradientColors = gradientFills
            val dataSets = ArrayList<IBarDataSet>()
            dataSets.add(set1)
            val data = BarData(dataSets)
            data.setValueTextSize(10f)
            data.barWidth = 0.9f
            binding.chart.setData(data)
        }
    }
}