package com.example.testik

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityRetainedComponent::class)
object MainModule {

    @Provides //инструкция
    @ActivityRetainedScoped
//    @Singleton //как и было по дефолту, единственная инстанция
    fun provideWiFiManager(settings: WiFiSettings): WiFiManager {

        return WiFiManager(settings)

    }

    @Provides //инструкция по предоставлению setting для параметра в инстанции
    fun provideWiFiSetting(): WiFiSettings {
        return WiFiSettings()
    }
}