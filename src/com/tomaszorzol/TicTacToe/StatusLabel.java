package com.tomaszorzol.TicTacToe;

import java.awt.*;

public class StatusLabel extends Label {
    private Moves move;
    private boolean gameOver = false;
    private Moves whoseTurn = Moves.CROSS; // 'X' or 'O'
    private int fieldsFilled = 0;

//    private String statusMessage() {
//        String message = "" ;
//        if (!gameOver) {
//            setMove(whoseTurn);
//            if (false) { //hasWon(whoseTurn)
//                gameOver = true;
//                message = whoseTurn + " won! The game is over";
//            }
//            else if (fieldsFilled>9) {
//                gameOver = true;
//                message = "Draw! The game is over";
//            }
//            else {
//                whoseTurn = (whoseTurn == Moves.CROSS) ? Moves.CIRCLE : Moves.CROSS;
//                message = whoseTurn + "'s turn";
//            }
//        }
//        return message;
//    }
}
