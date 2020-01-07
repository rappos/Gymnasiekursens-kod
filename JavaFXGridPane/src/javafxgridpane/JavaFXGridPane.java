package javafxgridpane;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class JavaFXGridPane extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("En fin rubrik");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label nameLabel = new Label("Användarnamn: ");
        GridPane.setConstraints(nameLabel, 0, 0);

        TextField nameInput = new TextField("Kalle Kalas");
        GridPane.setConstraints(nameInput, 1, 0);

        Label passwLabel = new Label("Lösenord: ");
        GridPane.setConstraints(passwLabel, 0, 1);

        TextField passwInput = new TextField();
        passwInput.setPromptText("lösenord");
        GridPane.setConstraints(passwInput, 1, 1);

        Button loginButton = new Button("Logga in");
        GridPane.setConstraints(loginButton, 1, 2);

        grid.getChildren().addAll(nameLabel, nameInput, passwLabel, passwInput, loginButton);

        Scene scene = new Scene(grid, 300, 200);
        window.setScene(scene);
        window.show();
    }

}
