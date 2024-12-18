
package doancanhan;

public final class GameLogic {
    private final String[][] board;
    private boolean playerXTurn;

    public GameLogic() {
        this.board = new String[3][3];
        this.playerXTurn = true;
        resetBoard();
    }

    // Reset the game board
    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "";
            }
        }
    }

    // Make a move
    public boolean makeMove(int row, int col) {
        if (board[row][col].equals("")) {
            board[row][col] = playerXTurn ? "X" : "O";
            playerXTurn = !playerXTurn;
            return true;
        }
        return false;
    }

    // Check if a player has won
    public String checkWinner() {
        // Check rows, columns, and diagonals for a winner
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].equals("")) {
                return board[i][0];
            }
            if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && !board[0][i].equals("")) {
                return board[0][i];
            }
        }
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals("")) {
            return board[0][0];
        }
        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].equals("")) {
            return board[0][2];
        }
        return null;
    }

    // Check if the board is full (draw condition)
    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    // Get the current state of the board
    public String[][] getBoard() {
        return board;
    }
}
