import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;

//Klass f�rest�llande en asteroid.
//Asteroiden ser sj�lv till att den studsar mot spelytans kanter
//genom att omdefineiera metoiden updatePose() fr�n superklassen Flyttbar.
//Klassvariabeln number (deklarerad static) h�ller reda p� det totala antalet
//asteroider som skapas och f�rst�rs och innh�ller d�rf�r hela tiden antalet
//kvarvarande asteroider. 
public class Asteroid extends DynamicAnimatedImage implements Hittable{
	public static int number=0; //static betyder h�r att alla asteroider delar p� en variabel
	private boolean wasHit=false; //Asteroiden �r �nnu ej tr�ffad
	private static final Image img = loadImage("asteroid");
        private static final Image[] animImg = loadAnimImages("explode", 16);
 
	public Asteroid(int diameter, Canvas canvas) {
               super(diameter,diameter,img,animImg,canvas); // Använd superklassen DynamicAnimatedImage konstruktor
		setRotSpeed(Math.random()*.0018-0.0009);
		number++; //antal (gemensam för alla asteroider) Ökas med ett när en skapas


        }
	
	public Asteroid(Canvas canvas) { // ny konstruktor utan parameter för diametern
		//Slumpa fram asteroidens diameter 
		this((int)(Math.random()*50 )+ 10,canvas); //anv�nder andra konstruktorn,diam 10 � 39 pix 
	}
	//Sådan uppstartkod som måste göras efter att alla komponenter 
	//byggts klart och f�tt en storlek etc
        @Override
	public void initialize(){
                double b=canvas.getWidth(); //Funkar inte i konstruktorn d� spelytan
		double h=canvas.getHeight();//har storleken noll.
                //System.err.println("Canvas b"+b+" h"+h);
		x=b/8+Math.random()*3*b/4; // placering i x-led b/8 till 7b/8
		y=Math.random()*h/8; // placering i y-led h/8 till h/2
		setSpeed(Math.random()*0.4 - 0.2, // Slumpad hastighet
			Math.random()*0.1 +0.1); 
                
                if(wasHit){
			number++; //antal (gemensam f�r alla asteroider) �kas med ett n�r en skapas
			wasHit=false;
		}
		resetAnimation();
	}
        
        @Override
	public void updatePose(int dt) {
		//Byt riktning om vi kommit till kanten
		if (x+vx*dt>canvas.getWidth() || x+vx*dt<0) {
			vx=-vx;
		}
		if (y+vy*dt>canvas.getHeight() || y+vy*dt<0) {
			vy=-vy;
		}
		//Kör DynamicPaintables variant av updatePose f�r att uppdatera positionen
 		super.updatePose(dt);
	}
	


	@Override
	//Asteroiden är träffad!
	//"försvinn" genom att sätta variabeln traffad till true.
	public int getPointsAndHit() {
		if(!wasHit){
			wasHit=true;
			setRotSpeed(0); 
			number--;
			animate();
			return number*100/width; // Poäng för träff
		}
                else return 0;
	}

    @Override
    public boolean isHitBy(HitRectangle rect) {
        if(this.wasHit) return false; //Asteroiden redan träffad
        return rect.hitsCircle(x, y, width/2);
    }
}
