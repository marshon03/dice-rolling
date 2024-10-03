package com.example.rolldice.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.repository.RandomRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val randomRepository: RandomRepository
): ViewModel() {

    fun fetchRandomNumbers() {
        viewModelScope.launch {
            val result = randomRepository.fetchRandomNumberForDiceRoll()

            result.onSuccess { randomNumbers ->
                println("Dice roll result: ${randomNumbers.first()}")
            }.onFailure { error ->
                println("Error: ${error.message}")
            }
        }
    }
}