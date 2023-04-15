package com.example.testtaskzm.data

import com.example.testtaskzm.domain.entity.CategoryItem
import com.example.testtaskzm.domain.entity.DishHorizontalItem
import com.example.testtaskzm.domain.repositpry.NetworkRepository
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val fakeData: FakeData,
    private val mapper: Mapper
) : NetworkRepository {

    override suspend fun getListCategory(): List<CategoryItem> {
        return fakeData.listCategory().map {
            mapper.mapCategoryDtoToCategoryItem(it)
        }
    }

    override suspend fun getListDish(): List<DishHorizontalItem> {
        return fakeData.listDishHorizontal().map {
            mapper.mapDishHorizontalDtoToDishHorizontalItem(it)
        }
    }
}