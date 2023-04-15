package com.example.testtaskzm.presentation.itemdecoration

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.core.view.size
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

        outRect.top = context.resources.getDimension(
            R.dimen.space_top_main_items
        ).toInt()

        outRect.left = context.resources.getDimension(
            R.dimen.space_between_items_dish
        ).toInt()

        if (parent.getChildAdapterPosition(view) == FIRST_ITEM) {
            outRect.left = context.resources.getDimension(
                R.dimen.space_first_and_end_items_dish
            ).toInt()
        }

        // Не работает parent.size
        if (parent.getChildAdapterPosition(view) == parent.size) {
            outRect.right = context.resources.getDimension(
                R.dimen.space_first_and_end_items_dish
            ).toInt()
        }
    }

    private companion object {
        const val FIRST_ITEM = 0
    }
}