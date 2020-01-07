package testarfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class TestarFX extends Application {

    @Override
    public void start(Stage primaryStage) {

        StackPane root = new StackPane();
        Canvas canvas = new Canvas(300, 250); //Storleken i pixlar
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.strokeLine(10, 10, 20, 50); //Rita linje (x1,y1,x2,y2)
        gc.fillOval(20, 50, 30, 30); //Fyll oval (x,y,bredd,höjd)
        gc.setStroke(Color.RED); //Rita i rött från och med nu
        gc.setLineWidth(5); //Med pennbredden 5 pixlar
        gc.setFill(Color.GREEN); //Fyll i grönt
        //Rita båge (x,y,bredd,höjd,startvinkel,vinkellängd,typ)
        gc.strokeArc(100, 100, 40, 30, 45, 270, ArcType.CHORD); //Med korda
        gc.fillArc(200, 100, 50, 50, -45, 270, ArcType.ROUND); //Tårtbit
        double[] xkoord = {100, 100, 200, 150}; //x-koordinater
        double[] ykoord = {150, 200, 200, 160}; //y-koordinater
        gc.strokePolygon(xkoord, ykoord, xkoord.length); //Testa att
        //gc.strokePolyline(xkoord,ykoord,xkoord.length); //byta!
        root.getChildren().add(canvas);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
