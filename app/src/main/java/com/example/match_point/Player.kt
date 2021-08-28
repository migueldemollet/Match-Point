package com.example.match_point

import java.io.Serializable

class Player (var point:Int, var game:Int, var setPoint:Int) : Serializable {

    var pointWin = 0.0f
    var pointLost = 0.0f

    fun addPoint(): Unit {
        this.point += 1
        this.pointWin +=1.0f
    }

    fun addGame(playerLost: Player): Unit {
        this.game += 1
        this.point = 0
        playerLost.point = 0
    }

    fun addSet(playerLost: Player): Unit {
        this.setPoint += 1
        this.point = 0
        this.game = 0
        playerLost.point = 0
        playerLost.game = 0
    }

    fun addPointLost() : Unit {
        this.pointLost += 1.0f
    }

}