package com.example.testtaskzm.domain.usecase

import com.example.testtaskzm.domain.repositpry.NetworkRepository
import javax.inject.Inject

class GetListDishUseCase @Inject constructor(
    private val repository: NetworkRepository
) {
    suspend fun invoke() = repository.getListDish()
}