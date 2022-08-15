package com.yunidarifa.githubusers

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import androidx.appcompat.app.AppCompatDelegate
import androidx.cardview.widget.CardView
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.switchmaterial.SwitchMaterial
import com.yunidarifa.githubusers.datastore.SettingPreferences


class SettingActivity : AppCompatActivity() {

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

        setContentView(R.layout.activity_setting)
        supportActionBar?.title = resources.getString(R.string.settings)

        val switchTheme = findViewById<SwitchMaterial>(R.id.switch_theme)
        val cvAbout = findViewById<CardView>(R.id.cv_about)

        switchTheme.isChecked = pref.getBoolean("pref_is_dark_mode")

        switchTheme.setOnCheckedChangeListener { _, isChecked ->
            when (isChecked) {
                true -> {
                    pref.put("pref_is_dark_mode", true)
                    Log.d("theme", "current toggle ${pref.getBoolean("pref_is_dark_mode")}")
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                }
                false -> {
                    pref.put("pref_is_dark_mode", false)
                    Log.d("theme", "current toggle ${pref.getBoolean("pref_is_dark_mode")}")
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                }
            }
        }

        cvAbout.setOnClickListener {
            Intent(this, AboutActivity::class.java).also {
                startActivity(it)
            }
        }
    }
}