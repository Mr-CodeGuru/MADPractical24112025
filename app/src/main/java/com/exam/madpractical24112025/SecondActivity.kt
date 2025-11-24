package com.exam.madpractical24112025

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val receivedTextView = findViewById<TextView>(R.id.receivedTextView)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Get the text passed from MainActivity
        val receivedText = intent.getStringExtra("TEXT_FROM_MAIN")
        if (receivedText != null) {
            receivedTextView.text = receivedText
        }

        // Back button functionality
        btnBack.setOnClickListener {
            finish()
        }
    }
}