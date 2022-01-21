package com.example.android.calculatormvp.ui

import com.example.android.calculatormvp.model.CalculatorStringParcelize
import com.example.android.calculatormvp.model.Operation

class CalculatorPresenter(
    private val view: CalculatorView,
    private val model: CalculatorStringParcelize,
) {

    var history: String = ""
    private var opHistory: String = ""
    private var defaultUserInput: String = ""
    var previousArg: String = ""
    private var defaultOperation: Operation = Operation.ADD
    var isDefaultOp: Boolean = false
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
        addHistory(digit.toString())
        updateDisplay()
    }

    /**
     * This function works when a user pressed any of an operation buttons like "+" "-" "/" "*" etc
     */

    fun insertOperation(operation: Operation){
        calculation()
        defaultOperation = operation
        isDefaultOp = true

        when (operation) {
            Operation.ADD -> {
                opHistory = " + "
                addHistory(opHistory)
                updateDisplay()
            }
            Operation.SUB -> {
                opHistory = " - "
                addHistory(opHistory)
                updateDisplay()
            }
            Operation.MULT -> {
                opHistory = " * "
                addHistory(opHistory)
                updateDisplay()
            }
            Operation.DEVI -> {
                opHistory = " / "
                addHistory(opHistory)
                updateDisplay()
            }
        }
    }

    fun onEqualsButtonPressed() {
        calculation()
        updateDisplay()
        view.showHistory(history + " = " + defaultValue.toString().replace("\\.0$".toRegex(), ""))
    }

    fun onClearButtonPressed() {
        defaultUserInput = ""
        defaultValue = 0.0
        previousArg = ""
        history = ""
        opHistory = ""
        isValueSet = false
        updateDisplay()
        view.showHistory("0")
    }

    fun onDotButtonPressed() {
        if (!defaultUserInput.contains(".")) {
            defaultUserInput += '.'
        }
        if (defaultUserInput == ".") {
            defaultUserInput = "0."
        }
        updateDisplay()
        addHistory(".")
    }


    /**
     * This function displays a digit inserted by user.
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
        view.showHistory(history)
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
        previousArg = defaultUserInput
        defaultUserInput = ""
    }

    private fun addHistory(value: String): String {
        history += value
        return value
    }

}