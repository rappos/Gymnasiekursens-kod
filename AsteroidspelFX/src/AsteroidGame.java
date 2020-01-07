
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AsteroidGame extends Application {

    private Canvas canvas; //Ytan allt ritas på
    private SpaceShip ship;
    private final Asteroid[] asteroids = new Asteroid[4]; //Array som ska hålla reda på alla asteroider
    private Paintable[] objectsToPaint; //Innehåller alla objekt som spelet ska rita
    //private Timeline tline; //Används för att få allt att röra sig
    private AnimationTimer tmr; //Ger händelser varje gång fönstret kan ritas om
    private long lastTickTime=0;
    private Text txt;  //Visar antal asteroider och poäng
    private Text bigTxt;  //Visar antal asteroider och po�ng
    private KeyCode lastArrowPress; //Håller reda på vilken pil som trycktes ned senast.
    private KeyCode lastRotPress; //Håller reda på vilken rotationsknapp som trycktes ned senast.
    private int score;
    private int lives;
    private boolean isRunning = false; 
    private boolean isGettingReady = false;
    final double VEL = 0.18; //Hastighet när skeppet rör sig pga pilknapp (px/ms)
    final double ANG_VEL = 0.003; //Rotation när skeppet snurrar (rad/ms)
    final double ACCELERATION = 0.0005; //Skeppets maxacceleration i px/s/s
    private boolean gameIsFinished;
    //private int state;
    private static final int STATE_STARTING = 1;
    private static final int STATE_PLAYING = 2;
    private static final int STATE_DYING = 3;
    private static final int STATE_GAME_OVER = 4;
    private static final int STATE_COMPLETED = 5;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        //Ärv från vanlig Canvas och skapa en som tillåter 
        canvas = new Canvas(){

            @Override
            public double maxWidth(double height) {
                return Double.MAX_VALUE;
            }

            @Override
            public double maxHeight(double width) {
                return Double.MAX_VALUE;
            }


            @Override
            public void resize(double width, double height) {
                setWidth(width);
                setHeight(height);
                System.err.println(width+","+height);
                System.err.println(prefHeight(width));
            }

            
            @Override
            public boolean isResizable() {
                return true;
            }
            
            
        };
        System.err.println(canvas.prefHeight(1000));
        System.out.println(canvas.maxWidth(768));
        BorderPane bPane = new BorderPane();
        root.getChildren().addAll(canvas, bPane);
        txt = new Text();
        txt.setFill(Color.LIME);
        txt.setFont(Font.font(null, FontWeight.NORMAL, 24));
        bPane.setTop(txt);
        bigTxt = new Text();
        bigTxt.setFill(Color.LIME);
        bigTxt.setFont(Font.font(null, FontWeight.BOLD, 28));
        bPane.setCenter(bigTxt);
        //Skapa arrayen som h�ller reda på vad som ska ritas upp
        objectsToPaint = new Paintable[asteroids.length + 1]; //Asteroiderna och ett skepp
        //Skapa en asteroid f�r varje plats i arrayen asteroider
        for (int i = 0; i < asteroids.length; i++) {
            asteroids[i] = new Asteroid(canvas);
            objectsToPaint[i] = asteroids[i];
        }
        ship = new SpaceShip(canvas); //Skapa rymdskeppet
        objectsToPaint[asteroids.length] = ship;
        //Skapa och starta timern som styr r�relsen i spelet
//        tline = new Timeline(new KeyFrame(
//                Duration.millis(30),
//                (ActionEvent e) -> {
//                    timerTicked();
//                }
//        ));
//        tline.setCycleCount(Timeline.INDEFINITE);
//        tline.play();
        tmr =new AnimationTimer() {
            @Override
            public void handle(long now) {
                timerTicked(now);
            }
        };
        tmr.start();
        
        //Lyssna p� tangenth�ndelser s� att skeppet g�r att styra
        root.setOnKeyPressed((KeyEvent e)->{handleKeypress(e);});
        root.setOnKeyReleased((KeyEvent e)->{handleKeyReleased(e);}); 
        //Vår Pane root måste kunna få fokus för tangenthändelser
        root.setFocusTraversable(true);
        
        root.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        //Om panelen root föredrar (prefers) en viss bredd anpassar sig fönstret
        Scene scene = new Scene(root,1024, 768);
        primaryStage.setTitle("Objektorienterat asteroidspel med JavaFX. "
                + "Styr med Z, C och D. Skjut med mellanslag.");
        primaryStage.setScene(scene);
        primaryStage.show();
        initialize();
        root.requestFocus();
    }

    //S�dan uppstartkod som m�ste g�ras efter att alla komponenter 
    //byggts klart och f�tt en storlek etc
    public void initialize() {
        //Initialisera alla asteroiderna
        for (Asteroid a: asteroids) {
            a.initialize();
        }
        isRunning = false;
        isGettingReady = false;
        gameIsFinished = false;
        lives = 3;
        score = 0;
        bigTxt.setText("");
        //Starta om skeppet
        ship.reset();

    }

    public void timerTicked(long now) {
        if(lastTickTime==0) lastTickTime=now; //Första gången
        int dt = (int)((now -lastTickTime)/1000000); // Hur länge som gått i ms
        lastTickTime = now;
        //System.err.println("dt = "+dt);
        //Timern har genererat en händelse
        if (!isGettingReady) {
            ship.updatePose(dt); //Flytta skeppet
        }
        if (isRunning) {
            for (Asteroid asteroid : asteroids) {
                if (ship.hits(asteroid)) {
                    //Skeppet träffat
                    ship.destroy();
                    lives--;
                    if (lives == 0) {
                        bigTxt.setText("Game Over. MELLANSLAG börjar om.");
                        gameIsFinished = true;
                        isRunning = false;
                    } else {
                        isRunning = false;
                        isGettingReady = false;
                    }
                }
            }
        } else if (!ship.isAnimating() && !isGettingReady && !gameIsFinished) {
            //Klart för ny omgång eller nytt liv. Vänta på startsignal från användaren
            isGettingReady = true;
            ship.reset();
            ship.dim();
            bigTxt.setText("Tryck MELLANSLAG för att starta! " + lives + " liv kvar.");
        }
        for (Asteroid asteroid : asteroids) {
            asteroid.updatePose(dt); //Flytta asteroiden
        }
        txt.setText("Antal asteroider kvar: " + Asteroid.number + //Visa antal	asteroider
                " Poäng: " + score + //och po�ng
                " Liv: " + lives); // ooch antal liv
        if (Asteroid.number == 0) {
            //inga asteroider är kvar
            bigTxt.setText("Uppdraget slutfört! MELLANSLAG för att börja om.");
            gameIsFinished = true;
        }
        redraw();
    }

    public void handleKeypress(KeyEvent e) {
        //En knapp har tryckts ner
        //System.err.println("Tangent ner: " + e);
        if (gameIsFinished && e.getCode() == KeyCode.SPACE) {
            initialize();
        } else if (isRunning) {
            if (e.getCode() == KeyCode.LEFT) {
                ship.setSpeed(-VEL, 0); //V�nster
                lastArrowPress = e.getCode();
            }
            if (e.getCode() == KeyCode.RIGHT) {
                ship.setSpeed(VEL, 0); //H�ger
                lastArrowPress = e.getCode();
            }
            if (e.getCode() == KeyCode.UP) {
                ship.setSpeed(0, -VEL); //Upp
                lastArrowPress = e.getCode();
            }
            if (e.getCode() == KeyCode.DOWN) {
                ship.setSpeed(0, VEL); //Ner
                lastArrowPress = e.getCode();
            }
            if (e.getCode() == KeyCode.Z) {
                ship.setRotSpeed(-ANG_VEL); //Rotera v�nster
                lastRotPress = e.getCode();
            }
            if (e.getCode() == KeyCode.C) {
                ship.setRotSpeed(ANG_VEL); //Rotera h�ger
                lastRotPress = e.getCode();
            }
            if (e.getCode() == KeyCode.D) {
                ship.setForwardAcceleration(ACCELERATION); //accelerera
            }
            if (e.getCode() == KeyCode.SPACE) {
                Shot shot = ship.fire();
                if (shot != null) {
                    for (int i = 0; i < asteroids.length; i++) {
                        if (shot.hits(asteroids[i])) {
                            score += asteroids[i].getPointsAndHit();
                        }
                    }
                }
            }
        } else if (isGettingReady && e.getCode() == KeyCode.SPACE) {
            isRunning = true;
            isGettingReady = false;
            ship.unDim();
            bigTxt.setText("");
        }
    }

    public void handleKeyReleased(KeyEvent e) {
        //En knapp har sl�ppts upp
        if (e.getCode() == lastArrowPress) {
				//Bara om det �r senaste pilen som trycktes
            //ned som sl�ppts up ska skeppet stanna.
            //Annars blir det sv�rstyrt om tv� pilar r�kar
            //vara nere samtidigt. Testa g�rna.
            ship.setSpeed(0, 0);
        }
        if (e.getCode() == lastRotPress) {
				//Bara om det �r senaste rotationsknappen som trycktes
            //ned som sl�ppts up ska skeppet sluta snurra.
            //Se motsvarande f�r pilar ovan.
            ship.setRotSpeed(0);
        }
        if (e.getCode() == KeyCode.D) {
            ship.setForwardAcceleration(0); //accelerera
        }
    }

    public void keyTyped(KeyCode e) {
			//M�ste vara med om vi implementerar gr�nssnittet KeyListener
        //men g�r ingenting
    }

    protected void redraw() {
        canvas.getGraphicsContext2D().clearRect(
                0,0,canvas.getWidth(),canvas.getHeight());
        for (Paintable p : objectsToPaint) {
            p.paint();
            //System.err.println("redraw"+p);
        }

        //Draw energy bar
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.RED);
        gc.fillRect(canvas.getWidth() - 20, canvas.getHeight() - 10 - 30 * ship.getEnergy(),
                10, 30 * ship.getEnergy());
    }

 }
