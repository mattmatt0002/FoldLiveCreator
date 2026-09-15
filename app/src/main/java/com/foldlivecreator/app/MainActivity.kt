package com.foldlivecreator.app

import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var preview: ImageView
    private lateinit var status: TextView

    private val pickImage =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->

            if (uri != null) {
                preview.setImageURI(uri)
                preview.visibility = ImageView.VISIBLE
                status.text = "Image loaded — ready to build effects"
            } else {
                status.text = "No image selected"
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
            setPadding(48, 72, 48, 48)
            setBackgroundColor(Color.rgb(8, 8, 12))
        }

        val title = TextView(this).apply {
            text = "FoldLiveCreator"
            textSize = 30f
            setTextColor(Color.WHITE)
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "Create animated live wallpapers for your foldable."
            textSize = 16f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
            setPadding(0, 24, 0, 36)
        }

        preview = ImageView(this).apply {
            visibility = ImageView.GONE
            adjustViewBounds = true
            scaleType = ImageView.ScaleType.CENTER_CROP
        }

        status = TextView(this).apply {
            text = "Choose an image to start"
            textSize = 14f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
            setPadding(0, 24, 0, 24)
        }

        val importButton = Button(this).apply {
            text = "Import Image"

            setOnClickListener {
                pickImage.launch("image/*")
            }
        }

        layout.addView(title)
        layout.addView(subtitle)

        layout.addView(
            preview,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        layout.addView(status)
        layout.addView(importButton)

        setContentView(layout)
    }
}
