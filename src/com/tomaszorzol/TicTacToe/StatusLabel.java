//package com.tomaszorzol.TicTacToe;
//
//
//import javafx.scene.control.Label;
//
//public class StatusLabel extends Label {
//    static String message1;
//    Board board = Board.getInstance();
//
//    Field field = new Field();
//    private boolean gameOver = false;
//
//    public StatusLabel() {
//    }
//
//    public String statusMessage(Moves whoseTurn) {
//        Moves move = board.checkWin();
//        String message = "X's turn to play";
//        if (!gameOver) {
//            if (move!=null) {
//                gameOver = true;
//                message = move + " won! The game is over";
//                System.out.println(message);
//            } else if (field.getFieldsFilled() > 9) {
//                gameOver = true;
//                message = "Draw! The game is over";
//                System.out.println(message);
//            } else {
//                message = whoseTurn + "'s turn";
//                System.out.println(message);
//            }
//        }
//        message1 = message;
//        return message;
//    }
//}
