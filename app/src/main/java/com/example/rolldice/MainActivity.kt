package com.example.rolldice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp(onBackPressedDispatcher = onBackPressedDispatcher)
        }
    }
}

@Composable
fun MyApp(onBackPressedDispatcher: OnBackPressedDispatcher) {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            AppNavigation(
                navController = navController,
                onBackPressedDispatcher = onBackPressedDispatcher,
                innerPadding = innerPadding
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp(onBackPressedDispatcher = OnBackPressedDispatcher())
}