package com.kata.domain

class Player(private val mana: Int, private val health: Int, private val deck: Deck, private val hand: Hand) {

    fun pickCards(amount: Int) {
        hand.addAll(deck.pickCards(amount))
    }

    fun getStatus() = HumanStatus(health, mana, hand, deck.size())

    fun playCards(cardValues: List<Int>): Int {
        if(cardValues.any { it > 8 }) throw Error()
        val cardValue = cardValues.sumBy { it }
        if (mana < cardValue) throw Error()
        return cardValue
    }
}
