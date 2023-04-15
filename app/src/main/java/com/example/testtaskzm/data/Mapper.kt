package com.example.testtaskzm.data

import com.example.testtaskzm.data.dto.CategoryDto
import com.example.testtaskzm.data.dto.DishDto
import com.example.testtaskzm.data.dto.DishHorizontalDto
import com.example.testtaskzm.domain.entity.CategoryItem
import com.example.testtaskzm.domain.entity.DishHorizontalItem
import com.example.testtaskzm.domain.entity.DishItem
import javax.inject.Inject

class Mapper @Inject constructor() {

    fun mapCategoryDtoToCategoryItem(categoryDto: CategoryDto) = CategoryItem(
        category = categoryDto.category
    )

    private fun mapDishDtoToDishItem(dishDto: DishDto) = DishItem(
        image = dishDto.image,
        discount = dishDto.discount,
        oldPrise = dishDto.oldPrise,
        newPrise = dishDto.newPrise,
        portionInGrams = dishDto.portionInGrams,
        description = dishDto.description
    )

    fun mapDishHorizontalDtoToDishHorizontalItem(
        dishHorizontalDto: DishHorizontalDto
    ) = DishHorizontalItem(
        title = dishHorizontalDto.title,
        dishes = dishHorizontalDto.dishes.map { mapDishDtoToDishItem(it) }
    )
}