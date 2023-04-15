package com.example.testtaskzm.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskzm.domain.entity.CategoryItem
import com.example.testtaskzm.databinding.ItemCategoryBinding
import com.example.testtaskzm.databinding.ItemSettingBinding
import com.example.testtaskzm.presentation.diffutil.DiffCallback

class CategoryAdapter : ListAdapter<CategoryItem, RecyclerView.ViewHolder>(
    DiffCallback<CategoryItem>()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            SETTING -> MyViewHolderFilter(
                ItemSettingBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            CATEGORY -> MyViewHolderCategory(
                ItemCategoryBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Invalid View Type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position != SETTING) {
            (holder as MyViewHolderCategory)
                .bind(currentList[position - SETTING_ITEM])
        }
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + SETTING_ITEM
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) SETTING else CATEGORY
    }

    class MyViewHolderFilter(
        binding: ItemSettingBinding
    ) : RecyclerView.ViewHolder(binding.root)

    class MyViewHolderCategory(
        private val binding: ItemCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CategoryItem) {
            binding.categoryItem = item
        }
    }

    private companion object {
        const val SETTING = 0
        const val CATEGORY = 1
        const val SETTING_ITEM = 1
    }
}