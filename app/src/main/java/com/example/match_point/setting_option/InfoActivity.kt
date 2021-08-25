package com.example.match_point.setting_option

import android.app.Activity
import android.os.Bundle
import com.example.match_point.Player
import com.example.match_point.R
import com.example.match_point.databinding.ActivityInfoBinding

class InfoActivity : Activity() {

    private lateinit var binding: ActivityInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val player: Player = intent.getSerializableExtra("player") as Player
        val player2: Player = intent.getSerializableExtra("player2") as Player

        val pointWin = player.pointWin
        val pointLost = player.pointLost

        val total = pointWin+pointLost
        val result = String.format("%.2f",(pointWin / total)*100)

        setTextWinning(player.point, player2.point, player.setPoint, player2.setPoint, player.game, player2.game)

        when(intent.getStringExtra("games")) {
            "3"-> binding.textgamesToWin.setText(R.string.text_win_3_games)
            "5" -> binding.textgamesToWin.setText(R.string.text_win_5_games)
        }

        when(intent.getStringExtra("service")) {
            "0" -> binding.resultTextService.setText(R.string.text_you)
            "1" -> binding.resultTextService.setText(R.string.text_rival)
        }

        when(intent.getStringExtra("side")) {
            "0" -> binding.resultServiceSide.setText(R.string.text_right)
            "1" -> binding.resultServiceSide.setText(R.string.text_left)
        }

        binding.resultTimePlayed.text = intent.getStringExtra("timePlayed")+" min"
        binding.resultPointWins.text = pointWin.toInt().toString()
        binding.resultPointLost.text = pointLost.toInt().toString()
        binding.resultWL.text = result.toString()+"%"


    }

    private fun setTextWinning(point1: Int, point2: Int, set1: Int, set2: Int, game1: Int, game2: Int) :Unit {
        if (game1 == game2) {
            if (set1 == set2) {
                if (point1 == point2) {
                    binding.resultTextWinning.setText(R.string.text_equal)
                } else if (point1 > point2) {
                    binding.resultTextWinning.setText(R.string.text_you)
                } else {
                    binding.resultTextWinning.setText(R.string.text_rival)
                }
            } else if (set1 > set2) {
                binding.resultTextWinning.setText(R.string.text_you)
            } else {
                binding.resultTextWinning.setText(R.string.text_rival)
            }
        } else if (game1 > game2) {
            binding.resultTextWinning.setText(R.string.text_you)
        } else {
            binding.resultTextWinning.setText(R.string.text_rival)
        }
    }
}