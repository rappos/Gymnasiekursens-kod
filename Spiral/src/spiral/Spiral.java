package spiral;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Spiral extends Application {

    Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

    @Override
    public void start(Stage primaryStage) {
       
        int width =  (int) primaryScreenBounds.getWidth();
        int height = (int) primaryScreenBounds.getHeight();
        
        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        StackPane root = new StackPane();
        root.getChildren().addAll(canvas);

        Scene scene = new Scene(root, width, height);
        gc.setStroke(Color.DARKCYAN);
        for (int i = 0; i < width; i++) {
            gc.strokeLine(i, 0, width - i, height);
        }
        gc.setStroke(Color.ORANGERED);
        for (int i = 0; i < height; i++) {
            gc.strokeLine(0, i, width, height - i);
        }
        primaryStage.setTitle("Spiral");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }

}
