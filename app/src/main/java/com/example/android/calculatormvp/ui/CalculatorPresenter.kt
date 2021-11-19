package com.example.android.calculatormvp.ui

import com.example.android.calculatormvp.model.CalculatorStringParcelize
import com.example.android.calculatormvp.model.Operation

class CalculatorPresenter(
    private val view: CalculatorView,
    private val model: CalculatorStringParcelize
) {

    var calculationHistory: List<String> = listOf()
    var opHistory:String  = ""
    private var defaultUserInput: String = ""
    private var defaultOperation: Operation = Operation.ADD
    var defaultValue: Double = 0.0
    var isValueSet: Boolean = false

    /**
     * This function displays a digit inserted by user.
     */

    fun insertDigit(digit: Int) {
        if (defaultUserInput == "0") {
            defaultUserInput =
                digit.toString() // do not let to have a few 0 from the beginning
        } else {
            defaultUserInput += digit.toString()
        }
        updateDisplay()
    }

    /**
     * This function works when a user pressed any of an operation buttons like "+" "-" "/" "*" etc
     */

    fun insertOperation(operation: Operation): String {
        val oppADD: String = "+"

        calculation()
        defaultOperation = operation

        if (operation == Operation.ADD) {
            updateDisplay()
            opHistory = oppADD
//            view.showHistory(oppADD)
        }
        return oppADD
    }

    fun onEqualsButtonPressed() {
        calculation()
        updateDisplay()
    }

    fun onClearButtonPressed() {
        defaultUserInput = ""
        isValueSet = false
        updateDisplay()
    }

    fun onDotButtonPressed() {
        if (!defaultUserInput.contains(".")) {
            defaultUserInput += '.'
        }
        if (defaultUserInput == ".") {
            defaultUserInput = "0."
        }
        updateDisplay()
    }


    /**
     * This function displays a digit inserted by user.
     *
     */

    private fun updateDisplay() {
        val text: String
        if (isUserEnteredNumber()) {
            // user started to enter a new digit, show what is entering
            text = defaultUserInput
        } else if (isValueSet) {
            // or show the result of the previous operation
            text = defaultValue.toString().replace("\\.0$".toRegex(), "")
        } else {
            // or else that was discharge. Show 0
            text = "0"
        }
        view.showResult(text)
        view.showHistory(noNameFunction(defaultUserInput, opHistory))
    }

    private fun isUserEnteredNumber() = defaultUserInput != ""


    private fun calculation() {
        if (!isUserEnteredNumber())
            return
        val currentValue = defaultUserInput.toDouble()
        if (!isValueSet) {
            defaultValue = currentValue
        } else {
            defaultValue = model.performOperation(defaultValue, currentValue, defaultOperation)
        }
        isValueSet = true
        defaultUserInput = ""
    }

    private fun noNameFunction(display: String, operation: String): String {
        return "$display $operation "
    }

}