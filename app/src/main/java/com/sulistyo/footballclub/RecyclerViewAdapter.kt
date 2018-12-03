package com.sulistyo.footballclub

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.sulistyo.footballclub.R.id.logoClub
import com.sulistyo.footballclub.R.id.namaClub


class RecyclerViewAdapter(
    private val context: Context,
    private val dataItems: List<DataItem>,
    private val listener: (DataItem) -> Unit
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(dataItems[position], listener)
    }

    override fun getItemCount(): Int = dataItems.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val name = view.findViewById<TextView>(namaClub)
        private val image = view.findViewById<ImageView>(logoClub)

        fun bindItem(items: DataItem, listener: (DataItem) -> Unit) {

            name.text = items.name

            items.image.let { Glide.with(itemView.context).load(it).into(image) }

            itemView.setOnClickListener {
                listener(items)
            }

        }
    }
}