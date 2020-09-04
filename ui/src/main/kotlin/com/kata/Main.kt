package com.kata

import com.kata.domain.CurrentGame
import com.kata.useCases.GetGameStatus
import com.kata.useCases.StartGame

fun main(){
    val currentGame = CurrentGame()
    App(SystemScreen(), SystemKeyboard(), StartGame(currentGame), GetGameStatus(currentGame)).run()
}
