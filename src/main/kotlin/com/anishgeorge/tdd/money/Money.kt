package com.anishgeorge.tdd.money

data class Money(val amount: Int, protected val currency: String) : Expression {

    override fun equals(other: Any?): Boolean {
        return other is Money
                && currency == other.currency
                && amount == other.amount
    }

    override fun toString(): String = "$amount $currency"

    fun times(multiplier: Int): Money? = Money(amount * multiplier, currency)
    fun currency() = currency

    fun plus(other: Money): Expression = Sum(this, other)

    override fun reduce(to: String): Money = this

    companion object {
        fun dollar(amount: Int): Money = Money(amount, "USD")
        fun franc(amount: Int): Money = Money(amount, "CHF")
    }
}
