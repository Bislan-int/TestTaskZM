package com.example.testtaskzm.util

import androidx.databinding.BindingAdapter
import com.google.android.material.imageview.ShapeableImageView

@BindingAdapter("loadImage")
fun loadImage(view: ShapeableImageView, drawable: Int) {
    view.setImageResource(drawable)
}