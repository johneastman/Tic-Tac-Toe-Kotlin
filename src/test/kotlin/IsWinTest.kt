import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class IsWinTest {

    @Test
    fun testIsWinDiagonalTopLeftBottomRight() {
        var board = resetBoard()
        var piece = "X"
        updateBoard(0, piece, board)
        updateBoard(4, piece, board)
        updateBoard(8, piece, board)

        assertTrue(isWin(piece, board))
    }

    @Test
    fun testIsWinDiagonalTopRightBottomLeft() {
        var board = resetBoard()
        var piece = "O"
        updateBoard(2, piece, board)
        updateBoard(4, piece, board)
        updateBoard(6, piece, board)

        assertTrue(isWin(piece, board))
    }

    @Test
    fun testIsWinHorizontalTop() {
        var board = resetBoard()
        var piece = "X"
        updateBoard(0, piece, board)
        updateBoard(1, piece, board)
        updateBoard(2, piece, board)

        assertTrue(isWin(piece, board))
    }

    @Test
    fun testIsWinHorizontalMiddle() {
        var board = resetBoard()
        var piece = "O"
        updateBoard(3, piece, board)
        updateBoard(4, piece, board)
        updateBoard(5, piece, board)

        assertTrue(isWin(piece, board))
    }

    @Test
    fun testIsWinHorizontalBottom() {
        var board = resetBoard()
        var piece = "X"
        updateBoard(6, piece, board)
        updateBoard(7, piece, board)
        updateBoard(8, piece, board)

        assertTrue(isWin(piece, board))
    }

    @Test
    fun testIsWinVerticalLeft() {
        var board = resetBoard()
        var piece = "O"
        updateBoard(0, piece, board)
        updateBoard(3, piece, board)
        updateBoard(6, piece, board)

        assertTrue(isWin(piece, board))
    }

    @Test
    fun testIsWinVerticalMiddle() {
        var board = resetBoard()
        var piece = "X"
        updateBoard(1, piece, board)
        updateBoard(4, piece, board)
        updateBoard(7, piece, board)

        assertTrue(isWin(piece, board))
    }

    @Test
    fun testIsWinVerticalRight() {
        var board = resetBoard()
        var piece = "O"
        updateBoard(2, piece, board)
        updateBoard(5, piece, board)
        updateBoard(8, piece, board)

        assertTrue(isWin(piece, board))
    }
}