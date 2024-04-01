package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public void start(Stage window) {
        // First view
        Label bpLabel = new Label("First view!");
        Button bpButton = new Button("To the second view!");

        BorderPane bpLayout = new BorderPane();
        bpLayout.setTop(bpLabel);
        bpLayout.setCenter(bpButton);

        // Second view
        Button vbButton = new Button("To the third view!");
        Label vbLabel = new Label("Second view!");

        VBox vbLayout = new VBox();
        vbLayout.getChildren().addAll(vbButton, vbLabel);

        // Third view
        Label gpLabel = new Label("Third view!");
        Button gpButton = new Button("To the first view!");

        GridPane gpLayout = new GridPane();
        gpLayout.add(gpLabel, 0, 0);
        gpLayout.add(gpButton, 1, 1);

        Scene firstView = new Scene(bpLayout);
        Scene secondView = new Scene(vbLayout);
        Scene thirdView = new Scene(gpLayout);

        // View switching
        bpButton.setOnAction((event) -> {
            window.setScene(secondView);
        });

        vbButton.setOnAction((event) -> {
            window.setScene(thirdView);
        });

        gpButton.setOnAction((event) -> {
            window.setScene(firstView);
        });

        window.setScene(firstView);
        window.show();
    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

}
