package com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.user.fadhlanhadaina.moviecataloguesubmission.R
import com.user.fadhlanhadaina.moviecataloguesubmission.databinding.ActivityHomeBinding
import com.user.fadhlanhadaina.moviecataloguesubmission.ui.activities.favorite.FavoriteActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var bind: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.vpHome.adapter = HomePagerAdapter(this, supportFragmentManager)
        bind.tlHome.setupWithViewPager(bind.vpHome)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.menuFavorite -> {
                val intent = Intent(this@HomeActivity, FavoriteActivity::class.java)
                startActivity(intent)
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
}