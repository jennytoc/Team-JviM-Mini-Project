package com.game.connecfour;

class Board {
    // Board Fields
    private static int column;
    private static int row;
    private int lastColumn = 0;
    private int lastTop = 0;

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

    public int getLastColumn() {
        return lastColumn;
    }

    public void setLastColumn(int lastColumn) {
        this.lastColumn = lastColumn;
    }

    public int getLastTop() {
        return lastTop;
    }

    public void setLastTop(int lastTop) {
        this.lastTop = lastTop;
    }
}