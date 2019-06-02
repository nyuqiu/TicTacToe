package com.tomaszorzol.TicTacToe;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;

public class Field extends Pane {
    StatusLabel statusLabel = new StatusLabel();

    private Moves move = Moves.EMPTY;
    private boolean gameOver = false;
    private int fieldsFilled = 0;

    public Field() {
        setStyle("-fx-border-color: black");
        setPrefSize(100.0f, 100.0f);
        setOnMouseClicked(e -> handleMouseClick());
    }

    public Moves getMove() {
        return move;
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
        if(move==Moves.EMPTY) {
            setMove(Board.whoseTurn);
            Board.whoseTurn = (Board.whoseTurn == Moves.CROSS) ? Moves.CIRCLE : Moves.CROSS;
            System.out.println(StatusLabel.message1);
        }
        return Board.whoseTurn;
    }

    public int getFieldsFilled() {
        return fieldsFilled;
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


