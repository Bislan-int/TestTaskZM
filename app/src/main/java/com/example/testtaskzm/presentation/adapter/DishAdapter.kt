package com.example.testtaskzm.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskzm.domain.entity.DishItem
import com.example.testtaskzm.databinding.ItemDishBinding
import com.example.testtaskzm.presentation.diffutil.DiffCallback

class DishAdapter : ListAdapter<DishItem, DishAdapter.DishViewHolder>(
    DiffCallback<DishItem>()
) {

    class DishViewHolder(
        private val binding: ItemDishBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DishItem) {
            binding.dishItem = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishViewHolder {
        val binding = ItemDishBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DishViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DishViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}