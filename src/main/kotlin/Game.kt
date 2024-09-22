package org.example

class Game (val player1: Player, val player2: Player) {
    private val board = Board()
    private var isEnded = false
    private val winningCombinations = listOf(
        listOf(0, 1, 2),
        listOf(3, 4, 5),
        listOf(6, 7, 8),

        listOf(0, 3, 6),
        listOf(1, 4, 7),
        listOf(2, 5, 8),

        listOf(0, 4, 8),
        listOf(2, 4, 6)
    )

    fun startGame() {
        board.printCurrentBoardState()
        while (true) {
            println("It's your move, ${player1.name}")
            val move = readLine()?.toIntOrNull()
            if (move == null) {
                println("Invalid move, please try again")
                continue
            }

            if (board.setCell(move, player1.symbol)) {
                player1.addMove(move)
                println("Your moves: ${player1.moves}")
                if (checkIfPlayerWon(player1)) {
                    isEnded = true
                    println("Congratulations ${player1.name}, you won!")
                    break
                }
                generateRandomMoveForPlayer(player2)
                println("${player2.name} moves: ${player2.moves}")
                if (checkIfPlayerWon(player2)) {
                    isEnded = true
                    println("Sorry this time, ${player2.name} won!")
                    break
                }
                if (board.checkIfBoardIsFull()) {
                    isEnded = true
                    println("It's a draw!")
                    break
                }
                board.printCurrentBoardState()
            }
        }
    }

    fun isGameEnded(): Boolean {
        return isEnded
    }

    private fun checkIfPlayerWon(player: Player): Boolean {
        val moves = player.moves
        if (moves.size < 3) {
            return false
        }

        // get all cells of the player
        val cells = board.getCells()

        // check if player won
        winningCombinations.forEach { combination ->
            val (a, b, c) = combination
            if (cells[a] == player.symbol && cells[b] == player.symbol && cells[c] == player.symbol) {
                return true
            }
        }

        return false;
    }

    private fun generateRandomMoveForPlayer(player2: Player): Int {
        if (board.checkIfBoardIsFull()) {
            return -1
        }
        val move = (0..8).random()
        if (!board.setCell(move, player2.symbol)) {
            return generateRandomMoveForPlayer(player2)
        }

        player2.addMove(move)
        return move
    }

}