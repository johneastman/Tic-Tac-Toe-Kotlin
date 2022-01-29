import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

internal class UpdateBoardTest {

    @Test
    fun testUpdateBoard0() {
        val board = resetBoard()
        val piece = "X"
        updateBoard(0, piece, board)
        assertEquals(piece, board[0][0])
    }

    @Test
    fun testUpdateBoard1() {
        val board = resetBoard()
        val piece = "O"
        updateBoard(1, piece, board)
        assertEquals(piece, board[0][1])
    }

    @Test
    fun testUpdateBoard2() {
        val board = resetBoard()
        val piece = "X"
        updateBoard(2, piece, board)
        assertEquals(piece, board[0][2])
    }

    @Test
    fun testUpdateBoard3() {
        val board = resetBoard()
        val piece = "O"
        updateBoard(3, piece, board)
        assertEquals(piece, board[1][0])
    }

    @Test
    fun testUpdateBoard4() {
        val board = resetBoard()
        val piece = "X"
        updateBoard(4, piece, board)
        assertEquals(piece, board[1][1])
    }

    @Test
    fun testUpdateBoard5() {
        val board = resetBoard()
        val piece = "O"
        updateBoard(5, piece, board)
        assertEquals(piece, board[1][2])
    }

    @Test
    fun testUpdateBoard6() {
        val board = resetBoard()
        val piece = "X"
        updateBoard(6, piece, board)
        assertEquals(piece, board[2][0])
    }

    @Test
    fun testUpdateBoard7() {
        val board = resetBoard()
        val piece = "O"
        updateBoard(7, piece, board)
        assertEquals(piece, board[2][1])
    }

    @Test
    fun testUpdateBoard8() {
        val board = resetBoard()
        val piece = "X"
        updateBoard(8, piece, board)
        assertEquals(piece, board[2][2])
    }

    @Test
    fun testUpdateBoardInvalidPosition() {
        val board = resetBoard()
        val piece = "O"

        assertThrows<Exception> { updateBoard(9, piece, board) }
    }
}