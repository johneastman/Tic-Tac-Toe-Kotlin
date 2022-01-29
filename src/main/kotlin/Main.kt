fun drawBoard(board: Array<Array<String>>): String {
    return """
        ${board[0][0]} | ${board[0][1]} | ${board[0][2]}
       ---+---+--- 
        ${board[1][0]} | ${board[1][1]} | ${board[1][2]}
       ---+---+--- 
        ${board[2][0]} | ${board[2][1]} | ${board[2][2]}
    """.trimIndent()
}

fun getBoardIndicesFromCellNumber(cellNumber: Int): Pair<Int, Int>? {
    return when(cellNumber) {
        0 -> { Pair(0, 0) }
        1 -> { Pair(0, 1) }
        2 -> { Pair(0, 2) }
        3 -> { Pair(1, 0) }
        4 -> { Pair(1, 1) }
        5 -> { Pair(1, 2) }
        6 -> { Pair(2, 0) }
        7 -> { Pair(2, 1) }
        8 -> { Pair(2, 2) }
        else -> null
    }
}

fun updateBoard(position: Int, piece: String, board: Array<Array<String>>) {

    val boardIndicies = getBoardIndicesFromCellNumber(position)
        ?: throw Exception("Invalid position: $position. Valid positions are 0 - 8")
    val x = boardIndicies.first
    val y = boardIndicies.second
    board[x][y] = piece
}

fun isWin(piece: String, board: Array<Array<String>>): Boolean {
    // Horizontal
    if (board[0][0] == piece && board[0][1] == piece && board[0][2] == piece) {
        return true
    }
    else if (board[1][0] == piece && board[1][1] == piece && board[1][2] == piece) {
        return true
    }
    else if (board[2][0] == piece && board[2][1] == piece && board[2][2] == piece) {
        return true
    }

    // Vertical
    if (board[0][0] == piece && board[1][0] == piece && board[2][0] == piece) {
        return true
    }
    else if (board[0][1] == piece && board[1][1] == piece && board[2][1] == piece) {
        return true
    }
    else if (board[0][2] == piece && board[1][2] == piece && board[2][2] == piece) {
        return true
    }

    // Diagonal
    else if (board[0][0] == piece && board[1][1] == piece && board[2][2] == piece) {
        return true
    }
    else if (board[0][2] == piece && board[1][1] == piece && board[2][0] == piece) {
        return true
    }

    return false
}

fun resetBoard(): Array<Array<String>> {
    return arrayOf(
        arrayOf("0", "1", "2"),
        arrayOf("3", "4", "5"),
        arrayOf("6", "7", "8")
    )
}


fun getPlayer(turn: Int, pieces: Array<String>): String {
    return pieces[turn % pieces.size]
}

fun getInput(prompt: String): String {
    print(prompt)
    return readLine() ?: throw Exception("Unable to read input")
}

fun validateInput(input: String, board: Array<Array<String>>, pieces: Array<String>) {
    // Check if the input is a number
    val intInput = input.toIntOrNull() ?: throw Exception("Input must be a number")

    // Check if the input number is on the board
    val selectedCell = getBoardIndicesFromCellNumber(intInput) ?: throw Exception("Input must be be 0 - 8")

    // Check if the selected cell is already filled
    if (pieces.contains(board[selectedCell.first][selectedCell.second])) {
        throw Exception("Input must not be a filled cell")
    }
}


fun main() {
    var turn = 0
    val board = resetBoard()
    val pieces = arrayOf("X", "O")
    var piece = getPlayer(turn, pieces)

    while (true) {
        println("\n" + drawBoard(board))

        val input = getInput("Player $piece: Enter a number between 0 - 8: ")

        // Ensure the input is valid
        try {
            validateInput(input, board, pieces)
        } catch (e: Exception) {
            println(e.message)
            continue
        }

        updateBoard(input.toInt(), piece, board)
        if (isWin(piece, board)) {
            println(drawBoard(board))
            println("Player $piece wins!")
            break
        }
        // Change player
        piece = getPlayer(++turn, pieces)
    }
}
