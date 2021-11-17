package com.example.android.calculatormvp.model

interface Calculator {

    fun performOperation(argOne: Digit?, argTwo: Digit, operation: Operation): Double?
}