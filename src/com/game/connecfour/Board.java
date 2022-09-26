package com.game.connecfour;

public class Board {
    // Board Fields
    private static int column;
    private static int row;

    // Constructor
    public Board(int column, int row) {
        setColumn(column);
        setRow(row);
    }

    // Methods

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