package com.example.gameverse.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis

@Composable
fun BarChartScreen(barEntries: List<BarEntry>) {
    val sortedEntries = barEntries.sortedBy { it.x }
    val barDataSet = BarDataSet(sortedEntries, "Rating")


    val barData = BarData(barDataSet)
    barData.barWidth = 1.0f
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            BarChart(context).apply {
                data = barData
                description.isEnabled = false
                setFitBars(true)
                xAxis.position = XAxis.XAxisPosition.BOTTOM
                xAxis.valueFormatter =
                    IndexAxisValueFormatter(listOf("1", "2", "3", "4", "5"))
                animateY(4000)
            }
        },
        update = { barChart ->
            barChart.data = BarData(barDataSet)
            barChart.notifyDataSetChanged()
            barChart.invalidate()
        }
    )

}