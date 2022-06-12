package com.example.calculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val mainActivity: MainActivity, val l1: List<datamodel>) : RecyclerView.Adapter<Adapter.View11>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): View11 {
        val view = LayoutInflater.from(mainActivity).inflate(R.layout.recyhist,parent,false)
        return View11(view)
    }

    override fun onBindViewHolder(holder: View11, position: Int) {
        holder.input.text = l1[position].inputtext
        holder.output.text = "= ${l1[position].output}"

    }

    override fun getItemCount(): Int {

        return l1.size
    }

    class View11(itemView: View) : RecyclerView.ViewHolder(itemView){
        val input = itemView.findViewById<TextView>(R.id.input)
        val output = itemView.findViewById<TextView>(R.id.output)
    }

}