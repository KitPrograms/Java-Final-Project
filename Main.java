import java.util.Random;

public class Main {
    public static void main(String[]args){

        //setting up game layout
        GameArena board = new GameArena(1000, 600);

        Rectangle left_side = new Rectangle(0,0,500,600, "BLUE");
        Rectangle right_side = new Rectangle(500,0,500,600, "BLUE");
        board.addRectangle(left_side);
        board.addRectangle(right_side);

        Line mid_line = new Line(497.5, 0, 497.5, 600, 10, "LIGHTGREY");
        board.addLine(mid_line);

        //adding corners to each corner 
        Ball corner1 = new Ball(0,0,100,"LIGHTGREY");
        Ball corner2 = new Ball(0,600,100,"LIGHTGREY");
        Ball corner3 = new Ball(1000,0,100,"LIGHTGREY");
        Ball corner4 = new Ball(1000,600,100,"LIGHTGREY");
        board.addBall(corner1);
        board.addBall(corner2);
        board.addBall(corner3);
        board.addBall(corner4);


        //adding magnets to start positions
        Goal left_goal = new Goal(40,300,60, "CYAN");
        Goal right_goal = new Goal(960, 300, 60, "CYAN");
        board.addBall(left_goal);
        board.addBall(right_goal);


        //adding magnets to start positions
        Magnet[] magnets = new Magnet[3];
        int yPlacement = 180;
        for(int i=0; i<3; i++){
            magnets[i] = new Magnet(500, yPlacement, 20, "WHITE");
            board.addBall(magnets[i]);
            yPlacement = yPlacement + 120;
        }
        

        //adding players to start positions
        Player player1 = new Player(120, 300, 50, "BLACK");
        Player player2 = new Player(880, 300, 50, "BLACK");
        board.addBall(player1);
        board.addBall(player2);


        //adding ball to game board into a random corner
        Ball puck;
        Random ballPlace = new Random();
        if (ballPlace.nextInt(4) == 1){
            puck = new Ball(60,60,30,"YELLOW");
        }
        else if (ballPlace.nextInt(4) == 2){
            puck = new Ball(60,540,30,"YELLOW");
        }
        else if (ballPlace.nextInt(4) == 3){
            puck = new Ball(940,60,30,"YELLOW");
        }
        else{
            puck = new Ball(940,540,30,"YELLOW");
        }
        board.addBall(puck);
        double[] deflectSpeeds = new double[4];




        while(true){
            //Player2 Movement
            if (board.upPressed() == true && player2.getYPosition() > 0){
                player2.setYSpeed(-10);
                player2.move(0,-10);
            }
            
            if (board.downPressed() == true && player2.getYPosition() < 600){
                player2.setYSpeed(10);
                player2.move(0,10);
            }
            
            if (board.leftPressed() == true && player2.getXPosition() > 500){
                player2.setXSpeed(-10);
                player2.move(-10,0);
            }
            
            if (board.rightPressed() == true && player2.getXPosition() < 1000){
                player2.setXSpeed(10);
                player2.move(10,0);
            }
            

            //Player 1 Movement
            if (board.letterPressed('w') == true && player1.getYPosition() > 0){
                player1.setYSpeed(-10);
                player1.move(0,-10);
            }
            
            if (board.letterPressed('s') == true && player1.getYPosition() < 600){
               player1.setYSpeed(10);
               player1.move(0,10);
            }
            
            if (board.letterPressed('a') == true && player1.getXPosition() > 0){
                 player1.setXSpeed(-10);
                 player1.move(-10,0);
            }
            
            if (board.letterPressed('d') == true && player1.getXPosition() < 500){
                 player1.setXSpeed(10);
                player1.move(10,0);
            }
            
            if (puck.collides(player1)){
                deflectSpeeds = puck.deflect(puck.getXSpeed(), puck.getYSpeed(), puck.getXPosition(), puck.getYPosition(),player1.getXSpeed(), player1.getYSpeed(), player1.getXPosition(), player1.getYPosition());
                puck.setSpeed(deflectSpeeds[0], deflectSpeeds[1]);
            }
            if (puck.collides(player2)){
                deflectSpeeds = puck.deflect(puck.getXSpeed(), puck.getYSpeed(), puck.getXPosition(), puck.getYPosition(),player2.getXSpeed(), player2.getYSpeed(), player2.getXPosition(), player2.getYPosition());
                puck.setSpeed(deflectSpeeds[0], deflectSpeeds[1]);
            }

            puck.keepmove();
            board.pause();
        }

    }
}