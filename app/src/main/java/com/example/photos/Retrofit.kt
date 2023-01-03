package com.example.photos

import com.example.photos.Retrofit.retrofit
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {

    var BaseUrl = "https://dummyjson.com/"


    val retrofit = Retrofit.Builder()
        .baseUrl(BaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


}

val retrofitVar = retrofit.create(RetrofitAPI::class.java)
