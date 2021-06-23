package com.bigodecompany.whatdidilearn.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.bigodecompany.whatdidilearn.entities.LearnedItem
import com.bigodecompany.whatdidilearn.entities.UnderstandingLevel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [LearnedItem::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class LearnedItemDatabase : RoomDatabase() {

    abstract fun learnedItemDao(): LearnedItemDao

    companion object {
        var INSTANCE: LearnedItemDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): LearnedItemDatabase {
            return INSTANCE ?: synchronized(this) {
                val database = Room.databaseBuilder(
                    context.applicationContext,
                    LearnedItemDatabase::class.java,
                    "learned_item_database"
                )
                    .addCallback(LearnedItemDatabaseCallback(scope))
                    .build()

                INSTANCE = database
                database
            }
        }


    }

    private class LearnedItemDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let {
                scope.launch {
                    populateDatabase(it.learnedItemDao())
                }
            }
        }

        private fun populateDatabase(learnedItemDao: LearnedItemDao) {
            val items = getAll()
            learnedItemDao.insert(items)
        }

        fun getAll(): List<LearnedItem> {
            return listOf(
                LearnedItem(0, "RecyclerView", "Mostra uma listaA", UnderstandingLevel.LOW),
                LearnedItem(0, "RecyclerView", "Mostra uma listaB", UnderstandingLevel.MEDIUM),
                LearnedItem(0, "RecyclerView", "Mostra uma listaC", UnderstandingLevel.HIGH)
            )
        }
    }
}