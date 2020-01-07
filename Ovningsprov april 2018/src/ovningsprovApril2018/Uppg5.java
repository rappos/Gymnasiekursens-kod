package ovningsprovApril2018;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Uppg5 extends Application {

    private final int[] array = {111, 222, 200, 178, 46, 291, 25, 17, 147, 220, 3, 7, 2, 1, 5, 8, 4, 17, 100, 48};
    private int workingIndex = -1; //Index till det tal som håller på att flyttas (för färgmärkning)
    private int numberSorted = 0; //Antal färdigsorterade tal (för färgmärkning)
    private boolean sortRunning = false; //Så att man inte kan starta flera sorteringar samtidigt

    public void start(Stage primaryStage) {
        Button sortBtn = new Button("Sortera");
        Button shuffleBtn = new Button("Blanda");

        Canvas canvas = new Canvas(250, 300);
        VBox root = new VBox(10);
        root.getChildren().addAll(canvas, sortBtn, shuffleBtn);

        Scene scene = new Scene(root);

        // Skapa en timeline som gör att metoden draw() körs varje 30
        //millisekunder.
        Timeline tline = new Timeline(new KeyFrame(Duration.millis(30),
                (ActionEvent e) -> {
                    draw(canvas);
                }
        ));
        tline.setCycleCount(Timeline.INDEFINITE);
        tline.play();

        //Skapa en separat tråd som kör metoden sort() SAMTIDIGT som
        //resten av programmet fortsätter
        Runnable runnable = () -> {
            sort();
        };
        sortBtn.setOnAction((ActionEvent event) -> {
            if (!sortRunning) {
                sortRunning = true;
                new Thread(runnable).start();
            }

        });
        shuffleBtn.setOnAction((ActionEvent event) -> {
            if (!sortRunning) {
                shuffle(array);
                numberSorted = 0;
            }
        });

        primaryStage.setTitle("Gafisk sortering");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void draw(Canvas can) {
        GraphicsContext gc = can.getGraphicsContext2D();

        //All användning av arrayen måste stå innanför synchronized-blocket
        //så att inte sorteringstråden kan ändra i arrayen medan vi använder den
        //för att rita.
        synchronized (array) {
            gc.clearRect(0, 0, can.getWidth(), can.getHeight());
            int diameter = 5;
            for (int i = 0; i < array.length; i++) {
                //Rita i olika färger (krävs ej)
                gc.setFill(Color.BLACK); //Normal färg
                if (i < numberSorted) {
                    gc.setFill(Color.LIME); //Punkten färdigsorterad&
                }
                if (i == workingIndex) {
                    gc.setFill(Color.RED); //Färg för aktuell punkt
                }
                gc.fillOval(i * 10, can.getHeight() - array[i] - diameter, diameter, diameter);
            }
        }
    }

    //Insertion sort (infogande sortering)
    //Sorterar arrayen array
    public void sort() {
        //Början av listan sorteras genom att vi sätter in
        //ett element i taget från den osorterade delen av listan.
        //Vi tar då det första osorterade elementet (firstUnsorted nedan)
        //och sätter in det på rätt plats (som ska pekas ut av i nedan).
        int n = array.length; //Antalet element att sortera
        synchronized (array) {
            //Variabler för färgmärkning
            workingIndex = -1; //Inget element håller på att infogas
            numberSorted = 1; //Första elementet är sorterat av sig själv.

            for (int firstUnsorted = 1; firstUnsorted < n; firstUnsorted++) {
                int i = firstUnsorted; //i är ett index som ska flyttas så att det pekar
                //där ett element ska infogas.
                //Det första osorterade elementet ska sättas in i den sorterade delen:
                int valueToInsert = array[firstUnsorted];
                //Nu flyttar vi i stegvis mot början av listan tills vi hittar rätt
                //plats att sätta in valueToInsert på.
                numberSorted++; //Ett element till sorteras in nu, ändra färgmärkning
                while (i > 0) {
                    workingIndex = i; //För att rita en punkt i annan färg
                    //Vänta 100 millisekunder och låt draw-metoden komma åt arrayen
                    try {
                        array.wait(100);
                    } catch (InterruptedException ex) {
                    } //Måste vara med men gör inget
                    //Kolla om infogningen är klar
                    if (array[i - 1] < valueToInsert) {
                        //Elementet som ska infogas har kommit rätt 
                        //Avbryt infogningen
                        break;
                    }
                    //valueToinsert ska vara före data[i-1]
                    //data[i-1] flyttas mot slutet av listan för att ge plats
                    //I denna variant av insertion sort ska värdet som ska infogas
                    //flyttas steg för steg, så vi byter helt enkelt plats på de
                    //två värdena
                    swap(array, i, i - 1);
                    i--; //Nästa varv tittar vi om elementet innan också är större och ska flyttas                    
                }
                workingIndex = -1; //Inget aktuellt index (ingen avvikande färg)
            }
            sortRunning = false; //Färdigsorterat!
        }

    }

    //Byt plats på två element (index i och j) i arrayen data
    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    // Blanda en heltalsarray slumpmässigt
    private static void shuffle(int[] array) {
        //Gå igenom alla elementen
        for (int i = 0; i < array.length - 1; i++) {
            //Slumpa ett index för element som ska stå på plats i.
            //Ska vara minst i och max arrayens längd minus ett.
            //Redan slumpade element (före plats i) påverkas då inte.
            int j = i + (int) (Math.random() * (array.length - i));
            swap(array, i, j);
        }
    }

}
