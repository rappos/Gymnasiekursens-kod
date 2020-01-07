package spinning.squares;

import javafx.animation.Animation;
import static javafx.animation.Animation.Status.RUNNING;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SpinningSquares extends Application {

    int width = 1366;
    int height = 768;
    int pos1, pos2, pos3 = 0;
    boolean isRunning = false;

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(width, height);

        Pane root = new Pane();
        root.getChildren().addAll(canvas);

        Rectangle[] rectangle = new Rectangle[3];
        for (int i = 0; i < 3; i++) {
            rectangle[i] = new Rectangle(height / 3, height);
        }

        for (int i = 0; i < 3; i++) {
            root.getChildren().add(rectangle[i]);
            rectangle[i].setLayoutY(0);
        }
        rectangle[0].setLayoutX(0);
        rectangle[1].setLayoutX(width - height / 3);
        rectangle[2].setLayoutX(width / 2 - height / 6);

        double alpha = 0.33333333;
        Color myRed = new Color(1, 0, 0, alpha);
        Color myBlue = new Color(0, 0, 1, alpha);
        Color myYellow = new Color(1, 1, 0, alpha);
        rectangle[0].setFill(myRed);
        rectangle[1].setFill(myYellow);
        rectangle[2].setFill(myBlue);

        Scene scene = new Scene(root, width, height);

        Timeline tline = new Timeline(new KeyFrame(
                Duration.millis(10),
                (ActionEvent e) -> {

                    if (rectangle[0].getLayoutX() > width) {
                        rectangle[0].setLayoutX(0);
                    }
                    if (rectangle[1].getLayoutX() > width) {
                        rectangle[1].setLayoutX(0);
                    }
                    if (rectangle[2].getLayoutX() > width) {
                        rectangle[2].setLayoutX(0);
                    }
                    rectangle[0].setLayoutX(rectangle[0].getLayoutX() + 3);
                    rectangle[1].setLayoutX(rectangle[1].getLayoutX() + 1);
                    rectangle[2].setLayoutX(rectangle[2].getLayoutX() + 2);
                }
        ));
        tline.setCycleCount(Timeline.INDEFINITE);

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent t) -> {
            if (t.getCode() == KeyCode.ESCAPE) {
                primaryStage.close();
            }
            if (t.getCode() == KeyCode.SPACE) {
                if (isRunning) {
                    tline.stop();
                    isRunning = false;
                } else {
                    tline.play();
                    isRunning = true;
                }

            }

        });

        primaryStage.setTitle("Spinning is a good trick");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
