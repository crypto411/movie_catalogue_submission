package com.user.fadhlanhadaina.favorite_feature.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.user.fadhlanhadaina.favorite_feature.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {
    private val bind: ActivityFavoriteBinding by lazy {
        ActivityFavoriteBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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