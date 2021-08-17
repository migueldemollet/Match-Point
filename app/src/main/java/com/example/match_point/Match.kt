package com.example.match_point


class Match() {
    var isTieBreak = false
    var state = 0

    fun point(playerWin: Player, playerLost: Player) : Int {
        playerWin.addPoint()

        if (isTieBreak) {
          tieBreak(playerWin, playerLost)

        } else if (playerWin.point == 4 && playerWin.point - 1 > playerLost.point) {
            set(playerWin, playerLost)

        } else if (playerWin.point == 4 && playerLost.point == 4) {
            playerWin.point = 3
            playerLost.point = 3

        } else if (playerWin.point == 5 && playerLost.point == 3) {
            set(playerWin, playerLost)
        }

        if (playerWin.game == 2) {
            state = 2
        }
        return state
    }

    private fun set(playerWin: Player, playerLost: Player): Unit {
        playerWin.addSet(playerLost)

        if (playerWin.setPoint == 6 && playerWin.setPoint - 2 >= playerLost.setPoint) {
            game(playerWin, playerLost)

        } else if (playerWin.setPoint == 6 && playerLost.setPoint == 6) {
            state = 1
            isTieBreak = true
            tieBreak(playerWin, playerLost)

        }

    }

    private fun game(playerWin: Player, playerLost: Player): Unit {
        playerWin.addGame(playerLost)

        if (playerWin.game == 1 && playerLost.game == 1) {
            state = 1
            isTieBreak = true
            tieBreak(playerWin, playerLost)
        }
    }

    private fun tieBreak(playerWin: Player, playerLost: Player): Unit {

        if (playerWin.point >= 7 && playerWin.point - 2 >= playerLost.point) {
            game(playerWin, playerLost)
            isTieBreak = false
            state = 0
        }
    }
}