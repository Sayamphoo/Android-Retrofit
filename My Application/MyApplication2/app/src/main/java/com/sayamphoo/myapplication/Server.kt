package com.sayamphoo.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface Server {
    @GET("jsontest/test.json")
    fun getUser() : Call<Model>
}