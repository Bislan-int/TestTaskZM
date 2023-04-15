package com.example.testtaskzm.data

import com.example.testtaskzm.R
import com.example.testtaskzm.data.dto.CategoryDto
import com.example.testtaskzm.data.dto.DishDto
import com.example.testtaskzm.data.dto.DishHorizontalDto
import javax.inject.Inject

class FakeData @Inject constructor() {


    fun listCategory(): List<CategoryDto> {
        return listOf(
            CategoryDto("Хачапури"),
            CategoryDto("Горячие блюда"),
            CategoryDto("Закуски"),
            CategoryDto("Хачапури"),
            CategoryDto("Горячие блюда"),
            CategoryDto("Закуски"),
        )
    }

    fun listDishHorizontal(): List<DishHorizontalDto> {
        return listOf(
            DishHorizontalDto(
                title = "Горячие блюда",
                listOf(
                    DishDto(
                        image = R.drawable.item_image,
                        discount = "15",
                        oldPrise = "612",
                        newPrise = "612",
                        portionInGrams = "500",
                        description = "Рахат-Лукум Гранато-вый с дробленной фисташкой"
                    ),
                    DishDto(
                        image = R.drawable.item_image,
                        discount = "15",
                        oldPrise = "612",
                        newPrise = "612",
                        portionInGrams = "500",
                        description = "Рахат-Лукум Гранато-вый с дробленной фисташкой"
                    ),
                    DishDto(
                        image = R.drawable.item_image,
                        discount = "15",
                        oldPrise = "612",
                        newPrise = "612",
                        portionInGrams = "500",
                        description = "Рахат-Лукум Гранато-вый с дробленной фисташкой"
                    ), DishDto(
                        image = R.drawable.item_image,
                        discount = "15",
                        oldPrise = "612",
                        newPrise = "612",
                        portionInGrams = "500",
                        description = "Рахат-Лукум Гранато-вый с дробленной фисташкой"
                    )
                )
            ),
            DishHorizontalDto(
                title = "Супы",
                listOf(
                    DishDto(
                        image = R.drawable.item_image_2,
                        discount = "15",
                        oldPrise = "612",
                        newPrise = "612",
                        portionInGrams = "500",
                        description = "Рахат-Лукум Гранато-вый с дробленной фисташкой"
                    ),
                    DishDto(
                        image = R.drawable.item_image_2,
                        discount = "15",
                        oldPrise = "612",
                        newPrise = "612",
                        portionInGrams = "500",
                        description = "Рахат-Лукум Гранато-вый с дробленной фисташкой"
                    ),
                    DishDto(
                        image = R.drawable.item_image_2,
                        discount = "15",
                        oldPrise = "612",
                        newPrise = "612",
                        portionInGrams = "500",
                        description = "Рахат-Лукум Гранато-вый с дробленной фисташкой"
                    ), DishDto(
                        image = R.drawable.item_image_2,
                        discount = "15",
                        oldPrise = "612",
                        newPrise = "612",
                        portionInGrams = "500",
                        description = "Рахат-Лукум Гранато-вый с дробленной фисташкой"
                    )
                )
            ),
            DishHorizontalDto(
                title = "Закуски",
                listOf(
                    DishDto(
                        image = R.drawable.item_image_2,
                        discount = "15",
                        oldPrise = "612",
                        newPrise = "612",
                        portionInGrams = "500",
                        description = "Рахат-Лукум Гранато-вый с дробленной фисташкой"
                    ),
                    DishDto(
                        image = R.drawable.item_image,
                        discount = "15",
                        oldPrise = "612",
                        newPrise = "612",
                        portionInGrams = "500",
                        description = "Рахат-Лукум Гранато-вый с дробленной фисташкой"
                    ),
                    DishDto(
                        image = R.drawable.item_image,
                        discount = "15",
                        oldPrise = "612",
                        newPrise = "612",
                        portionInGrams = "500",
                        description = "Рахат-Лукум Гранато-вый с дробленной фисташкой"
                    ), DishDto(
                        image = R.drawable.item_image_2,
                        discount = "15",
                        oldPrise = "612",
                        newPrise = "612",
                        portionInGrams = "500",
                        description = "Рахат-Лукум Гранато-вый с дробленной фисташкой"
                    )
                )
            )
        )
    }
}