package com.example.whatdidilearn.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface LearnedItemDAO {
    @Query("SELECT * FROM learned_item ORDER BY item_name ASC")
    fun getAll(): List<LearnedItem>

    @Insert
    fun insert(learnedItem: LearnedItem)
}