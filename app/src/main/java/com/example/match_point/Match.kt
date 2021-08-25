package com.example.match_point


class Match(service: Int, games: Int, goldPoint: Boolean) {
    var isTieBreak = false
    var state = 0
    var side = 0
    var service = service
    var games = games
    var goldPoint = goldPoint

    fun point(playerWin: Player, playerLost: Player) : IntArray {

        playerWin.addPoint()
        playerLost.addPointLost()
        changeSide()

        if (isTieBreak) {
            side = 0
            tieBreak(playerWin, playerLost)

        } else if (playerWin.point == 4 && playerWin.point - 1 > playerLost.point) {
            set(playerWin, playerLost)
            side = 0
            changeService()

        } else if (playerWin.point == 4 && playerLost.point == 4) {
            playerWin.point = 3
            playerLost.point = 3

        } else if (playerWin.point == 5 && playerLost.point == 3) {
            set(playerWin, playerLost)
            side = 0
            changeService()

        } else if (goldPoint && playerWin.point == 4 && playerLost.point == 3) {
            set(playerWin, playerLost)
            side = 0
            changeService()
        }

        when(games) {
            3 -> {
                if (playerWin.game == 2) {
                    state = 2
                }
            }
            5 -> {
                if (playerWin.game == 3) {
                    state = 2
                }
            }
        }

        return intArrayOf(state, side, service)
    }

    private fun set(playerWin: Player, playerLost: Player): Unit {
        playerWin.addSet(playerLost)

        if (playerWin.setPoint == 6 && playerWin.setPoint - 2 >= playerLost.setPoint) {
            game(playerWin, playerLost)

        } else if (playerWin.setPoint == 7 && playerLost.setPoint == 6) {
            game(playerWin, playerLost)

        }

    }

    private fun game(playerWin: Player, playerLost: Player): Unit {
        playerWin.addGame(playerLost)
        when(games) {
            3-> {
                if (playerWin.game == 1 && playerLost.game == 1) {
                    state = 1
                    isTieBreak = true
                    tieBreak(playerWin, playerLost)
                }
            }
            5 -> {
                if (playerWin.game == 2 && playerLost.game == 2) {
                    state = 1
                    isTieBreak = true
                    tieBreak(playerWin, playerLost)
                }
            }
        }
    }

    private fun tieBreak(playerWin: Player, playerLost: Player): Unit {

        if (playerWin.point >= 7 && playerWin.point - 2 >= playerLost.point) {
            game(playerWin, playerLost)
            isTieBreak = false
            state = 0
        }
    }

    private fun changeSide() : Unit {
        if (side == 0) {
            side = 1
        } else
            side = 0
    }

    private fun changeService() : Unit {
        if (service == 0) {
            service = 1
        } else
            service = 0
    }
}