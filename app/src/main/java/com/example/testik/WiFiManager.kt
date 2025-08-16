package com.example.testik

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

//@Singleton // удалить если есть модуль и не свой класс
//class WiFiManager @Inject constructor(private val settings: WiFiSettings) { // удалить конструктор если есть модуль и не свой класс

class WiFiManager(private val settings: WiFiSettings) {

    fun connection() {

        settings.openConnection()

    }

    fun sendMessage() {

        settings.writeBytes()
    }


}

//class WiFiSettings @Inject constructor() { // удалить конструктор если есть модуль и не свой класс
class WiFiSettings {

    fun openConnection() {
        Log.d("qwe","connected!")
    }

    fun writeBytes() {
        Log.d("qwe","Hello!")
    }
}