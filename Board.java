import java.util.Random;

public class Board extends GameArena{
    
    public Board(int width, int height)
	{
		super(width, height, true);
	}

    public void reset(Magnet[] magnets, Player player1, Player player2, Ball puck, int player){

        for (int i=0; i<3; i++){
            magnets[i].setXPosition(magnets[i].getStartXPosition());
            magnets[i].setYPosition(magnets[i].getStartYPosition());
        }

        player1.setXPosition(player1.getStartXPosition());
        player1.setYPosition(player1.getStartYPosition());
        player2.setXPosition(player2.getStartXPosition());
        player2.setYPosition(player2.getStartYPosition());

        Random ballPlace = new Random();
        if (player == 1){
            if (ballPlace.nextInt(2) == 1){
            puck.setXPosition(60);
            puck.setYPosition(60);
            }
            else if (ballPlace.nextInt(2) == 2){
            puck.setXPosition(60);
            puck.setYPosition(540);
            }
        }
        else{
            if (ballPlace.nextInt(2) == 1){
                puck.setXPosition(940);
                puck.setYPosition(60);
                }
                else if (ballPlace.nextInt(2) == 2){
                puck.setXPosition(940);
                puck.setYPosition(540);
                }
        }
    }

}