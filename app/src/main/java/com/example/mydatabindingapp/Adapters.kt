package com.example.mydatabindingapp

import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageFromUrl")
fun ImageView.imageFromUrl(url : String?){
    if (url != null ) {
        Glide.with(this.context).load(url).into(this)
    }
    else{
//        Toast.makeText(context,"Image not Loaded",Toast.LENGTH_LONG).show()
        Log.e("Img","Error Loading the Image")
    }
}