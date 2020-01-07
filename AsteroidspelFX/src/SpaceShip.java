import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;



//Klass f�rest�llande rymdskeppet.
//Rymdskeppet har ett skott-objekt (se klassen Shot) som hanteras
//h�rifr�n. N�r skeppet ska skjuta anropas bara skeppets metod fire()
//och skeppet ser sj�lv till att skottet hamnar p� r�tt st�lle.
//Skeppet kollar ocks� sj�lvt att det inte kommer utanf�r spelytan
//genom att omdefineiera metoiden updatePose() fr�n superklassen
//DynamicPaintable.
public class SpaceShip extends DynamicAnimatedImage {
	public final static int WIDTH=80;
	public final static int HEIGHT=100;
	private static final Image img = loadImage("shuttle");
        private static final Image[] animImg = loadAnimImages("explode", 16);
	private final Shot shot;
	//Rektanglar f�r kollisionsber�kning
	private final HitRectangle outerRect; //Yttre rektangel som rymmer hela skeppet
	private final HitRectangle[] innerRects; //Delrektanglar som t�cker en bit var

	private double energy; //Energin annv�nds för att skjuta
        private final double ENERGY_REFILL_SPEED=0.002; //Energitillskott varje tidssteg
        private final double MAX_ENERGY = 10; //Energitillskott varje tidssteg
	private boolean dimmed;
	
	//Konstruktor som l�mnar alla medlemsvariabler p� utg�ngsv�rdena
	//och anropar superklassen Drawables konstruktor med den enda 
	//parametenrn surface som �r ritytan objektet ska ritas p� 
	public SpaceShip(Canvas canvas) {
		super(WIDTH,HEIGHT,img,animImg,canvas);
		shot=new Shot(canvas);
		outerRect=new HitRectangle(-WIDTH/2.0,-HEIGHT/2.0 , WIDTH, HEIGHT);
		innerRects = new HitRectangle[] {
                    new HitRectangle(-WIDTH/2.0,HEIGHT/5.0,WIDTH, HEIGHT/5.0),
                    new HitRectangle(-WIDTH/6,-HEIGHT/4.0 , WIDTH/3.0, 3*HEIGHT/4.0),
                    new HitRectangle(-WIDTH/16.0,-HEIGHT/2.0 , WIDTH/8.0, HEIGHT/4.0)
                };
	}
	
	public double getEnergy(){
		return energy;
	}
	
	public Shot fire(){
		if(energy>1.0){	
			energy-=1.0;
			shot.fire(getTransformation());
			return shot;
		}
		else return null;
	}
	
	@Override
	public void paint() {

		Affine savedTransform=gc.getTransform();
		gc.transform(getTransformation()); // G�r s� att det vi ritar hamnar p� r�tt st�lle
		//Rita skottet
		shot.paint();
		gc.setTransform(savedTransform); //�terst�ll transormationen
		if(dimmed) gc.setGlobalAlpha(0.4);
		super.paint();
		gc.setGlobalAlpha(1);
		if(true){
			//Rita kollisionsrektanglarna
			gc.transform(getTransformation()); // G�r s� att det vi ritar hamnar p� r�tt st�lle
			gc.setStroke(Color.GREEN);
			outerRect.stroke(gc);
			for(HitRectangle r : innerRects) r.stroke(gc);
			gc.setTransform(savedTransform); //�terst�ll transormationen
		}
	}

	@Override
	public void updatePose(int dt) {
		//Kolla att vi inte hamnar utanf�r ritytan.
//		if (x+vx > drawingSurface.getWidth() || 
//				x+vx < 0) {
//			vx = 0; //Stanna!
//			acc=0;
//		}
//		if (y+vy > drawingSurface.getHeight() || 
//				y+vy < 0) {
//			vy = 0; //Stanna!
//			acc=0;			
//		}
		if (x+vx*dt > canvas.getWidth()){
			x-=canvas.getWidth();		 
		}
		if(x+vx*dt < 0) {
			x+=canvas.getWidth();
		}
		if (y+vy*dt > canvas.getHeight()){
			y-=canvas.getHeight();
		}
		if(	y+vy*dt < 0) {
			y+=canvas.getHeight();
		}
		//K�r superklassen DynamicPaintables updatePose()
		super.updatePose(dt);
		energy+=ENERGY_REFILL_SPEED*dt;
                if(energy>MAX_ENERGY) energy = MAX_ENERGY;
	}

	public boolean hits(Hittable h){
                        Affine curentT = getTransformation();
                        outerRect.setTransform(curentT);
                        if(!h.isHitBy(outerRect)) return false; // Träffar inte ens yttre rekt
                        for(HitRectangle r: innerRects) {
                            r.setTransform(curentT);
                            if(h.isHitBy(r)) return true;
                        }
			return false;
	}

	
	//S�dan uppstartkod som m�ste g�ras efter att alla komponenter 
	//byggts klart och f�tt en storlek etc
	public void reset(){
		//Detta funkar inte i konstruktorn f�r d� har spelytan
		//storleken noll.
		x=canvas.getWidth()/2; // placering i x-led p� mitten
		y=canvas.getHeight()/2;//-HEIGHT/2; // placering i y-led med nedre kant mot botten
		angle=0;
		vx=vy=vAngle=0;
		energy=5;
		resetAnimation();
		
	}
	
	public void dim(){
		dimmed=true;
	}
	public void unDim(){
		dimmed=false;
	}

	public void destroy() {
		animate();
	}
}
