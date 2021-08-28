package com.example.match_point

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.match_point.databinding.ActivityOptionMatchBinding

class OptionMatchActivity : Activity() {

    private lateinit var binding: ActivityOptionMatchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOptionMatchBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun startClick(view: View) {
        val intent = Intent(this, MatchActivity::class.java)
        prepareIntent(intent)
        startActivity(intent)
    }

    fun cancelClick(view: View) {
        onBackPressed()
    }

    private fun prepareIntent(intent: Intent) : Unit {
        if (binding.switchMaxSets!!.isChecked) {
            intent.putExtra("sets",5)
        } else {
            intent.putExtra("sets",3)
        }
        if (binding.switchStartService!!.isChecked) {
            intent.putExtra("service",1)
        } else {
            intent.putExtra("service",0)
        }
        if (binding.checkBoxGoldPoint!!.isChecked) {
            intent.putExtra("goldPoint", true)
        } else {
            intent.putExtra("goldPoint", false)
        }
    }
}