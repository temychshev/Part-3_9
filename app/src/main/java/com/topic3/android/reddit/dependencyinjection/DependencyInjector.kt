package com.topic3.android.reddit.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.topic3.android.reddit.data.database.AppDatabase
import com.topic3.android.reddit.data.dbmapper.DbMapper
import com.topic3.android.reddit.data.dbmapper.DbMapperImpl
import com.topic3.android.reddit.data.repository.Repository
import com.topic3.android.reddit.data.repository.RepositoryImpl
import kotlinx.coroutines.DelicateCoroutinesApi
/**
 * Обеспечивает зависимости через приложение.
 */
class DependencyInjector(applicationContext: Context) {
    val repository: Repository by lazy { provideRepository(database) }

    private val database: AppDatabase by lazy { provideDatabase(applicationContext) }
    private val dbMapper: DbMapper = DbMapperImpl()

    private fun provideDatabase(applicationContext: Context): AppDatabase =
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()

    @OptIn(DelicateCoroutinesApi::class)
    private fun provideRepository(database: AppDatabase): Repository {
        val postDao = database.postDao()
        return RepositoryImpl(postDao, dbMapper)
    }
}