package com.game.connecfour;


import java.util.Scanner;


public class Player {
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


    public void dropToken(char symbol, Scanner input, Board board){
        do{
            System.out.println("\nPlayer " + symbol + "turn: ");
            int col = input.nextInt();
            if(!(1 <= col && col < Board.getColumn() + 1)){
                System.out.println("Column must be between 1 and " + (Board.getColumn() + 1));
                continue;
            }
            for(int h = Board.getRow() -1; h >= 0; h --){
                if(board.initBoard()[h][col] == '-'){
                    board.initBoard()[lastTop = h][lastColumn = col] = symbol;
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