package com.connectfour.controller;

import com.apps.util.Prompter;
import com.connectfour.model.Board;
import com.connectfour.model.Player;

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
        boolean play = true;
        while (play) {
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
                    break;
                }
                else if (board.tie(column, row)){
                    System.out.println("Tie!");
                    return;
                }
            }
            play = restartGame();
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

    private void congratulations() {
        try {
            String congrats = Files.readString(Path.of("resources/congrats.txt"));
            System.out.println(congrats);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void goodbye() {
        try {
            String bye = Files.readString(Path.of("resources/goodbye-banner.txt"));
            System.out.println(bye);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean restartGame() {
        while (true) {
            String restart = prompter.prompt("Do you want to start a new game? [Y/N]\n").toUpperCase();
            if (restart.equals("Y")) {
                return true;
            } else if (restart.equals("N")) {
                goodbye();
                return false;
            } else {
                System.out.println("Please type Y or N only.");
                continue;
            }
        }
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
}