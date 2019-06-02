package com.tomaszorzol.TicTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private boolean gameOver = false;
    Label statusLabel = new Label();
//    StatusLabel statusLabel = new StatusLabel();
    Field field = new Field();
    Board board = new Board();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane root = new BorderPane();
        GridPane gridPane = new Board();



//        Label label = new Label();
//        label.setText(statusLabel.statusMessage(Board.whoseTurn));

        root.setLeft(gridPane);
        gridPane.setMinHeight(300);
        gridPane.setMinWidth(300);

        root.setBottom(statusLabel);
        statusMessage(Board.whoseTurn);

        HBox options = new HBox();
        root.setRight(options);




        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(new Scene(root, 500, 320, Color.WHITE));
        primaryStage.show();
    }

    public void statusMessage(Moves whoseTurn) {
        Moves move = board.checkWin();
        String message = "X's turn to play";
        if (!gameOver) {
            if (move!=null) {
                gameOver = true;
                message = move + " won! The game is over";
                System.out.println(message);
            } else if (field.getFieldsFilled() > 9) {
                gameOver = true;
                message = "Draw! The game is over";
                System.out.println(message);
            } else {
                message = whoseTurn + "'s turn";
                System.out.println(message);
            }
        }
        statusLabel.setText(message);
    }


}
