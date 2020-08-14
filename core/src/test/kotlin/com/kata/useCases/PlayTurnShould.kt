package com.kata.useCases

import com.kata.domain.Game
import com.kata.domain.Human
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class PlayTurnShould {
    @Test
    fun `decrease machine health in 5 when human card played is five`() {
        val game = Game(givenaHuman(mana = 6))
        PlayTurn(game).execute(5)

        Assertions.assertThat(game.machineHealth).isEqualTo(25)
    }

    @Test
    fun `decrease machine health in 5 when human card played are two and three`() {
        val game = Game(givenaHuman(mana = 6))
        PlayTurn(game).execute(2, 3)

        Assertions.assertThat(game.machineHealth).isEqualTo(25)
    }

    @Test
    fun `can't play without enough mana`() {
        val game = Game(givenaHuman(mana = 1))

        assertThrows<Error> { PlayTurn(game).execute(5) }
    }

    @Test
    fun `can't play a card with value higher than 8`() {
        val game = Game(givenaHuman(mana = 100000))

        assertThrows<Error> { PlayTurn(game).execute(555) }
    }

    private fun givenaHuman(mana: Int = 1): Human {
        val health = 30
        return Human(health, mana)
    }
}