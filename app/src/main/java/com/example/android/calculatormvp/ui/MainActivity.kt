package com.example.android.calculatormvp.ui

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.android.calculatormvp.R
import com.example.android.calculatormvp.extensions.showToast
import com.example.android.calculatormvp.model.Calculator
import com.example.android.calculatormvp.model.CalculatorImpl

class MainActivity : AppCompatActivity(),MainView {

    private val calculator: Calculator = CalculatorImpl()
    private var presenter: MainPresenter = MainPresenter(this, calculator)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //digits

        findViewById<View>(R.id.key_0).setOnClickListener { presenter.onKeyZeroPressed() }
        findViewById<View>(R.id.key_1).setOnClickListener { presenter.onKeyOnePressed() }
        findViewById<View>(R.id.key_2).setOnClickListener { presenter.onKeyTwoPressed() }
        findViewById<View>(R.id.key_3).setOnClickListener { presenter.onKeyThreePressed() }
        findViewById<View>(R.id.key_4).setOnClickListener { presenter.onKeyFourPressed() }
        findViewById<View>(R.id.key_5).setOnClickListener { presenter.onKeyFivePressed() }
        findViewById<View>(R.id.key_6).setOnClickListener { presenter.onKeySixPressed() }
        findViewById<View>(R.id.key_7).setOnClickListener { presenter.onKeySevenPressed() }
        findViewById<View>(R.id.key_8).setOnClickListener { presenter.onKeyEightPressed() }
        findViewById<View>(R.id.key_9).setOnClickListener { presenter.onKeyNinePressed() }

        //calculation

        findViewById<View>(R.id.key_addition).setOnClickListener { presenter.onKeyPlusPressed() }
        findViewById<View>(R.id.key_subtract).setOnClickListener { showToast(this, "-") }
        findViewById<View>(R.id.key_multiply).setOnClickListener { showToast(this, "*") }
        findViewById<View>(R.id.key_divide).setOnClickListener { showToast(this, "/") }

        //others

        findViewById<View>(R.id.key_equal).setOnClickListener { Toast.makeText(this,"=",Toast.LENGTH_SHORT).show() }
        findViewById<View>(R.id.key_ac).setOnClickListener { Toast.makeText(this,"AC",Toast.LENGTH_SHORT).show() }
        findViewById<View>(R.id.key_dot).setOnClickListener { Toast.makeText(this,".",Toast.LENGTH_SHORT).show() }
    }

    override fun showResult(result: String) {
        findViewById<EditText>(R.id.display_text).setText(result)
    }
}