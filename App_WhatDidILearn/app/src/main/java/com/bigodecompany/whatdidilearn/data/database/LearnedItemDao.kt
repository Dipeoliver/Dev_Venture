package com.bigodecompany.whatdidilearn.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bigodecompany.whatdidilearn.entities.LearnedItem

@Dao
interface LearnedItemDao {
    @Query("SELECT * FROM learned_item")
    fun getAll(): LiveData<List<LearnedItem>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(learnedItem: LearnedItem)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(learnedItems: List<LearnedItem>)
}