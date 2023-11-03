package com.example.mydatabindingapp.recyclerAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mydatabindingapp.databinding.RecLayoutBinding
import com.example.mydatabindingapp.model.Product


class ProductsAdapter(private val productsList: ArrayList<Product>) : RecyclerView.Adapter<ProductsAdapter.MyViewHolder>() {
    lateinit var binding : RecLayoutBinding

    class MyViewHolder(var view:RecLayoutBinding):RecyclerView.ViewHolder(view.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = RecLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.text.text = productsList[position].title
        holder.view.des.text = productsList[position].title

    }


}