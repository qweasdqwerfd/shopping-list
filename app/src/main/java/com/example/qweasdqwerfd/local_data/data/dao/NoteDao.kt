package com.example.qweasdqwerfd.local_data.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.qweasdqwerfd.local_data.data.model.AddItem
import com.example.qweasdqwerfd.local_data.data.model.NoteItem
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: AddItem)

    @Delete
    suspend fun deleteItem(item: NoteItem)

    @Query("SELECT * FROM note_table")
    fun getAllItems(): Flow<List<NoteItem>>

    @Query("SELECT * FROM note_table WHERE id = :id")
    suspend fun getNoteItemById(id: Int): NoteItem

}
