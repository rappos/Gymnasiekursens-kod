package sliderleftright;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SliderLeftRight extends Application {

    @Override
    public void start(Stage primaryStage) {
        Insets inset = new Insets(40, 0, 0, 0);

        Slider slider = new Slider();
        slider.setMin(-10);
        slider.setMax(10);
        slider.setValue(0);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(1); 
        slider.setMinorTickCount(1);
        slider.setBlockIncrement(1);
        slider.setSnapToTicks(true);
        slider.setBlockIncrement(1);
        slider.setMaxWidth(340);
        slider.setTranslateX(290);
        slider.setScaleY(2);
        slider.setScaleX(2);

        Circle crc = new Circle(40);
        crc.setTranslateX(420);
        Image sunImg = new Image("/sliderleftright/sun.jpg");
        ImagePattern sunPattern = new ImagePattern(sunImg);
        crc.setFill(sunPattern);

        VBox root = new VBox();
        root.setSpacing(60);
        root.setPadding(inset);

        root.getChildren().addAll(slider, crc);

        Scene scene = new Scene(root, 900, 250);

        Timeline goLeft = new Timeline(new KeyFrame(
                Duration.millis(20),
                (ActionEvent e) -> {
                    crc.setTranslateX(crc.getTranslateX() + slider.valueProperty().intValue() * 1);
                    crc.setRotate(crc.getRotate() + slider.valueProperty().intValue() * 1);
                    if (crc.getTranslateX() < 0) {
                        crc.setTranslateX(820);
                    }
                }
        ));
        Timeline goRight = new Timeline(new KeyFrame(
                Duration.millis(20),
                (ActionEvent e) -> {
                    crc.setTranslateX(crc.getTranslateX() + slider.valueProperty().intValue() * 1);
                    crc.setRotate(crc.getRotate() + slider.valueProperty().intValue() * 1);
                    if (crc.getTranslateX() > 820) {
                        crc.setTranslateX(0);
                    }
                }
        ));

        goLeft.setCycleCount(Timeline.INDEFINITE);
        goRight.setCycleCount(Timeline.INDEFINITE);

        slider.valueProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue arg0, Object arg1, Object arg2) {
                if (slider.valueProperty().intValue() < 0) {
                    goRight.stop();
                    goLeft.play();
                }
                if (slider.valueProperty().intValue() > 0) {
                    goLeft.stop();
                    goRight.play();
                }
                if (slider.valueProperty().intValue() == 0) {
                    goLeft.stop();
                    goRight.stop();
                }

            }
        });

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
