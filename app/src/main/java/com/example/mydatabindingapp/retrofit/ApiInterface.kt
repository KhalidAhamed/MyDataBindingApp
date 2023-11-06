package com.example.mydatabindingapp.retrofit

import com.example.mydatabindingapp.model.MemeModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/gimme")
    suspend fun getMemes():Response<MemeModel>
}