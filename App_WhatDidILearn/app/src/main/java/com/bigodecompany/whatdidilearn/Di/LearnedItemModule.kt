package com.bigodecompany.whatdidilearn.Di

import com.bigodecompany.whatdidilearn.data.LearnedItemRepository
import com.bigodecompany.whatdidilearn.data.database.LearnedItemDatabase
import com.bigodecompany.whatdidilearn.viewmodel.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object LearnedItemModule {
    val module = module{
    // receitas de contrução de CoroutineScope
        factory{
            CoroutineScope(Dispatchers.IO)
        }
        // explicar como oferece estancia do banco
        single {
            LearnedItemDatabase.getDatabase(context = get(),scope = get())
        }
        // DAO
        single {
            get<LearnedItemDatabase>().learnedItemDao()
        }
        factory{
            // criar repositore
            LearnedItemRepository(get())
        }
        // explicar que queremos um viewmodel injetando um koin
        viewModel{
            MainViewModel(get())
        }
    }
}