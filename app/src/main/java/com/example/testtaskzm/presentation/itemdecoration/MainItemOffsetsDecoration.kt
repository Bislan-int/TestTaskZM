package com.example.testtaskzm.presentation.itemdecoration

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.core.view.size
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskzm.R


class MainItemOffsetsDecoration(
    private val context: Context
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.top = context.resources.getDimension(R.dimen.space_top_main_items).toInt()
        if (parent.getChildAdapterPosition(view) == parent.size + 2) {
            outRect.top = context.resources.getDimension(R.dimen.space_top_last_main_item).toInt()
        }
    }
}