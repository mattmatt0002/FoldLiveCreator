package com.foldlivecreator.app

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = android.view.Gravity.CENTER
            setPadding(48, 48, 48, 48)
        }

        val title = TextView(this).apply {
            text = "FoldLiveCreator"
            textSize = 30f
            gravity = android.view.Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "Create animated live wallpapers for your foldable."
            textSize = 16f
            gravity = android.view.Gravity.CENTER
            setPadding(0, 24, 0, 48)
        }

        val importButton = Button(this).apply {
            text = "Import Image"
        }

        layout.addView(title)
        layout.addView(subtitle)
        layout.addView(importButton)

        setContentView(layout)
    }
}
