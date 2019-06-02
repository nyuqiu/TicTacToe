package com.tomaszorzol.TicTacToe;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;

public class Field extends Pane {
    private Board board = Board.getInstance();
    private Moves move;
    private boolean gameOver = false;
    private Moves whoseTurn = Moves.CROSS; // 'X' or 'O'
    private int fieldsFilled = 0;

    public Field(){
        setStyle("-fx-border-color: black");
        setPrefSize(100.0f, 100.0f);
        setOnMouseClicked(e -> handleMouseClick());
    }

    public Moves getMove() {
        return move;
    }

    public void setMove(Moves move) {
        if (move == Moves.CROSS){
            whoseTurn = Moves.CIRCLE;
            drawX();
        }
        else {
            whoseTurn = Moves.CROSS;
            drawO();
        }
        this.move = move;
        fieldsFilled++;
    }

    public void drawX() {
        double w = getWidth(), h = getHeight();
        Line line1 = new Line(10.0f, 10.0f, w - 10.0f, h - 10.0f);
        Line line2 = new Line(10.0f, h - 10.0f, w - 10.0f, 10.0f);
        getChildren().addAll(line1, line2);
    }

    public void drawO() {
        double w = getWidth(), h = getHeight();
        Ellipse ellipse = new Ellipse(w/2, h/2, w/2 - 10.0f, h/2 - 10.0f);
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(Color.WHITE);
        getChildren().add(ellipse);
    }

    private String handleMouseClick() {
        String message = "" ;
        if (!gameOver) {
            setMove(whoseTurn);
            if (board.checkWin()!=null) { //hasWon(whoseTurn)
                gameOver = true;
                message = whoseTurn + " won! The game is over";
            }
            else if (fieldsFilled>9) {
                gameOver = true;
                message = "Draw! The game is over";
            }
            else {
                whoseTurn = (whoseTurn == Moves.CROSS) ? Moves.CIRCLE : Moves.CROSS;
                message = whoseTurn + "'s turn";
            }
        }
        return message;
    }

}


