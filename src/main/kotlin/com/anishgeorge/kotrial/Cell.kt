package com.anishgeorge.kotrial

data class Cell(private val alive: Boolean = false) {
    fun isAlive() = alive;

    companion object {
        fun alive() = Cell(true)
        fun dead() = Cell(false)
    }
}
