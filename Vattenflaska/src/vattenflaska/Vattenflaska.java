package vattenflaska;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Vattenflaska extends Application {

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Flaska[] flaska = new Flaska[5];
        for (int i = 0; i < 5; i++) {

        }

        StackPane root = new StackPane();
        root.getChildren().addAll();

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
