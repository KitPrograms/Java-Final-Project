/**
 * this class extends on the given Ball class to hold goal specific variables and methods.
 */
public class Goal extends Ball{

	private int goals; 			// goals from each side

	/**
	 * Constructor from mother class but also initiates goals as = 0
	 * @param x
	 * @param y
	 * @param diameter
	 * @param col
	 */
    public Goal(double x, double y, double diameter, String col)
	{
		super(x, y, diameter, col);
		this.goals = 0;
	}

	/**
	 * returns goals to check for win
	 * @return
	 */
	public int getGoals(){
        return goals;
    }

	/**
	 * adds to goal count when a goal is scored
	 */
	public void addGoal(){
		this.goals +=1;
	}

	/**
	 * score is reset each time players choose to play again
	 */
	public void resetScore(){
		this.goals = 0;
	}

	/**
	 * checks for collition between goals and the puck and then goals and players to see if a goal is scored there
	 * @param object
	 * @return
	 */
    public boolean checkGoal(Ball object){
		if (this.collides(object)){
			object.setSpeed(0,0);
			return true;
		}
		else{
			return false;
		}
    }

}