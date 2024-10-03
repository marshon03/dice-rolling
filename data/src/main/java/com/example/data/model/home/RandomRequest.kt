package com.example.data.model.home

data class RandomRequest(
    val jsonrpc: String = "2.0",
    val method: String = "generateIntegers",
    val params: Params,
    val id: Int = 1
)

data class Params(
    val apiKey: String,
    val n: Int,
    val min: Int,
    val max: Int,
    val replacement: Boolean = true
)