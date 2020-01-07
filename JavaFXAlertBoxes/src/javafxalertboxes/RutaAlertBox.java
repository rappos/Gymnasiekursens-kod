package javafxalertboxes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RutaAlertBox {

    public static void display(String title, String message) {
        Stage window = new Stage();

        //Blockar det bakom tills den tas hand om
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);
        window.setMinHeight(100);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Stäng rutan");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new Vbox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

    }

}
