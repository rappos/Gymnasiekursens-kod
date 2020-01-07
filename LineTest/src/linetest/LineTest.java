package linetest;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.Random;
import javafx.scene.paint.Color;

public class LineTest extends Application {

    Canvas canvas;
    GraphicsContext gc;
    Timeline tline;
    int x = 0, y = 0, w = 20;
    Random rand;

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(600, 600);
        gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        rand = new Random();

        StackPane root = new StackPane();
        root.getChildren().addAll(canvas);

        Scene scene = new Scene(root, 600, 600);

        tline = new Timeline(new KeyFrame(Duration.millis(10),
                (ActionEvent e) -> {
                    
                    double r = rand.nextDouble();
                    if (r < 0.5) {
                        line(x, y, x + w, y + w);
                    } else {
                        line(x + w, y, x, y + w);
                    }
                    x += w;
                    if (x > canvas.getWidth()) {
                        y += w;
                        x=0;
                    }
                    if (y > canvas.getHeight()) {
                        tline.stop();
                    }
                }));

        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.show();

        tline.setCycleCount(Timeline.INDEFINITE);
        tline.play();

    }

    public static void main(String[] args) {
        launch(args);
    }

    private void line(int x1, int y1, int x2, int y2) {
        gc.strokeLine(x1, y1, x2, y2);
    }

}
