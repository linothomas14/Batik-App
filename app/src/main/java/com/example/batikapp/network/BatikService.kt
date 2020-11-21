package com.example.batikapp.network

import com.example.batikapp.model.ResponseServer
import retrofit2.Call
import retrofit2.http.GET

interface BatikService {
    @GET("index.php/batik/all")
    fun getDataBatik():Call<ResponseServer>
}