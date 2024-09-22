import org.example.Board
import org.example.Game
import org.example.Player
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GameTest {

    private lateinit var player1: Player
    private lateinit var player2: Player
    private lateinit var board: Board
    private lateinit var game: Game

    @BeforeEach
    fun setUp() {
        player1 = Player("Player1", 'X')
        player2 = Player("Player2", 'O')
        game = Game(player1, player2)
        board = game.getBoard()
    }

    @Test
    fun `test game initialization`() {
        assertFalse(game.isGameEnded())
    }

    @Test
    fun `test player1 wins`() {
        player1.addMove(0)
        player1.addMove(1)
        player1.addMove(2)
        board.setCell(0, 'X')
        board.setCell(1, 'X')
        board.setCell(2, 'X')

        assertTrue(game.checkIfPlayerWon(player1))
        assertFalse(game.checkIfPlayerWon(player2))
    }

    @Test
    fun `test player2 wins`() {
        player2.addMove(3)
        player2.addMove(4)
        player2.addMove(5)
        board.setCell(3, 'O')
        board.setCell(4, 'O')
        board.setCell(5, 'O')

        assertTrue(game.checkIfPlayerWon(player2))
        assertFalse(game.checkIfPlayerWon(player1))
    }

    @Test
    fun `test game draw`() {
        // Fill the board to simulate a draw
        for (i in 0..8) {
            board.setCell(i, if (i % 2 == 0) 'X' else 'O')
        }

        assertFalse(game.checkIfPlayerWon(player2))
        assertFalse(game.checkIfPlayerWon(player1))
        assertTrue(board.checkIfBoardIsFull())
    }

    @Test
    fun `test invalid move`() {
        assertFalse(board.setCell(10, 'X'))
    }
}
