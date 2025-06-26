package com.winlayonwearos.a3x

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.google.android.material.button.MaterialButton

class SettingsActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val appInfoButton: MaterialButton = findViewById(R.id.appInfoButton)
        appInfoButton.setOnClickListener {
            startActivity(Intent(this, AppInfoActivity::class.java))
        }
    }
}
