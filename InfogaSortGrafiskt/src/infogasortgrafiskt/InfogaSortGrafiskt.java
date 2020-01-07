package infogasortgrafiskt;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class InfogaSortGrafiskt extends Application {

    Canvas canvas;
    GraphicsContext gc;
    int talen[] = new int[]{61, 22, 152, 160, 132, 103, 178, 153, 52, 118, 13, 24, 154, 182, 54, 116, 166, 9, 175, 107, 113, 158, 11, 65, 34, 128, 184, 4, 186, 163, 28, 127, 189, 40, 1, 39, 30, 70, 159, 31, 8, 197, 192, 174, 109, 108, 188, 151, 42, 72, 104, 38, 47, 122, 164, 21, 143, 177, 190, 57, 37, 80, 117, 111, 16, 84, 102, 99, 157, 74, 183, 200, 60, 162, 90, 112, 79, 3, 32, 58, 110, 43, 68, 75, 196, 12, 5, 27, 97, 44, 194, 87, 20, 101, 25, 81, 23, 138, 73, 170, 83, 179, 76, 146, 169, 180, 67, 66, 185, 145, 191, 69, 141, 45, 35, 119, 89, 150, 161, 15, 36, 53, 171, 149, 172, 167, 133, 10, 156, 59, 106, 125, 126, 48, 155, 100, 41, 49, 198, 142, 144, 94, 64, 115, 105, 71, 91, 173, 14, 88, 7, 2, 121, 135, 136, 6, 137, 93, 176, 120, 124, 140, 129, 82, 165, 187, 148, 19, 62, 114, 168, 96, 17, 86, 55, 181, 98, 130, 78, 56, 195, 123, 29, 33, 199, 193, 50, 51, 139, 26, 18, 95, 131, 77, 46, 134, 92, 85, 147, 63};

    int ii;
    int tempo;
    int nn = 0;

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(600, 600);
        gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.rgb(200, 0, 200));

        Button btn = new Button("Sort");
        FlowPane root = new FlowPane();
        root.getChildren().addAll(btn, canvas);

        Scene scene = new Scene(root, 600, 600);
        draw();

        Timeline tline = new Timeline(new KeyFrame(
                Duration.millis(2),
                (ActionEvent e) -> {
                    nn++;
                    if (nn < talen.length) {
                        tempo = talen[nn];
                        ii = nn - 1;
                        if (ii >= 0 && talen[ii] > tempo) {
                            talen[ii + 1] = talen[ii];
                            ii--;
                        }
                        talen[ii + 1] = tempo;
                    }

                }
        ));
        tline.setCycleCount(Timeline.INDEFINITE);
        btn.setOnAction((ActionEvent event) -> {
            tline.play();
        });
        primaryStage.setTitle("sort");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void draw() {
        gc.clearRect(0, 0, 1000, 1000);
        for (int i = 0; i < (talen.length - 1); i++) {
            gc.strokeLine(2 * i + 100, 450, 2 * i + 100, 200 + talen[i]);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
