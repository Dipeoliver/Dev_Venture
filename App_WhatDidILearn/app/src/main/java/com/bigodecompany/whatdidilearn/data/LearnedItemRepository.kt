package com.bigodecompany.whatdidilearn.data

import androidx.lifecycle.LiveData
import com.bigodecompany.whatdidilearn.data.database.LearnedItemDao
import com.bigodecompany.whatdidilearn.entities.LearnedItem

class LearnedItemRepository(private val dao: LearnedItemDao) {
    val learnedItems: LiveData<List<LearnedItem>> = dao.getAll()

    fun addNewItem(item: LearnedItem) {
        dao.insert(item)
    }
}