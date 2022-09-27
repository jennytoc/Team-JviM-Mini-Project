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

    public boolean checkBoard(char token, int lastTop, int lastCol) {
        boolean result = false;
        if (horizontalLine(lastTop, token) || verticalLine(lastCol, token) || forwardDiagonal(lastTop, lastCol) || backwardDiagonal(lastTop, lastCol)) {
            result = true;
        }
        return result;
    }

    private boolean horizontalLine(int lastTop, char token) {
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

    private boolean forwardDiagonal(int lastTop, int lastCol) {
        int streak = 1;
        int nextTop = lastTop + 1;
        int nextCol = lastCol - 1;
        if (lastTop < 3 && lastCol > 2) {
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
                nextTop++;
            }
        }
        return false;
    }

    private boolean backwardDiagonal(int lastTop, int lastCol) {
        int streak = 1;
        int nextTop = lastTop + 1;
        int nextCol = lastCol + 1;
        if (lastTop < 3 && lastCol < 4) {
            for (int i = 0; i <= 3; i++) {
                if (board[nextTop][nextCol] == (board[lastTop][lastCol])) {
                    streak++;
                    if (streak == 4) {
                        return true;
                    }
                } else {
                    break;
                }
                nextTop++;
                nextCol++;
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