package com.tomaszorzol.TicTacToe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {

    private Moves whoseTurn = Moves.CROSS;
    private Field[][] array = new Field[3][3];
    private Label label = new Label();
    private boolean gameOver = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane root = new BorderPane();
        GridPane gridPane = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gridPane.add(array[i][j] = new Field(), j, i);
            }
        }

        root.setLeft(gridPane);
        gridPane.setMinHeight(300);
        gridPane.setMinWidth(300);

        root.setBottom(label);

        HBox options = new HBox();
        root.setRight(options);

        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(new Scene(root, 300, 320, Color.WHITE));
        primaryStage.show();
    }

    public class Board extends GridPane {

        public Moves getMove(int x, int y) {
            return array[x][y].getMove();
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

    public class Field extends Pane {
        private Board gridPane = new Board();
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
            if (!gameOver) {
                if (c == Moves.CROSS) {
                    drawCross();
                } else {
                    drawCircle();
                }
                move = c;
                fieldsFilled++;
            }
        }

        private Moves handleMouseClick() {
            if (move == Moves.EMPTY && !gameOver) {
                drawMove(whoseTurn);
                whoseTurn = (whoseTurn == Moves.CROSS) ? Moves.CIRCLE : Moves.CROSS;
                statusMessage();
            }
            return whoseTurn;
        }

        public void statusMessage() {
            Moves move = gridPane.checkWin();
            String message = "X's turn to play";
            if (!gameOver) {
                if (move != null) {
                    gameOver = true;
                    message = move + " won! The game is over";
                } else if (fieldsFilled > 9) {
                    gameOver = true;
                    message = "Draw! The game is over";
                } else {
                    message = whoseTurn + "'s turn";
                }
            }
            label.setText(message);
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
}
