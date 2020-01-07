import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

//Abstrakt basklass f�r alla objekt som kan ritas i spelet 
public abstract class Paintable {
	protected Canvas canvas; //Ritytan där objektet ska ritas
        protected GraphicsContext gc;

	//Konstruktor som tar ritytan d�r objektet ska ritas som parameter
	public Paintable(Canvas canvas){
		this.canvas=canvas;
                this.gc = canvas.getGraphicsContext2D();
	}
	
	//Abstrakt metod som m�ste omdefinieras av subklasserna f�r att objekt
	//ska kunna skapas (och ritas upp)
	public abstract void paint();
}
