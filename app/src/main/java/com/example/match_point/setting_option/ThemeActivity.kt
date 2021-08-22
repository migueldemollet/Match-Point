package com.example.match_point.setting_option

import android.app.Activity
import android.os.Bundle
import com.example.match_point.databinding.ActivityThemeBinding

class ThemeActivity : Activity() {

    private lateinit var binding: ActivityThemeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThemeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}