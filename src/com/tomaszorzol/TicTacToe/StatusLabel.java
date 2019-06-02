//package com.tomaszorzol.TicTacToe;
//
//
//import javafx.scene.control.Label;
//import javafx.scene.control.Labeled;
//
//public class StatusLabel extends Labeled {
//    private static StatusLabel statusLabelInstance = null;
//    Board board = Board.getInstance();
//    Field field = new Field();
//    private boolean gameOver = false;
//    Label label = new Label();
//
//    public StatusLabel() {
//    }
//
//    public Label getLabel() {
//        return label;
//    }
//
//    public static StatusLabel getInstance() {
//        if (statusLabelInstance == null) {
//            statusLabelInstance = new StatusLabel();
//        }
//        return statusLabelInstance;
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
//        return message;
//    }
//}
