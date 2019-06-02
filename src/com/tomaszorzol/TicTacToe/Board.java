package com.tomaszorzol.TicTacToe;

import javafx.scene.layout.GridPane;

public class Board extends GridPane {
    private static Board boardInstance = null;
    private Field[][] array = new Field[3][3];

    public Board() {
        Board board = this;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.add(array[i][j] = new Field(), j, i);
            }
        }
    }

    public Moves getMove(int x, int y) {
        return array[x][y].getMove();
    }

    public static Board getInstance() {
        if (boardInstance == null) {
            boardInstance = new Board();
        }
        return boardInstance;
    }

    public Moves checkWin() {
        for (int i = 0; i < 3; i++) {
            if (getMove(i, 0).equals(getMove(i, 1)) &&
                    getMove(i, 1).equals(getMove(i, 2)) &&
                    !getMove(i, 1).equals(Moves.EMPTY)) {
                return getMove(i, 1);
            }
        }
        for (int j = 0; j < 3; j++) {
            if (getMove(0, j).equals(getMove(1, j)) &&
                    getMove(1, j).equals(getMove(2, j)) &&
                    !getMove(1, j).equals(Moves.EMPTY)) {
                return getMove(1, j);
            }
        }
        if (((getMove(0, 0).equals(getMove(1, 1)) &&
                getMove(1, 1).equals(getMove(2, 2))) ||
                (getMove(0, 2).equals(getMove(1, 1)) &&
                        getMove(1, 1).equals(getMove(2, 0)))) &&
                !getMove(1, 1).equals(Moves.EMPTY)) {
            return getMove(1, 1);
        }
        return null;
    }
}
