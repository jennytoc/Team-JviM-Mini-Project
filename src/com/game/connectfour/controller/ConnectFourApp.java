package com.game.connectfour.controller;

import com.game.connecfour.Board;

import java.util.Scanner;

public class ConnectFourApp {
    public void execute() {
        welcome();

        int row = 7;
        int column = 8;
        int moves = row * column;
        Board board = new Board(column, row);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please use 0-" + (column - 1) + " to choose a column.");
        int input = scanner.nextInt();
        System.out.println(board);

        /*
        for (int player = 0; moves-- > 0; player = 1 - player) {
            char symbol = PLAYERS[player];

            Player.dropToken(symbol, input);

            System.out.println(board);

            if (Player.isWinning()) {
                System.out.println("\nPlayer " + symbol + " wins!");
                return;
            }
        }
        */
    }

    private void welcome() {
        System.out.println("Welcome to Captain's Mistress");
        System.out.println();
    }
}