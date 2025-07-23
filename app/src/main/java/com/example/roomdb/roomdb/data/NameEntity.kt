package com.example.roomdb.roomdb.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "name_table")
data class NameEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "skibidi_name")
    val id: Int = 0,
    val name: String
)