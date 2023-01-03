package com.example.photos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.photos.Retrofit.retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var text:TextView
    private lateinit var loadButton:Button
    private lateinit var loadAll:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.text)
        loadButton = findViewById(R.id.loadButton)
        loadAll = findViewById(R.id.loadButtonAll)

        loadButton.setOnClickListener {
            onLoadButtonClicked()
        }
        loadAll.setOnClickListener {
            onLoadButtonClickedAll()
        }
    }


    private fun onLoadButtonClicked() {
        retrofitVar.getFirstProduct().enqueue(object : Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                var response = response.body()
                text.text = "Phone is  ${response?.title}, the price is ${response?.price} euro, the rating is ${response?.rating}"
            }

            override fun onFailure(call: Call<Product>, t: Throwable) {
                text.text = t.message
            }
        })
        }


    private fun onLoadButtonClickedAll() {
        retrofitVar.getProducts().enqueue(object : Callback<AllProducts> {
            override fun onResponse(call: Call<AllProducts>, response: Response<AllProducts>) {
                var response = response.body()?.products
                var string = ""
                for (product in response!!) {
                    string += "Phone is ${product?.title}, price is ${product?.price} euro \n"
                    text.text = string
                }
            }

            override fun onFailure(call: Call<AllProducts>, t: Throwable) {
                text.text = t.message
            }

        })
}
}