package ticTacToe;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class GameBoard {
    private boolean gameEnded = false;
    private String currentPlayer = "X";
    List<Button> buttons = new ArrayList<>();

    private Label turnStatus = new Label("Turn: " + currentPlayer);

    public List<Button> createButtons(Label turnStatus) {
        List<Button> buttons = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            Button button = new Button();
            button.setFont(Font.font("Monospaced", 25));
            button.setMinSize(70, 70);
            button.setMaxSize(70, 70);

            button.setOnMouseClicked((event) -> {
                if (turnStatus.getText().startsWith("Winner: ") || turnStatus.getText().equals("It's a draw!")) {
                    button.disarm();
                } else if (button.getText().isEmpty()) {
                    button.setText(currentPlayer);
                    if (checkIfWinner()) {
                        turnStatus.setText("The end!");
                    } else if (allBoxesFilled()) {
                        turnStatus.setText("It's a draw");
                    } else {
                        takeTurn();
                        turnStatus.setText("Turn: " + currentPlayer);
                    }
                }
            });

            buttons.add(button);
        }

        return buttons;
    }

    public boolean gameEnded() {
        return gameEnded;
    }

    public Label getCurrentStatus() {
        return turnStatus;
    }

    public boolean checkIfWinner() {
        return checkColumns() || checkRows() || checkDiagonals();
    }

    public boolean checkColumns() {
        for (int i = 0; i < 9; i = i + 3) {
            if (buttons.get(i).getText().isEmpty() == false
                    && buttons.get(i).getText().equals(buttons.get(i + 1).getText())
                    && buttons.get(i).getText().equals(buttons.get(i + 2).getText())) {
                return true;
            }
        }

        return false;
    }

    public boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (buttons.get(i).getText().isEmpty() == false
                    && buttons.get(i).getText().equals(buttons.get(i + 3).getText())
                    && buttons.get(i).getText().equals(buttons.get(i + 6).getText())) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonals() {
        if (buttons.get(0).getText().isEmpty() == false && buttons.get(0).getText().equals(buttons.get(4).getText())
                && buttons.get(0).getText().equals(buttons.get(8).getText())) {
            return true;
        }

        if (buttons.get(2).getText().isEmpty() == false && buttons.get(2).getText().equals(buttons.get(4).getText())
                && buttons.get(2).getText().equals(buttons.get(6).getText())) {
            return true;
        }

        return false;
    }

    public boolean allBoxesFilled() {
        for (Button button : buttons) {
            if (button.getText().isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public void takeTurn() {
        if (currentPlayer.equals("X")) {
            currentPlayer = "O";
        } else if (currentPlayer.equals("O")) {
            currentPlayer = "X";
        }
    }

    public Parent getView() {
        turnStatus.setFont(Font.font("Monospaced", 40));
        GridPane layout = new GridPane();

        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setAlignment(Pos.CENTER);

        buttons.addAll(createButtons(turnStatus));
        int k = 0;
        for (int i = 0; i < buttons.size() / 3; i++) {
            for (int j = 0; j < buttons.size() / 3; j++) {
                layout.add(buttons.get(k), i, j);
                k++;
            }
        }
        return layout;
    }
}
