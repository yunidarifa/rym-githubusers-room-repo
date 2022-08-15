package com.yunidarifa.githubusers

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDelegate
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.yunidarifa.githubusers.datastore.SettingPreferences

class AboutActivity : AppCompatActivity() {

    private val pref by lazy { SettingPreferences(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        when (pref.getBoolean("pref_is_dark_mode")) {
            true -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            false -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        setContentView(R.layout.activity_about)
        supportActionBar?.title = resources.getString(R.string.aboutapp)

        val imgAbout: ImageView = findViewById(R.id.imageView)
        Glide.with(this)
            .load(R.drawable.yunidarifa)
            .circleCrop()
            .into(imgAbout)
    }
}