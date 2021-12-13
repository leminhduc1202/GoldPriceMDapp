package com.mdapp.goldprice.apigold

data class Gold(
    val date: String,
    val gold: List<Any>,
    val updated: String,
    val value: List<Value>
)