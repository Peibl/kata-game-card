package com.kata

import com.kata.ui.Screen
import com.kata.useCases.StartGame
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifySequence
import org.junit.jupiter.api.Test

class AppShould {
    @Test
    fun `show a welcome message on start`(){
        val screen = mockk<Screen>(relaxed = true)
        val keyboard = mockk<Keyboard>(relaxed = true)
        val startGame = mockk<StartGame>(relaxed = true)

        App(screen, keyboard, startGame).run()

        verify { screen.printLine("Welcome to de jungle") }
    }

    @Test
    fun `start a new game when the user press any key after the welcome mesage`(){
        val screen = mockk<Screen>(relaxed = true)
        val keyboard = mockk<Keyboard>(relaxed = true)
        val startGame = mockk<StartGame>(relaxed = true)

        App(screen, keyboard, startGame).run()

        verifySequence {
            screen.printLine("Welcome to de jungle")
            keyboard.readKey()
            startGame.execute()
        }
    }
}
