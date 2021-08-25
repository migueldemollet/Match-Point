package com.example.match_point

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import com.example.match_point.databinding.ActivitySettingBinding
import com.example.match_point.setting_option.AboutActivity
import com.example.match_point.setting_option.HelpActivity
import com.example.match_point.setting_option.InfoActivity
import com.example.match_point.setting_option.ThemeActivity

var runMatch: Boolean = false

class SettingActivity: Activity() {

    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (runMatch) {
            binding.BtnNewMatch!!.isGone = true
            binding.BtnBackMatch!!.isGone = false
            binding.BtnInfo!!.isGone = false
        } else {
            binding.BtnInfo!!.isGone = true
            binding.BtnBackMatch!!.isGone = true
            binding.BtnNewMatch!!.isGone = false
        }
    }

    fun infoClick(view: View) {
        val intent2 = Intent(this, InfoActivity::class.java)

        intent2.putExtra("side", intent.getStringExtra("side"))
        intent2.putExtra("timePlayed", intent.getStringExtra("timePlayed"))
        intent2.putExtra("service", intent.getStringExtra("service"))
        intent2.putExtra("player", intent.getSerializableExtra("player"))
        intent2.putExtra("player2", intent.getSerializableExtra("player2"))
        intent2.putExtra("games", intent.getStringExtra("games"))

        startActivity(intent2)
    }

    fun themeClick(view: View) {
        val intent = Intent(this, ThemeActivity::class.java)
        startActivity(intent)
    }

    fun helpClick(view: View) {
        val intent = Intent(this, HelpActivity::class.java)
        startActivity(intent)
    }

    fun aboutClick(view: View) {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }

    fun exitClick(view: View) {
        System.exit(0)
    }

    fun newMatchClick(view: View) {
        val intent = Intent(this, OptionMatchActivity::class.java)
        startActivity(intent)
    }
    fun staticsClick(view: View) {
        val intent = Intent(this, StaticActivity::class.java)
        startActivity(intent)
    }

    fun backMatchClick(view: View) {
        onBackPressed()
    }
}