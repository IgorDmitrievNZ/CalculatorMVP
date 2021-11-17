package com.example.android.calculatormvp.model

import java.util.*

class Digit {
    private val mod = ArrayList<Int>()  //whole number
    private val div = ArrayList<Int>()  //a fractional number

    var isReal = false                  //checking fractional

    fun removeDigit() {
        if (mod.isEmpty()) {
            ///
        }
    }

    fun addDigit(value: Int) {
        if (isReal) {
            mod.add(value)
        } else {
            div.add(value)
        }
    }

    // transform to double
    fun toDoubleConvert(): Double {
        var result = 0.0
        for (i: Int in div) {
            result = result * 10 + i
        }
        return result
    }
}