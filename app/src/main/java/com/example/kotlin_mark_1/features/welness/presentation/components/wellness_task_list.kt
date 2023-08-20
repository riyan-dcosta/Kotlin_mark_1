package com.example.kotlin_mark_1.features.welness.presentation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.kotlin_mark_1.features.welness.domain.WellnessTask

@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    onCheckedChanged: (WellnessTask, Boolean) -> Unit
) {
    LazyColumn(modifier = modifier) {
        items(list) { task ->
            WellnessTaskItemState(
                taskName = task.label,
                onClose = { onCloseTask(task) },
                checked = task.checked.value,
                onCheckedChanged = { value -> onCheckedChanged(task, value) }
            )
        }
    }

}

