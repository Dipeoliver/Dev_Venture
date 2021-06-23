package com.bigodecompany.whatdidilearn

import android.app.Application
import com.bigodecompany.whatdidilearn.data.LearnedItemRepository
import com.bigodecompany.whatdidilearn.data.database.LearnedItemDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class WhatDidILearnApplication : Application() {
    val database by lazy { LearnedItemDatabase.getDatabase(this, CoroutineScope(Dispatchers.IO)) }
    val repository by lazy { LearnedItemRepository(database.learnedItemDao()) }
}