package com.kata

import com.kata.ui.Screen
import com.kata.useCases.StartGame

class App(private val screen: Screen, private val keyboard: Keyboard, private val startGame: StartGame) {
    fun run() {
        screen.printLine("Welcome to de jungle")
        keyboard.readKey()
        startGame.execute()
    }
}
