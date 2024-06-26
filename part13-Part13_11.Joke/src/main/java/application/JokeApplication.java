package application;

import java.util.Stack;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JokeApplication extends Application {
    public void start(Stage window) throws Exception {
        BorderPane layout = new BorderPane();
        HBox menu = new HBox();

        Button first = new Button("Joke");
        Button second = new Button("Answer");
        Button third = new Button("Explanation");

        menu.getChildren().addAll(first, second, third);
        menu.setPrefSize(600, 360);
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        layout.setTop(menu);

        StackPane firstLayout = createView("What do you call a bear with no teeth?");
        StackPane secondLayout = createView("A gummy bear.");
        StackPane thirdLayout = createView(
                "A toothless bear is humorously called a \"gummy bear\" due to its lack of teeth, creating wordplay.");

        first.setOnAction((event) -> layout.setCenter(firstLayout));
        second.setOnAction((event) -> layout.setCenter(secondLayout));
        third.setOnAction((event) -> layout.setCenter(thirdLayout));

        layout.setCenter(firstLayout);

        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.show();
    }

    private StackPane createView(String text) {
        StackPane layout = new StackPane();
        layout.setPrefSize(600, 360);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }
}
