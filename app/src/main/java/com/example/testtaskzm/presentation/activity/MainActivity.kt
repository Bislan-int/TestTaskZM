package com.example.testtaskzm.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskzm.databinding.ActivityMainBinding
import com.example.testtaskzm.presentation.TestTaskZMApplication
import com.example.testtaskzm.presentation.adapter.MainAdapter
import com.example.testtaskzm.presentation.itemdecoration.MainItemOffsetsDecoration
import com.example.testtaskzm.presentation.viewmodel.MainViewModel
import com.example.testtaskzm.presentation.viewmodel.ViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (application as TestTaskZMApplication).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        setContentView(binding.root)

        recyclerView = binding.mainRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        viewModel.listCategory.observe(this) { listCategory ->
            viewModel.listDishHorizontal.observe(this) { listHorizontalDish ->
                adapter = MainAdapter(listCategory)
                adapter.submitList(listHorizontalDish)
                recyclerView.addItemDecoration(MainItemOffsetsDecoration(this))
                recyclerView.adapter = adapter
            }
        }
    }
}