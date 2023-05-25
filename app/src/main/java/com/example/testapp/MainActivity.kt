package com.example.testapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testapp.BarChart.BarChartActivity
import com.example.testapp.PieChart.PieChartActivity
import com.example.testapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

    }

    private fun initView() {

        binding.apply {

            barChart.setOnClickListener {
                startActivity(Intent(this@MainActivity,BarChartActivity::class.java))
            }

            pieChart.setOnClickListener {
                startActivity(Intent(this@MainActivity,PieChartActivity::class.java))
            }

        }

    }
}