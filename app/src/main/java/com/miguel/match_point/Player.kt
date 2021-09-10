package com.miguel.match_point

import java.io.Serializable

class Player (var point:Int, var game:Int, var setPoint:Int) : Serializable {

    var pointWin = 0.0f
    var pointLost = 0.0f
    val games: MutableList<Int> = ArrayList()

    fun addPoint(): Unit {
        this.point += 1
        this.pointWin +=1.0f
    }

    fun addGame(): Unit {
        this.game += 1
        this.point = 0
    }

    fun lostGame() {
        this.point = 0
    }

    fun addSet(): Unit {
        this.setPoint += 1
        this.point = 0
        saveGames()
        this.game = 0
    }

    fun lostSet() {
        this.point = 0
        saveGames()
        this.game = 0
    }

    fun addPointLost() : Unit {
        this.pointLost += 1.0f
    }

    private fun saveGames() : Unit {
        this.games.add(this.game)
    }

}