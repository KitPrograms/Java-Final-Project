import java.util.Random;


/**
 * This class extends on the given game arenaclass to present winning screens and resetting the game board
 */
public class Board extends GameArena {

    /***
     * Constructor for the subclass using super() to access given constructor from game arena.
     * @param width
     * @param height
     */
    public Board(int width, int height) {
        super(width, height, true);
    }

    /***
     * Method to reset the game board with all the pieces being places back to the starting places, 
     * ball start randomly chosen on side that lost the point and all speeds set to 0.
     * @param magnets
     * @param player1
     * @param player2
     * @param puck
     * @param player variable that tells the reset which player lost the point.
     */
    public void reset(Magnet[] magnets, Player player1, Player player2, Ball puck, int player) {

        //setting magnets to original positions, setting speed to 0 and making sure none have been set to collided this round.
        for (int i = 0; i < 3; i++) {
            magnets[i].setXPosition(magnets[i].getStartXPosition());
            magnets[i].setYPosition(magnets[i].getStartYPosition());
            magnets[i].setSpeed(0,0);
            magnets[i].setCollided(false);
        }

        //resetting player positions and setting magnet count back to 0
        player1.setXPosition(player1.getStartXPosition());
        player1.setYPosition(player1.getStartYPosition());
        player1.resetMagnet();
        player2.setXPosition(player2.getStartXPosition());
        player2.setYPosition(player2.getStartYPosition());
        player2.resetMagnet();

        //randomly placing ball on loosers side
        Random ballPlace = new Random();
        if (player == 1) {
            if (ballPlace.nextInt(2) == 0) {
                puck.setXPosition(60);
                puck.setYPosition(60);
            } else{
                puck.setXPosition(60);
                puck.setYPosition(540);
            }
        } else {
            if (ballPlace.nextInt(2) == 0) {
                puck.setXPosition(940);
                puck.setYPosition(60);
            } else{
                puck.setXPosition(940);
                puck.setYPosition(540);
            }
        }
    }

    /**
     * Method that displays the winning screen before constantly checking for input from players for play again or exit.
     * @param winner
     * @return
     */
    public boolean win(Text winner){
        Rectangle winScreen = new Rectangle(0,0,1000,600,"YELLOW", 4);
        this.addRectangle(winScreen);
        this.addText(winner);
        while(true){
            if (this.enterPressed()){
                this.removeRectangle(winScreen);
                this.removeText(winner);
                return true;
            }
            else if(this.escPressed()){
                this.exit();
            }
        }
    }

}