package com.example.match_point

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.match_point.databinding.ActivityMainBinding

class MainActivity : Activity() {

    var player1:Player = Player(0,0,0)
    var player2:Player = Player(0,0,0)
    var match:Match = Match()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var textPoint = findViewById(R.id.myPoint) as TextView
        var textRivalPoint = findViewById(R.id.rivalPoint) as TextView
        var textSetPoint = findViewById(R.id.mySet) as TextView
        var textRivalSetPoint = findViewById(R.id.rivalSet) as TextView
        var textMyGame = findViewById(R.id.myGame) as TextView
        var textRivalGame = findViewById(R.id.rivalGame) as TextView
        var pointForMy = findViewById<Button>(R.id.me)
        var pointForRival = findViewById<Button>(R.id.rival)

        var enable:Boolean = false
        //functions click
        pointForMy.setOnClickListener {
            match.point(player1, player2)
            enable = true
        }

        pointForRival.setOnClickListener {
            match.point(player2, player1)
            enable = true
        }


        if (enable) {
            when(player1.point) {
                0 -> textPoint.text ="0"
                1 -> textPoint.text ="15"
                2 -> textPoint.text ="30"
                3 -> textPoint.text ="40"
                4 -> textPoint.text ="AD"
            }
            when(player2.point) {
                0 -> textRivalPoint.text ="0"
                1 -> textRivalPoint.text ="15"
                2 -> textRivalPoint.text ="30"
                3 -> textRivalPoint.text ="40"
                4 -> textRivalPoint.text ="AD"
            }
            textSetPoint.setText(player1.setPoint)
            textRivalSetPoint.setText(player2.setPoint)
            textMyGame.setText(player1.game)
            textRivalGame.setText(player2.game)
            enable = false
        }

    }
}