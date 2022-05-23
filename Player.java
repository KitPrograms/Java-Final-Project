
/**
 * This class extends on the given ball class so that it can function in specific ways with specific variables unique to players and not other ball objects.
 */
public class Player extends Ball{

    private double[] deflectSpeeds = new double[4];         //place to store speeds from deflect class.
    private int magnetCount = 0;                            //count of magnets touched by each player.


    /**
     * constructor of the player class using the same parameters as mother class constructor and setting speeds = 0.
     * @param x
     * @param y
     * @param diameter
     * @param col
     */
    public Player(double x, double y, double diameter, String col)
	{
		super(x, y, diameter, col);
        this.xSpeed = 0;
        this.ySpeed = 0;
	}

    /**
     * setting y speed = s for when needed to calculate deflection
     * @param s
     */
    public void setYSpeed(double s){
        this.ySpeed = s;
    }

    /**
     * returns y speed at given moment
     */
    public double getYSpeed(){
        return ySpeed;
    }

    /**
     * setting x speed = s for when needed to calculate deflection
     * @param s
     */
    public void setXSpeed(double s){
        this.xSpeed = s;
    }

    /**
     * returns x speed at given moment
     */
    public double getXSpeed(){
        return xSpeed;
    }

    /**
     * sets touched magnets to 0 at the start of each round
     */
    public void resetMagnet(){
        this.magnetCount = 0;
    }
    
    /**
     * adds to the count when a player has touched a magnet
     */
    public void addMagnet(){
        this.magnetCount += 1;
    }

    /**
     * returns the magnet count to see if 2 or more touched (= goal scored)
     * @return
     */
    public double getMagnetCount(){
        return magnetCount;
    }
    
    /**
     * checks for collision with an object and instantly uses the deflection algorith to return the speeds the object needs to move.
     * @param object
     */
    public void checkCollides(Ball object){
        if (this.collides(object)){
            deflectSpeeds = object.deflect(object.getXSpeed(), object.getYSpeed(), object.getXPosition(), object.getYPosition(),this.getXSpeed(), this.getYSpeed(), this.getXPosition(), this.getYPosition());
            object.setSpeed(deflectSpeeds[0], deflectSpeeds[1]);
        }
    }
    
}