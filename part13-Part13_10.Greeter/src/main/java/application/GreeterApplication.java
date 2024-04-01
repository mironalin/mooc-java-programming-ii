package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    public void start(Stage window) throws Exception {
        // Creating componenets -- First view
        Label nameText = new Label("Enter your name and start.");
        TextField nameField = new TextField();
        Button startButton = new Button("Start");
        Label error = new Label();

        // Create the layout -- First view
        GridPane layout = new GridPane();
        layout.add(nameText, 0, 0);
        layout.add(nameField, 0, 1);
        layout.add(startButton, 0, 2);
        layout.add(error, 0, 3);

        // Customize the layout -- First view
        layout.setPrefSize(600, 360);
        layout.setHgap(10);
        layout.setVgap(10);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20, 20, 20, 20));

        // Creating componenets -- Second view
        Label welcomeText = new Label();

        // Create the layout -- Second view
        StackPane welcomeLayout = new StackPane();

        // Customize the layout -- Third view
        welcomeLayout.getChildren().add(welcomeText);
        welcomeLayout.setPrefSize(600, 360);
        welcomeLayout.setAlignment(Pos.CENTER);

        // Create the scenes
        Scene enterDetailsScene = new Scene(layout);
        Scene welcomeScene = new Scene(welcomeLayout);

        startButton.setOnAction((event) -> {
            if (nameField.getText().isEmpty()) {
                error.setText("Text field can't be empty!");
                return;
            }
            welcomeText.setText("Welcome " + nameField.getText() + "!");
            window.setScene(welcomeScene);
        });

        window.setScene(enterDetailsScene);
        window.show();
    }

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }
}
