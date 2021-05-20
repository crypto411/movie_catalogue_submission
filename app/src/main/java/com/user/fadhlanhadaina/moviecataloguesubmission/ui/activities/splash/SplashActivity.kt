package com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.user.fadhlanhadaina.moviecataloguesubmission.R
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.home.HomeActivity

class SplashActivity : AppCompatActivity() {
    companion object {
        private const val DELAY_MILLIS = 1000L
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        Handler(mainLooper).postDelayed({
            startActivity(Intent(applicationContext, HomeActivity::class.java))
            finish()
        }, DELAY_MILLIS)
    }
}