package com.example.qweasdqwerfd.local_data.di

import android.app.Application
import androidx.room.Room
import com.example.qweasdqwerfd.local_data.data.AddItemRepoImpl
import com.example.qweasdqwerfd.local_data.data.AddItemRepository
import com.example.qweasdqwerfd.local_data.data.MainDb
import com.example.qweasdqwerfd.local_data.data.NoteRepoImpl
import com.example.qweasdqwerfd.local_data.data.NoteRepository
import com.example.qweasdqwerfd.local_data.data.ShoppingListRepoImpl
import com.example.qweasdqwerfd.local_data.data.ShoppingListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMainDb(app: Application): MainDb {
        return Room.databaseBuilder(
            app,
            MainDb::class.java,
            "shopping_list_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideShopRepo(db: MainDb): ShoppingListRepository {
        return ShoppingListRepoImpl(db.shoppingListDao)
    }

    @Provides
    @Singleton
    fun provideAddItemRepo(db: MainDb): AddItemRepository {
        return AddItemRepoImpl(db.addItemDao)
    }

    @Provides
    @Singleton
    fun provideNoteRepo(db: MainDb): NoteRepository {
        return NoteRepoImpl(db.noteDao)
    }
}