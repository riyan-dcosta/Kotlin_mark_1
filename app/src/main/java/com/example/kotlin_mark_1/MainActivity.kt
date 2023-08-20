package com.example.kotlin_mark_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlin_mark_1.app.anotationTypes.DarkAndLightMode
import com.example.kotlin_mark_1.features.welness.presentation.pages.Wellness
import com.example.kotlin_mark_1.ui.theme.Kotlin_mark_1Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kotlin_mark_1Theme {
                Wellness()
//                GoToScreenButtons()
//                Scaffold(
//                    topBar = { TopAppBar(title = { Text(text = "Jetpcak") }) },
//                )
//                { contentPadding ->
//                    Box(modifier = Modifier.padding(contentPadding)) {
//                        HomePage()
//                    }
//
//                }
            }
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
