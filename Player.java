public class Player extends Ball{

    private double[] deflectSpeeds = new double[4];
    private int magnetCount = 0;

    public Player(double x, double y, double diameter, String col)
	{
		super(x, y, diameter, col);
        this.xSpeed = 0;
        this.ySpeed = 0;
	}

    public void setYSpeed(double s){
        this.ySpeed = s;
    }

    public double getYSpeed(){
        return ySpeed;
    }

    public void setXSpeed(double s){
        this.xSpeed = s;
    }

    public double getXSpeed(){
        return xSpeed;
    }

    public void resetMagnet(){
        this.magnetCount = 0;
    }
    
    public void addMagnet(){
        this.magnetCount += 1;
    }

    public double getMagnetCount(){
        return magnetCount;
    }

    public void checkCollides(Ball puck){
        if (this.collides(puck)){
            deflectSpeeds = puck.deflect(puck.getXSpeed(), puck.getYSpeed(), puck.getXPosition(), puck.getYPosition(),this.getXSpeed(), this.getYSpeed(), this.getXPosition(), this.getYPosition());
            puck.setSpeed(deflectSpeeds[0], deflectSpeeds[1]);
        }
    }
    
}