package com.anishgeorge.tdd.money

interface Expression {
    fun reduce(to: String): Money
}
