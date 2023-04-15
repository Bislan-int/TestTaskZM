package com.example.testtaskzm.presentation

import android.app.Application
import com.example.testtaskzm.di.DaggerApplicationComponent

class TestTaskZMApplication : Application() {
    val component by lazy {
        DaggerApplicationComponent.create()
    }
}