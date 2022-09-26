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
        System.out.println(Arrays.deepToString(board));
    }

    // After this is called, it prints out the Board?
    public boolean checkBoard() {
        boolean result = false;
        return result;
    }

    private boolean horizontalLine(String token) {
        int streak = 0;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c].equals(token)) {
                    streak++;
                    if (streak == 4) {
                        return true;
                    }
                    else {
                        streak = 0;
                    }
                }
            }
        }
        return false;
    }

    private boolean verticalLine(String token) {
        int streak = 0;
        for (int c = 0; c < column; c++) {
            for (int r = 0; r < board.length; r++) {
                if (board[r][c].equals(token)) {
                    streak++;
                    if (streak == 4) {
                        return true;
                    }
                    else {
                        streak = 0;
                    }
                }
            }
        }
        return false;
    }

    private boolean forwardDiagonal(String token) {
        return false;
    }

    private boolean backwardDiagonal(String token) {
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