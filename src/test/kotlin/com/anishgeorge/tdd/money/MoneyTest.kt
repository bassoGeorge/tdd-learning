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
}