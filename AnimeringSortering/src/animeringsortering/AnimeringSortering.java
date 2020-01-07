/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animeringsortering;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AnimeringSortering extends Application {

    Canvas canvas = new Canvas(750, 350);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    @Override
    public void start(Stage primaryStage) {
        Label inledning = new Label("Dags att sortera, klicka på knapparna och se hur olika sorteringssytem funkar");
        inledning.setLayoutX(20);
        inledning.setLayoutY(10);
        canvas.setLayoutY(50);
        canvas.setLayoutX(25);
        gc.setFill(Color.BLACK);
        gc.strokeRect(25, 50, 720, 295);
        gc.setLineWidth(2);
        gc.strokeLine(268, 50, 268, 345);
        gc.strokeLine(505, 50, 505, 345);

        Button[] btnSort = new Button[3];
        

        Pane root = new Pane();
        root.getChildren().addAll(inledning, canvas);

        Scene scene = new Scene(root, 800, 450);

        primaryStage.setTitle("Sortering");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
