package letspaint;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

public class LetsPaint extends Application {

    int r = 0;
    int g = 0;
    int b = 0;
    int brushSizeInt = 5;
    Insets hInset = new Insets(5, 0, 0, 5);
    boolean isBrushClicked = false;
    int width = 900;
    int height = 600;
    boolean isMirror = false;

    @Override
    public void start(Stage primaryStage) {

        Canvas canvas = new Canvas(910, 610);
        canvas.toBack();
        GraphicsContext gc = canvas.getGraphicsContext2D();

        HBox knappFack = new HBox(10);
        knappFack.setPadding(hInset);

        Button btnReset = new Button("Reset");
        btnReset.setPrefWidth(45);

        Label brushSizeLabel = new Label("Brush Size");
        TextField brushSize = new TextField("5");
        brushSize.setPrefWidth(4);
        brushSize.toFront();
        VBox brushBox = new VBox(5, brushSizeLabel, brushSize);
        brushBox.setAlignment(Pos.CENTER);

        Label typeBrushLabel = new Label("Brush Type");
        Button typeBrush = new Button("Square");
        typeBrush.setPrefWidth(56);
        VBox typeBrushBox = new VBox(5, typeBrushLabel, typeBrush);
        typeBrushBox.setAlignment(Pos.CENTER);

        TextField txfR = new TextField();
        txfR.setText("0");
        txfR.setPrefWidth(35);
        txfR.setStyle("-fx-background-color: red;");
        TextField txfG = new TextField();
        txfG.setText("0");
        txfG.setPrefWidth(35);
        txfG.setStyle("-fx-background-color: green;");
        TextField txfB = new TextField();
        txfB.setText("0");
        txfB.setPrefWidth(35);
        txfB.setStyle("-fx-background-color: blue;");
        Button btnColor = new Button("Change color");
        btnColor.setAlignment(Pos.CENTER);
        Rectangle rectColor = new Rectangle(16, 16);
        rectColor.setFill(Color.BLACK);
        rectColor.setStrokeWidth(2);
        rectColor.setStroke(Color.WHITE);

        HBox colorRow = new HBox(5, txfR, txfG, txfB);
        colorRow.setAlignment(Pos.CENTER);

        HBox textMKnapp = new HBox(5, btnColor, rectColor);

        VBox colorMain = new VBox(textMKnapp, colorRow);
        colorMain.setAlignment(Pos.CENTER);

        Button btnSave = new Button("Save");

        Button btnMirror = new Button("Mirror");
        btnMirror.setAlignment(Pos.CENTER);
        Label lblMirror = new Label("Not mirrored");
        lblMirror.setAlignment(Pos.CENTER);
        VBox mirrorStack = new VBox(5, btnMirror, lblMirror);
        mirrorStack.setAlignment(Pos.CENTER);
        mirrorStack.setPrefWidth(70);

        knappFack.getChildren().addAll(btnReset, brushBox, typeBrushBox, colorMain, mirrorStack, btnSave);
        knappFack.toFront();

        Pane root = new Pane();
        root.getChildren().addAll(canvas, knappFack);

        Scene scene = new Scene(root, width, height);

        primaryStage.setTitle("Let's Paint!");
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.requestFocus();
        primaryStage.setResizable(false);
        primaryStage.show();

        btnSave.setOnAction((ActionEvent t) -> {
            timeToSave(primaryStage, canvas);
        });

        btnMirror.setOnAction((ActionEvent event) -> {
            mirrorTheMethod(lblMirror);
        });

        btnColor.setOnAction((ActionEvent event) -> {
            changeColor(txfR, gc, rectColor, txfG, txfB);
        });

        typeBrush.setOnAction((ActionEvent event) -> {
            changeBrushBoi(typeBrush);
        });

        brushSize.setOnAction((ActionEvent event) -> {
            brushSizeInt = Integer.parseInt(brushSize.getText());
        });
        btnReset.setOnAction((ActionEvent event) -> {
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        });

        canvas.setOnMouseClicked((MouseEvent me) -> {
            draw(gc, me);

        });
        canvas.setOnMouseDragged((MouseEvent me) -> {
            draw(gc, me);
        });
    }

    private void mirrorTheMethod(Label lblMirror) {
        if (!isMirror) {
            isMirror = true;
            lblMirror.setText("Mirrored");
        } else {
            isMirror = false;
            lblMirror.setText("Not mirrored");
        }
    }

    private void timeToSave(Stage primaryStage, Canvas canvas) {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterPng = new FileChooser.ExtensionFilter("PNG (*.png)", "*.png");
        FileChooser.ExtensionFilter extFilterJpg = new FileChooser.ExtensionFilter("JPEG (*.jpg)", "*.jpg");
        FileChooser.ExtensionFilter extFilterGif = new FileChooser.ExtensionFilter("GIF (*.gif)", "*.gif");
        FileChooser.ExtensionFilter extFilterBmp = new FileChooser.ExtensionFilter("BMP (*.bmp)", "*.bmp");
        fileChooser.getExtensionFilters().addAll(extFilterPng, extFilterJpg, extFilterGif, extFilterBmp);
        File file = fileChooser.showSaveDialog(primaryStage);
        if (file != null) {
            try {
                WritableImage writableImage = new WritableImage(900, 600);
                canvas.snapshot(null, writableImage);
                RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                ImageIO.write(renderedImage, "png", file);
            } catch (IOException ex) {
                Logger.getLogger(LetsPaint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void changeBrushBoi(Button typeBrush) {
        if (!isBrushClicked) {
            typeBrush.setText("Circle");
            isBrushClicked = true;
        } else {
            typeBrush.setText("Square");
            isBrushClicked = false;
        }
    }

    private void changeColor(TextField txfR, GraphicsContext gc, Rectangle rectColor, TextField txfG, TextField txfB) throws NumberFormatException {
        if (Integer.parseInt(txfR.getText()) < 256 && Integer.parseInt(txfR.getText()) >= 0) {
            r = Integer.parseInt(txfR.getText());
            gc.setFill(Color.rgb(r, g, b));
            rectColor.setFill(Color.rgb(r, g, b));
        } else {
            r = 255;
        }
        if (Integer.parseInt(txfG.getText()) < 256 && Integer.parseInt(txfG.getText()) >= 0) {
            g = Integer.parseInt(txfG.getText());
            gc.setFill(Color.rgb(r, g, b));
            rectColor.setFill(Color.rgb(r, g, b));
        } else {
            g = 255;
        }
        if (Integer.parseInt(txfB.getText()) < 256 && Integer.parseInt(txfB.getText()) >= 0) {
            b = Integer.parseInt(txfB.getText());
            gc.setFill(Color.rgb(r, g, b));
            rectColor.setFill(Color.rgb(r, g, b));
        } else {
            b = 255;
        }
    }

    private void draw(GraphicsContext gc, MouseEvent me) {
        if (isMirror) {
            if (!isBrushClicked) {
                gc.fillRect(me.getX() - brushSizeInt / 2, me.getY() - brushSizeInt / 2, brushSizeInt, brushSizeInt);
                gc.fillRect(width - me.getX() - brushSizeInt / 2, me.getY() - brushSizeInt / 2, brushSizeInt, brushSizeInt);
            } else {
                gc.fillOval(me.getX() - brushSizeInt / 2, me.getY() - brushSizeInt / 2, brushSizeInt, brushSizeInt);
                gc.fillOval(width - me.getX() - brushSizeInt / 2, me.getY() - brushSizeInt / 2, brushSizeInt, brushSizeInt);
            }
        } else {
            if (!isBrushClicked) {
                gc.fillRect(me.getX() - brushSizeInt / 2, me.getY() - brushSizeInt / 2, brushSizeInt, brushSizeInt);
            } else {
                gc.fillOval(me.getX() - brushSizeInt / 2, me.getY() - brushSizeInt / 2, brushSizeInt, brushSizeInt);
            }

        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
