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


    public static void main(String[] args) {
        launch(args);
    }
    private Field[][] field =  new Field[3][3];

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        GridPane gridPane = new Board();
        Label statusLabel = new Label("X's turn to play");

        root.setLeft(gridPane);
        gridPane.setMinHeight(300);
        gridPane.setMinWidth(300);

        root.setBottom(statusLabel);

        HBox options = new HBox();
        root.setRight(options);


        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(new Scene(root, 500, 300, Color.WHITE));
        primaryStage.show();
    }



}
