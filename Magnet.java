/**
 * this class extends ball to give it unique methods and variables for magnets
 */
public class Magnet extends Ball{

	private double[] deflectSpeeds = new double[4];			//holds speeds from deflection algorithm
	private boolean alreadyCollided;						//boolean of if magnet has already collided with a player or not

	/**
	 * constructor using the super constructor
	 * @param x
	 * @param y
	 * @param diameter
	 * @param col
	 */
    public Magnet(double x, double y, double diameter, String col)
	{
		super(x, y, diameter, col);
	}

	/**
	 * checks the collision with an object and sets speeds for both the object and the magnet
	 * @param collisionObject
	 */
	public void checkCollides(Ball collisionObject){
        if (this.collides(collisionObject)){
            deflectSpeeds = collisionObject.deflect(collisionObject.getXSpeed(), collisionObject.getYSpeed(), collisionObject.getXPosition(), collisionObject.getYPosition(),this.getXSpeed(), this.getYSpeed(), this.getXPosition(), this.getYPosition());
            collisionObject.setSpeed(deflectSpeeds[0], deflectSpeeds[1]);
			this.setSpeed(deflectSpeeds[2], deflectSpeeds[3]);
        }
    }

	/**
	 * continues to move the magnets after they have been hit, also implementing friction, slowing them down over time.
	 * unique to the magnets radius
	 */
	public void keepmove(){
		this.move(xSpeed, ySpeed);

		if ((this.getYPosition() <= 10 && ySpeed < 0) || (this.getYPosition() >= 590 && ySpeed > 0)){
			ySpeed = ySpeed * -1;
		}
		if ((this.getXPosition() <=10 && xSpeed < 0) || (this.getXPosition() >= 990 && xSpeed > 0)) {
			xSpeed = xSpeed * -1;
		}

		if (this.getXSpeed() > 1 || this.getYSpeed() > 1){
			xSpeed = xSpeed*0.99;
			ySpeed = ySpeed*0.99;
		}

	}

	/**
	 * set to true when hit by a player and set to false when a new round or game is started
	 * @param bool
	 */
	public void setCollided(Boolean bool){
		alreadyCollided = bool;
	}

	/**
	 * used to check for collision before adding it to a players tally.
	 * @return
	 */
	public boolean checkCollided(){
		return alreadyCollided;
	}
}