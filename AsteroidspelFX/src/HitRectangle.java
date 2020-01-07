
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Affine;
import javafx.scene.transform.NonInvertibleTransformException;


//Klass som representerar en rektangel som kan avgöra om den överlappar med
//(träffar) en godtycklig cirkel
public class HitRectangle {
    private final double minX,maxX,minY,maxY; //I lokala koordinater
    private Affine transform; //Invers transformation till rektangelns koordinatsystem

    public HitRectangle(double minX, double minY, double width, double height) {
        this.minX = minX;
        this.maxX = minX+width;
        this.minY = minY;
        this.maxY = minY+height;
    }
    
    //Anropa varje gång transformationen ändras för att följande
    //anrop av hits... ska bli rätt
    //t är transformationen från globala till rektangelns lokala koordinater
    public void setTransform(Affine t){
        //(Det går inte så lätt att transformera rektangeln
	// så vi transformerar det som ska träffas baklänges istället.)       
        try {
            transform = t.createInverse();
        }
        catch(NonInvertibleTransformException ex) {
            ex.printStackTrace(); //Skriv ut info
            System.exit(1); //Detta ska inte kunna hända. Leta rätt på felet!
        }
    }
    
    //Överlappar rektangeln med en cirkel med givna globala centrumkoordinater
    //och radie
    public boolean hitsCircle(double cx, double cy, double r){
        Point2D p;
        //Transformera om transformation finns
        if(transform!=null) p = transform.transform(cx,cy);
        else p = new Point2D(cx, cy);
        double x = p.getX();
        double y = p.getY();
        //Utöka rektangeln med radien åt alla håll
        double extMinX=minX-r;
        double extMaxX=maxX+r;
        double extMinY=minY-r;
        double extMaxY=maxY+r;
        //Om cirkelns centrum är utanför utökade rectangeln träffar den inte
        if(x>extMaxX || x<extMinX || y>extMaxY || y<extMinY) return false;
        //System.err.println("In ("+cx+","+cy+") Ut ("+x+","+y+")");
        //System.err.println("Rect ("+minX+"<"+maxX+", "+minY+"<"+maxY+")");
        //Om centrum är innanför utökad rektangel utom i hörnen träffar cirkeln
        if(x>minX && x<maxX && y>extMinY && y<extMaxY) return true;
        if(x>extMinX && x<extMaxX && y>minY && y<maxY) return true;
        System.err.println("In ("+cx+","+cy+") Ut ("+x+","+y+")");
        System.err.println("Rect ("+minX+"<"+maxX+", "+minY+"<"+maxY+")");
        //Kommer vi hit ligger centrum nära utanför ett hörn
        double dx, dy; //Avstånd centrum till närmaste hörn i x- och y-led
        if(x<minX) dx=minX-x; else dx=x-maxX;
        if(y<minY) dy=minY-y; else dy=y-maxY;
        return dx*dx+dy*dy<=r*r; //Om centrum är närmare hörnet än en radie 
    }

    //Ligger punkten givna globala centrumkoordinater i rektangeln?
    public boolean hitsPoint(double cx, double cy){
        Point2D p = transform.transform(cx,cy);
        return p.getX()>minX && p.getX()<maxX && p.getY()>minY && p.getY()<maxY;
    }
    
    //Rita rektangeln med aktuell penna och aktuell koordinattransformation
    public void stroke(GraphicsContext gc){
        gc.strokeRect(minX, minY, maxX-minX, maxY-minY);
    }

    //Fyll rektangeln med aktuell fyllning och aktuell koordinattransformation
    public void fill(GraphicsContext gc){
        gc.fillRect(minX, minY, maxX-minX, maxY-minY);
    }
}
