package com.bigodecompany.whatdidilearn.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.bigodecompany.whatdidilearn.WhatDidILearnApplication
import com.bigodecompany.whatdidilearn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = (application as WhatDidILearnApplication).repository
        val items = repository.learnedItems

        val recycler = binding.learnedItemsRecyclerView
        val adapter = LearnedItemAdapter()
        recycler.adapter = adapter

        items.observe(this, Observer {
            adapter.learnedItems = it
        })

        binding.newItemButton.setOnClickListener {
            val intent = Intent(this, NewLearnedItemActivity::class.java)
            startActivity(intent)
        }
    }
}