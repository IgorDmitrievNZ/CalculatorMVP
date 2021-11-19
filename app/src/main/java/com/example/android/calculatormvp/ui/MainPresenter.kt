package com.example.android.calculatormvp.ui

import com.example.android.calculatormvp.model.CalculatorStringParcelize
import com.example.android.calculatormvp.model.Digit
import com.example.android.calculatormvp.model.Operation

class MainPresenter(private val view: CalculatorView, private val calculatorStringParcelize: CalculatorStringParcelize) {

    private val argOne: Digit = Digit()
    private val argTwo: Digit? = null
    private var operation: Operation? = null

    //DIGITS

    fun onKeyZeroPressed() {
        argOne.addDigit(0)
        view.showResult(argOne.toDoubleConvert().toString())
    }

    fun onKeyOnePressed() {
        argOne.addDigit(1)
        view.showResult(argOne.toDoubleConvert().toString())
    }

    fun onKeyTwoPressed() {
        argOne.addDigit(2)
        view.showResult(argOne.toDoubleConvert().toString())
    }

    fun onKeyThreePressed() {
        argOne.addDigit(3)
        view.showResult(argOne.toDoubleConvert().toString())
    }

    fun onKeyFourPressed() {
        argOne.addDigit(4)
        view.showResult(argOne.toDoubleConvert().toString())
    }

    fun onKeyFivePressed() {
        argOne.addDigit(5)
        view.showResult(argOne.toDoubleConvert().toString())
    }

    fun onKeySixPressed() {
        argOne.addDigit(6)
        view.showResult(argOne.toDoubleConvert().toString())
    }

    fun onKeySevenPressed() {
        argOne.addDigit(7)
        view.showResult(argOne.toDoubleConvert().toString())
    }

    fun onKeyEightPressed() {
        argOne.addDigit(8)
        view.showResult(argOne.toDoubleConvert().toString())
    }

    fun onKeyNinePressed() {
        argOne.addDigit(9)
        view.showResult(argOne.toDoubleConvert().toString())
    }

    //OPERATIONS

    fun onKeyPlusPressed() {
        operation = Operation.ADD

        if (argOne != null && argTwo != null) {
//            val result = calculator.performOperation(argOne, argTwo, operation!!)
        }
    }
}