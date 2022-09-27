package com.game.connectfour.controller;

import com.apps.util.Prompter;
import com.game.connecfour.Board;
import com.game.connecfour.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ConnectFourApp {
    private static final char[] PLAYERS = {'R', 'Y'};
    private String player1;
    private String player2;
    Player players = new Player(getPlayer1(), getPlayer2());
    private Prompter prompter = new Prompter(new Scanner(System.in));

    public void execute() {
        welcome();

        int row = 6;
        int column = 7;
        int moves = row * column;
        Board board = new Board(column, row);

        System.out.println("\nPlease use 1-" + column + " to choose a column.");
        System.out.println(board);


        for (int player = 0; moves-- > 0; player = 1 - player) {
            char symbol = PLAYERS[player];

            players.dropToken(symbol, prompter, board);

            System.out.println(board);

            if (board.checkBoard(symbol, players.getLastTop(), players.getLastColumn())) {
                congratulations();
                System.out.println("\nPlayer " + symbol + " wins!");
                return;
            }
            else if (board.tie(players.getLastTop(), players.getLastColumn(), symbol)){
                System.out.println("Tie!");
                return;
            }
        }

    }

    private void welcome() {
        try {
            String banner = Files.readString(Path.of("resources/banner.txt"));
            System.out.println(banner);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        setPlayer1(prompter.prompt("What is the name of Player 1?\n"));
        System.out.println(getPlayer1() + " your symbol is 'R'\n");
        setPlayer2(prompter.prompt("What is the name of Player 2\n"));
        System.out.println(getPlayer2() + " your symbol is 'Y'\n");
    }

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

    private void congratulations() {
        try {
            String congrats = Files.readString(Path.of("resources/congrats.txt"));
            System.out.println(congrats);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}