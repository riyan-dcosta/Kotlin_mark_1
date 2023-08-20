package com.example.kotlin_mark_1.app.basic_functions

fun main() {
    val basicFunc = BasicFunctions()
    val printResp = basicFunc.printMessage("hello", 10)
    println(printResp)

    basicFunc.printMessage(age = 11)
}

class BasicFunctions {

    fun printMessage(message: String = "empty", age: Int): String {
        println(message);
        return message + "returned"
    }
}