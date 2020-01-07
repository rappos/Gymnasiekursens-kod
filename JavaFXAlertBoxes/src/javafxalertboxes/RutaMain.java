package javafxalertboxes;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RutaMain extends Application {

    Stage window;
    Button button1;
    Button button2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Huvudrutan");
        button1 = new Button("Tryck här!");
        button2 = new Button("Eller här");

        button1.setOnAction(e -> RutaAlertBox.display("En ny och fräsch ruta", "Wow mer text"));

        button2.setOnAction(e -> {
            boolean result = ConfirmBox.display("Rubrik", "Vad är ditt svar?");
            System.out.println("Resultat: " + result);
        });

        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(button1, button2);

        StackPane layout = new StackPane();

        layout.getChildren().add(vbox);
        window.setScene(new Scene(layout));
        window.setMinWidth(300);
        window.setMinHeight(300);
        window.show();
    }

}
