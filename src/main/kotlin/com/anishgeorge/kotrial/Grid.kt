package com.anishgeorge.kotrial

class Grid(private val rows: Int, private val cols: Int) {
    private val data = ArrayList<ArrayList<Cell>>()

    init {
        for (i in IntRange(1, rows)) {
            val row = ArrayList<Cell>()
            for (j in IntRange(1, cols)) {
                row.add(Cell.alive())
            }
            data.add(row)
        }
    }
}
