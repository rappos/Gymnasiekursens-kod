package flag;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Flag extends Application {
    
    Canvas canvas = new Canvas(600, 400);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    
    @Override
    public void start(Stage primaryStage) {
        
        StackPane root = new StackPane();
        root.getChildren().addAll(canvas);
        Scene scene = new Scene(root, 600, 400);
        gc.setFill(Color.rgb(0, 106, 167));
        gc.fillRect(0, 0, 600, 400);
        gc.setFill(Color.rgb(254, 204, 0));
        gc.fillRect(280, 0, 40, 400);
       gc.fillRect(0, 180, 600, 40);
        
        primaryStage.setTitle("Flaggan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
