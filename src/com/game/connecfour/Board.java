package com.game.connecfour;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Board {
    // Board Fields
    private static final String[] PLAYERS = {"R", "Y"};
    private static int column;
    private static int row;
    private String[][] board;

    // Constructor
    public Board(int column, int row) {
        setColumn(column);
        setRow(row);
        initBoard();
    }

    // Methods
    public void initBoard() {
        board = new String[getRow()][getColumn()];
        for (String[] row : board) {
            Arrays.fill(row, "_|");
        }
    }

    public void updateBoard(String token) {
        for (String[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    public boolean checkBoard(String token, int lastTop, int lastCol) {
        boolean result = false;
        if (horizontalLine(lastTop, token) || verticalLine(lastCol, token) || forwardDiagonal(lastTop, lastCol) || backwardDiagonal(lastTop, lastCol)) {
            result = true;
        }
        return result;
    }

    private boolean horizontalLine(int lastTop, String token) {
        int streak = 0;
        for (int i = 0; i < board[lastTop].length; i++) {
            if (board[lastTop][i].equals(token)) {
                streak++;
                if (streak == 4) {
                    return true;
                }
            }
            else {
                streak = 0;
            }
        }
        return false;
    }

    private boolean verticalLine(int lastCol, String token) {
        int streak = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][lastCol].equals(token)) {
                streak++;
                if (streak == 4) {
                    return true;
                }
            }
            else {
                streak = 0;
            }
        }
        return false;
    }

    // Changing to public for now for testing
    // Checks next three coordinates using Player's last play
    public boolean forwardDiagonal(int lastTop, int lastCol) {
        int streak = 1;
        int nextTop = --lastTop;
        int nextCol = --lastCol;
        for (int i = 0; i < 3; i++) {
            if (board[nextTop][nextCol].equals(board[lastTop][lastCol])) {
                streak++;
                if (streak == 4) {
                    return true;
                }
            }
            else {
                return false;
            }
            nextCol--;
            nextTop--;
        }
        return false;
    }

    public boolean backwardDiagonal(int lastTop, int lastCol) {
        int streak = 1;
        int nextTop = --lastTop;
        int nextCol = ++lastCol;
        for (int i = 0; i < 3; i++) {
            if (board[nextTop][nextCol].equals(board[lastTop][lastCol])) {
                streak++;
                if (streak == 4) {
                    return true;
                }
            }
            else {
                return false;
            }
            nextTop--;
            nextCol++;
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
}