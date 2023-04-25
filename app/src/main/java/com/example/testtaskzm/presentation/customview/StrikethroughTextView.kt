package com.example.testtaskzm.presentation.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import com.example.testtaskzm.R

class StrikethroughTextView(
    context: Context,
    attributes: AttributeSet
) : androidx.appcompat.widget.AppCompatTextView(context, attributes) {

    private var strokeWidthAttr = 0f
    private var strokeColor = 0

    init {
        val attributes = context.theme.obtainStyledAttributes(
            attributes,
            R.styleable.CustomTextView,
            0,
            0
        )

        try {
            strokeWidthAttr = attributes.getFloat(
                R.styleable.CustomTextView_stroke_width,
                0F
            )
            strokeColor = attributes.getColor(
                R.styleable.CustomTextView_strokeColor,
                Color.BLACK
            )
        } finally {
            attributes.recycle()
        }
    }

    private val strokePaint = Paint().apply {
        color = strokeColor
        style = Paint.Style.STROKE
        strokeWidth = strokeWidthAttr
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawLine(
            0f,
            (height / 2 + 5).toFloat(),
            width.toFloat(),
            (height / 2 + 5).toFloat(),
            strokePaint
        )
    }
}