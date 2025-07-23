package com.example.roomdb.roomdb

import android.app.Application
import com.example.roomdb.roomdb.data.MainDB

class App: Application() {
    val dataBase by lazy { MainDB.createDataBase(this) }
}