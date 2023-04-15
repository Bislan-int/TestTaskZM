package com.example.testtaskzm.domain.entity

data class DishItem(
    val image: Int,
    val discount: String,
    val oldPrise: String,
    val newPrise: String,
    val portionInGrams: String,
    val description: String
)
