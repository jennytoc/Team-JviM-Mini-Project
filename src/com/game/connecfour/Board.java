package com.game.connecfour;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Board {
    // Board Fields
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
        String[][] board = new String[getRow()][getColumn()];
        for (String[] row : board) {
            Arrays.fill(row, "_");
        }
    }

    public boolean checkBoard() {
        boolean result = false;
        return result;
    }

    private void horizontalLine() {

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