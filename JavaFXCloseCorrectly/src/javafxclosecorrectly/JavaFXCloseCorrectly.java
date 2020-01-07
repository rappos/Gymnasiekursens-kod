package javafxclosecorrectly;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class JavaFXCloseCorrectly extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Namnet på min lilla ruta");

        window.setOnCloseRequest(e -> {
            e.consume();
            System.out.println("Allt sparat");
            closeProgram();
        });

        button = new Button("Stäng programmet");
        button.setOnAction(e -> closeProgram());

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        Scene scene = new Scene(layout, 300, 300);
        window.setScene(scene);
        window.show();
    }

    private void closeProgram() {
        Boolean answer = ConfirmBox.display("Titel", "Är du säker på att du vill stänga?");
        if (answer) {
            window.close();
        }
        
    }

}
