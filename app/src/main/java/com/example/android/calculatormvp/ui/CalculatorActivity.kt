package com.example.android.calculatormvp.ui

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.android.calculatormvp.R
import com.example.android.calculatormvp.model.CalculatorStringParcelize
import com.example.android.calculatormvp.model.CalculatorParcelStringImpl
import com.example.android.calculatormvp.model.Operation

class CalculatorActivity : AppCompatActivity(),CalculatorView {

    private val calculator: CalculatorStringParcelize = CalculatorParcelStringImpl()
    private var presenter: CalculatorPresenter = CalculatorPresenter(this, calculator)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //digits

        findViewById<View>(R.id.key_0).setOnClickListener { presenter.insertDigit(0) }
        findViewById<View>(R.id.key_1).setOnClickListener { presenter.insertDigit(1) }
        findViewById<View>(R.id.key_2).setOnClickListener { presenter.insertDigit(2) }
        findViewById<View>(R.id.key_3).setOnClickListener { presenter.insertDigit(3) }
        findViewById<View>(R.id.key_4).setOnClickListener { presenter.insertDigit(4) }
        findViewById<View>(R.id.key_5).setOnClickListener { presenter.insertDigit(5) }
        findViewById<View>(R.id.key_6).setOnClickListener { presenter.insertDigit(6) }
        findViewById<View>(R.id.key_7).setOnClickListener { presenter.insertDigit(7) }
        findViewById<View>(R.id.key_8).setOnClickListener { presenter.insertDigit(8) }
        findViewById<View>(R.id.key_9).setOnClickListener { presenter.insertDigit(9) }

        //calculation

        findViewById<View>(R.id.key_addition).setOnClickListener { presenter.insertOperation(Operation.ADD) }
        findViewById<View>(R.id.key_subtract).setOnClickListener { presenter.insertOperation(Operation.SUB) }
        findViewById<View>(R.id.key_multiply).setOnClickListener { presenter.insertOperation(Operation.MULT) }
        findViewById<View>(R.id.key_divide).setOnClickListener { presenter.insertOperation(Operation.DEVI) }

        //others

        findViewById<View>(R.id.key_equal).setOnClickListener { presenter.onEqualsButtonPressed() }
        findViewById<View>(R.id.key_ac).setOnClickListener { presenter.onClearButtonPressed() }
        findViewById<View>(R.id.key_dot).setOnClickListener { presenter.onDotButtonPressed() }
    }

    override fun showResult(result: String) {
        findViewById<EditText>(R.id.display_text).setText(result)
    }

    override fun showHistory(history: String) {
        findViewById<TextView>(R.id.previous_text).text = history
    }
}