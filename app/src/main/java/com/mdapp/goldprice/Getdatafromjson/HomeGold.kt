package com.mdapp.goldprice.Getdatafromjson

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mdapp.goldprice.databinding.ActivityHomeGoldBinding
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class HomeGold : AppCompatActivity() {

    lateinit var binding: ActivityHomeGoldBinding

    var brand: ArrayList<String> = ArrayList()
    var type: ArrayList<String> = ArrayList()
    var updated: ArrayList<String> = ArrayList()
    var buy: ArrayList<String> = ArrayList()
    var sell: ArrayList<String> = ArrayList()

    private var matchedArrayList: ArrayList<String> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeGoldBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerGold.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerGold.layoutManager = linearLayoutManager

        try {
            val obj = JSONObject(loadJson())
            val userArray = obj.getJSONArray("value")
            for (i in 0 until userArray.length()){
                val userDetail = userArray.getJSONObject(i)
                brand.add(userDetail.getString("brand"))
                type.add(userDetail.getString("type"))
                updated.add(userDetail.getString("updated"))
                buy.add(userDetail.getString("buy"))
                sell.add(userDetail.getString("sell"))
            }
        }catch (e: JSONException){
            e.printStackTrace()
        }

        val goldAdapter = GoldAdapter(this, brand, type, updated, buy, sell)
        binding.recyclerGold.adapter = goldAdapter

    }

    private fun loadJson(): String {

        val json: String?

        try {
            val inputStream = assets.open("GoldJson.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer,charset)
        }catch (ex: IOException){
            ex.printStackTrace()
            return " "
        }
        return json
    }

}