package com.example.match_point

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.match_point.databinding.ActivityMainBinding

class MainActivity : Activity() {

    var player1 = Player(0,0,0)
    var player2 = Player(0,0,0)
    var match = Match()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun pointForMe(view: View) {
        match.point(player1, player2)
        translateAndShow()
        println("caca")
    }

    fun pointForRival(view: View) {
        match.point(player2, player1)
        translateAndShow()
        println("caca2")
    }

    private fun translateAndShow() {
        when(player1.point) {
            0 -> binding.myPoint.text ="0"
            1 -> binding.myPoint.text ="15"
            2 -> binding.myPoint.text ="30"
            3 -> binding.myPoint.text ="40"
            4 -> binding.myPoint.text ="AD"
        }
        when(player2.point) {
            0 -> binding.rivalPoint.text ="0"
            1 -> binding.rivalPoint.text ="15"
            2 -> binding.rivalPoint.text ="30"
            3 -> binding.rivalPoint.text ="40"
            4 -> binding.rivalPoint.text ="AD"
        }
        binding.mySet.text = player1.setPoint.toString()
        binding.rivalSet.text = player2.setPoint.toString()
        binding.myGame.text = player1.game.toString()
        binding.rivalGame.text = player2.game.toString()
    }
}