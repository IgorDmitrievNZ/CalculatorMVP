package com.example.android.calculatormvp.model

class CalculatorParcelStringImpl : CalculatorStringParcelize {
    override fun performOperation(argOne: Double, argTwo: Double, operation: Operation): Double {

        return when (operation) {
            Operation.ADD -> argOne + argTwo
            Operation.SUB -> argOne - argTwo
            Operation.MULT -> argOne * argTwo
            Operation.DEVI -> argOne / argTwo
        }
    }
}