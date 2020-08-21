package com.kata.useCases

import com.kata.domain.Game
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class PlayTurnShould {
    @Test
    fun `decrease machine health in 5 when human card played is five`() {
        val game = Game(6)
        PlayTurn(game).execute(listOf(5))

        Assertions.assertThat(game.getStatus().machineStatus.health).isEqualTo(25)
    }

    @Test
    fun `decrease machine health in 5 when human card played are two and three`() {
        val game = Game(6)
        PlayTurn(game).execute(listOf(2, 3))

        Assertions.assertThat(game.getStatus().machineStatus.health).isEqualTo(25)
    }

    @Test
    fun `can't play without enough mana`() {
        val game = Game(1)

        assertThrows<Error> { PlayTurn(game).execute(listOf(5) )}
    }

    @Test
    fun `can't play a card with value higher than 8`() {
        val game = Game(100000)

        assertThrows<Error> { PlayTurn(game).execute(listOf(555) )}
    }
}
