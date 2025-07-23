package com.example.roomdb.roomdb.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdb.roomdb.App

@Database(
    entities = [
        NameEntity::class
    ],

    version = 1
)
abstract class MainDB: RoomDatabase() {
    abstract val dao: Daooo

    companion object {
        fun createDataBase(context: App): MainDB {
            return Room.databaseBuilder(
                context = context,
                klass = MainDB::class.java,
                name = "test.db"
            ).build()
        }
    }
}