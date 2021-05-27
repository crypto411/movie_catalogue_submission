package com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.user.fadhlanhadaina.moviecataloguesubmission.R
import com.user.fadhlanhadaina.moviecataloguesubmission.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val bind: ActivityHomeBinding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)

        bind.vpHome.adapter = HomePagerAdapter(this, supportFragmentManager)
        bind.tlHome.setupWithViewPager(bind.vpHome)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.menuFavorite -> {
                moveToFavoriteActivity()
                true
            }
            else -> {
                false
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater : MenuInflater = menuInflater
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    // Dynamic Feature
    private fun moveToFavoriteActivity() {
        try {
            val favoriteActivity = Class.forName("com.user.fadhlanhadaina.favorite_feature.ui.activity.FavoriteActivity")
            val intent = Intent(
                this@HomeActivity,
                favoriteActivity
            )
            startActivity(intent)
        }
        catch (e: ClassNotFoundException) {
            Log.e("Favorite Feature", e.localizedMessage.toString())
        }
    }
}