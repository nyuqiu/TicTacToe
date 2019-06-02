//package com.tomaszorzol.TicTacToe;
//
//public class WinningConditions {
//    private static WinningConditions winningConditionsInstance = null;
//    private Board board = Board.getInstance();
//
//    private WinningConditions() {
//    }
//
//    public static WinningConditions getInstance() {
//        if (winningConditionsInstance == null) {
//            winningConditionsInstance = new WinningConditions();
//        }
//        return winningConditionsInstance;
//    }
//
//    public Moves checkWin() {
//        for (int i = 0; i < 3; i++) {
//            if (board.getMove(i, 0).equals(board.getMove(i, 1)) &&
//                    board.getMove(i, 1).equals(board.getMove(i, 2)) &&
//                    !board.getMove(i, 1).equals(Moves.EMPTY)) {
//                return board.getMove(i, 1);
//            }
//        }
//        for (int j = 0; j < 3; j++) {
//            if (board.getMove(0, j).equals(board.getMove(1, j)) &&
//                    board.getMove(1, j).equals(board.getMove(2, j)) &&
//                    !board.getMove(1, j).equals(Moves.EMPTY)) {
//                return board.getMove(1, j);
//            }
//        }
//        if (((board.getMove(0, 0).equals(board.getMove(1, 1)) &&
//                board.getMove(1, 1).equals(board.getMove(2, 2))) ||
//                (board.getMove(0, 2).equals(board.getMove(1, 1)) &&
//                        board.getMove(1, 1).equals(board.getMove(2, 0)))) &&
//                !board.getMove(1, 1).equals(Moves.EMPTY)) {
//            return board.getMove(1, 1);
//        }
//        return null;
//    }
//
////    public boolean hasWon(Moves move) {
////        for (int i = 0; i < 3; i++)
////            if (board.getMove(i,0) == move &&
////                    board.getMove(i,1) == move &&
////                    board.getMove(i,2) == move)
////                return true;
////        for (int j = 0; j < 3; j++)
////            if (board.getMove(0,j) == move &&
////                    board.getMove(1,j) == move &&
////                    board.getMove(2,j) == move)
////                return true;
////        if (board.getMove(0,0) == move &&
////                board.getMove(1,1) == move &&
////                board.getMove(2,2) == move)
////            return true;
////        if (board.getMove(0,2) == move &&
////                board.getMove(1,1) == move &&
////                board.getMove(0,2) == move)
////            return true;
////        return false;
////    }
//}