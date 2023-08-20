package com.example.kotlin_mark_1.features.welness.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WellnessTaskItemState(
    taskName: String,
    onClose: () -> Unit,
    checked: Boolean,
    onCheckedChanged: (value: Boolean) -> Unit
) {

    WellnessTaskItem(
        taskName = taskName,
        checked = checked,
        onCheckedChanged = { value ->
            onCheckedChanged(value)
        },
        onClose = onClose
    )
}

@Composable
private fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckedChanged: (value: Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier = Modifier.padding(8.dp)
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = taskName,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp)
        )
        Checkbox(
            checked = checked,
            onCheckedChange = { value ->
                onCheckedChanged(value)
            }
        )
        IconButton(onClick = onClose) {
            Icon(
                Icons.Default.Close,
                contentDescription = "Close"
            )

        }
    }
}