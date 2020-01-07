package prov3uppgift4;
//Placering utan överlappning funkar
//Nollställning funkar
//Men något med TimeLine fick jag ej till, de startar och stannar lite som de vill

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Prov3Uppgift4 extends Application {

    Canvas canvas;
    private Klocka[] klocka = new Klocka[400]; //Maxar vid 400 men rekommenderar inte mer än 10
    int antalKlockor = 0;

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(600, 400);
        Pane root = new Pane();
        root.getChildren().addAll(canvas);

        Scene scene = new Scene(root, 600, 400);

        canvas.setOnMouseClicked((MouseEvent me) -> {
            mouseClicked(me.getX(), me.getY(), me.getButton() == MouseButton.SECONDARY);
        });

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void mouseClicked(double Mousex, double Mousey, boolean secondary) {
        if (!secondary) {
            if (antalKlockor > 0) {
                for (int i = 0; i <= antalKlockor; i++) {
                    if (klocka[i].pick(Mousex, Mousey)) {
                        klocka[i].playStopClock();
                        break;
                    } else {
                        klocka[antalKlockor] = new Klocka(Mousey, Mousex, 40, 0, false);
                        antalKlockor++;
                        redraw();
                    }
                }
            } else { //ritar alltid om det inte finns nån klocka
                klocka[antalKlockor] = new Klocka(Mousey, Mousex, 40, 0, false);
                antalKlockor++;
                redraw();
            }

        } else {
            for (int i = 0; i < antalKlockor; i++) {
                if (klocka[i].pick(Mousex, Mousey)) {
                    klocka[i].setSec(0);
                    redraw();
                    break;
                }
            }
        }

    }

    private void redraw() {

        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        for (int i = 0; i < antalKlockor; i++) {
            klocka[i].paint(canvas);
        }

    }

}
