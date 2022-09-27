package com.game.connectfour.test;

import com.game.connecfour.Board;

class ConnectFourTest {

    public static void main(String[] args) {
        Board brd1 = new Board(7, 6);
        // brd1.updateBoard("R");
        // brd1.forwardDiagonal(2, 2);
        // brd1.forwardDiagonal(3, 3);
        // brd1.backwardDiagonal(4,3);
        // brd1.backwardDiagonal(1, 1);
        System.out.println(brd1);
    }
}