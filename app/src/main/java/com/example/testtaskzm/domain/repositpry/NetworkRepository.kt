package com.example.testtaskzm.domain.repositpry

import com.example.testtaskzm.domain.entity.CategoryItem
import com.example.testtaskzm.domain.entity.DishHorizontalItem

interface NetworkRepository {
    suspend fun getListCategory(): List<CategoryItem>
    suspend fun getListDish(): List<DishHorizontalItem>
}