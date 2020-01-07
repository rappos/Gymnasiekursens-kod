package plockacirklar;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle {

    private int centX;          //Centrumkoordinater
    private int centY;          //Centrumkoordinater
    private int r;                  //radien
    private Color color;    //Färgen

    public int getCentX() {
        return centX;
    }

    public int getCentY() {
        return centY;
    }

    public int getR() {
        return r;
    }

    public Color getColor() {
        return color;
    }

    public void setCentX(int centX) {
        this.centX = centX;
    }

   
    public Circle(int centX, int centY, int r) {
        this.centX = centX;
        this.centY = centY;
        this.r = r;
        color = Color.WHITE;
    }

    public Circle(int centX, int centY, int r, Color color) {
        this.centX = centX;
        this.centY = centY;
        this.r = r;
        this.color = color;
    }

    public void setCentY(int centY) {
        this.centY = centY;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setColor(Color color) {
        this.color = color;
    }

  
    public int getD() {
        return 2 * r;
    }

  
    public void setD(int d) {
        this.r = d / 2;
    }

  
    public void paint(Canvas can) {
        GraphicsContext gc = can.getGraphicsContext2D();
        gc.setFill(color);
        // - r är för att komma till ”övre högra hörnet”: 
        gc.fillOval(centX - r, centY - r, 2 * r, 2 * r);
        gc.setStroke(Color.BLACK);
        gc.strokeOval(centX - r, centY - r, 2 * r, 2 * r);
    }

    //Flytta i x-led, positivt värde ger höger
    public void moveX(int dx) {
        centX += dx;
    }

    //Flytta i y-led, positivt värde ger nedåt
    public void moveY(int dy) {
        centY += dy;
    }

    public String toString() {
        return "Cirkel: centrum(" + centX + "," + centY + ") radie=" + r;
    }

    //Returnerar true om koordinaterna ligger i denna cirkel
    public boolean pick(double x, double y) {
        //om avståndet till centrum är högst
        //lika stor som radien, ligger (x, y) i cirkeln
        return (x - centX) * (x - centX) + (y - centY) * (y - centY) <= r * r;
    }
}
