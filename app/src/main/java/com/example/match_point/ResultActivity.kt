package com.example.match_point

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.match_point.databinding.ActivityResultBinding
import android.view.View


class ResultActivity : Activity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val player: Player = intent.getSerializableExtra("player") as Player
        val player2: Player = intent.getSerializableExtra("player2") as Player

        if (intent.getIntExtra("winner",0) == 0) {
            binding.textResult.setText(R.string.end_game_victory)
        } else {
            binding.textResult.setText(R.string.end_game_faild)
        }

        binding.textYou1.text = player.games[0].toString()
        binding.textYou2.text = player.games[1].toString()

        binding.textOponent1.text = player2.games[0].toString()
        binding.textOponent2.text = player2.games[1].toString()

        when (player.games.size) {
            3 -> setScoreboard3(player, player2)
            4 -> setScoreboard4(player, player2)
            5 -> setScoreboard5(player, player2)
        }

        binding.resultTotalPoints.text = (player.pointWin + player.pointLost).toInt().toString()

    }

    private fun setScoreboard3(player: Player, player2: Player) : Unit {
        binding.textYou3.text = player.games[2].toString()
        binding.textOponent3.text = player2.games[2].toString()

    }

    private fun setScoreboard4(player: Player, player2: Player) : Unit {
        setScoreboard3(player, player2)
        binding.textYou4.text = player.games[3].toString()
        binding.textOponent4.text = player2.games[3].toString()

    }

    private fun setScoreboard5(player: Player, player2: Player) : Unit {
        setScoreboard4(player, player2)
        binding.textYou5.text = player.games[4].toString()
        binding.textOponent5.text = player2.games[4].toString()

    }

    fun bacMenuClick(view: View) {
        finish()
        startActivity(Intent(this, SettingActivity::class.java))
    }
}