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

	public void addGoal(){
		this.goals +=1;
	}

    public boolean checkGoal(Ball puck){
		if (this.collides(puck)){
			puck.setSpeed(0,0);
			return true;
		}
		else{
			return false;
		}
    }

}