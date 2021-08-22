package com.example.match_point

import java.io.Serializable

class Player (var point:Int, var setPoint:Int, var game:Int = 0) : Serializable {

    var pointWin = 0.0f
    var pointLost = 0.0f

    fun addPoint(): Unit {
        this.point += 1
        this.pointWin +=1.0f
    }

    fun addSet(playerLost: Player): Unit {
        this.setPoint += 1
        this.point = 0
        playerLost.point = 0
    }

    fun addGame(playerLost: Player): Unit {
        this.game += 1
        this.point = 0
        this.setPoint = 0
        playerLost.point = 0
        playerLost.setPoint = 0
    }

    fun addPointLost() : Unit {
        this.pointLost += 1.0f
    }

}