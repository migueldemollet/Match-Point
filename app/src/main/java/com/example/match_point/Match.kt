package com.example.match_point


class Match(service: Int, sets: Int, goldPoint: Boolean) {
    private var isTieBreak = false
    private var state = 0
    private var side = 0
    private var service = service
    private val sets = sets
    private val goldPoint = goldPoint

    fun point(playerWin: Player, playerLost: Player) : IntArray {

        playerWin.addPoint()
        playerLost.addPointLost()
        changeSide()

        if (isTieBreak) {
            side = 0
            tieBreak(playerWin, playerLost)

        } else if (playerWin.point == 4 && playerWin.point - 1 > playerLost.point) {
            game(playerWin, playerLost)
            side = 0
            changeService()

        } else if (playerWin.point == 4 && playerLost.point == 4) {
            playerWin.point = 3
            playerLost.point = 3

        } else if (playerWin.point == 5 && playerLost.point == 3) {
            game(playerWin, playerLost)
            side = 0
            changeService()

        } else if (goldPoint && playerWin.point == 4 && playerLost.point == 3) {
            game(playerWin, playerLost)
            side = 0
            changeService()
        }

        when(sets) {
            3 -> {
                if (playerWin.setPoint == 2) {
                    state = 2
                }
            }
            5 -> {
                if (playerWin.setPoint == 3) {
                    state = 2
                }
            }
        }

        return intArrayOf(state, side, service)
    }

    private fun game(playerWin: Player, playerLost: Player): Unit {
        playerWin.addGame()
        playerLost.lostGame()

        if (playerWin.game >= 6 && playerWin.game - 2 >= playerLost.game) {
            playerWin.addSet()
            playerLost.lostSet()

        } else if (playerWin.game == 6 && playerLost.game == 6) {
            state = 1
            isTieBreak = true
            tieBreak(playerWin, playerLost)
        }

    }

    private fun tieBreak(playerWin: Player, playerLost: Player): Unit {

        if (playerWin.point >= 7 && playerWin.point - 2 >= playerLost.point) {
            playerWin.addGame()
            playerWin.addSet()
            playerLost.lostSet()
            isTieBreak = false
            state = 0
        }
    }

    private fun changeSide() : Unit {
        side = if (side == 0) {
            1
        } else
            0
    }

    private fun changeService() : Unit {
        service = if (service == 0) {
            1
        } else
            0
    }
}