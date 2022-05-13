package com.example.homework7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.homework7.api.RestClient
import com.example.homework7.api.dto.AddUser
import com.example.homework7.api.dto.ReqResData
import com.example.homework7.api.dto.Resource
import com.example.homework7.api.dto.User
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RestClient.getReqResApi.getResource(2).enqueue(object :retrofit2.Callback<ReqResData<List<Resource>>>{
            override fun onResponse(
                call: Call<ReqResData<List<Resource>>>,
                response: Response<ReqResData<List<Resource>>>
            ) {
               if (response.isSuccessful && response.body() != null){
                   response.body()!!.data?.forEach { resource -> Log.d("MyResourceData",resource.toString()) }
               }
            }

            override fun onFailure(call: Call<ReqResData<List<Resource>>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        RestClient.getReqResApi.getResourceById(2).enqueue(object :retrofit2.Callback<ReqResData<Resource>>{
            override fun onResponse(
                call: Call<ReqResData<Resource>>,
                response: Response<ReqResData<Resource>>
            ) {
                if (response.isSuccessful && response.body() != null){
                    response.body()!!.data?.toString()?.let { Log.d("MyResourceDataById", it) }
                }
            }

            override fun onFailure(call: Call<ReqResData<Resource>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        RestClient.getReqResApi.getUserById(4).enqueue(object :retrofit2.Callback<ReqResData<User>>{

            override fun onResponse(
                call: Call<ReqResData<User>>,
                response: Response<ReqResData<User>>
            ) {
                if (response.isSuccessful && response.body() != null){
                    response.body()!!.data?.toString()?.let { Log.d("UserDataById", it) }
                }
            }

            override fun onFailure(call: Call<ReqResData<User>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        RestClient.getReqResApi.addUser(
            AddUser(  id = null,
                name = "Luka",
                job = "TBC",
                createdAt = null )
        ).enqueue(object :retrofit2.Callback<AddUser>{

            override fun onResponse(call: Call<AddUser>, response: Response<AddUser>) {
                if (response.isSuccessful && response.body() != null){
                    response.body()!!.toString().let { Log.d("User Add", it) }
                }
            }

            override fun onFailure(call: Call<AddUser>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}