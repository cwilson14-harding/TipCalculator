// Name: Curtis Wilson
// Project: Tip Calculator
// COMP 475 (Android)
package edu.harding.cwilson14.tipcalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import java.text.NumberFormat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Create the text watcher anonymous class using an object expression.
        val textWatcher = object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }
            override fun afterTextChanged(p0: Editable?) {
                calculate()
            }
        }

        // Set the new text watcher as a listener.
        inputBill.addTextChangedListener(textWatcher)
        inputTipPercent.addTextChangedListener(textWatcher)
    }

    // Update the calculations.
    fun calculate() {
        try {
            // Calculate the answers.
            val tipCalculator = TipCalculator(inputBill.text.toString().toFloat(), inputTipPercent.text.toString().toFloat()/100)
            val numberFormat = NumberFormat.getCurrencyInstance()

            // Update the labels with the calculations.
            labelTipAmount.text = numberFormat.format(tipCalculator.tipAmount)
            labelTotal.text = numberFormat.format(tipCalculator.total)

        } catch (e: NumberFormatException) {
            // Numbers failed to parse.
            Toast.makeText(this, "Enter numbers for bill and tip percent.", Toast.LENGTH_SHORT).show()
            labelTipAmount.text = ""
            labelTotal.text = ""
        }
    }
}
