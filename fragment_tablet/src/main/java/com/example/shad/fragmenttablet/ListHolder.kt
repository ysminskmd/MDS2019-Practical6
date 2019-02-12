package com.example.shad.fragmenttablet

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

internal class ListHolder(view: View) : RecyclerView.ViewHolder(view) {
    val image: View = view.findViewById(R.id.image)
    val title: TextView = view.findViewById(R.id.title)
}
