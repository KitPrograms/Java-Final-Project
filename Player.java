public class Player extends Ball{

    private int goals;

    public Player(double x, double y, double diameter, String col)
	{
		super(x, y, diameter, col);
        this.goals = 0;
        this.xSpeed = 0;
        this.ySpeed = 0;
	}

    public int getGoals(){
        return goals;
    }

    public void addGoal(){
        goals = goals + 1;
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
    
}