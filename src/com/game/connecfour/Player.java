package com.game.connecfour;

class Player {
    // Fields
    private String player1;
    private String player2;
    private int lastColumn = 0;
    private int lastTop = 0;

    // Constructor


    public Player(String player1, String player2) {
        setPlayer1(player1);
        setPlayer2(player2);
    }

    // Accessor Methods

    public String getPlayer1() {
        return player1;
    }

    // Add validation
    //  Only 1 character, uppercase it, cannot be same initial as 2nd player
    // Method overload
    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
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