package com.tomaszorzol.TicTacToe;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;

public class Field extends Pane {
    static Board board = Board.getInstance();
    private boolean gameOver = false;
    private int fieldsFilled = 0;

    private Moves move = Moves.EMPTY;

    public Field() {
        setPrefSize(100, 100);
        setStyle("-fx-border-color: black");
        setOnMouseClicked(e -> handleMouseClick());
    }

    public Moves getMove() {
        return move;
    }

    public void drawMove(Moves c) {
        if (c == Moves.CROSS) {
            drawCross();

        } else {
            drawCircle();

        }
        this.move = c;
        fieldsFilled++;
    }

    private Moves handleMouseClick() {
        if(move==Moves.EMPTY) {
            drawMove(Board.whoseTurn);
            Board.whoseTurn = (Board.whoseTurn == Moves.CROSS) ? Moves.CIRCLE : Moves.CROSS;
            statusMessage();
        }
        return Board.whoseTurn;
    }

    public String statusMessage() {
        Moves move = board.checkWin();
        System.out.println("checkwin " + move + board.getMove(1,1));
        String message = "X's turn to play";
        if (!gameOver) {
            if (move!=null) {
                gameOver = true;
                message = move + " won! The game is over";
                System.out.println(message);
            } else if (fieldsFilled> 9) {
                gameOver = true;
                message = "Draw! The game is over";
                System.out.println(message);
            } else {
                message = Board.whoseTurn + "'s turn";
                System.out.println(message);
            }
        }
//        statusLabel.setText(message);
        return message;
    }

    public void drawCross() {
        double w = getWidth(), h = getHeight();
        Line line1 = new Line(10, 10, w - 10, h - 10);
        Line line2 = new Line(10, h - 10, w - 10, 10);
        getChildren().addAll(line1, line2);
    }

    public void drawCircle() {
        double w = getWidth(), h = getHeight();
        Ellipse ellipse = new Ellipse(w / 2, h / 2, w / 2 - 10.0f, h / 2 - 10.0f);
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(Color.WHITE);
        getChildren().add(ellipse);
    }


}


