package com.sayamphoo.myapplication

import com.google.gson.annotations.SerializedName

data class Model (
    @SerializedName("name")
    val name:String?,
    @SerializedName("nickname")
    val nickname:String?
)