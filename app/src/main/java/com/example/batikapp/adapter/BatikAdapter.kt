package com.example.batikapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.batikapp.detail.DetailBatikActivity
import com.example.batikapp.R
import com.example.batikapp.model.Batik
import kotlinx.android.synthetic.main.item_batik.view.*

class BatikAdapter(var data: ArrayList<Batik>?) :RecyclerView.Adapter<BatikAdapter.BatikHolder>() {
    class BatikHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val img = itemView.itemImg
        val itemNamaBatik = itemView.itemNamaBatik
        val itemNamaDaerah = itemView.itemNamaDaerah

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatikHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_batik,parent,false)
        val holder = BatikHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: BatikHolder, position: Int) {
        holder.itemNamaBatik.text = data?.get(position)?.nama_batik
        holder.itemNamaDaerah.text = data?.get(position)?.daerah_batik

        Glide.with(holder.itemView.context)
            .load(data?.get(position)?.link_batik)
            .placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher)
            .into(holder.img)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailBatikActivity::class.java)
            intent.putExtra("batik", data?.get(position)?.nama_batik)
            intent.putExtra("daerah", data?.get(position)?.daerah_batik)
            intent.putExtra("harga_tinggi", data?.get(position)?.harga_tinggi)
            intent.putExtra("harga_rendah", data?.get(position)?.harga_rendah)
            intent.putExtra("desk", data?.get(position)?.makna_batik)
            intent.putExtra("img",data?.get(position)?.link_batik)
            holder.itemView.context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return data?.size?: 0
    }
}