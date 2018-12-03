package com.anishgeorge.tdd.money

interface Expression {
    fun reduce(bank: Bank, to: String): Money
}
