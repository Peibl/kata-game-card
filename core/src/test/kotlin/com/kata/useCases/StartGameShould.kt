package com.kata.useCases

import com.kata.domain.CurrentGame
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class StartGameShould {
    @Test
    fun `return the health of the human player`() {
        val currentGame = CurrentGame()

        StartGame(currentGame).execute()

        Assertions.assertThat(currentGame.current).isNotNull()
    }
}
