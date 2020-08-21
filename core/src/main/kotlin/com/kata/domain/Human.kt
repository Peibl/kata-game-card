package com.kata.domain

class Human(private var health: Int, val mana: Int) {
    private var hand = mutableListOf<Int>()

    fun pickCards(desk: MutableList<Int>) {
        pickRandomCard(desk)
        pickRandomCard(desk)
        pickRandomCard(desk)
    }

    fun getStatus() = HumanStatus(health, mana, hand)

    private fun pickRandomCard(desk: MutableList<Int>) {
        val card = desk.random()
        hand.add(card)
        desk.remove(card)
    }

    fun playCards(cardValues: List<Int>): Int {
        if(cardValues.any { it > 8 }) throw Error()
        val cardValue = cardValues.sumBy { it }
        if (mana < cardValue) throw Error()
        return cardValue
    }
}
