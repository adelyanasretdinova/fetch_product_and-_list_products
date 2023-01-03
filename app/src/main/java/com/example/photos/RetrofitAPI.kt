package com.example.photos

import retrofit2.Call
import retrofit2.http.GET


public interface RetrofitAPI {
    @GET("products/1")
    fun getFirstProduct(): Call<Product>

    @GET("products")
    fun getProducts(): Call<AllProducts>
}
