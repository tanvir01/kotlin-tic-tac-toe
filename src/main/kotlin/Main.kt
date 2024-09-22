package org.example

fun main() {

    // show welcome message for TIC-TAC-TOE game
    println("Welcome to TIC-TAC-TOE game!")
    println("Pick a number from 0-8")

    // take user input for name
    var name: String?
    while (true) {
        println("Enter your name:")
        name = readlnOrNull()
        if (name.isNullOrEmpty()) {
            println("Invalid name")
            continue
        }
        break
    }

    // create 2 Players
    val player1 = Player(name.toString(), 'X')
    val player2 = Player("COMPUTER", 'O')


    // start game
    val game = Game(player1, player2)
    game.startGame()
    if (game.isGameEnded()) {
        println("Do you want to play again? (yes/no)")
        val playAgain = readlnOrNull() ?: "no"
        if (playAgain.equals("yes", ignoreCase = true)) {
            main()
        }
    }

}