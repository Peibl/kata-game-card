package com.kata.useCases

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class StartGameShould {
    @Test
    fun `return the health of the human player`() {
        val status = StartGame().execute()

        Assertions.assertThat(status.health).isEqualTo(30)
    }

    @Test
    fun `return the mana of the human player`() {
        val status = StartGame().execute()

        Assertions.assertThat(status.mana).isEqualTo(0)
    }

    @Test
    fun `return the initial hand of the human player`() {
        val status = StartGame().execute()

        Assertions.assertThat(status.cards.size).isEqualTo(3)
    }
    @Test
    fun `decrease the human desk in 3 cards`() {
        val status = StartGame().execute()

        Assertions.assertThat(status.remainingCards).isEqualTo(17)
    }
}
