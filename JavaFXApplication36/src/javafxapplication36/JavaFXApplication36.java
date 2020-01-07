package javafxapplication36;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFXApplication36 extends Application {
    
    int i = 0;
    int j = 0;
    Timeline tline;
    
    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(256, 256);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        Pane root = new Pane();
        root.getChildren().addAll(canvas);
        
        Scene scene = new Scene(root, 246, 256);
        
        tline = new Timeline(new KeyFrame(
                Duration.millis(0.5),
                (ActionEvent e) -> {
                    if (i < 256) {
                        if (j < 256) {
                            gc.setFill(Color.rgb(255-i, 255-j, 255-j));
                            gc.fillRect(j, i, 1, 1);
                            j++;
                        } else {
                            j = 0;
                            i++;
                        }
                    } else {
                        tline.stop();
                    }
                    
                }
        ));
        tline.setCycleCount(Animation.INDEFINITE);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        tline.play();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
