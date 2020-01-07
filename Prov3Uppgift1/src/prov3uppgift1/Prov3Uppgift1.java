package prov3uppgift1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Prov3Uppgift1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField txf = new TextField();

        Canvas canvas = new Canvas(500, 200);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.ORANGERED);

        Pane root = new Pane();
        root.getChildren().addAll(txf, canvas);

        Scene scene = new Scene(root, 500, 200);

        txf.setOnAction((ActionEvent event) -> {
            gc.clearRect(0, 0, 500, 400); //Rensar canvas från eventuella tidiga körningare
            for (int i = 0; i < 10; i++) {
                gc.strokeOval(Integer.parseInt(txf.getText()) * i, 100, 40, 40);            //Integer.pareseInt för att få strängen till ett heltal, hanterar inte eventuella errors
            }
        });

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
