package com.example.rolldice.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rolldice.R
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel) {
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = { TopAppBar(title = { Text("") }) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            val diceValue = when (viewModel.diceRollResult.intValue) {
                1 -> painterResource(id = R.drawable.dice_six_faces_one)
                2 -> painterResource(id = R.drawable.dice_six_faces_two)
                3 -> painterResource(id = R.drawable.dice_six_faces_three)
                4 -> painterResource(id = R.drawable.dice_six_faces_four)
                5 -> painterResource(id = R.drawable.dice_six_faces_five)
                6 -> painterResource(id = R.drawable.dice_six_faces_six)
                else -> {
                    //TODO: add default/failure image
                    painterResource(id = R.drawable.dice_six_faces_one)
                }
            }
            Image(
                modifier = Modifier
                    .size(200.dp)
                    .align(Alignment.Center),
                painter = diceValue,
                contentDescription = ""
            )

            Button(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 96.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                onClick = {
                    scope.launch {
                        viewModel.fetchRandomNumbers()
                    }
                }
            ) {
                Text(color = Color.White, text = "Roll")
            }
        }
    }
}