package com.mdapp.goldprice.apigold

data class GoldData(
    val count1: Int,
    val count2: Int,
    val excute1_time: Int,
    val excute2_time: Int,
    val excute3_time: Int,
    val golds: List<Gold>,
    val time: Int
)