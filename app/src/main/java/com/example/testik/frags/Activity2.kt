package com.example.testik.frags

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.testik.WiFiManager
import com.example.testik.ui.theme.TestikTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Activity2 : ComponentActivity() {

    @Inject
    lateinit var wiFiManager: WiFiManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestikTheme {

            }

            Log.d("qwe", "Activity2 instance id: $wiFiManager")



        }
    }
}
