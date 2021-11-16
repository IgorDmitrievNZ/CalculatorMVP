package com.example.android.calculatormvp.model

interface Calculator {

    fun performOperation(argOne: Double, argTwo: Double, operation: Operation): Double
}