package com.example.android.calculatormvp.model

import java.util.ArrayList

class Digit {
    private val mod = ArrayList<Int>()
    private val div = ArrayList<Int>()
    var isReal = false

        private set

    fun removeDigit() {
        if (mod.isEmpty()) {
        }
    }

    fun makeInt() {
        isReal = false
    }

    fun addDigit(value: Int) {
        if (isReal) {
            mod.add(value)
        } else {
            div.add(value)
        }
    }

    fun toDouble(): Double {
        val result = 0.0
        return 0.0
    }
}