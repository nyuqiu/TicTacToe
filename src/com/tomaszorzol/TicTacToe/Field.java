package com.tomaszorzol.TicTacToe;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;

public class Field extends Pane {
    static Board board = Board.getInstance();
    private Moves move = Moves.EMPTY;
    private int fieldsFilled = 0;
    boolean gameOver = false;
    private StringProperty statusLabel = new SimpleStringProperty((String) (statusMessage(Board.whoseTurn)));


    public Field() {
        setStyle("-fx-border-color: black");
        setPrefSize(100.0f, 100.0f);
        setOnMouseClicked(e -> handleMouseClick());
    }

    public Moves getMove() {
        return move;
    }

    public String getStatusLabel() {
        return statusLabel.get();
    }

    public StringProperty statusLabelProperty() {
        return statusLabel;
    }

    public void setMove(Moves c) {
        if (c == Moves.CROSS) {
            drawCross();
        } else {
            drawCircle();
        }
        move = c;
        fieldsFilled++;
    }

    private Moves handleMouseClick() {
        if (move == Moves.EMPTY) {
            setMove(Board.whoseTurn);
            Board.whoseTurn = (Board.whoseTurn == Moves.CROSS) ? Moves.CIRCLE : Moves.CROSS;
            statusMessage(Board.whoseTurn);
        }
        return Board.whoseTurn;
    }

    private String statusMessage(Moves whoseTurn) {
        Moves move = board.checkWin();
        String message = "X's turn to play";
        if (!gameOver) {
            if (move != null) {
                gameOver = true;
                message = move + " won! The game is over";
                System.out.println(message);
            } else if (fieldsFilled > 9) {
                gameOver = true;
                message = "Draw! The game is over";
                System.out.println(message);
            } else {
                message = whoseTurn + "'s turn";
                System.out.println(message);
            }
        }
        return message;
    }

    public void drawCross() {
        double w = getWidth(), h = getHeight();
        Line line1 = new Line(10.0f, 10.0f, w - 10.0f, h - 10.0f);
        Line line2 = new Line(10.0f, h - 10.0f, w - 10.0f, 10.0f);
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


