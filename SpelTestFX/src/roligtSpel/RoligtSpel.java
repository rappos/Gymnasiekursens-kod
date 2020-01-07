package roligtSpel;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

public class RoligtSpel extends Application {

    int tangent = 0;
    int speed = 1000;    //Less is faster
    int points = 0;

    @Override
    public void start(Stage primaryStage) {

        Image pattern = new Image("/roligtSpel/pattern.bmp");
        ImagePattern imgPattern = new ImagePattern(pattern);

        Image kubBild = new Image("/roligtSpel/bildKub.png");
        ImagePattern kubPattern = new ImagePattern(kubBild);

        Pane canvas = new Pane();
        canvas.setStyle("-fx-background-color: white;");
        canvas.setPrefSize(500, 400);
        Rectangle background = new Rectangle(500, 400, Color.WHITE);
        background.setStrokeWidth(10);
        background.setStroke(imgPattern);

        Rectangle rectangle = new Rectangle(10, 10, kubPattern);
        rectangle.relocate(5, 5);

        canvas.getChildren().addAll(background, rectangle);

        Scene scene = new Scene(canvas, 491, 391);

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent t) -> {
            if (t.getCode() == KeyCode.ESCAPE) {
                primaryStage.close();
            }
            if (t.getCode() == KeyCode.UP) {
                tangent = 1;
            }
            if (t.getCode() == KeyCode.DOWN) {
                tangent = 2;
            }
            if (t.getCode() == KeyCode.RIGHT) {
                tangent = 3;
            }
            if (t.getCode() == KeyCode.LEFT) {
                tangent = 4;
            }
//            if (t.getCode() == KeyCode.SPACE) {
//                tangent = 0;
//            }
        });

        Timeline tline = new Timeline(new KeyFrame(
                Duration.millis(speed),
                (ActionEvent e) -> {
                    outsideBox(rectangle, primaryStage);
                    moveSquare(rectangle);

                }
        ));

        primaryStage.setTitle("Roligt spel");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

        tline.setCycleCount(Timeline.INDEFINITE);
        tline.play();
    }

    private void outsideBox(Rectangle rectangle, Stage primaryStage) {
        if (rectangle.getLayoutY() + rectangle.getY() < 5
                || (rectangle.getLayoutY() + rectangle.getY()) > 385
                || (rectangle.getLayoutX() + rectangle.getX()) < 5
                || (rectangle.getLayoutX() + rectangle.getX()) > 485) {
            primaryStage.close();
        }
    }

    private void moveSquare(Rectangle rectangle) {
        if (tangent == 1) {
            rectangle.setY(rectangle.getY() - 10);
        }
        if (tangent == 2) {
            rectangle.setY(rectangle.getY() + 10);
        }
        if (tangent == 3) {
            rectangle.setX(rectangle.getX() + 10);
        }
        if (tangent == 4) {
            rectangle.setX(rectangle.getX() - 10);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
