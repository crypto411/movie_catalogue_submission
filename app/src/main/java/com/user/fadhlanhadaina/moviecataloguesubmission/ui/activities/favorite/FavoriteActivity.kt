package com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.user.fadhlanhadaina.moviecataloguesubmission.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {
    private lateinit var bind: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(bind.root)

        title = "Favorites"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        bind.vpFavorite.adapter = FavoritePagerAdapter(this, supportFragmentManager)
        bind.tlFavorite.setupWithViewPager(bind.vpFavorite)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}