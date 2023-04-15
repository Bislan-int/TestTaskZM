package com.example.testtaskzm.di

import com.example.testtaskzm.data.NetworkRepositoryImpl
import com.example.testtaskzm.domain.repositpry.NetworkRepository
import dagger.Binds
import dagger.Module

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindNetworkRepository(impl: NetworkRepositoryImpl): NetworkRepository

//    companion object {
//        @ApplicationScope
//        @Provides
//        fun provideApi(): Api {
//            return Api.create()
//        }
//    }
}