package scaredbutton;

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ScaredButton extends Application {

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(700, 700);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Button btn = new Button("Komsi");
        Pane root = new Pane();

        root.getChildren().addAll(btn,canvas);

        Random rand = new Random();
        int x = rand.nextInt((int) (700 - btn.getWidth()));
        int y = rand.nextInt((int) (700 - btn.getWidth()));
        btn.setLayoutX(x);
        btn.setLayoutY(y);

        Scene scene = new Scene(root, 700, 700);

        canvas.setOnMouseMoved((MouseEvent me) -> {

            btn.setLayoutX(me.getX()+rand.nextInt(28));
            btn.setLayoutY(me.getY()+rand.nextInt(28));
        });
      

        primaryStage.setTitle("Hej");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
