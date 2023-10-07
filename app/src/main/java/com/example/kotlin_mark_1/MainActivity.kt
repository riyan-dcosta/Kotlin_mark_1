package com.example.kotlin_mark_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlin_mark_1.app.anotationTypes.DarkAndLightMode
import com.example.kotlin_mark_1.app.basic_functions.HomePage
import com.example.kotlin_mark_1.app.basic_functions.OnBoarding
import com.example.kotlin_mark_1.app.basic_functions.ProfilePage
import com.example.kotlin_mark_1.features.welness.presentation.pages.Wellness

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home") {
                composable("home") { HomePage() }
                composable("wellness") { Wellness() }
//                composable("on-boarding") { OnBoarding() }
                composable("profile") { ProfilePage() }
            }
//            Kotlin_mark_1Theme {
//                Column {
//                    Button(onClick = { navController.navigate("home") }) {
//                        Text(text = "Home")
//                    }
//                    Button(onClick = { navController.navigate("wellness") }) {
//                        Text(text = "Wellness")
//                    }
//                }
//            }
        }
    }
}

@DarkAndLightMode
@Composable
fun GoToScreenButtons() {
    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        ElevatedButton(onClick = {}) {

        }
        OutlinedButton(onClick = { /*TODO*/ }) {

        }
        Button(onClick = { /*TODO*/ }) {

        }
    }
}
