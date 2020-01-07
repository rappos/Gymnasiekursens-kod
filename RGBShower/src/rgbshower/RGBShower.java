package rgbshower;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RGBShower extends Application {

    int r = 0;
    int g = 0;
    int b = 255;

    @Override
    public void start(Stage primaryStage) {

        Text txt = new Text("Skriv färgens RGB-värde i rutorna");

        TextField txfR = new TextField();
        txfR.setText("0");
        txfR.setPrefWidth(35);
        txfR.setStyle("-fx-background-color: red;");

        TextField txfG = new TextField();
        txfG.setText("0");
        txfG.setPrefWidth(35);
        txfG.setStyle("-fx-background-color: green;");

        TextField txfB = new TextField();
        txfB.setText("255");
        txfB.setPrefWidth(35);
        txfB.setStyle("-fx-background-color: blue;");

        Button btn = new Button("Visa färg");
       

        Rectangle rect = new Rectangle(500, 200);
        rect.setFill(Color.BLUE);

        HBox rutorOchKnappar = new HBox();
        rutorOchKnappar.setSpacing(5);
        rutorOchKnappar.setMaxWidth(180);
               
        rutorOchKnappar.getChildren().addAll(txfR, txfG, txfB, btn);
        VBox allaTillsammans = new VBox(5);
        allaTillsammans.setAlignment(Pos.CENTER);
        allaTillsammans.getChildren().addAll(txt, rutorOchKnappar, rect);

        Scene scene = new Scene(allaTillsammans, 550, 320);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

        btn.setOnAction((ActionEvent event) -> {
            if (r < 256 && g < 256 && b < 256 && r >= 0 && g >= 0 && b >= 0) {
                r = Integer.parseInt(txfR.getText());
                g = Integer.parseInt(txfG.getText());
                b = Integer.parseInt(txfB.getText());

                rect.setFill(Color.rgb(r, g, b));

            }
        });
        scene.addEventHandler(KeyEvent.KEY_PRESSED, (KeyEvent t) -> {
            if (t.getCode() == KeyCode.ESCAPE) {
                primaryStage.close();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}
