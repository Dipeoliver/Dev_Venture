package com.bigodecompany.whatdidilearn.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bigodecompany.whatdidilearn.WhatDidILearnApplication
import com.bigodecompany.whatdidilearn.databinding.ActivityMainBinding
import com.bigodecompany.whatdidilearn.viewmodel.MainViewModel
import com.bigodecompany.whatdidilearn.viewmodel.MainViewModelFactory
import org.koin.androidx.viewmodel.ext.android.viewModel



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // inicializando viewModel
    private val viewModel:MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val recycler = binding.learnedItemsRecyclerView
        val adapter = LearnedItemAdapter()
        recycler.adapter = adapter
       /* val repository = (application as WhatDidILearnApplication).repository
        val viewModelFactory = MainViewModelFactory(repository)
        val viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        */
        val items = viewModel.learnedItems
        items.observe(this, Observer {
            adapter.learnedItems = it
        })

        binding.newItemButton.setOnClickListener {
            val intent = Intent(this, NewLearnedItemActivity::class.java)
            startActivity(intent)
        }
    }
}