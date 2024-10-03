package com.example.data.api

import com.example.data.model.home.RandomRequest
import com.example.data.model.home.RandomResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface RandomApi {
    @POST("/")
    fun getRandomNumbers(@Body request: RandomRequest): RandomResponse
}