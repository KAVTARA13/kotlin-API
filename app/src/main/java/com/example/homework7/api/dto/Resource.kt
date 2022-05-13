package com.example.homework7.api.dto

import com.google.gson.annotations.SerializedName


data class Resource(
    val id:Long?,
    val name:String?,
    val year:Long?,
    val color:String?,
    @SerializedName("pantone_value")
    val pantoneValue:String?,
)
data class User(
    val id:Long?,
    val email:String?,
    @SerializedName("first_name")
    val firstName:String?,
    @SerializedName("last_name")
    val lastName:String?,

    val avatar:String?,
)

data class AddUser(
    val name:String?,
    val job:String?,
    val id:String?,
    val createdAt:String?,
)


data class ReqResData<T>(
    val data: T?
)
