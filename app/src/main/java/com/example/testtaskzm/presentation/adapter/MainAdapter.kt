package com.example.testtaskzm.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskzm.databinding.BannerBinding
import com.example.testtaskzm.databinding.BottomInformationBinding
import com.example.testtaskzm.databinding.ItemCategoryHorizontalBinding
import com.example.testtaskzm.databinding.ItemHorizontalBinding
import com.example.testtaskzm.domain.entity.CategoryItem
import com.example.testtaskzm.domain.entity.DishHorizontalItem
import com.example.testtaskzm.presentation.diffutil.DiffCallback
import com.example.testtaskzm.presentation.itemdecoration.CategoryItemOffsetsDecoration
import com.example.testtaskzm.presentation.itemdecoration.DishItemOffsetsDecoration

class MainAdapter(
    private val listCategory: List<CategoryItem>
) : ListAdapter<DishHorizontalItem, RecyclerView.ViewHolder>(
    DiffCallback<DishHorizontalItem>()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            BANNER -> BannerViewHolder(
                BannerBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            CATEGORY -> CategoryViewHolder(
                ItemCategoryHorizontalBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            currentList.size + 2 -> InformationViewHolder(
                BottomInformationBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> DishesViewHolder(
                ItemHorizontalBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (position == CATEGORY) {
            val categoryAdapter = CategoryAdapter()
            categoryAdapter.submitList(listCategory)
            (holder as CategoryViewHolder).categoryRV.adapter = categoryAdapter

        } else if (position != BANNER && position != CATEGORY && position != currentList.size + 2) {
            val dishHolder = (holder as DishesViewHolder)
            dishHolder.bind(currentList[position - 2])
            val dishHorizontalAdapter = DishAdapter()
            dishHorizontalAdapter.submitList(currentList[position - 2].dishes)
            holder.dish.adapter = dishHorizontalAdapter
        }
    }

    override fun getItemCount() = currentList.size + ADDITIONAL_ITEMS

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> BANNER
            1 -> CATEGORY
            currentList.size + 2 -> currentList.size + 2
            else -> position
        }
    }

    class BannerViewHolder(binding: BannerBinding) : RecyclerView.ViewHolder(binding.root)

    class CategoryViewHolder(
        binding: ItemCategoryHorizontalBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        val categoryRV = binding.rvCategory

        init {
            categoryRV.layoutManager = LinearLayoutManager(
                categoryRV.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            categoryRV.addItemDecoration(CategoryItemOffsetsDecoration(categoryRV.context))
        }
    }

    class DishesViewHolder(
        private val binding: ItemHorizontalBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        val dish = binding.rvDish

        init {
            dish.layoutManager = LinearLayoutManager(
                dish.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            dish.addItemDecoration(DishItemOffsetsDecoration(dish.context))
        }

        fun bind(item: DishHorizontalItem) {
            binding.dishHorizontal = item
        }
    }

    class InformationViewHolder(
        binding: BottomInformationBinding
    ) : RecyclerView.ViewHolder(binding.root)

    private companion object {
        const val BANNER = 0
        const val CATEGORY = 1
        const val ADDITIONAL_ITEMS = 3
    }
}