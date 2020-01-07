package skifferknappar;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SvarBox {

    public static void display(String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Ditt chiffer");
        window.setMinWidth(250);
        window.setMinHeight(100);

        Label label = new Label(message);
        label.setText(message);
        GridPane.setConstraints(label, 0, 0);

        GridPane layout = new GridPane();
        layout.getChildren().add(label);

        Scene scene = new Scene(layout);
        window.setScene(scene);

    }

}
