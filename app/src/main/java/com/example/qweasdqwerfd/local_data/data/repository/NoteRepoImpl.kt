package com.example.qweasdqwerfd.local_data.data.repository

import com.example.qweasdqwerfd.local_data.data.dao.NoteDao
import com.example.qweasdqwerfd.local_data.data.model.AddItem
import com.example.qweasdqwerfd.local_data.data.model.NoteItem
import kotlinx.coroutines.flow.Flow

class NoteRepoImpl(
    private val dao: NoteDao
): NoteRepository {
    override suspend fun insertItem(item: AddItem) {
        dao.insertItem(item)
    }

    override suspend fun deleteItem(item: NoteItem) {
        dao.deleteItem(item)
    }

    override fun getAllItems(): Flow<List<NoteItem>> {
        return dao.getAllItems()
    }

    override suspend fun getNoteItemById(id: Int): NoteItem {
        return dao.getNoteItemById(id)
    }
}