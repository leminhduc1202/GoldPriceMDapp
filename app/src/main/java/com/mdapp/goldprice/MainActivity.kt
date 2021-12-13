package com.mdapp.goldprice

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mdapp.goldprice.databinding.ActivityMainBinding
import com.mdapp.goldprice.ui.HomeGold
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerUser.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerUser.layoutManager = linearLayoutManager

        getMydata()

        binding.btNextScreen.setOnClickListener {
            val intent = Intent(this, HomeGold::class.java )
            startActivity(intent)
        }


//        val mWebView = binding.webview
//        mWebView.loadUrl("https://goldprice.org/")
//
//        val webSettings = mWebView.settings
//        webSettings.javaScriptEnabled = true
//        mWebView.webViewClient = WebViewClient()
//
//        mWebView.canGoBack()
//        mWebView.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
//            if (keyCode == KeyEvent.KEYCODE_BACK
//
//                && event.action == MotionEvent.ACTION_UP
//                && mWebView.canGoBack()
//            ) {
//                mWebView.goBack()
//                return@OnKeyListener true
//            }
//            false
//        })

    }

    private fun getMydata() {
        val retrofitBuilder =
            Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL)
                .build().create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {
                val responseBody = response.body()!!

                myAdapter = MyAdapter(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                binding.recyclerUser.adapter = myAdapter

            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                d("===", "onFailure:" + t.message)
            }
        })

    }
}
