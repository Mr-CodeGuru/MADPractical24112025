package com.exam.madpractical24112025

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    
    private lateinit var mainLayout: LinearLayout
    private lateinit var textView: TextView
    private lateinit var animationImage: ImageView
    private lateinit var btnOpenSecondActivity: Button
    private lateinit var btnAnimation: Button
    private lateinit var btnColorMenu: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        mainLayout = findViewById(R.id.main)
        textView = findViewById(R.id.textView)
        animationImage = findViewById(R.id.animationImage)
        btnOpenSecondActivity = findViewById(R.id.btnOpenSecondActivity)
        btnAnimation = findViewById(R.id.btnAnimation)
        btnColorMenu = findViewById(R.id.btnColorMenu)

        setupButtonListeners()
    }

    private fun setupButtonListeners() {
        // Button 1: Open Second Activity with text passing
        btnOpenSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("TEXT_FROM_MAIN", textView.text.toString())
            startActivity(intent)
        }

        // Button 2: Start Animation
        btnAnimation.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.tween_anim)
            animationImage.startAnimation(animation)
        }

        // Button 3: Color Menu
        btnColorMenu.setOnClickListener {
            showColorMenu()
        }
    }

    private fun showColorMenu() {
        val colors = arrayOf("Red", "Blue", "Green", "Default")
        
        AlertDialog.Builder(this)
            .setTitle("Choose Background Color")
            .setItems(colors) { _, which ->
                when (which) {
                    0 -> mainLayout.setBackgroundColor(Color.RED)
                    1 -> mainLayout.setBackgroundColor(Color.BLUE)
                    2 -> mainLayout.setBackgroundColor(Color.GREEN)
                    3 -> mainLayout.setBackgroundColor((Color.WHITE))
                }
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}