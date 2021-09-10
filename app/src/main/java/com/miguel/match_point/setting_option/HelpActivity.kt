package com.miguel.match_point.setting_option

import android.app.Activity
import android.os.Bundle
import com.miguel.match_point.databinding.ActivityHelpBinding

class HelpActivity : Activity() {
    private lateinit var binding: ActivityHelpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHelpBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}