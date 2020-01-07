import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.util.Duration;

//Klass som föreställer ett skott. Skottet håller själv reda på hur länge
//det ska finnas kvar efter varje anrop av metoden skjut() mha en timer
public class Shot extends Paintable{
	private final double WIDTH=10;
	private final double LENGTH=1500;	
	private boolean isVisible = false; //sann när skottet syns och kan förstöra asteroider
	private final Timeline tmr;
	private final HitRectangle rectangle;
	private Affine transform; //Transformation från skeppet. Används i hits();

	
	public Shot(Canvas canvas){
		super(canvas);
		rectangle = new HitRectangle(-WIDTH/2,-LENGTH,WIDTH,LENGTH);  
		// Timern används för att sudda skottet efter 60 ms
                tmr = new Timeline(new KeyFrame(
                    Duration.millis(30),
                    (ActionEvent e) -> {timeout();}
                ));
        tmr.setCycleCount(1); // Skottet ska bara suddas en gång varje gång timern startas
	}

	//Skjut ett skott från position (0,0) och rakt uppåt i transformerade koordinater
	public void fire(Affine t){
		isVisible = true;
		tmr.play(); //Starta timern så att skottet suddas efter ett tag
		transform=t;
	}
	
	//Anropas från skeppets paint()-metod med dess transformation
        @Override
	public void paint() {
		if(!isVisible) return; //Ej synligt --> inget att göra
		//Vi behöver ej bry oss om pos och vinkel här.
		//Det har skeppets paint() redan fixat.
		gc.setFill(Color.RED);		
		rectangle.fill(gc);
	}

	private void timeout() {
		//Timern har räknat klart,
		//dags att stänga av skottet
		isVisible=false;
	}
	
	public boolean hits(Hittable h){
            //Transformera för att kompensera skottets utgångspunkt och vinkel
            rectangle.setTransform(transform);
            return h.isHitBy(rectangle);
	}
}
