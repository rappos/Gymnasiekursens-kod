package minesweeper;

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Minesweeper extends Application {

    Canvas canvas;
    GraphicsContext gc;
    int uniSize = 30;
    int coordinates[] = new int[uniSize]; //array för hörncoordinates
    Block blocks[] = new Block[uniSize * uniSize];
    Random rand = new Random(uniSize);
    int bombCounter = 0; //För att göra rätt antal bomber

    @Override
    public void start(Stage primaryStage) {
        canvas = new Canvas((uniSize * 20) + 1, (uniSize * 20) + 1);
        gc = canvas.getGraphicsContext2D();

        fillCoordinates();
        makeBlocks();
        placeTheBombs();

        numberOfNeighbours();
        for (Block block : blocks) {
            block.openBlock();
        }
        Pane root = new Pane();
        root.getChildren().addAll(canvas);
        Scene scene = new Scene(root, (uniSize * 20) + 1, (uniSize * 20) + 1);

        mainDraw();
        canvas.setOnMouseClicked((MouseEvent mouse) -> {
            if (mouse.getButton() == MouseButton.PRIMARY) {
                mouseClicked(mouse.getX(), mouse.getY());
            }
        });

        primaryStage.setTitle("Minesweeper");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void numberOfNeighbours() {
        for (int i = 0; i < uniSize * uniSize; i++) {
            int numToSend = 0;
            if (!blocks[i].isIsBomb()) {
                try {
                    if (blocks[i - 1].isIsBomb()) {
                        numToSend++;
                    }
                } catch (Exception e) {
                }
                try {
                    if (blocks[i + 1].isIsBomb()) {
                        numToSend++;
                    }
                } catch (Exception e) {
                }
                try {
                    if (blocks[i - uniSize].isIsBomb()) {
                        numToSend++;
                    }
                } catch (Exception e) {
                }
                try {
                    if (blocks[i + uniSize].isIsBomb()) {
                        numToSend++;
                    }
                } catch (Exception e) {
                }
                try {
                    if (blocks[i - (uniSize + 1)].isIsBomb()) {
                        numToSend++;
                    }
                } catch (Exception e) {
                }
                try {
                    if (blocks[i + (uniSize + 1)].isIsBomb()) {
                        numToSend++;
                    }
                } catch (Exception e) {
                }
                try {
                    if (blocks[i - (uniSize - 1)].isIsBomb()) {
                        numToSend++;
                    }
                } catch (Exception e) {
                }
                try {
                    if (blocks[i + uniSize - 1].isIsBomb()) {
                        numToSend++;
                    }
                } catch (Exception e) {
                }
            }
            blocks[i].countNeighbours(numToSend);
        }
    }

    private void placeTheBombs() {
        for (Block block : blocks) {
            if (Math.random() < 0.15) {
                block.placeBomb();
            }
        }
    }

    private void makeBlocks() {
        for (int i = 0; i < uniSize; i++) {
            for (int j = 0; j < uniSize; j++) {
                blocks[bombCounter] = new Block(coordinates[j], coordinates[i], uniSize, false, false);
                bombCounter++;
            }
        }
    }

    private void mainDraw() {
        for (Block block : blocks) {
            block.draw(gc, uniSize);
        }
    }

    private void fillCoordinates() {
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i] = i * uniSize;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void mouseClicked(double x, double y) {
        for (Block block : blocks) {
            if (block.pick(x, y, uniSize)) {
                block.openBlock();
                mainDraw();
            }
        }
    }
}
