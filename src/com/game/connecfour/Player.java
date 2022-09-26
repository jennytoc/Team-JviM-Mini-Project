package com.game.connecfour;

import java.util.Scanner;

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

    public void dropToken(char symbol, Scanner input){
        do{
            System.out.println("\nPlayer " + symbol + "turn: ");
            int col = input.nextInt();
            if(!(0 <= col && col < width)){
                System.out.println("Column must be between 0 and " + (width -1));
                continue;
            }
            for(int h = height -1; h >= 0; h --){
                if(grid[h][col] == '.'){
                    grid[lastTop = h][lastColumn = col] = symbol;
                    return;
                }
            }
            System.out.println("column " + col + " is full.");
        }while (true);
    }



    // Accessor Methods

    public String getPlayer1() {
        return player1;
    }

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