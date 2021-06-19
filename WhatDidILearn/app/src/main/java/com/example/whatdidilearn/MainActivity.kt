package com.example.whatdidilearn


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.whatdidilearn.data.LearnedItemDatabase
import com.example.whatdidilearn.databinding.ActivityMainBinding
import com.example.whatdidilearn.view.LearnedItemAdapter


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycler = binding.recyclerView
        val adapter = LearnedItemAdapter()

        adapter.learnedItems = LearnedItemDatabase.getAll()
        recycler.adapter = adapter
        //setContentView(R.layout.activity_main)

    }
}