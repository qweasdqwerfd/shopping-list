package com.example.qweasdqwerfd.local_data.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "add_item")
data class AddItem(
    @PrimaryKey
    val id: Int? = null,
    val name: String,
    val isChecked: Boolean,
    val listId: Int,
)
