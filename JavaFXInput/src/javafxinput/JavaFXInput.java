package javafxinput;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class JavaFXInput extends Application {

    Button button;
    Stage window;
    Scene scene;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Titel på fönster");

        TextField nameInput = new TextField();
        button = new Button("Tryck här");
        button.setOnAction(e -> isInt(nameInput, nameInput.getText()));

        Label text = new Label("Din ålder: ");

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(text, nameInput, button);

        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }

    private boolean isInt(TextField input, String message) {
        try {
            int age = Integer.parseInt(input.getText());
            System.out.println("User is: " + age);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Error: " + message + " is not a number");
            return false;
        }

    }

}
