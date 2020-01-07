import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.util.Duration;

public abstract class DynamicAnimatedImage extends DynamicPaintable{
	public final int width;
	public final int height;
	private int animStep = 0;
	private final Timeline animTmr;
	private final Image img; //Image before animatin
	private final Image[] animImgs; //Images during animatioon
	private boolean animStarted=false;

	public DynamicAnimatedImage(int width, int height, Image image, Image[] animImgs, Canvas canvas) {
            super(canvas);
            this.width=width;
            this.height=height;
            animTmr = new Timeline(new KeyFrame(
                Duration.millis(30),
                (ActionEvent e) -> {animationEvent();}
            ));
            animTmr.setCycleCount(Timeline.INDEFINITE);
            this.animImgs =animImgs;
            this.img =image;
	}


        protected static Image[] loadAnimImages(String animImgName,int numAnimImg){
                Image[] animImges = new Image[numAnimImg];
		//Ladda bilder
		for(int i=0;i<numAnimImg;i++){
				animImges[i]=loadImage(animImgName+i);			
		}
                return animImges;
        }

        protected static Image loadImage(String imgName){
        try{
		return new Image(DynamicAnimatedImage.class.getResourceAsStream(imgName+".png"));			
		} catch(Exception e) {
			System.err.println("Hittar inte "+imgName+".png!");
			System.exit(1);
                        return null;
		}
        }

	protected void animate(){
		animStarted=true;
		animTmr.play();
	}
	
	protected void resetAnimation(){
		animStarted=false;
		animTmr.stop();
		animStep=0;
	}
	
	public boolean isAnimating(){
		return animStarted&&animStep<animImgs.length;
	}
	
	@Override
	public void paint() {
                        //System.err.println("Paint at x"+x+" y"+y+" w"+width+" h"+height);
			Affine savedTransform=gc.getTransform();
                        // Gör så att det vi ritar transformeras till rätt ställe
			gc.transform(this.getTransformation()); 
                        //gc.setStroke(Color.CYAN);
                        //gc.strokeRect(-width/2, -height/2, width,height);
			if(!animStarted){
				//Animerar inte
				//Rita objektet som en bild lagrad i img
				gc.drawImage(img,-width/2, -height/2, width,height);
			}
			else if(animStep<animImgs.length){
				//Animera en större bild
				gc.drawImage(animImgs[animStep],-width, -height, 2*width,2*height);
			}				
			gc.setTransform(savedTransform); //Återställ transormationen
		}

	private void animationEvent() {
		// Event från animTmr
		if(animStep<animImgs.length) animStep++;
		if(animStep==animImgs.length) {
			animTmr.stop();		
		}
	}

}