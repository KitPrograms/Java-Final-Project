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

    public void checkGoal(Ball puck, Board board){
		if (this.collides(puck)){
			this.goals += 1;
			
		}
    }

}