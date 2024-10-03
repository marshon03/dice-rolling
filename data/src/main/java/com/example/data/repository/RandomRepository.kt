package com.example.data.repository

import com.example.data.BuildConfig
import com.example.data.api.RandomApi
import com.example.data.model.home.Params
import com.example.data.model.home.RandomRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RandomRepository @Inject constructor(private val randomApi: RandomApi) {

    suspend fun fetchRandomNumberForDiceRoll(): Result<List<Int>> {
        val request = RandomRequest(
            params = Params(BuildConfig.RANDOM_API_KEY, n = 1, min = 1, max = 6)
        )

        return try {
            withContext(Dispatchers.IO) {
                val response = randomApi.getRandomNumbers(request)

                Result.success(response.result.random.data)
            }
        } catch (e: HttpException) {
            Result.failure(e)
        } catch (e: IOException) {
            Result.failure(e)
        }
    }
}