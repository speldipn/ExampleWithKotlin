package com.example.examplewithkotlin.views

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat
import com.example.examplewithkotlin.R

class CustomB(context: Context?) : LinearLayoutCompat(context) {
    init {
        val view = LayoutInflater.from(context).inflate(R.layout.viewpager_b, this, false)
        addView(view)
    }
}