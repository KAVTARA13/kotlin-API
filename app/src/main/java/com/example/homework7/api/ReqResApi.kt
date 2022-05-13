package com.example.homework7.api

import com.example.homework7.api.dto.AddUser
import com.example.homework7.api.dto.ReqResData
import com.example.homework7.api.dto.Resource
import com.example.homework7.api.dto.User
import retrofit2.http.*

interface ReqResApi {

    @GET("unknown")
    fun getResource(@Query("page") page:Int): retrofit2.Call<ReqResData<List<Resource>>>
    @GET("unknown/{resourceId}")
    fun getResourceById(@Path("resourceId") resourceId:Int): retrofit2.Call<ReqResData<Resource>>
    @GET("users/{userId}")
    fun getUserById(@Path("userId") userId:Int): retrofit2.Call<ReqResData<User>>
    @Headers("Content-Type: application/json")
    @POST("users")
    fun addUser(@Body userData: AddUser): retrofit2.Call<AddUser>
}