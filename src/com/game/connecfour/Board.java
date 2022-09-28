package com.game.connecfour;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {
    // Board Fields
    private static int column;
    private static int row;
    private char[][] board;

    // Constructor
    public Board(int column, int row) {
        setColumn(column);
        setRow(row);
        initBoard();
    }

    // Methods
    public char[][] initBoard() {
        board = new char[getRow()][getColumn()];
        for (char[] row : board) {
            Arrays.fill(row, '-');
        }
        return board;
    }

    public boolean tie(int lastTop, int lastCol, char token){
        boolean tie = true;
        boolean Break = false;
        for(int i = 0; i <= 7; i++){
            for(int j = 0; j <= 6; j++){
                if(board[i][j] == token){
                    tie = false;
                    Break = true;
                    break;
                }
            }
            if(Break)
                break;
        }
        return tie;
    }


    public boolean checkBoard(char token, int lastTop, int lastCol) {
        boolean result = false;
        if (horizontalLine(lastTop, token) || verticalLine(lastCol, token) || forwardDiagonal(token) || backwardDiagonal(token)) {
            result = true;
        }
        return result;
    }

    private boolean horizontalLine(int lastTop, char token) {
        int streak = 0;
        for (char space : board[lastTop]) {
            if (space == (token)) {
                streak++;
                if (streak == 4) {
                    return true;
                }
            } else {
                streak = 0;
            }
        }
        return false;
    }

    private boolean verticalLine(int lastCol, char token) {
        int streak = 0;
        for (char[] chars : board) {
            if (chars[lastCol] == (token)) {
                streak++;
                if (streak == 4) {
                    return true;
                }
            } else {
                streak = 0;
            }
        }
        return false;
    }

    private boolean forwardDiagonal(char token) {
        for (int r = 0; r < board.length - 3; r++) {
            for (int c = 3; c < board[r].length; c++) {
                char start = board[r][c];
                if (start != token) {
                    continue;
                }
                else if (board[r + 1][c - 1] == token &&
                         board[r + 2][c - 2] == token &&
                         board[r + 3][c - 3] == token) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backwardDiagonal(char token) {
        for (int r = 0; r < board.length - 3; r++) {
            for (int c = 0; c < board[r].length - 3; c++) {
                char start = board[r][c];
                if (start != token) {
                    continue;
                }
                else if (board[r + 1][c + 1] == token &&
                         board[r + 2][c + 2] == token &&
                         board[r + 3][c + 3] == token) {
                    return true;
                }
            }
        }
        return false;
    }

    // Accessor Methods
    public char[][] getBoard() {
        return board;
    }

    public void setBoard(int lastTop, int lastColumn, char symbol) {
        this.board[lastTop][lastColumn] = symbol;
    }

    public static int getColumn() {
        return column;
    }

    public static void setColumn(int column) {
        Board.column = column;
    }

    public static int getRow() {
        return row;
    }

    public static void setRow(int row) {
        Board.row = row;
    }

    public String toString() {
        return IntStream.range(1, getColumn() + 1)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining()) +
                "\n" +
                Arrays.stream(getBoard())
                        .map(String::new)
                        .collect(Collectors.joining("\n"));
    }
}