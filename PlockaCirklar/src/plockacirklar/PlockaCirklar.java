package plockacirklar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//Program som använder klassen Cirkel (finns i separat java-fil)
//för att rita cirklar som kan sorteras med musklick
public class PlockaCirklar extends Application {

    private Circle[] circles = new Circle[10];
    Canvas canvas;

    @Override
    public void start(Stage primaryStage) {
        //skapa cirklar
        for (int i = 0; i < circles.length; i++) {
            circles[i] = new Circle(100 + 60 * i, 200 - 10 * i, 75 - 3 * i,
                    Color.rgb(255, 20 * i, 200 - 10 * i));
        }
        canvas = new Canvas(800, 600);
        canvas.setOnMouseClicked((MouseEvent me) -> {
            //Anropa metoden mouse-clicked
            //Sista parametern är sann om klicket kommer från högerknappen
            mouseClicked(me.getX(), me.getY(), me.getButton() == MouseButton.SECONDARY);
        });

        StackPane root = new StackPane();
        root.getChildren().add(canvas);

        redraw();

        Scene scene = new Scene(root);

        primaryStage.setTitle("Cirklar");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Byter plats på två cirklar i arrayen
    public void swap(int index1, int index2) {
        Circle temp;
        temp = circles[index1];
        circles[index1] = circles[index2];
        circles[index2] = temp;
    }

    public static void main(String[] args) {
        launch(args);
    }

    //Körs när musen klickats vid givna koordinater.
    //Secondry är true om det är höger- i st f vänsterknapp
    private void mouseClicked(double x, double y, boolean secondary) {
        //Gå igenom cirklarna från sist till först eftersom den sista
        //ritas sist och därför ligger överst.
        for (int i = circles.length - 1; i >= 0; i--) {
            if (circles[i].pick(x, y)) {
                if (secondary) {
                    moveToFirst(i); //Lägg cirkel i förstst i listan
                } else {
                    moveToLast(i); //Lägg cirkel i sist i listan
                }
                redraw(); //Rita om allt
                break; //Leta inte efter någon mer cirkel som träffats
            }
        }
    }

    //Rita om allt
    private void redraw() {
        //Sudda hela bilden först
        canvas.getGraphicsContext2D().
                clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        //Rita upp cirklarna
        for (Circle c : circles) {
            c.paint(canvas);
        }

    }

    //Flytta cirkeln på plats n till början (plats 0)
    //Mer om detta senare när vi jobbar med sortering

    private void moveToFirst(int n) {
        //Gör en serie platsbyten för att nå rätt slutresultat
        for (int i = n - 1; i >= 0; i--) {
            swap(i, i + 1);
        }
    }

    //Flytta cirkeln på plats n till slutet
    //Mer om detta senare när vi jobbar med sortering
    private void moveToLast(int n) {
        //Gör en serie platsbyten för att nå rätt slutresultat
        for (int i = n + 1; i < circles.length; i++) {
            swap(i, i - 1);
        }
    }

}
