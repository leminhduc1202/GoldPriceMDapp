package com.mdapp.goldprice.apigold

import retrofit2.Call
import retrofit2.http.GET

interface ApiGold {

    fun getGoldData(): Call<GoldData>
}