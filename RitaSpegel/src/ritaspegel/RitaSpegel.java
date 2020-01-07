package ritaspegel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RitaSpegel extends Application {

    int width = 900;
    int height = 600;

    @Override
    public void start(Stage primaryStage) {

        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Pane root = new Pane();
        root.getChildren().addAll(canvas);

        Scene scene = new Scene(root, width, height);

        canvas.setOnMouseClicked((MouseEvent me) -> {
            gc.fillRect(me.getX() - 2, me.getY() - 2, 5, 5);
            gc.fillRect(width - me.getX() - 2, me.getY() - 2, 5, 5);
        });
        canvas.setOnMouseDragged((MouseEvent me) -> {
            gc.fillRect(me.getX(), me.getY(), 5, 5);
            gc.fillRect(width - me.getX() - 2, me.getY() - 2, 5, 5);
        });

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
