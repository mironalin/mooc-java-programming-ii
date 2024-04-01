package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class NotifierApplication extends Application {

    @Override
    public void start(Stage window) {

        TextField textFieldComponent = new TextField();
        Button buttonComponent = new Button("Update");
        Label labelComponent = new Label();

        buttonComponent.setOnAction((event) -> {
            labelComponent.setText(textFieldComponent.getText());
        });

        VBox layout = new VBox();

        layout.getChildren().addAll(textFieldComponent, buttonComponent, labelComponent);

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();

    }

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }

}
