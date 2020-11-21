package com.example.batikapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.batikapp.model.ResponseServer
import com.example.batikapp.network.ConfigNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ConfigNetwork.getRetrofit().getDataBatik().enqueue(object : Callback<ResponseServer> {
            override fun onResponse(call: Call<ResponseServer>, response: Response<ResponseServer>) {
                //if there is response from server
                Log.d("response server",response.message())

            }

            override fun onFailure(call: Call<ResponseServer>, t: Throwable) {
                Log.d("Error server",t.message)
                //if there is no response from server
            }

        })
    }
}
