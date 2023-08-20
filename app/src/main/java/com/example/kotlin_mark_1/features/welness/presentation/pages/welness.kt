package com.example.kotlin_mark_1.features.welness.presentation.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlin_mark_1.features.welness.domain.WellnessViewModel
import com.example.kotlin_mark_1.features.welness.presentation.components.StatefulCounter
import com.example.kotlin_mark_1.features.welness.presentation.components.WellnessTaskList

@Composable
fun Wellness(
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column {
        StatefulCounter()
        WellnessTaskList(list = wellnessViewModel.tasks,
            onCloseTask = { task -> wellnessViewModel.remove(task) },
            onCheckedChanged = { task, value ->
                wellnessViewModel.toggleChecked(task, value)
            })
    }
}

