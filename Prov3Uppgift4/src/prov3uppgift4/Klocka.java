package prov3uppgift4;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Klocka {

    private double centY;
    private double centX;
    private double r;
    private double sec;
    private boolean isClockRunning = false;
    private Timeline tline = new Timeline(new KeyFrame( //TimeLine för uppdatering och stopp av klockan
            Duration.millis(1000), //kör varje sekund
            (ActionEvent e) -> {
                this.sec++;
            }
    ));

    public Klocka(double centY, double centX, double r, double sec, boolean isClockRunning) {
        this.centY = centY;
        this.centX = centX;
        this.r = r;
        this.sec = sec;
        this.isClockRunning = isClockRunning;
        this.tline.setCycleCount(Timeline.INDEFINITE);

    }

    public double getCentY() {
        return centY;
    }

    public void setCentY(double centY) {
        this.centY = centY;
    }

    public double getCentX() {
        return centX;
    }

    public void setCentX(double centX) {
        this.centX = centX;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getSec() {
        return sec;
    }

    public void setSec(double sec) {
        this.sec = sec;
    }

    public void paint(Canvas can) {
        GraphicsContext gc = can.getGraphicsContext2D();
        gc.setFill(Color.YELLOW);
        gc.setLineWidth(3);
        gc.fillOval(centX - r, centY - r, 2 * r, 2 * r);
        gc.setStroke(Color.BLACK);
        gc.strokeOval(centX - r, centY - r, 2 * r, 2 * r);
        gc.strokeLine(centX, centY, clockX(centX, r, sec), clockY(centY, r, sec));
    }

    public boolean pick(double x, double y) {
        return x > (this.centX - r) && x < (this.centX + r) && y > (this.centY - r) && y < (this.centY + r);
    }

    double clockX(double centX, double r, double sec) {
        return centX + r * Math.sin(sec * 2 * Math.PI / 60);
    }

    double clockY(double centY, double r, double sec) {
        return centY - r * Math.cos(sec * 2 * Math.PI / 60);
    }

    public void playStopClock() {
        if (!this.isClockRunning) {
            this.tline.play();
            this.isClockRunning = true;
        } else {
            this.tline.stop();
            this.isClockRunning = false;
        }
    }

}
