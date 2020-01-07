import javafx.scene.canvas.Canvas;
import javafx.scene.transform.Affine;


//Abstrakt basklass som används för både asteroider och rymdskepp.
//De gemensamma egenskaperna hos dessa finns här.
//Ärver från Paintable och lägger till förmågan att röra sig och
//rotera med konstant hastighet om updatePose() anropas regelbundet.
public abstract class DynamicPaintable extends Paintable{
	protected double x = 0; //x-koordinat för mittpunkt
	protected double y = 0; //y-koordinat för mittpunkt
	protected double angle = 0; //rotationsvinkel i radianer motsols
	protected double vx = 0; //Styr hur långt vi ska flytta i x-led sig vid uppdatering
	protected double vy = 0; //I y-led. Dessa båda variabler styr hastigheten.
	protected double vAngle = 0; //I vinkel. Styr rotationshastigheten	
	protected double acc =0; //Acceleration framåt
	
	//Konstruktor som lämnar alla medlemsvariabler på utgångsvärdena
	//och anropar superklassen Paintables konstruktor med den enda 
	//parametenrn canvas som är ritytan objektet ska ritas på 
	public DynamicPaintable(Canvas canvas) {
		super(canvas);
	}
	
	//S�dan uppstartkod som m�ste g�ras efter att alla komponenter 
	//byggts klart och f�tt en storlek etc	
	public void initialize(){
		//Subklasserna omdefinierar denna metod om det beh�vs
		//men denna variant g�r ingenting 
	}
	
	//S�tt objektets position i pixels fr�n �vre v�nstra h�rnet
	public void setPosition(double x, double y){
		this.x=x;
		this.y=y;
	}
	//Sätt objektets rotationsvinkel i radianer motsols
	public void setRotation(double angle){
		this.angle=angle;
	}
	//Sätt objektets hastighet i pixels per ms
	public void setSpeed(double vx, double vy){
		this.vx=vx; //Hur l�ngt vi ska flytta vid uppdatering
		this.vy=vy; //beror p� hastigheten
	}
	//Sätt objektets rotationshastighet i radianer motsols per ms
	public void setRotSpeed(double vAngle){
		this.vAngle=vAngle; //Styr hur långt vi ska snurra vid uppdatering
	}
	//Öka objektets hastighet i framåtriktningen (det håll objektet är roterat)
	public void setForwardAcceleration(double a){
		acc=a;
	}

	//Uppdatera position och rotationsvinkel utifrån hastighet och rotations-
	//hastighet. Anropas regelbundet av en timerhändelse.
        //dt är tid sedan senast i ms
	public void updatePose(int dt) {
		//uppdatera hastighet, position och rotation
		vx+=acc*dt*Math.sin(angle); 
		vy-=acc*dt*Math.cos(angle); 
		x+=vx*dt;
		y+=vy*dt;
		angle+=vAngle*dt;
	}

	//Returnerar en transformation f�r position och rotation s�
	//att objekt kan ritas p� r�tt st�ller med r�tt rotationsvinkel.
	//Ritar inget, men anropas i subklassernas paint()-metod
	//och anv�nds d�r p� Graphics2D-objektet innan n�got ritas d�r.
	//Det som sedan ritas p�verkas d� av transformationen. 
	//P� detta s�tt beh�ver transformationen bara kodas p� ett
	//st�lle, dvs h�r. 
	public Affine getTransformation() {
		Affine t=new Affine();
		t.appendTranslation(x, y);
		t.appendRotation(angle*180/Math.PI); //I grader
		return t;
	}
	
	
}