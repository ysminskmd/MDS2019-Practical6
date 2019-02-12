package com.example.shad.fragmenttablet

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class ListAdapter internal constructor(
        private val listItemClickListener: ListFragment.ListItemClickListener?,
        private val data: IntArray
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ListHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        bindListView(holder as ListHolder, position)
    }

    private fun bindListView(holder: ListHolder, position: Int) {
        holder.image.setBackgroundColor(data[position])

        val color = data[position]
        val hex = Integer.toHexString(color and 0x00FFFFFF)
        holder.title.text = hex.toUpperCase()

        holder.itemView.setOnClickListener { listItemClickListener?.onListItemClick(position) }
    }

    override fun getItemCount(): Int = data.size
}
