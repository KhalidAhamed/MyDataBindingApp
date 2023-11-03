package com.example.mydatabindingapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mydatabindingapp.R
import com.example.mydatabindingapp.databinding.ActivityMainBinding
import com.example.mydatabindingapp.model.ImageClass
import com.example.mydatabindingapp.model.MemeModel
import com.example.mydatabindingapp.repository.MemesRepository
import com.example.mydatabindingapp.retrofit.ApiInterface
import com.example.mydatabindingapp.retrofit.RetrofitInstance
import com.example.mydatabindingapp.viewModel.MemeViewModel
import com.example.mydatabindingapp.viewModel.MemeViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var memeViewModel: MemeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val apiInterface = RetrofitInstance.getInstance().create(ApiInterface::class.java)
        val repository = MemesRepository(apiInterface)

        memeViewModel = ViewModelProvider(this,MemeViewModelFactory(repository)).get(MemeViewModel::class.java)

        binding.image = ImageClass("https://media.istockphoto.com/id/521200806/photo/idyllic-summer-landscape-with-clear-mountain-lake-in-the-alps.jpg?s=2048x2048&w=is&k=20&c=BbLwnG3-goIxB5by9ySFeEHCug2ejFdZBwAw29jrC6Y=")
        binding.NavigationDrawer.setOnClickListener {
            val intent = Intent(this, NavigationDrawer::class.java)
            startActivity(intent)
        }
        binding.genBtn.setOnClickListener {
            memeViewModel.memes.observe(this, Observer {
                var memes = MemeModel(it.author,it.nsfw,it.postLink,it.preview,it.spoiler,it.subreddit,it.title,it.ups,it.url)
                Log.e("Res",memes.toString())

                binding.meme = memes


            })








        }

    }
}