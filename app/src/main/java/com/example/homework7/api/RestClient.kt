package com.example.homework7.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {
    private lateinit var rwtrofit:Retrofit
    private lateinit var okHttpClient:OkHttpClient

    fun initClients(){
        okHttpClient = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        rwtrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun <S> getService(serviceClass:Class<S>): S {
        return rwtrofit.create(serviceClass)
    }

    val getReqResApi:ReqResApi
        get() = getService(ReqResApi::class.java)
}