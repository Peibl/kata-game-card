package com.kata.domain

data class Hand(val cards: MutableList<Int> = mutableListOf()) {

    fun addAll(pickCards: List<Int>) {
        cards.addAll(pickCards)
    }
}
