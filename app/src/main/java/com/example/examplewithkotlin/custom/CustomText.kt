package com.example.examplewithkotlin.custom

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.examplewithkotlin.R

class CustomText : AppCompatTextView {
    constructor(context: Context)
            : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet)
            : super(context, attrs) {
        val typed = context.obtainStyledAttributes(attrs, R.styleable.CustomText)
        val size = typed.indexCount

        for (i in 0 until size) {
            when (typed.getIndex(i)) {
                R.styleable.CustomText_delimeter -> {
                    val value = typed.getString(typed.getIndex(i))
                    val delimeter = if (value?.length == 0) "-" else value
                    process(delimeter)
                }
            }
        }
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int)
            : super(context, attrs, defStyleAttr) {
    }

    private fun process(delimeter: String?) {
        var one = text.substring(0, 3)
        var two = text.substring(3, 7)
        var three = text.substring(7)

        setText("$one $delimeter $two $delimeter $three")
    }
}