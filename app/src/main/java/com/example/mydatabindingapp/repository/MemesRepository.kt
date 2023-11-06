package com.example.mydatabindingapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mydatabindingapp.model.MemeModel
import com.example.mydatabindingapp.retrofit.ApiInterface

class MemesRepository(private val apiInterface: ApiInterface) {
    private val memesLiveData = MutableLiveData<MemeModel>()
    val memes : LiveData<MemeModel>
        get() = memesLiveData


    suspend fun getMemes(){
        val result = apiInterface.getMemes()
        if (result.isSuccessful){
            memesLiveData.postValue(result.body())
            Log.e("res",result.body().toString())
        }
    }


}