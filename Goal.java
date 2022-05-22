public class Goal extends Ball{

	private int goals;

    public Goal(double x, double y, double diameter, String col)
	{
		super(x, y, diameter, col);
		this.goals = 0;
	}

	public int getGoals(){
        return goals;
    }

    public boolean checkGoal(Ball puck){
		if (this.collides(puck)){
			puck.setSpeed(0,0);
			this.goals += 1;
			return true;
		}
		else{
			return false;
		}
    }

}