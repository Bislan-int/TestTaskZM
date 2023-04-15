package com.example.testtaskzm.data

import com.example.testtaskzm.data.dto.CategoryDto
import com.example.testtaskzm.data.dto.DishHorizontalDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface Api {
    @GET("get/url")
    suspend fun getCategory(): List<CategoryDto>?

    @GET("get/url")
    suspend fun getDishHorizontal(): List<DishHorizontalDto>?

    companion object {

        private const val BASE_URL = "https://url/"

        fun create(): Api {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(Api::class.java)
        }
    }
}