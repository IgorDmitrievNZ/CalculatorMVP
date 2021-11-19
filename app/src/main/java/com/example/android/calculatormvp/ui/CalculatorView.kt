package com.example.android.calculatormvp.ui

interface CalculatorView {

    fun showResult(result: String)
    fun showHistory(history: String)
}