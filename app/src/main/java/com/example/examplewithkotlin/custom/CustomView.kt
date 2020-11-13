package com.example.examplewithkotlin.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class CustomView(context: Context): View(context) {
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val green = Paint()
        green.color = Color.GREEN
        green.style = Paint.Style.STROKE
        val strokeWidth = 10f
        green.strokeWidth = strokeWidth
        val recPosition = floatArrayOf(0f, 0f, 200f, 200f)
        for(i in 0 until recPosition.size) {
            recPosition[i] += strokeWidth
        }
        canvas?.drawRoundRect(
            recPosition[0], recPosition[1], recPosition[2], recPosition[3],
            1f, 1f, green)
    }
}