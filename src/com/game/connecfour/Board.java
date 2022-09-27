package com.game.connecfour;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {
    // Board Fields
    private static final char[] PLAYERS = {'R', 'Y'};
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
        System.out.println(Arrays.deepToString(board));
        return board;
    }

    public void updateBoard(String token) {
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    public boolean checkBoard(char token, int lastTop, int lastCol) {
        boolean result = false;
        if (horizontalLine(lastTop, token) || verticalLine(lastCol, token) || forwardDiagonal(lastTop, lastCol) || backwardDiagonal(lastTop, lastCol)) {
            result = true;
        }
        return result;
    }

    private boolean horizontalLine(int lastTop, char  token) {
        int streak = 0;
        for (int i = 0; i < board[lastTop].length; i++) {
            if (board[lastTop][i] == (token)) {
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
        for (int i = 0; i < board.length; i++) {
            if (board[i][lastCol] == (token)) {
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

    // Changing to public for now for testing
    // Checks next three coordinates using Player's last play
    public boolean forwardDiagonal(int lastTop, int lastCol) {
        int streak = 1;
        int nextTop = lastTop - 1;
        int nextCol = lastCol - 1;
        if (lastTop > 2 && lastCol > 2) {
            for (int i = 0; i <= 3; i++) {
                if (board[nextTop][nextCol] == (board[lastTop][lastCol])) {
                    streak++;
                    if (streak == 4) {
                        return true;
                    }
                } else {
                    break;
                }
                nextCol--;
                nextTop--;
            }
        }
        return false;
    }

    public boolean backwardDiagonal(int lastTop, int lastCol) {
        int streak = 1;
        int nextTop = lastTop - 1;
        int nextCol = lastCol + 1;
        if (lastTop > 2 && lastCol < 4) {
            for (int i = 0; i <= 3; i++) {
                if (board[nextTop][nextCol] == (board[lastTop][lastCol])) {
                    streak++;
                    if (streak == 4) {
                        return true;
                    }
                } else {
                    break;
                }
                nextTop--;
                nextCol++;
            }
        }
        return false;
    }

    // Accessor Methods
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
                Arrays.stream(initBoard())
                        .map(String::new)
                        .collect(Collectors.joining("\n"));
    }
}