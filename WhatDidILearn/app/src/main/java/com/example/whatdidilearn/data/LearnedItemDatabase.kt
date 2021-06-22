package com.example.whatdidilearn.data

import android.content.Context
import androidx.room.*

@Database(entities = [LearnedItem::class],version = 1,exportSchema = false)
@TypeConverters(Converters::class)

abstract class LearnedItemDatabase: RoomDatabase() {
    abstract fun learnedItemDao(): LearnedItemDAO

    // recurso para nao criar (N) varias instancias (chamadas)
    companion object {
        @Volatile
        var INSTANCE : LearnedItemDatabase? = null

        // funcao que irei expor para fora
        fun getDatabase(context: Context): LearnedItemDatabase {
            return INSTANCE ?: synchronized(this) {
                val database = Room
                                .databaseBuilder(
                                    context.applicationContext,
                                    LearnedItemDatabase::class.java,
                              "Learned_iteM_databse"
                                ).build()
                INSTANCE = database
                database
            }
        }
        fun getAll(): List<LearnedItem> {
            return listOf(
                LearnedItem(name = "Kotlin", description = "Linguagem kotlin para Android", understandingLevel = UnderstandingLevel.HIGH),
                LearnedItem(name = "RecyclerView", description = "Listas em Android", understandingLevel = UnderstandingLevel.MEDIUM),
                LearnedItem(name = "DataClass", description = "Kotlin data Class", understandingLevel = UnderstandingLevel.LOW),
                LearnedItem(name = "Life Cycle", description = "Ciclo de vida de uma aplicação Android", understandingLevel = UnderstandingLevel.HIGH),
                LearnedItem(name = "Intent", description = "Como usar intents", understandingLevel = UnderstandingLevel.MEDIUM),
                LearnedItem(name = "Services", description = "Service em  Android", understandingLevel = UnderstandingLevel.MEDIUM),
                LearnedItem(name = "Content Provider", description = "Dados com Contenct Provider", understandingLevel = UnderstandingLevel.LOW)
            )

        }
    }
}


