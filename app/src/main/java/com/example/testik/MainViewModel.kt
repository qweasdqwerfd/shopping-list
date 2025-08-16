package com.example.testik

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val wiFiManager: WiFiManager
): ViewModel() {

    init {
        Log.d("qwe", "MainViewModel instance id: $wiFiManager")
    }

    fun connect() {


        wiFiManager.connection()


    }



}