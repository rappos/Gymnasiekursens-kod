package spindraw;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SpinDraw extends Application {

    Timeline tline;
    int size = 400;
    int nn = 0;
    int[] colorGrade = new int[]{49, 30, 8, 48, 39, 37, 55, 1, 53, 58, 16, 45, 7, 51, 2, 3, 5, 24, 14, 18, 43, 25, 47, 11, 12, 19, 56, 52, 59, 29, 50, 28, 20, 41, 13, 26, 36, 38, 10, 35, 6, 21, 57, 4, 15, 17, 40, 22, 42, 46, 23, 33, 34, 27, 44, 32, 31, 9, 54, 0};

    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        Canvas canvas = new Canvas(size, size);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(22);
        Button btn = new Button("Sortera");

        Pane root = new Pane();
        root.getChildren().addAll(canvas, btn);
        Scene scene = new Scene(root, size, size);

        draw(gc);

        tline = new Timeline(new KeyFrame(
                Duration.millis(4),
                (ActionEvent e) -> {
                    if (nn < colorGrade.length - 1) {
                        if (colorGrade[nn] > colorGrade[nn + 1]) {
                            int temp = colorGrade[nn];
                            colorGrade[nn] = colorGrade[nn + 1];
                            colorGrade[nn + 1] = temp;
                        }

                        canvas.setRotate(canvas.getRotate() + 0.1);
                        draw(gc);
                        nn++;
                    } else {
                        nn = 0;
                    }
                }
        ));

        tline.setCycleCount(Timeline.INDEFINITE);

        btn.setOnAction((ActionEvent e) -> {
            tline.play();
        });
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void draw(GraphicsContext gc) {
        for (int i = 0; i < 60; i++) {
            gc.setStroke(Color.rgb(4 * colorGrade[i], 0, 255 - (4 * colorGrade[i])));
            gc.strokeLine(200, 200, clockX(200, 200, i), clockY(200, 200, i));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    double clockX(double x, double r, double sec) {
        return x + r * Math.sin(sec * 2 * Math.PI / 60);
    }

    double clockY(double y, double r, double sec) {
        return y - r * Math.cos(sec * 2 * Math.PI / 60);
    }

}
