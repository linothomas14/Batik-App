package com.example.batikapp

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.batikapp.adapter.BatikAdapter
import com.example.batikapp.model.Batik
import com.example.batikapp.model.ResponseServer
import com.example.batikapp.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(isConnect()){
            ConfigNetwork.getRetrofit().getDataBatik().enqueue(object : Callback<ResponseServer> {
                override fun onResponse(
                    call: Call<ResponseServer>,
                    response: Response<ResponseServer>
                ) {
                    //if there is response from server
                    Log.d("response server", response.message())
                    progress.visibility = View.GONE
                    if (response.isSuccessful) {
                        val data = response.body()?.hasil
                        showData(data)
                    }
                }
                override fun onFailure(call: Call<ResponseServer>, t: Throwable) {
                    Log.d("Error server", t.message)
                    progress.visibility = View.GONE
                    //if there is no response from server
                }
            })
        } else{
            progress.visibility = View.GONE
            Toast.makeText(this,"No internet",Toast.LENGTH_LONG).show()
        }
    }

    private fun showData(data: ArrayList<Batik>?) {
        listBatik.adapter = BatikAdapter(data)
    }

    fun isConnect():Boolean{
        val connect: ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connect.activeNetworkInfo != null && connect.activeNetworkInfo.isConnected
    }


}
