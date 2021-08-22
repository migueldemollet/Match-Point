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

        var player: Player = intent.getSerializableExtra("player") as Player
        var player2: Player = intent.getSerializableExtra("player2") as Player

        if (player.game == player2.game) {
            if (player.setPoint == player2.setPoint) {

                if (player.point == player2.point) {
                    binding.resultTextWinning.setText(R.string.text_equal)
                } else if (player.point > player2.point) {
                    binding.resultTextWinning.setText(R.string.text_you)
                } else {
                    binding.resultTextWinning.setText(R.string.text_rival)
                }
            } else if (player.setPoint > player2.setPoint) {
                binding.resultTextWinning.setText(R.string.text_you)
            } else {
                binding.resultTextWinning.setText(R.string.text_rival)
            }
        } else if (player.game > player2.game) {
            binding.resultTextWinning.setText(R.string.text_you)
        } else {
            binding.resultTextWinning.setText(R.string.text_rival)
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


        var pointWin = player.pointWin
        var pointLost = player.pointLost

        binding.resultPointWins.text = pointWin.toInt().toString()
        binding.resultPointLost.text = pointLost.toInt().toString()

        var total = pointWin+pointLost
        var result = String.format("%.2f",(pointWin / total)*100)
        binding.resultWL.text = result.toString()+"%"


    }
}