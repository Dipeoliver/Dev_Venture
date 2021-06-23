package com.bigodecompany.whatdidilearn.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bigodecompany.whatdidilearn.data.LearnedItemRepository
import com.bigodecompany.whatdidilearn.entities.LearnedItem

class MainViewModel(private val repository: LearnedItemRepository) : ViewModel() {
    val leardItems: LiveData<List<LearnedItem>> = repository.learnedItems
}