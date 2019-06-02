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
    Field field = new Field();
    Board board = Board.getInstance();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        GridPane gridPane = new Board();
        Label label = new Label();
//        label.textProperty().bind(field.statusLabelProperty());

        root.setBottom(label);

        root.setLeft(gridPane);
        gridPane.setMinHeight(300);
        gridPane.setMinWidth(300);

        HBox options = new HBox();
        root.setRight(options);

        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(new Scene(root, 500, 320, Color.WHITE));
        primaryStage.show();
    }

//    public String statusMessage(Moves whoseTurn) {
//        Moves move = board.checkWin();
//        String message = "X's turn to play";
//        if (!gameOver) {
//            if (move != null) {
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
////        statusLabel.setText(message);
//    }
}
