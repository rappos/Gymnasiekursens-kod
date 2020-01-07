package klockafx;

import java.time.ZonedDateTime;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class KlockaFX extends Application {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    String currentTime;
    Double sekund1;
    Double sekund2;
    Double sekund3;

    @Override
    public void start(Stage primaryStage) {
        Text time = new Text();
        setTime(time);
        Rectangle wrist = new Rectangle();
        Circle watch = new Circle(100, 100, 100);
        Circle watchBackground = new Circle(90, 90, 90);
        Circle secondShower = new Circle(70, 70, 70);
        Image pointer = new Image("/klockafx/point.png");
        ImagePattern pointerPattern = new ImagePattern(pointer);
        secondShower.setFill(pointerPattern);
        wrist.setWidth(70);
        wrist.setHeight(410);
        watch.setFill(Color.GOLD);
        watchBackground.setFill(Color.WHITE);
        time.setText(currentTime);
        time.setScaleX(6);
        time.setScaleY(6);

        StackPane root = new StackPane();
        root.getChildren().addAll(wrist, watch, watchBackground, secondShower, time);

        Scene scene = new Scene(root, 400, 400);

        primaryStage.setTitle("Klocka!");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

        Timeline tline = new Timeline(new KeyFrame(
                Duration.millis(1000),
                (ActionEvent e) -> {
                    secondRotate(secondShower);
                    setTime(time);

                }
        ));

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent t) -> {
            if (t.getCode() == KeyCode.ESCAPE) {
                primaryStage.close();
            }
        });

        tline.setCycleCount(Timeline.INDEFINITE);
        tline.play();

    }

    private void secondRotate(Circle secondShower) throws NumberFormatException {
        sekund1 = Double.parseDouble((String.valueOf(ZonedDateTime.now().toString().charAt(17)))) * 10;
        sekund2 = Double.parseDouble((String.valueOf(ZonedDateTime.now().toString().charAt(18))));
        sekund3 = (sekund1 + sekund2);
        secondShower.setRotate(sekund3 * 6);
    }

    private void setTime(Text time) {
        currentTime
                = (String.valueOf(ZonedDateTime.now().toString().charAt(11)))
                + (String.valueOf(ZonedDateTime.now().toString().charAt(12)))
                + " "
                + (String.valueOf(ZonedDateTime.now().toString().charAt(14)))
                + (String.valueOf(ZonedDateTime.now().toString().charAt(15)));

        time.setText(currentTime);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
