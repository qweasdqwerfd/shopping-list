package com.example.qweasdqwerfd.local_data.data

import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun insertItem(item: AddItem)

    suspend fun deleteItem(item: NoteItem)

    fun getAllItems(): Flow<List<NoteItem>>

    suspend fun getNoteItemById(id: Int): NoteItem
}