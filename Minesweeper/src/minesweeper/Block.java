package minesweeper;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Block {

    private int x;
    private int y;
    private int w;
    private boolean isBomb;
    private boolean isOpened;
    private int neighbour;

    public Block(int x, int y, int w, boolean isBomb, boolean isOpened) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.isBomb = isBomb;
        this.isOpened = isOpened;
        this.neighbour = 0;
    }

    @Override
    public String toString() {
        return "Block{" + "x=" + x + ", y=" + y + ", w=" + w + ", isBomb=" + isBomb + ", isOpened=" + isOpened + '}';
    }

    public boolean isIsBomb() {
        return isBomb;
    }

    public boolean isIsOpened() {
        return isOpened;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void openBlock() {
        this.isOpened = true;
    }

    public void placeBomb() {
        this.isBomb = true;
    }

    public void countNeighbours(int num) {
        this.neighbour = num;
    }

    public int getGranne() {
        return neighbour;
    }

    void draw(GraphicsContext gc, int uniSize) {
        if (!isOpened) {
            gc.setStroke(Color.BLACK);
            gc.strokeRect(getX(), getY(), uniSize, uniSize);
            gc.setFill(Color.rgb(51, 204, 255));
            gc.fillRect(getX() + 1, getY() + 1, uniSize - 1, uniSize - 1);
        } else {
            if (!isBomb) {
                if (neighbour > 0) {
                    gc.setStroke(Color.BLACK);
                    gc.strokeRect(getX(), getY(), uniSize, uniSize);
                    gc.setFill(Color.GREEN);
                    gc.fillRect(getX() + 1, getY() + 1, uniSize - 1, uniSize - 1);

                } else {
                    gc.setStroke(Color.BLACK);
                    gc.strokeRect(getX(), getY(), uniSize, uniSize);
                    gc.setFill(Color.WHITE);
                    gc.fillRect(getX() + 1, getY() + 1, uniSize - 1, uniSize - 1);
                }
            } else {
                gc.setStroke(Color.BLACK);
                gc.strokeRect(getX(), getY(), uniSize, uniSize);
                gc.clearRect(getX() + 2, getY() + 2, uniSize - 2, uniSize - 2);
                gc.setFill(Color.RED);
                gc.fillOval(getX() + 2, getY() + 2, uniSize - 4, uniSize - 4);
            }
        }

    }

    boolean pick(double x, double y, double w) {
        return x > getX() && x < getX() + w && y > getY() && y < getY() + w;
    }

}
