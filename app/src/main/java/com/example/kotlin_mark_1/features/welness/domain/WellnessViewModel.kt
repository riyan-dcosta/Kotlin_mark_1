package com.example.kotlin_mark_1.features.welness.domain

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()

    //    Another way to create mutableStateList
    //    private val _tasks2 = remember {
    //        mutableStateListOf<WellnessTask>().apply { addAll(getWellnessTasks()) }
    //    }

    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(item: WellnessTask) {
        _tasks.remove(item)
    }

    fun toggleChecked(item: WellnessTask, checked: Boolean) {
        println("toggleChecked : $item , $checked")
        _tasks.find { it.id == item.id }?.let { task -> task.checked.value = checked }
    }
}

private fun getWellnessTasks() = List(30) { i ->
    WellnessTask(
        i, "Task No : $i", checked =
        mutableStateOf(false)
    )
}