package com.example.match_point

data class Player (var point:Int, var setPoint:Int, var game:Int = 0) {


    fun addPoint(): Unit {
        this.point += 1
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

}