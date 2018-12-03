package com.anishgeorge.tdd.money

class Bank {
    val rates = hashMapOf<Pair, Int>()

    fun reduce(expression: Expression, to: String): Money {
        return expression.reduce(this, to)
    }

    fun addRate(from: String, to: String, value: Int) {
        rates[Pair(from, to)] = value
    }

    fun rate(from: String, to: String): Int {
        return if(from == to) 1 else rates.getOrDefault(Pair(from, to), 0) // TODO: should we return zero?
    }
}
