package com.anishgeorge.tdd.money

class Bank {
    fun reduce(expression: Expression, to: String): Money {
        return expression.reduce(to)
    }
}
