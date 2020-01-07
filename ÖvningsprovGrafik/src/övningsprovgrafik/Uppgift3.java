package övningsprovgrafik;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Uppgift3 extends Application {

    int vSpace = 20;
    int hSpace = 40;

    Button btnBredare = new Button("Bredare");
    Button btnSmalare = new Button("Smalare");
    Button btnHögre = new Button("Högre");
    Button btnLägre = new Button("Lägre");

    FlowPane knappar = new FlowPane(btnBredare, btnSmalare, btnHögre, btnLägre);

    Canvas canvas = new Canvas(600, 600);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    Pane root = new Pane();

    Scene scene = new Scene(root, 600, 600);

    @Override
    public void start(Stage primaryStage) {
        knappar.setLayoutX(180);
        knappar.setLayoutY(30);
        root.getChildren().addAll(canvas, knappar);
        gc.setStroke(Color.rgb(244, 36, 203));

        btnBredare.setOnAction((ActionEvent event) -> {
            bredare();
        });
        btnHögre.setOnAction((ActionEvent event) -> {
            högre();
        });
        btnLägre.setOnAction((ActionEvent event) -> {
            lägre();
        });
        btnSmalare.setOnAction((ActionEvent event) -> {
            smalare();
        });

        primaryStage.setTitle("Uppgift 3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void smalare() {
        if (vSpace > 4) {
            gc.clearRect(0, 0, 600, 600);
            vSpace--;
            for (int i = 0; vSpace * i < 600; i++) {
                gc.strokeLine(vSpace * i, 0, vSpace * i, 600);
            }
            for (int i = 0; hSpace * i < 600; i++) {
                gc.strokeLine(0, hSpace * i, 600, hSpace * i);
            }
        }
    }

    private void lägre() {
        if (hSpace > 4) {
            gc.clearRect(0, 0, 600, 600);
            hSpace--;
            for (int i = 0; hSpace * i < 600; i++) {
                gc.strokeLine(0, hSpace * i, 600, hSpace * i);
            }
            for (int i = 0; vSpace * i < 600; i++) {
                gc.strokeLine(vSpace * i, 0, vSpace * i, 600);
            }
        }
    }

    private void högre() {
        gc.clearRect(0, 0, 600, 600);
        hSpace++;
        for (int i = 0; hSpace * i < 600; i++) {
            gc.strokeLine(0, hSpace * i, 600, hSpace * i);
        }
        for (int i = 0; vSpace * i < 600; i++) {
            gc.strokeLine(vSpace * i, 0, vSpace * i, 600);
        }
    }

    private void bredare() {
        gc.clearRect(0, 0, 600, 600);
        vSpace++;
        for (int i = 0; vSpace * i < 600; i++) {
            gc.strokeLine(vSpace * i, 0, vSpace * i, 600);
        }
        for (int i = 0; hSpace * i < 600; i++) {
            gc.strokeLine(0, hSpace * i, 600, hSpace * i);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
