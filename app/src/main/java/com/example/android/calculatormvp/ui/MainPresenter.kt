package com.example.android.calculatormvp.ui

import com.example.android.calculatormvp.model.Calculator
import com.example.android.calculatormvp.model.Operation

class MainPresenter(private val view: MainView,private val calculator:Calculator) {

    fun onKeyZeroPressed() {
        calculator.performOperation(2.0, 3.5, Operation.ADD)
        view.showResult("Result")
    }

    fun onKeyOnePressed() {}
    fun onKeyTwoPressed() {}
}