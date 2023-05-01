package com.example.testtaskzm.presentation.itemdecoration

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskzm.R

class DishItemOffsetsDecoration(
    private val context: Context
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val lastItem = parent.adapter?.let { it.itemCount - 1 }

        outRect.top = context.resources.getDimension(
            R.dimen.space_top_main_items
        ).toInt()

        when (parent.getChildAdapterPosition(view)) {
            RecyclerView.NO_POSITION,
            FIRST_ITEM -> {
                outRect.left = context.resources.getDimension(
                    R.dimen.space_first_and_end_items_dish
                ).toInt()
                outRect.right = context.resources.getDimension(
                    R.dimen.space_between_items_dish
                ).toInt()
            }
            lastItem -> {
                outRect.right = context.resources.getDimension(
                    R.dimen.space_first_and_end_items_dish
                ).toInt()
            }
            else -> {
                outRect.right = context.resources.getDimension(
                    R.dimen.space_between_items_dish
                ).toInt()
            }
        }
    }

    private companion object {
        const val FIRST_ITEM = 0
    }
}