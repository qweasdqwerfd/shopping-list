package com.example.qweasdqwerfd.local_data.data.repository

import com.example.qweasdqwerfd.local_data.data.model.AddItem
import com.example.qweasdqwerfd.local_data.data.model.NoteItem
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun insertItem(item: AddItem)

    suspend fun deleteItem(item: NoteItem)

    fun getAllItems(): Flow<List<NoteItem>>

    suspend fun getNoteItemById(id: Int): NoteItem
}