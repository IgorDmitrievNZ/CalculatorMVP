package com.example.android.calculatormvp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.android.calculatormvp.R
import com.example.android.calculatormvp.extensions.showToast
import com.example.android.calculatormvp.model.Calculator
import com.example.android.calculatormvp.model.CalculatorImpl

class MainActivity : AppCompatActivity(),MainView {

    private val model: Calculator = CalculatorImpl()
    private var presenter: MainPresenter = MainPresenter(this,model)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //digits

        findViewById<View>(R.id.key_0).setOnClickListener { presenter.onKeyZeroPressed() }
        findViewById<View>(R.id.key_1).setOnClickListener { presenter.onKeyOnePressed() }
        findViewById<View>(R.id.key_2).setOnClickListener { presenter.onKeyTwoPressed() }
        findViewById<View>(R.id.key_3).setOnClickListener { showToast(this,"3") }
        findViewById<View>(R.id.key_4).setOnClickListener { showToast(this,"4") }
        findViewById<View>(R.id.key_5).setOnClickListener { Toast.makeText(this,"5",Toast.LENGTH_SHORT).show() }
        findViewById<View>(R.id.key_6).setOnClickListener { Toast.makeText(this,"6",Toast.LENGTH_SHORT).show() }
        findViewById<View>(R.id.key_7).setOnClickListener { Toast.makeText(this,"7",Toast.LENGTH_SHORT).show() }
        findViewById<View>(R.id.key_8).setOnClickListener { Toast.makeText(this,"8",Toast.LENGTH_SHORT).show() }
        findViewById<View>(R.id.key_9).setOnClickListener { Toast.makeText(this,"9",Toast.LENGTH_SHORT).show() }

        //calculation

        findViewById<View>(R.id.key_addition).setOnClickListener { Toast.makeText(this,"+",Toast.LENGTH_SHORT).show() }
        findViewById<View>(R.id.key_subtract).setOnClickListener { Toast.makeText(this,"-",Toast.LENGTH_SHORT).show() }
        findViewById<View>(R.id.key_multiply).setOnClickListener { Toast.makeText(this,"*",Toast.LENGTH_SHORT).show() }
        findViewById<View>(R.id.key_divide).setOnClickListener { Toast.makeText(this,"/",Toast.LENGTH_SHORT).show() }

        //others

        findViewById<View>(R.id.key_equal).setOnClickListener { Toast.makeText(this,"=",Toast.LENGTH_SHORT).show() }
        findViewById<View>(R.id.key_ac).setOnClickListener { Toast.makeText(this,"AC",Toast.LENGTH_SHORT).show() }
        findViewById<View>(R.id.key_dot).setOnClickListener { Toast.makeText(this,".",Toast.LENGTH_SHORT).show() }
    }

    override fun showResult(result: String) {
        findViewById<EditText>(R.id.display_text).setText(result)
    }
}