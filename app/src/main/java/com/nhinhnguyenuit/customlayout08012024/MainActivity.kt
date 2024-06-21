package com.nhinhnguyenuit.customlayout08012024

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.IntegerRes
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var editTextNum1: EditText? = null
    private var editTextNum2: EditText? = null
    private var btnName: Button? = null
    private var txtNumber: TextView? = null
    private var imageViewAvatar : ImageView? = null
    private var screen: ConstraintLayout? = null
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
        txtNumber = findViewById(R.id.txtNum)
        imageViewAvatar = findViewById(R.id.imgAvatar)
        screen = findViewById(R.id.main)

        val listAvatar = ArrayList<Int>()
        listAvatar.add(R.drawable.avatar1)
        listAvatar.add(R.drawable.avatar2)
        listAvatar.add(R.drawable.avatar3)


//        screen?.setBackgroundColor(Color.rgb(10,50,100))
        btnName?.setOnClickListener {
            val str1 = editTextNum1?.text.toString()
            val str2 = editTextNum2?.text.toString()
            val index = Random.nextInt(listAvatar.size)
            imageViewAvatar?.setImageResource(R.drawable.avatar)
            screen?.setBackgroundResource(listAvatar[index])
            Toast.makeText(this, index.toString(), Toast.LENGTH_SHORT).show()
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

    fun sayHi(view: View) {
        Toast.makeText(this,"ImageButton Was Press", Toast.LENGTH_SHORT).show()
    }
}