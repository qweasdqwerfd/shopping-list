package com.example.testik.frags

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.testik.MainViewModel
import com.example.testik.WiFiManager
import com.example.testik.ui.theme.TestikTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var wiFiManager: WiFiManager
    val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestikTheme {

            }


//            WiFiManager(WiFiSettings()).connection()
//            WiFiManager(WiFiSettings()).sendMessage()

//            wiFiManager.connection()
//            wiFiManager.sendMessage()



            Log.d("qwe", "MainActivity instance id: $wiFiManager")
//            startActivity(Intent(this, Activity1::class.java)) //проверка на разные id инстанций (инстанции)

            mainViewModel.connect()




        }
    }
}

