package com.example.data.model.home

data class RandomResponse(
    val jsonrpc: String,
    val result: Result
)

data class Result(
    val random: RandomData,
    val bitsUsed: Int,
    val bitsLeft: Int,
    val requestsLeft: Int,
    val advisoryDelay: Int
)

data class RandomData(
    val data: List<Int>,
    val completionTime: String
)