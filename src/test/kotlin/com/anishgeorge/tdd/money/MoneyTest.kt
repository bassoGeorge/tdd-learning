package com.anishgeorge.tdd.money

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MoneyTest {

    @Test fun shouldPerformMultiplication() {
        val five = Money.dollar(5)
        assertEquals(Money.dollar(5), five)
        assertEquals(Money.dollar(10), five.times(2))
        assertEquals(Money.dollar(15), five.times(3))
    }

    @Test fun shouldImplementEquality() {
        assertTrue(Money.dollar(5) == Money.dollar(5))
        assertTrue(Money.dollar(5) != Money.dollar(10))
        assertTrue(Money.franc(5) != Money.dollar(5))
    }

    @Test fun shouldDescribeCurrency() {
        assertEquals("USD", Money.dollar(1).currency())
        assertEquals("CHF", Money.franc(1).currency())
    }

    @Test fun shouldImplementBasicAddition() {
        val five = Money.dollar(5)
        val sum = five.plus(five)
        val bank = Bank()
        val reduced = bank.reduce(sum, "USD")
        assertEquals(Money.dollar(10), reduced)
    }

    @Test fun shouldImplementBasicAdditionReturningASum() {
        val five = Money.dollar(5)
        val result: Expression = five.plus(five)
        val sum = result as Sum
        assertEquals(five, sum.augend)
        assertEquals(five, sum.addend)
    }

    @Test fun shouldCorrectlyGetReduceImplementationByBank() {
        val sum = Money.dollar(4).plus(Money.dollar(3))
        val bank = Bank()
        val result = bank.reduce(sum, "USD")
        assertEquals(Money.dollar(7), result)
    }

    @Test fun shouldGetBankReduceOnMoney() {
        val bank = Bank()
        val result = bank.reduce(Money.dollar(5), "USD")
        assertEquals(Money.dollar(5), result)
    }

    @Test fun shouldGetBankReduceOnDifferentCurrency() {
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result = bank.reduce(Money.franc(2), "USD")
        assertEquals(Money.dollar(1), result)
    }

    @Test fun identityRate() {
        assertEquals(1, Bank().rate("USD", "USD"))
    }

    @Test fun mixedCurrencyAddition() {
        val fiveBucks = Money.dollar(5)
        val tenFrancs = Money.franc(10)
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        assertEquals(Money.dollar(10), bank.reduce(fiveBucks.plus(tenFrancs), "USD"))
    }

}
