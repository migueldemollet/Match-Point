package com.example.match_point

import com.example.match_point.Player

class Match {

    fun point(playerWin: Player, playerLost: Player) {
        playerWin.addPoint()

        if (playerWin.point == 4 && playerWin.point - 1 > playerLost.point) {
            set(playerWin, playerLost)

        } else if (playerWin.point == 4 && playerLost.point == 4) {
            playerWin.point = 3
            playerLost.point = 3

        } else if (playerWin.point == 5 && playerLost.point == 3) {
            set(playerWin, playerLost)
        }

    }

    private fun set(playerWin: Player, playerLost: Player): Unit {
        playerWin.addSet(playerLost)

        if (playerWin.setPoint == 6 && playerWin.setPoint - 2 >= playerLost.setPoint) {
            game(playerWin, playerLost)

        } else if (playerWin.setPoint == 6 && playerLost.setPoint == 6) {
        // breakpoint
        }

    }

    private fun game(playerWin: Player, playerLost: Player): Unit {
        playerWin.addGame(playerLost)

        if (playerWin.game == 2 && playerLost.game == 1) {
            // win
        } else if (playerWin.game == 1 && playerLost.game == 1) {
            //breakpoint
        }
    }
}