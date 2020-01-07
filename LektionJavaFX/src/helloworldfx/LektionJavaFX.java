package helloworldfx;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LektionJavaFX extends Application {

    int antalTryck = 0;
    int clownTryck = 1;

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Tryck inte på mig");
        CheckBox cbx = new CheckBox("Knas");
        Circle circ = new Circle(100, 300, 75);
        Rectangle rct = new Rectangle(100, 80);
        Ellipse elp = new Ellipse(100, 50);
        Text txt = new Text("Swoosh i en cirkel");
        Text visaTryck = new Text("Antal tryck: " + Integer.toString(antalTryck));
        TextField txf = new TextField("Skriv här!");
        Text shw = new Text("Så visas det här");

        Image clown = new Image(getClass().getResourceAsStream("clown.png"));
        Button btnClown = new Button("", new ImageView(clown));

        ImageView clownBild = new ImageView(clown);

        shw.setScaleX(2);
        shw.setScaleY(2);
        shw.toBack();

        circ.setStroke(Color.ORANGE);
        circ.setFill(Color.PURPLE);
        circ.setStrokeWidth(20);

        rct.setStroke(Color.BLUE);
        rct.setFill(Color.CRIMSON);
        rct.setStrokeWidth(20);

        elp.setStroke(Color.LIGHTSEAGREEN);
        elp.setFill(Color.TRANSPARENT);
        elp.setStrokeWidth(20);

        cbx.setSelected(false);
        cbx.selectedProperty().addListener((ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
            if (cbx.isSelected()) {
                circ.setStroke(Color.PURPLE);
                circ.setFill(Color.ORANGE);
                rct.setStroke(Color.CRIMSON);
                rct.setFill(Color.BLUE);
                elp.setStroke(Color.TRANSPARENT);
                elp.setFill(Color.LIGHTSEAGREEN);
            } else {
                circ.setStroke(Color.ORANGE);
                circ.setFill(Color.PURPLE);
                rct.setStroke(Color.BLUE);
                rct.setFill(Color.CRIMSON);
                elp.setStroke(Color.LIGHTSEAGREEN);
                elp.setFill(Color.TRANSPARENT);
            }
        });

        txf.setOnAction((ActionEvent event) -> {
            shw.setText(txf.getText());
        });

        btn.setOnAction((ActionEvent event) -> {
            txt.setRotate(txt.getRotate() + 10);
            antalTryck++;
            visaTryck.setText("Antal tryck: " + Integer.toString(antalTryck));
        });

        TilePane root = new TilePane();
        root.getChildren().addAll(btn, txt, visaTryck, txf, shw, cbx, circ, rct, elp, btnClown, clownBild);

        int screenWidth = 1366;
        int screenHeight = 768;
        Scene scene = new Scene(root, screenWidth, screenHeight);

        primaryStage.setTitle("Wow ett namn på en ruta");
        primaryStage.centerOnScreen();
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();

        Timeline tline = new Timeline(new KeyFrame(
                Duration.millis(100),
                (ActionEvent e) -> {
                    rct.setRotate(rct.getRotate() + 1);
                    elp.setRotate(elp.getRotate() + 1);
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

    public static void main(String[] args) {
        launch(args);
    }
}
