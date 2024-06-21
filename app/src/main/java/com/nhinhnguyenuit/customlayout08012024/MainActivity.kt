package com.nhinhnguyenuit.customlayout08012024

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.IntegerRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var editTextNum1: EditText? = null
    private var editTextNum2: EditText? = null
    private var btnName: Button? = null
    private var txtNumber: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        editTextNum1 = findViewById(R.id.edtSo1)
        editTextNum2 = findViewById(R.id.edtSo2)
        btnName = findViewById(R.id.btnName)
        txtNumber = findViewById<TextView>(R.id.txtNum)

        btnName?.setOnClickListener {
            val str1 = editTextNum1?.text.toString()
            val str2 = editTextNum2?.text.toString()

            if (str1.isEmpty() || str2.isEmpty()) {
                Toast.makeText(this, "Please input number", Toast.LENGTH_SHORT).show()
            } else {
                val min = str1.toInt()
                val max = str2.toInt()

                if (min < max) {
                    txtNumber?.text = Random.nextInt(min, max).toString()
                } else {
                    Toast.makeText(this, "Min need lower Max", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}