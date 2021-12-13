package com.mdapp.goldprice.apigold

import com.google.gson.annotations.SerializedName

data class Value(

    @SerializedName("brand")
    val brand: String,
    val brand1: String,
    val buy: String,
    val code: String,
    val company: String,
    val day: String,
    val id: String,
    val sell: String,
    val type: String,
    val updated: String
)