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

    // After this is called, it prints out the Board?
    public boolean checkBoard() {
        boolean result = false;
        return result;
    }

    private boolean horizontalLine(String token) {
        int streak = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                if (board[r][c].equals(token)) {
                    streak++;
                    if (streak == 4) {
                        return true;
                    }
                }
                else {
                    streak = 0;
                }
            }
        }
        return false;
    }

    private boolean verticalLine(String token) {
        int streak = 0;
        for (int c = 0; c < column; c++) {
            for (int r = 0; r < row; r++) {
                if (board[r][c].equals(token)) {
                    streak++;
                    if (streak == 4) {
                        return true;
                    }
                }
                else {
                    streak = 0;
                }
            }
        }
        return false;
    }

    // Changing to public for now for testing
    // Checks next three coordinates using Player's last play
    public boolean forwardDiagonal(int lastTop, int lastCol) {
        int streak = 1;
        int nextCol = ++lastCol;
        int nextTop = ++lastTop;
        for (int i = 0; i < 3; i++) {
            if (board[nextTop][nextCol].equals(board[lastTop][lastCol])) {
                streak++;
                if (streak == 4) {
                    return true;
                }
            }
            else {
                streak = 1;
            }
            System.out.println("Next col:" + nextCol);
            System.out.println("Next top:" + nextTop);
            nextCol++;
            nextTop++;
        }
        return false;
    }

    private boolean backwardDiagonal(int lastTop, int lastCol) {
        int streak = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {

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
}