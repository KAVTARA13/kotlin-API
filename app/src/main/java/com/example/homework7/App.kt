package com.example.homework7

import android.app.Application
import com.example.homework7.api.RestClient

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        RestClient.initClients()
    }
}