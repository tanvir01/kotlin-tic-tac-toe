package org.example

class Player(val name: String, val symbol: Char) {
    internal val moves = mutableListOf<Int>()

    fun addMove(move: Int) {
        moves.add(move)
    }
}