import java.util.Random;

public class Board extends GameArena {

    public Board(int width, int height) {
        super(width, height, true);
    }

    public void reset(Magnet[] magnets, Player player1, Player player2, Ball puck, int player) {

        for (int i = 0; i < 3; i++) {
            magnets[i].setXPosition(magnets[i].getStartXPosition());
            magnets[i].setYPosition(magnets[i].getStartYPosition());
            magnets[i].setSpeed(0,0);
            magnets[i].setCollided(false);
        }

        player1.setXPosition(player1.getStartXPosition());
        player1.setYPosition(player1.getStartYPosition());
        player1.resetMagnet();
        player2.setXPosition(player2.getStartXPosition());
        player2.setYPosition(player2.getStartYPosition());
        player2.resetMagnet();

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
            else{
                break;
            }
        }
        return false;
    }

}