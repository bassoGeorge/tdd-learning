package com.anishgeorge.kotrial

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BasicsKtTest {

    @Test fun helloShouldReturnHelloWorld() {
        assertEquals("Hello World!", hello())
    }
}
