package skifferknappar;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class SkifferKnappar extends Application {

    Button button;
    Stage window;
    Scene scen;
    String text = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Brädgårdschiffer");

        //Alfabetets knappar
        Button bA = new Button("A");
        GridPane.setConstraints(bA, 0, 1);
        bA.setOnAction(e -> text = text + "A");
        Button bB = new Button("B");
        GridPane.setConstraints(bB, 1, 1);
        bB.setOnAction(e -> text = text + "B");
        Button bC = new Button("C");
        GridPane.setConstraints(bC, 2, 1);
        bC.setOnAction(e -> text = text + "C");
        Button bD = new Button("D");
        GridPane.setConstraints(bD, 0, 2);
        bD.setOnAction(e -> text = text + "D");
        Button bE = new Button("E");
        GridPane.setConstraints(bE, 1, 2);
        bE.setOnAction(e -> text = text + "E");
        Button bF = new Button("F");
        GridPane.setConstraints(bF, 2, 2);
        bF.setOnAction(e -> text = text + "F");
        Button bG = new Button("G");
        GridPane.setConstraints(bG, 0, 3);
        bG.setOnAction(e -> text = text + "G");
        Button bH = new Button("H");
        GridPane.setConstraints(bH, 1, 3);
        bH.setOnAction(e -> text = text + "H");
        Button bI = new Button("I");
        GridPane.setConstraints(bI, 2, 3);
        bI.setOnAction(e -> text = text + "I");
        Button bJ = new Button("J");
        GridPane.setConstraints(bJ, 4, 4);
        bJ.setOnAction(e -> text = text + "J");
        Button bK = new Button("K");
        GridPane.setConstraints(bK, 5, 4);
        bK.setOnAction(e -> text = text + "K");
        Button bL = new Button("L");
        GridPane.setConstraints(bL, 6, 4);
        bL.setOnAction(e -> text = text + "L");
        Button bM = new Button("M");
        GridPane.setConstraints(bM, 4, 5);
        bM.setOnAction(e -> text = text + "M");
        Button bN = new Button("N");
        GridPane.setConstraints(bN, 5, 5);
        bN.setOnAction(e -> text = text + "N");
        Button bO = new Button("O");
        GridPane.setConstraints(bO, 6, 5);
        bO.setOnAction(e -> text = text + "O");
        Button bP = new Button("P");
        GridPane.setConstraints(bP, 4, 6);
        bP.setOnAction(e -> text = text + "P");
        Button bR = new Button("R");
        GridPane.setConstraints(bR, 5, 6);
        bR.setOnAction(e -> text = text + "R");
        Button bS = new Button("S");
        GridPane.setConstraints(bS, 6, 6);
        bS.setOnAction(e -> text = text + "S");
        Button bT = new Button("T");
        GridPane.setConstraints(bT, 8, 1);
        bT.setOnAction(e -> text = text + "T");
        Button bU = new Button("U");
        GridPane.setConstraints(bU, 9, 1);
        bU.setOnAction(e -> text = text + "U");
        Button bV = new Button("V");
        GridPane.setConstraints(bV, 10, 1);
        bV.setOnAction(e -> text = text + "V");
        Button bX = new Button("X");
        GridPane.setConstraints(bX, 8, 2);
        bX.setOnAction(e -> text = text + "X");
        Button bY = new Button("Y");
        GridPane.setConstraints(bY, 9, 2);
        bY.setOnAction(e -> text = text + "Y");
        Button bZ = new Button("Z");
        GridPane.setConstraints(bZ, 10, 2);
        bZ.setOnAction(e -> text = text + "Z");
        Button bÅ = new Button("Å");
        GridPane.setConstraints(bÅ, 8, 3);
        bÅ.setOnAction(e -> text = text + "Å");
        Button bÄ = new Button("Ä");
        GridPane.setConstraints(bÄ, 9, 3);
        bÄ.setOnAction(e -> text = text + "Ä");
        Button bÖ = new Button("Ö");
        GridPane.setConstraints(bÖ, 10, 3);
        bÖ.setOnAction(e -> text = text + "Ö");

        //Mellanslagsknappen
        Button bSpace = new Button("      ");
        GridPane.setConstraints(bSpace, 5, 2);
        bSpace.setOnAction(e -> text = text + " ");

        //Enterknapp
        Button bKlar = new Button("Klar");
        GridPane.setConstraints(bKlar, 5, 1);
        bKlar.setOnAction(e -> {
            System.out.println(text);
            text = "";
            SvarBox.display(text);
            closeProgram();
        });

        //Indikationsprickarna
        Label prick = new Label("   •");
        GridPane.setConstraints(prick, 5, 3);
        Label prick2 = new Label("  ••");
        GridPane.setConstraints(prick2, 9, 0);

        //Sätter upp rutans grid
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        //Placerar alla saker
        grid.getChildren().addAll(
                bA, bB, bC, bD, bE, bF, bG, bH, bI, bJ, bK, bL, bM, bN, bO, bP, bR,
                bS, bT, bU, bV, bX, bY, bZ, bÅ, bÄ, bÖ, prick, prick2, bSpace, bKlar);

        //Startar rutan
        Scene scen = new Scene(grid, 360, 230);
        window.setMinWidth(380);
        window.setMinHeight(270);
        window.setMaxWidth(380);
        window.setMaxHeight(270);
        window.centerOnScreen();
        window.setScene(scen);
        window.show();
    }

    private void closeProgram() {
        Boolean answer = ConfirmBox.display("", "Vill du stänga programmet?");
        if (answer) {
            window.close();
        }

    }

}
