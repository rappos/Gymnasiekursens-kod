package webcamtest;

import com.github.sarxos.webcam.Webcam;
import java.awt.Dimension;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class WebcamTest extends Application {

    Scene scene;
    Image img;
    ImageView imgView;
    Webcam webcam;
    Pane root;
    FlowPane knappar;
    Button btnBild, btnVideo;
    boolean isRecording = false;
    Timeline tline;
    java.awt.image.BufferedImage buffImg;
    Canvas canvas;
    GraphicsContext gc;

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas(640, 480);
        gc = canvas.getGraphicsContext2D();
        root = new Pane();
        knappar = new FlowPane();
        btnBild = new Button("Take Picture");
        btnVideo = new Button("Take Video");
        webcam = Webcam.getDefault();
        webcam.setViewSize(new Dimension(640, 480));
        webcam.open();

        btnBild.setOnAction((ActionEvent e) -> {
            takePicture();
        });

        tline = new Timeline(new KeyFrame(
                Duration.millis(1000 / 15),
                (ActionEvent e) -> {
                    takePicture();
                }
        ));
        tline.setCycleCount(Timeline.INDEFINITE);

        btnVideo.setOnAction((ActionEvent e) -> {
            flipRecStatus();
        });

        knappar.getChildren().addAll(btnBild, btnVideo);
        root.getChildren().addAll(canvas, knappar);
        scene = new Scene(root, 640, 480);

        primaryStage.setTitle("NSA Camera");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void flipRecStatus() {
        if (!isRecording) {
            tline.play();
            isRecording = true;
        } else {
            tline.stop();
            isRecording = false;
        }
    }

    private void takePicture() {
        buffImg = webcam.getImage();
        img = SwingFXUtils.toFXImage(buffImg, null);
        buffImg.flush();
        gc.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), img.getWidth(), 0, -img.getWidth(), img.getHeight());
    }

    public static void main(String[] args) {
        launch(args);
    }

}
