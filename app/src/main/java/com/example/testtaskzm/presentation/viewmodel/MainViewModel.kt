package com.example.testtaskzm.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskzm.domain.entity.CategoryItem
import com.example.testtaskzm.domain.entity.DishHorizontalItem
import com.example.testtaskzm.domain.usecase.GetListCategoryUseCase
import com.example.testtaskzm.domain.usecase.GetListDishUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getListCategoryUseCase: GetListCategoryUseCase,
    private val getListDishUseCase: GetListDishUseCase
) : ViewModel() {

    private val _listCategory = MutableLiveData<List<CategoryItem>>()
    val listCategory: LiveData<List<CategoryItem>>
        get() = _listCategory

    private val _listDishHorizontal = MutableLiveData<List<DishHorizontalItem>>()
    val listDishHorizontal: LiveData<List<DishHorizontalItem>>
        get() = _listDishHorizontal

    init {
        viewModelScope.launch {
            _listCategory.value = getListCategory()
            _listDishHorizontal.value = getListDishHorizontal()
        }
    }

    private suspend fun getListCategory() = getListCategoryUseCase.invoke()
    private suspend fun getListDishHorizontal() = getListDishUseCase.invoke()

}