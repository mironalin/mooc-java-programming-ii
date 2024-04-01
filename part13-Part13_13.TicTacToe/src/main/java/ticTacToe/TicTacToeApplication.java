package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    public void start(Stage window) throws Exception {
        GameBoard gameBoard = new GameBoard();
        BorderPane layout = new BorderPane();

        layout.setPrefSize(300, 300);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setTop(gameBoard.getCurrentStatus());
        layout.setCenter(gameBoard.getView());

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}
