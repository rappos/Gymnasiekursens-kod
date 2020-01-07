package prov3uppgift3;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

public class Prov3Uppgift3 extends Application {

    double centX = 160;
    double centY = 160;
    double r = 60;

    double sec = 0;

    boolean isClockRunning = false;   //Används för start och stopp av klockan

    @Override
    public void start(Stage primaryStage) {
        Button startStopp = new Button("Start/stopp");
        Button nollstall = new Button("Nollställ");
        FlowPane platsFörKnappar = new FlowPane(startStopp, nollstall);

        Canvas canvas = new Canvas(300, 300);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //Lite snyggare klocka
        gc.setFill(Color.YELLOW);
        gc.setLineWidth(3);

        drawWatchBackground(gc); //ritar klockan första gången

        Pane root = new Pane();
        root.getChildren().addAll(canvas, platsFörKnappar);

        Scene scene = new Scene(root, 300, 300);

        Timeline tline = new Timeline(new KeyFrame( //TimeLine för uppdatering och stopp av klockan
                Duration.millis(1000), //kör varje sekund
                (ActionEvent e) -> {
                    gc.clearRect(0, 0, 300, 300); //Tar bort Gamla visaren
                    drawWatchBackground(gc); //ritar bakgrunden igen som en följd av clearingen ovanför
                    gc.strokeLine(centX, centY, clockX(centX, r, sec), clockY(centY, r, sec));
                    sec++;
                }
        ));
        tline.setCycleCount(Timeline.INDEFINITE);
        startStopp.setOnAction((ActionEvent event) -> {
            if (!isClockRunning) {
                tline.play();
                isClockRunning = true;
            } else {
                tline.stop();
                isClockRunning = false;
            }
        });
        nollstall.setOnAction((ActionEvent event) -> {
            //sätter sec till 0 och ritar upp allt igen
            sec = 0;
            gc.clearRect(0, 0, 300, 300);
            drawWatchBackground(gc);
            gc.strokeLine(centX, centY, clockX(centX, r, sec), clockY(centY, r, sec));
        });

        primaryStage.setTitle("Klockan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawWatchBackground(GraphicsContext gc) {
        gc.strokeOval(centX - r, centY - r, r * 2, r * 2);
        gc.fillOval(centX - r, centY - r, r * 2, r * 2);
    }

    public static void main(String[] args) {
        launch(args);
    }

    double clockX(double centX, double r, double sec) {
        return centX + r * Math.sin(sec * 2 * Math.PI / 60);
    }

    double clockY(double centY, double r, double sec) {
        return centY - r * Math.cos(sec * 2 * Math.PI / 60);
    }

}
