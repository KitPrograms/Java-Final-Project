public class Player extends Ball{

    private int goals;

    public Player(double x, double y, double diameter, String col)
	{
		super(x, y, diameter, col);
        this.goals = 0;
	}

    public int getGoals(){
        return goals;
    }

    public void addGoal(){
        goals = goals + 1;
    }
    
}