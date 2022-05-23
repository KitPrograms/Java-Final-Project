public class Magnet extends Ball{

	private double[] deflectSpeeds = new double[4];
	private boolean alreadyCollided;

    public Magnet(double x, double y, double diameter, String col)
	{
		super(x, y, diameter, col);
	}

	public void checkCollides(Ball collisionObject){
        if (this.collides(collisionObject)){
            deflectSpeeds = collisionObject.deflect(collisionObject.getXSpeed(), collisionObject.getYSpeed(), collisionObject.getXPosition(), collisionObject.getYPosition(),this.getXSpeed(), this.getYSpeed(), this.getXPosition(), this.getYPosition());
            collisionObject.setSpeed(deflectSpeeds[0], deflectSpeeds[1]);
			this.setSpeed(deflectSpeeds[2], deflectSpeeds[3]);
        }
    }

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

	public void setCollided(Boolean bool){
		alreadyCollided = bool;
	}

	public boolean checkCollided(){
		return alreadyCollided;
	}
}