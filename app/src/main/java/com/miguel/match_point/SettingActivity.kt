package com.miguel.match_point

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import com.miguel.match_point.databinding.ActivitySettingBinding
import com.miguel.match_point.setting_option.AboutActivity
import com.miguel.match_point.setting_option.HelpActivity
import com.miguel.match_point.setting_option.InfoActivity

var runMatch: Boolean = false

class SettingActivity: Activity() {

    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.dark)
        super.onCreate(savedInstanceState)

        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeView()

    }

    private fun changeView() : Unit {
        if (runMatch) {
            binding.BtnNewMatch!!.isGone = true
            binding.BtnBackMatch!!.isGone = false
            binding.BtnInfo!!.isGone = false
            binding.BtnExit.setText(R.string.button_cancel_match)
        } else {
            binding.BtnInfo!!.isGone = true
            binding.BtnBackMatch!!.isGone = true
            binding.BtnNewMatch!!.isGone = false
            binding.BtnExit.setText(R.string.button_Exit)
        }
    }

    fun infoClick(view: View) {
        val intent2 = Intent(this, InfoActivity::class.java)

        intent2.putExtra("side", intent.getStringExtra("side"))
        intent2.putExtra("timePlayed", intent.getStringExtra("timePlayed"))
        intent2.putExtra("service", intent.getStringExtra("service"))
        intent2.putExtra("player", intent.getSerializableExtra("player"))
        intent2.putExtra("player2", intent.getSerializableExtra("player2"))
        intent2.putExtra("sets", intent.getStringExtra("sets"))

        startActivity(intent2)
    }

    fun helpClick(view: View) {
        startActivity(Intent(this, HelpActivity::class.java))
    }

    fun aboutClick(view: View) {
        startActivity(Intent(this, AboutActivity::class.java))
    }

    fun exitClick(view: View) {
        if (runMatch) {
            runMatch = false
            recreate()
        } else {
            System.exit(0)
        }

    }

    fun newMatchClick(view: View) {
        startActivity(Intent(this, OptionMatchActivity::class.java))
    }

    fun backMatchClick(view: View) {
        onBackPressed()
    }
}