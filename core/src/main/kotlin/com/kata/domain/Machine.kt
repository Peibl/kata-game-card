package com.kata.domain

class Machine(var health: Int) {
    fun reduceHealth(damage: Int) {
        health -= damage
    }

    fun getStatus() = MachineStatus(health)
}
