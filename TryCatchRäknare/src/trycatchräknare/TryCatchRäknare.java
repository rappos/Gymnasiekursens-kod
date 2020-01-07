package trycatchräknare;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TryCatchRäknare extends Application {

    TextField txf1, txf2;
    Label lbl1, lbl2, lbl3;
    Button btn;
    boolean redo = false;
    Alert noll, ord;

    @Override
    public void start(Stage primaryStage) {
        txf1 = new TextField("");
        txf2 = new TextField("");
        lbl1 = new Label("Tal 1");
        lbl2 = new Label("Tal 2");
        lbl3 = new Label("");
        btn = new Button("Dividera");
        noll = new Alert(Alert.AlertType.ERROR);
        ord = new Alert(Alert.AlertType.ERROR);
        btn.setDisable(true);
        VBox root = new VBox(5);
        root.getChildren().addAll(lbl1, txf1, lbl2, txf2, btn, lbl3);

        Scene scene = new Scene(root, 400, 400);

        btn.setOnAction((ActionEvent event) -> {
            lbl3.setText("Svar: " + Integer.toString(Integer.parseInt(txf1.getText()) / Integer.parseInt(txf2.getText())) + " med resten " + Integer.toString(Integer.parseInt(txf1.getText()) % Integer.parseInt(txf2.getText())));
        });
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

        Timeline tline = new Timeline(new KeyFrame(
                Duration.millis(100),
                (ActionEvent e) -> {
                    testTexts();
                }
        ));
        tline.setCycleCount(Timeline.INDEFINITE);
        tline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void testTexts() {
        try {
            int test = Integer.parseInt(txf1.getText()) / Integer.parseInt(txf2.getText());
            btn.setDisable(false);
        } catch (NumberFormatException e) {
            lbl3.setText("Skriv in ett heltal!!!");
            //  ord.show();
            btn.setDisable(true);
        } catch (ArithmeticException e) {
            lbl3.setText("Du får inte dela med dividera med 0!!!");
            //noll.show();
            btn.setDisable(true);
        }

    }

}
