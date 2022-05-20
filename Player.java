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

    public void setYSpeed(int s){
        this.ySpeed = s;
    }

    public int getYSpeed(){
        return ySpeed;
    }

    public void setXSpeed(int s){
        this.xSpeed = s;
    }

    public int getXSpeed(){
        return xSpeed;
    }
    
}