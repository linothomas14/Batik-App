package com.example.batikapp.detail

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.batikapp.R

import kotlinx.android.synthetic.main.activity_detail_batik.*
import kotlinx.android.synthetic.main.content_detail_batik.*

class DetailBatikActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_batik)
        setSupportActionBar(toolbar)


        val batik:String? = intent.getStringExtra("batik")
        val daerah:String? = intent.getStringExtra("daerah")
        val harga_tinggi:String? = intent.getStringExtra("harga_tinggi")
        val harga_rendah:String? = intent.getStringExtra("harga_rendah")
        val desk:String? = intent.getStringExtra("desk")
        val img:String? = intent.getStringExtra("img")

        BatikDetail.text = batik
        DaerahDetail.text = "Asal Daerah : " + daerah
        HargaTertinggi.text ="Harga Tertinggi : " + harga_tinggi
        HargaTerendah.text = "Harga Terendah : " + harga_rendah
        Deskripsi.text = desk

        Glide.with(this).load(img).into(imgDetail)

    }

}
