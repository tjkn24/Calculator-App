package com.example.bitamirshafiee.calculatorappskeletonproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG = "TJKN"

    var number: String = ""
    var numberOne: Float = 0.0F
    var numberTwo: Float = 0.0F

    var isAddition: Boolean = false
    var isDivision: Boolean = false
    var isSubtraction: Boolean = false

    var regexStr = "/^\\d*\\.?\\d*\$/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // test github modification
    }

    fun operationFunction(view: View) {

        val editText: EditText? = findViewById(R.id.edit_text)

        when (view.id) {
            R.id.button_one -> {
                number += 1
                editText?.setText(number)
            }
            R.id.button_two -> {
                number += 2
                editText?.setText(number)
            }
            R.id.button_three -> {
                number += 3
                editText?.setText(number)
            }
            R.id.button_four -> {
                number += 4
                editText?.setText(number)
            }
            R.id.button_five -> {
                number += 5
                editText?.setText(number)
            }
            R.id.button_six -> {
                number += 6
                editText?.setText(number)
            }
            R.id.button_seven -> {
                number += 7
                editText?.setText(number)
            }
            R.id.button_eight -> {
                number += 8
                editText?.setText(number)
            }
            R.id.button_nine -> {
                number += 9
                editText?.setText(number)
            }
            R.id.button_zero -> {
                number += 0
                editText?.setText(number)
            }
            R.id.button_clear -> {
                number = ""
                editText?.setText("")
            }
            R.id.button_dot -> {
                number += "."
                editText?.setText(number)
            }

            R.id.button_divide -> {
                if (number.isNullOrBlank())
                    editText?.setText("")
                else if (!number.matches(("^\\d*\\.?\\d+\$").toRegex())) { // check if a string is a valid number
                    Toast.makeText(this, "Invalid Number", Toast.LENGTH_LONG).show()
                } else {
                    numberOne = number.toFloat()
                    Log.d(TAG, "after clicking button_divide, numberOne: " + numberOne)
                    editText?.setText("")
                    // isSubtraction = false
                    // isAddition = false
                    isDivision = true
                    number = ""
                }
            }

            R.id.button_minus -> {
                if (number.isNullOrBlank())
                    editText?.setText("")
                else if (!number.matches(("^\\d*\\.?\\d+\$").toRegex())) { // check if a string is a valid number
                    Toast.makeText(this, "Invalid Number", Toast.LENGTH_LONG).show()
                } else {
                    numberOne = number.toFloat()
                    Log.d(TAG, "after clicking button_minus, numberOne: " + numberOne)
                    editText?.setText("")
                    // isAddition = false
                    // isDivision = false
                    isSubtraction = true
                    number = ""
                }
            }
            R.id.button_plus -> {
                if (number.isNullOrBlank())
                    editText?.setText("")
                else if (!number.matches(("^\\d*\\.?\\d+\$").toRegex())) { // check if a string is a valid number
                    Toast.makeText(this, "Invalid Number", Toast.LENGTH_LONG).show()
                }
                else {
                    numberOne = number.toFloat()
                    Log.d(TAG, "after clicking button_plus, numberOne: " + numberOne)
                    editText?.setText("")
                    // isDivision = false
                    // isSubtraction = false
                    isAddition = true
                    number = ""
                }
            }

            R.id.button_equal -> {
                if (!number.matches(("^\\d*\\.?\\d+\$").toRegex())) { // check if a string is a valid number
                    Toast.makeText(this, "Invalid Number", Toast.LENGTH_LONG).show()
                }
                else if (isAddition == true) {
                    numberTwo = number.toFloat()
                    editText?.setText((numberOne + numberTwo).toString())
                    number =
                        (numberOne + numberTwo).toString() //TJ added this so that the result becomes numberOne for the next calculation

                } else if (isDivision) {
                    numberTwo = number.toFloat()
                    editText?.setText((numberOne / numberTwo).toString())
                    number =
                        (numberOne / numberTwo).toString() //TJ added this so that the result becomes numberOne for the next calculation

                } else if (isSubtraction) {
                    numberTwo = number.toFloat()
                    editText?.setText((numberOne - numberTwo).toString())
                    number =
                        (numberOne - numberTwo).toString() //TJ added this so that the result becomes numberOne for the next calculation

                }

                // TJ added this so that current operator is not carried on the next calculation
                isAddition = false
                isDivision = false
                isSubtraction = false

                Log.d(TAG, "after clicking equal button, number: " + number)
            }
        }
    }
}



