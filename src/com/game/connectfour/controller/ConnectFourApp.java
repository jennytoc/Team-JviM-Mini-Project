package com.game.connectfour.controller;

import com.game.connecfour.Board;
import com.game.connecfour.Player;

import java.util.Scanner;

public class ConnectFourApp {
    private static final char[] PLAYERS = {'R', 'Y'};
    Player players = new Player("Joe", "Sally");

    public void execute() {
        welcome();

        int row = 6;
        int column = 7;
        int moves = row * column;
        Board board = new Board(column, row);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please use 1-" + column + " to choose a column.");
        System.out.println(board);


        for (int player = 0; moves-- > 0; player = 1 - player) {
            char symbol = PLAYERS[player];

            players.dropToken(symbol, scanner, board);

            System.out.println(board);

            if (board.checkBoard(symbol, players.getLastTop(), players.getLastColumn())) {
                System.out.println("\nPlayer " + symbol + " wins!");
                return;
            }
        }

    }

    private void welcome() {
        System.out.println("Welcome to Connect4");
        System.out.println();
    }
}