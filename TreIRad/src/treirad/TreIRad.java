package treirad;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TreIRad extends Application {

    Canvas canvas;
    GraphicsContext gc;
    Button[] btn;

    @Override
    public void start(Stage primaryStage) {

        canvas = new Canvas(600, 600);
        gc = canvas.getGraphicsContext2D();

        btn = new Button[9];

        Pane root = new Pane();

        gc.strokeLine(200, 0, 200, 600);
        gc.strokeLine(400, 0, 400, 600);
        gc.strokeLine(0, 200, 600, 200);
        gc.strokeLine(0, 400, 600, 400);
        gc.strokeLine(600, 0, 600, 600);

        root.getChildren().addAll(canvas);

        for (int i = 0; i < 9; i++) {
            btn[i] = new Button("X");
            btn[i].setPrefSize(200, 200);
            btn[i].setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\n"
                    + "    -fx-background-radius: 360;\n"
                    + "    -fx-background-insets: 0;\n"
                    + "    -fx-text-fill: white;\n"
                    + "    -fx-font-size: 90;");
            
            root.getChildren().addAll(btn[i]);
        }

        int indx = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btn[indx].setLayoutX(200 * i);
                btn[indx].setLayoutY(200 * j);
                indx++;
            }

        }

        Scene scene = new Scene(root, 800, 600);

        actionListeners();

        primaryStage.setTitle("Tre i Rad");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void actionListeners() {
        btn[0].setOnAction((ActionEvent e) -> {
            btn[0].setText("O");
        });
        btn[1].setOnAction((ActionEvent e) -> {
            btn[1].setText("O");
        });
        btn[2].setOnAction((ActionEvent e) -> {
            btn[2].setText("O");
        });
        btn[3].setOnAction((ActionEvent e) -> {
            btn[3].setText("O");
        });
        btn[4].setOnAction((ActionEvent e) -> {
            btn[4].setText("O");
        });
        btn[5].setOnAction((ActionEvent e) -> {
            btn[5].setText("O");
        });
        btn[6].setOnAction((ActionEvent e) -> {
            btn[6].setText("O");
        });
        btn[7].setOnAction((ActionEvent e) -> {
            btn[7].setText("O");
        });
        btn[8].setOnAction((ActionEvent e) -> {
            btn[8].setText("O");
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}
