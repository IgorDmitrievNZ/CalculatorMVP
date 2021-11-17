package com.example.android.calculatormvp.model

class CalculatorImpl : Calculator {
    override fun performOperation(argOne: Digit?, argTwo: Digit, operation: Operation): Double? {
        return when (operation) {
            Operation.ADD -> argOne?.toDoubleConvert()?.plus(argTwo.toDoubleConvert())
            Operation.SUB -> argOne?.toDoubleConvert()?.minus(argTwo.toDoubleConvert())
            Operation.MULT -> argOne?.toDoubleConvert()?.times(argTwo.toDoubleConvert())
            Operation.DEVI -> argOne?.toDoubleConvert()?.div(argTwo.toDoubleConvert())
        }
    }
}