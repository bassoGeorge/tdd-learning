package com.anishgeorge.tdd.money

data class Money(val amount: Int, protected val currency: String) : Expression {

    override fun equals(other: Any?): Boolean {
        return other is Money
                && currency == other.currency
                && amount == other.amount
    }

    override fun toString(): String = "$amount $currency"

    override fun times(multiplier: Int): Expression = Money(amount * multiplier, currency)
    fun currency() = currency

    override fun plus(addend: Expression): Expression = Sum(this, addend)

    override fun reduce(bank: Bank, to: String): Money {
        val rate = bank.rate(currency, to)
        return Money(amount / rate, to)
    }

    companion object {
        fun dollar(amount: Int): Money = Money(amount, "USD")
        fun franc(amount: Int): Money = Money(amount, "CHF")
    }
}
