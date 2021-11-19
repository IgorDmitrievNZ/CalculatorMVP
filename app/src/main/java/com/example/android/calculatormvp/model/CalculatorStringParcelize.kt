package com.example.android.calculatormvp.model

interface CalculatorStringParcelize {

    fun performOperation(argOne: Double, argTwo: Double, operation: Operation): Double
}