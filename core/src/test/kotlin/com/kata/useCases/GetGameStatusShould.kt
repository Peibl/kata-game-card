package com.kata.useCases

import com.kata.domain.*
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class GetGameStatusShould {
    @Test
    fun `return the health of the human player`() {
        val humanHealth = 20
        val games = Games(Game(Human(0, humanHealth, Deck()), Machine()))

        val status = GetGameStatus(games).execute()

        Assertions.assertThat(status.human.health).isEqualTo(humanHealth)
    }

    @Test
    fun `return the mana of the human player`() {
        val humanMana = 0
        val games = Games(Game(Human(0, 30, Deck()), Machine()))

        val status = GetGameStatus(games).execute()

        Assertions.assertThat(status.human.mana).isEqualTo(humanMana)
    }

    @Test
    fun `return the hand of the human player`() {
        val humanRemainingCards = 5
        val games = Games(Game(Human(0, 30, Deck()), Machine()))

        val status = GetGameStatus(games).execute()

        Assertions.assertThat(status.human.remainingCards).isEqualTo(humanRemainingCards)
    }
//
//    @Test
//    fun `decrease the human deck in 3 cards`() {
//        val status = GetGameStatus().execute()
//
//        Assertions.assertThat(status.human.remainingCards).isEqualTo(17)
//    }
}
