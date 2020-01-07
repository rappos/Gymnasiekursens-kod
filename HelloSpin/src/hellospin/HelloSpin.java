package hellospin;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloSpin extends Application {

    int i = 0;
    Timeline tline;

    @Override
    public void start(Stage primaryStage) {

        String[] alphabet = new String[]{"A", "a", "B", "b", "C", "c", "D", "d", "E", "e", "F", "f", "G", "g", "H", "h", "I", "i", "J", "j", "K", "k", "L", "l", "M", "m", "N", "n", "O", "o", "P", "p", "Q", "q", "R", "r", "S", "s", "T", "t", "U", "u", "V", "v", "W", "w", "X", "x", "Y", "y", "Z", "z", " ", "!"};
        String[] answer = new String[]{"H", "e", "l", "l", "o", " ", "W", "o", "r", "l", "d", "!"};
        String[] input = new String[answer.length];

        Text txt = new Text("");
        txt.setScaleX(5);
        txt.setScaleY(5);

        Random rand = new Random();

        StackPane root = new StackPane(txt);
        root.getChildren().addAll();

        Scene scene = new Scene(root, 340, 100);

        tline = new Timeline(new KeyFrame(
                Duration.millis(10),
                (ActionEvent e) -> {

                    try {
                        input[i] = alphabet[rand.nextInt(alphabet.length)];
                        if (input[i].equals(answer[i])) {
                            txt.setText(txt.getText() + input[i]);
                            i++;
                        }
                    } catch (ArrayIndexOutOfBoundsException b) {
                        tline.stop();
                    }
                }
        ));
        tline.setCycleCount(Timeline.INDEFINITE);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        tline.play();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
