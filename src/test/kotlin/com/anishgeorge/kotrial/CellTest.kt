package com.anishgeorge.kotrial

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CellTest {
    @Test fun cellShouldHaveDefaultState() {
        val cell = Cell(false);
        assertFalse(cell.isAlive())
    }
}
