package com.example.match_point

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isGone
import com.example.match_point.databinding.ActivityMatchBinding
import kotlin.properties.Delegates


class MatchActivity : Activity() {

    private var tStart = System.currentTimeMillis()

    private lateinit var player1 : Player
    private lateinit var player2 : Player
    private lateinit var intArray : IntArray
    private lateinit var match: Match
    private lateinit var binding: ActivityMatchBinding
    private var goldPoint by Delegates.notNull<Boolean>()
    private var game by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMatchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        runMatch = true

        player1 = Player(0,5,1)
        player2 = Player(0,0,0)

        goldPoint = intent.getBooleanExtra("goldPoint", false)
        game = intent.getIntExtra("games",3)
        var service = intent.getIntExtra("service",0)
        match = Match(service, game, goldPoint)

        intArray = intArrayOf(0,0,service)

    }

    override fun onBackPressed() {}

    fun pointForMe(view: View) {
        intArray = match.point(player1, player2)
        when(intArray[0]) {
            0 -> translateAndShow()
            1 -> showBreak()
            2 -> finishGame()
        }
    }

    fun pointForRival(view: View) {
        intArray = match.point(player2, player1)
        when(intArray[0]) {
            0 -> translateAndShow()
            1 -> showBreak()
            2 -> finishGame()
        }

    }

    fun settingClick(view: View) {
        var time = System.currentTimeMillis()
        time = (time - tStart)/60000

        val intent = Intent(this, SettingActivity::class.java)
        intent.putExtra("side", intArray[1].toString())
        intent.putExtra("timePlayed", time.toString())
        intent.putExtra("service", intArray[2].toString())
        intent.putExtra("player", player1)
        intent.putExtra("player2", player2)
        intent.putExtra("games", game.toString())

        startActivity(intent)
    }

    private fun translateAndShow() {
        binding.mainLayout.isGone = false
        binding.tieBreakLayout.isGone = true
        binding.settingButton!!.isGone = false

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

    private fun showBreak() {
        binding.mainLayout.isGone = true
        binding.tieBreakLayout.isGone = false
        binding.settingButton!!.isGone = true

        binding.meTieBreak.text = player1.point.toString()
        binding.rivalTieBreak.text = player2.point.toString()
    }

    private fun finishGame() {
        //cambiar dependiendo de los juegos
        if (player1.game == 2) {
            Toast.makeText(this, R.string.end_game_victory, Toast.LENGTH_SHORT).show()
        } else
            Toast.makeText(this, R.string.end_game_faild, Toast.LENGTH_SHORT).show()
        runMatch = false
        finish()
        var intent = Intent(this, SettingActivity::class.java)
        startActivity(intent)
    }

}