package com.winlayonwearos.a3x

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val eventButton: ImageButton = findViewById(R.id.eventButton)
        val settingsButton: ImageButton = findViewById(R.id.settingsButton)

        eventButton.setOnClickListener {
            startActivity(Intent(this, EventActivity::class.java))
        }

        settingsButton.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }
}
