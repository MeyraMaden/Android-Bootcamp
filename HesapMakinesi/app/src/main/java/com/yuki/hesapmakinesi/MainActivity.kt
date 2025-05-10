package com.yuki.hesapmakinesi

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private var currentInput = ""
    private var totalSum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)

        val numberButtons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        numberButtons.forEach { id ->
            findViewById<Button>(id).setOnClickListener {
                val digit = (it as Button).text.toString()
                currentInput += digit
                tvResult.text = currentInput
            }
        }

        // Toplama tuşu
        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            if (currentInput.isNotEmpty()) {
                totalSum += currentInput.toInt()
                currentInput = ""
                tvResult.text = totalSum.toString()
            }
        }

        // Sıfırlama tuşu
        findViewById<Button>(R.id.btnClear).setOnClickListener {
            currentInput = ""
            totalSum = 0
            tvResult.text = "0"
        }
    }
}
