package com.miguel.match_point.setting_option

import android.app.Activity
import android.os.Bundle
import com.miguel.match_point.databinding.ActivityAboutBinding

class AboutActivity : Activity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}