package övningsprovgrafik;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Uppgift1 extends Application {

    int antalCirklar = 0;

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(900, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.setStroke(Color.RED);

        TextField txf = new TextField();
        Button btn = new Button("Byt antal");
        TilePane knappLåda = new TilePane(txf, btn);

        Pane root = new Pane();
        root.getChildren().addAll(canvas, knappLåda);
        knappLåda.setLayoutX(250);

        Scene scene = new Scene(root, 900, 600);

        primaryStage.setTitle("Uppgift 1");
        primaryStage.setScene(scene);
        primaryStage.show();

        btn.setOnAction((ActionEvent event) -> {
            antalCirklar = Integer.parseInt(txf.getText());
            gc.clearRect(0, 0, 900, 600);
            for (int i = 0; i < antalCirklar; i++) {

                gc.strokeOval((8 * i)+2, (8 * i)+2, 10 * i + 10, 10 * i + 10);
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}
