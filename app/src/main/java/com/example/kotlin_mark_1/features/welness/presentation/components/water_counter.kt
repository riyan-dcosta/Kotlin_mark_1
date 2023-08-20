package com.example.kotlin_mark_1.features.welness.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun StatefulCounter() {
    var count by rememberSaveable { mutableStateOf(0) }
    WaterCounter(count = count, onIncrement = {
        count++
    })
}

@Composable
private fun WaterCounter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier.padding(8.dp)
) {
    Column(modifier = modifier) {

        if (count > 0) {
            Text(text = "You had $count glass of water")
        }
        Button(
            onClick = onIncrement,
            modifier = Modifier.padding(8.dp),
            enabled = count < 10
        ) {
            Text(text = "Add One")
        }
    }
}