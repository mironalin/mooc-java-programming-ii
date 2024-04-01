package textstatistics;

import java.util.Arrays;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    public void start(Stage window) {
        BorderPane layout = new BorderPane();

        HBox bottomLayout = new HBox();
        bottomLayout.setSpacing(10);
        Label letterLabel = new Label("Letters: 0");
        Label wordLabel = new Label("Words: 0");
        Label longestWordLabel = new Label("The longest word is: ");
        bottomLayout.getChildren().add(letterLabel);
        bottomLayout.getChildren().add(wordLabel);
        bottomLayout.getChildren().add(longestWordLabel);

        TextArea textField = new TextArea();

        textField.textProperty().addListener((change, oldValue, newValue) -> {
            int characterCount = newValue.length();
            String[] parts = newValue.split(" ");
            int wordsCount = parts.length;

            if (characterCount == 0) {
                wordsCount = 0;
            }

            String longestWord = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();

            letterLabel.setText("Letters: " + characterCount);
            wordLabel.setText("Words: " + wordsCount);
            longestWordLabel.setText("The longest word is: " + longestWord);
        });

        layout.setCenter(textField);
        layout.setBottom(bottomLayout);
        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

}
