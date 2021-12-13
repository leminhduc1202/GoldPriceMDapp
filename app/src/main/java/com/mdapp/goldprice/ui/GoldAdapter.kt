package com.mdapp.goldprice.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mdapp.goldprice.R

class GoldAdapter(
    private var context: Context,
    private var brand: ArrayList<String>,
    private var type: ArrayList<String>,
    private var updated: ArrayList<String>,
    private var buy: ArrayList<String>,
    private var sell: ArrayList<String>,
) : RecyclerView.Adapter<GoldAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var brand: TextView = itemView.findViewById(R.id.tv_brand)
        var type: TextView = itemView.findViewById(R.id.tv_type)
        var updated: TextView = itemView.findViewById(R.id.tv_updated)
        var buy: TextView = itemView.findViewById(R.id.tv_buy)
        var sell: TextView = itemView.findViewById(R.id.tv_sell)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.row_gold_items, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.brand.text = brand[position]
        holder.type.text = type[position]
        holder.updated.text = updated[position]
        holder.buy.text = buy[position]
        holder.sell.text = sell[position]
    }

    override fun getItemCount(): Int {
        return brand.size
    }
}