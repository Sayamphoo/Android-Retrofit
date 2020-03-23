package com.sayamphoo.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ret = Retrofit.Builder()
                .baseUrl("https://sayamphoo.github.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val server = ret.create(Server::class.java)

        val call = server.getUser()


        call.enqueue(object : Callback<Model>{
            override fun onFailure(call: Call<Model>, t: Throwable) {
                Log.e("Error" , t.toString())
            }

            override fun onResponse(call: Call<Model>, response: Response<Model>) {
                val res = response.body()!!
                nameUser.text = "name : ${res.name} \n nickname : ${res.nickname}"
            }

        })

    }
}
