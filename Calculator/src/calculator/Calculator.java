package calculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Calculator extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();

        Button btn1 = new Button("1");
        root.add(btn1, 0, 0);
        btn1.setPrefSize(100, 100);
        btn1.setStyle("-fx-font: 41 arial; -fx-base: #42bff4;");

        Button btn2 = new Button("2");
        root.add(btn2, 1, 0);
        btn2.setPrefSize(100, 100);
        btn2.setStyle("-fx-font: 41 arial; -fx-base: #42bff4;");

        Button btn3 = new Button("3");
        root.add(btn3, 2, 0);
        btn3.setPrefSize(100, 100);
        btn3.setStyle("-fx-font: 41 arial; -fx-base: #42bff4;");

        Button btn4 = new Button("4");
        root.add(btn4, 0, 1);
        btn4.setPrefSize(100, 100);
        btn4.setStyle("-fx-font: 41 arial; -fx-base: #42bff4;");

        Button btn5 = new Button("5");
        root.add(btn5, 1, 1);
        btn5.setPrefSize(100, 100);
        btn5.setStyle("-fx-font: 41 arial; -fx-base: #42bff4;");

        Button btn6 = new Button("6");
        root.add(btn6, 2, 1);
        btn6.setPrefSize(100, 100);
        btn6.setStyle("-fx-font: 41 arial; -fx-base: #42bff4;");

        Button btn7 = new Button("7");
        root.add(btn7, 0, 2);
        btn7.setPrefSize(100, 100);
        btn7.setStyle("-fx-font: 41 arial; -fx-base: #42bff4;");

        Button btn8 = new Button("8");
        root.add(btn8, 1, 2);
        btn8.setPrefSize(100, 100);
        btn8.setStyle("-fx-font: 41 arial; -fx-base: #42bff4;");

        Button btn9 = new Button("9");
        root.add(btn9, 2, 2);
        btn9.setPrefSize(100, 100);
        btn9.setStyle("-fx-font: 41 arial; -fx-base: #42bff4;");

        Button btn0 = new Button("0");
        root.add(btn0, 1, 3);
        btn0.setPrefSize(100, 100);
        btn0.setStyle("-fx-font: 41 arial; -fx-base: #42bff4;");

        Button btnPlus = new Button("+");
        root.add(btnPlus, 4, 0);
        btnPlus.setPrefSize(100, 100);
        btnPlus.setStyle("-fx-font: 41 arial; -fx-base: #42bff4;");

        Button btnMinus = new Button("-");
        root.add(btnMinus, 4, 1);
        btnMinus.setPrefSize(100, 100);
        btnMinus.setStyle("-fx-font: 41 arial; -fx-base: #42bff4;");

        Button btnTimes = new Button("*");
        root.add(btnTimes, 4, 2);
        btnTimes.setPrefSize(100, 100);
        btnTimes.setStyle("-fx-font: 41 arial; -fx-base: #42bff4;");

        Button btnDivide = new Button("/");
        root.add(btnDivide, 4, 3);
        btnDivide.setPrefSize(100, 100);
        btnDivide.setStyle("-fx-font: 41 arial; -fx-base: #42bff4;");

        Button btnEquals = new Button("=");
        root.add(btnEquals, 4, 4);
        btnEquals.setPrefSize(100, 100);
        btnEquals.setStyle("-fx-font: 41 arial; -fx-base: #42bff4;");

        Text txt = new Text("");
        root.add(txt, 5, 0);

        Scene scene = new Scene(root, 960, 540);

        primaryStage.setTitle("Calcing machine");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
