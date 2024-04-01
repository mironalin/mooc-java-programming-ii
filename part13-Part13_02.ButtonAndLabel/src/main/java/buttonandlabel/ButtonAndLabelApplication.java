package buttonandlabel;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.application.Application;

public class ButtonAndLabelApplication extends Application {

    public void start(Stage window) {
        Button buttonComponent = new Button("Button");
        Label labelComponent = new Label("Label");

        FlowPane componentGroup = new FlowPane();

        componentGroup.getChildren().add(labelComponent);
        componentGroup.getChildren().add(buttonComponent);

        Scene view = new Scene(componentGroup);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }

}
