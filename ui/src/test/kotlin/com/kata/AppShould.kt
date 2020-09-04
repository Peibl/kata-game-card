package com.kata

import com.kata.domain.GameStatus
import com.kata.domain.Hand
import com.kata.domain.HumanStatus
import com.kata.domain.MachineStatus
import com.kata.ui.Screen
import com.kata.useCases.GetGameStatus
import com.kata.useCases.StartGame
import io.mockk.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class AppShould {
    @Test
    fun `show a welcome message on start`() {
        app.run()

        verify { screen.printLine("Welcome to the Game, press any key to start") }
    }

    @Test
    fun `start a new game when the user press any key after the welcome message`() {
        app.run()

        verifyOrder {
            screen.printLine("Welcome to the Game, press any key to start")
            keyboard.readKey()
            startGame.execute()
        }
    }

    @Test
    fun `show the initial health after create a game`() {
        val initialHealth = 35
        every { getGameStatus.execute() } returns statusWith(initialHealth)

        app.run()

        verifyOrder {
            startGame.execute()
            screen.printLine("Health: $initialHealth")
        }
    }

    @Test
    fun `show the initial mana after create a game`() {
        val initialMana = 0
        every { getGameStatus.execute() } returns statusWith(initialMana = initialMana)

        app.run()

        verifyOrder {
            startGame.execute()
            screen.printLine("Mana: $initialMana")
        }
    }

    @Test
    fun `show the initial hand after create a game`() {
        val cards = mutableListOf(5, 3, 2)
        every { getGameStatus.execute() } returns statusWith(hand = Hand(cards))

        app.run()

        verify { screen.printLine("Card 1: 5") }
        verify { screen.printLine("Card 2: 3") }
        verify { screen.printLine("Card 3: 2") }
    }

    @BeforeEach
    fun init() {
        every { getGameStatus.execute() } returns statusWith()
        every { getGameStatus.execute() } returns statusWith()
    }

    private fun statusWith(
        initialHealth: Int = 30,
        initialMana: Int = 0,
        hand: Hand = Hand(mutableListOf(1, 1, 1)),
        remainingCards: Int = 0
    ): GameStatus {
        val humanStatus = HumanStatus(initialHealth, initialMana, hand, remainingCards)
        val machineStatus = MachineStatus(initialHealth)
        return GameStatus(humanStatus, machineStatus)
    }

    private val screen = mockk<Screen>(relaxed = true)
    private val keyboard = mockk<Keyboard>(relaxed = true)
    private val startGame = mockk<StartGame>(relaxed = true)
    private val getGameStatus = mockk<GetGameStatus>(relaxed = true)
    private val app = App(screen, keyboard, startGame, getGameStatus)
}
