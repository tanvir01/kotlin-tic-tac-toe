package org.example

class Board {
    private val cells = Array(9) { '_' }

    fun getCells(): Array<Char> {
        return cells
    }

    fun getCell(index: Int): Char {
        return cells[index]
    }

    fun checkIfCellIsOccupied(index: Int): Boolean {
        return getCell(index) != '_'
    }

    fun setCell(index: Int, value: Char): Boolean {
        if (index < 0 || index > 8) {
            println("Invalid cell index")
            return false
        }

        if (checkIfCellIsOccupied(index)) {
            println("Cell is already occupied")
            return false
        }

        cells[index] = value
        return true
    }

    fun checkIfBoardIsFull(): Boolean {
        return cells.all { it != '_' }
    }

    fun printCurrentBoardState() {
        println("-----------")
        println("| ${cells[0]}  ${cells[1]}  ${cells[2]} |")
        println("| ${cells[3]}  ${cells[4]}  ${cells[5]} |")
        println("| ${cells[6]}  ${cells[7]}  ${cells[8]} |")
        println("-----------")
    }
}