package pl.marta.kopp.home.TicTacToe;


public class TicTacToe {
    private Character[][] board = {
            {'E', 'E', 'E'},
            {'E', 'E', 'E'},
            {'E', 'E', 'E'}
    };
    private char currentPlayer = 'O';
    private static final String NO_WINNER = "Brak zwycięzcy";
    private static final String WINNER = "Wygrał ";
    private static final String DRAW = "Remis";
    private static final int SIZE = 3;


    public String play(int x, int y) {
        currentPlayer = nextPlayer();
        checkAxis(x);
        checkAxis(y);
        setBox(x, y);
        if (isWin()) return WINNER + currentPlayer;
        else if (isDraw()) {return DRAW;}
        else return NO_WINNER;
    }

    private boolean isDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 'E') {
                    return false;
                }
            }
        }
        return true;
    }

    private void checkAxis(int x) {
        if (x < 1 || x > 3) throw new RuntimeException("value is outside the board");
    }

    private void setBox(int x, int y) {
        if (board[x - 1][y - 1] != 'E')
            throw new RuntimeException("box is occupied");
        else {
            board[x - 1][y - 1] = currentPlayer;
        }
    }

    public char nextPlayer() {
        if (currentPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }

    private boolean isWin() {
        int playerTotal = currentPlayer * SIZE;
        for (int i = 0; i < SIZE; i++) {
            if ((board[0][i] + board[1][i] + board[2][i]) == playerTotal) return true;

        }
        for (int i = 0; i < SIZE; i++) {
            if ((board[i][0] + board[i][1] + board[i][2]) == playerTotal) return true;
        }
        if ((board[0][0] + board[1][1] + board[2][2]) == playerTotal) return true;
        if ((board[0][2] + board[1][1] + board[2][0]) == playerTotal) return true;

        return false;
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }
}
