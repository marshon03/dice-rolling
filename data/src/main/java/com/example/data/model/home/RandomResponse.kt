package com.example.data.model.home

data class RandomResponse(
    val result: ResultData
)

data class ResultData(
    val random: RandomData
)

data class RandomData(
    val data: List<Int>
)