package com.example.mydatabindingapp.recyclerAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mydatabindingapp.R
import com.example.mydatabindingapp.model.ProgrammingItem

class ProgrammingAdapter: ListAdapter<ProgrammingItem,ProgrammingAdapter.ProgrammingViewHolder>(DiffUtil()){


    class ProgrammingViewHolder(view :View):RecyclerView.ViewHolder(view){
        val name = view.findViewById<TextView>(R.id.name)
        val initial = view.findViewById<TextView>(R.id.initial)
        fun bindItem(item : ProgrammingItem){
            name.text = item.name
            initial.text = item.intial
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rec_layout,parent,false)
        return ProgrammingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgrammingViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindItem(item)
    }
    class DiffUtil : androidx.recyclerview.widget.DiffUtil.ItemCallback<ProgrammingItem>(){
        override fun areItemsTheSame(oldItem: ProgrammingItem, newItem: ProgrammingItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProgrammingItem,
            newItem: ProgrammingItem,
        ): Boolean {
            return oldItem == newItem
        }
    }
}