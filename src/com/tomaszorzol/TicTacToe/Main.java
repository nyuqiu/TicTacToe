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
    Field field = new Field();
    Board board = new Board();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane root = new BorderPane();
        GridPane gridPane = new Board();

        Label label = new Label();

        root.setLeft(gridPane);
        gridPane.setMinHeight(300);
        gridPane.setMinWidth(300);


        root.setBottom(label);

        HBox options = new HBox();
        root.setRight(options);

        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(new Scene(root, 500, 320, Color.WHITE));
        primaryStage.show();
    }
}
