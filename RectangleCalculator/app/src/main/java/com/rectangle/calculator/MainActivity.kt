package com.rectangle.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rectangle.calculator.ui.theme.RectangleCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        val lengthInput: EditText = findViewById(R.id.lengthInput);
        val widthInput: EditText = findViewById(R.id.widthInput);
        val calculateButton:Button = findViewById(R.id.calculateButton);
        val resetButton: Button = findViewById(R.id.resetButton);

        val resultTextView: TextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener {
            val length = lengthInput.text.toString().toDoubleOrNull();
            val width = widthInput.text.toString().toDoubleOrNull();


            if(validateInput(length,width)){

                val resultText = StringBuilder()
                for (i in 1..3) {
                val perimeter = calculatePerimeter(length!!, width!!)
                    val area = calculateArea(length, width)
                    resultText.append("Calculation #$i: Perimeter = $perimeter, Area = $area\n")
                }
                resultTextView.text = resultText.toString();
            }


            else{
                resultTextView.text = "Invalid Input"
            }

        }

        resetButton.setOnClickListener{
            lengthInput.text.clear();
            widthInput.text.clear();
            resultTextView.text = "Results will be displayed here"

        }

    }

    private fun validateInput(length:Double?,width:Double?):Boolean{
        //return length != null && width != null &&length > 0 && width > 0;

        return when {
            length == null || width == null -> false // If either is null
            length <= 0 || width <= 0 -> false // If either is non-positive
            else -> true // Valid input
        }


    }

    private fun calculatePerimeter(length:Double,width:Double):Double{
        return 2 * (length + width);

    }

    private fun calculateArea(length:Double,width:Double):Double{
        return length * width;

    }
}

