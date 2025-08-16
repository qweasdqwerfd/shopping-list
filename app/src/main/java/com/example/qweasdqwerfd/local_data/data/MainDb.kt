package com.example.qweasdqwerfd.local_data.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.qweasdqwerfd.local_data.data.dao.AddItemDao
import com.example.qweasdqwerfd.local_data.data.dao.NoteDao
import com.example.qweasdqwerfd.local_data.data.dao.ShoppingListDao
import com.example.qweasdqwerfd.local_data.data.model.AddItem
import com.example.qweasdqwerfd.local_data.data.model.NoteItem
import com.example.qweasdqwerfd.local_data.data.model.ShoppingListItem

@Database(
    entities = [ShoppingListItem::class, AddItem::class, NoteItem::class],
    version = 1
)
abstract class MainDb: RoomDatabase() {
    abstract val shoppingListDao: ShoppingListDao
    abstract val noteDao: NoteDao
    abstract val addItemDao: AddItemDao
}