import java.util.Random;

public class Main {
    public static void main(String[]args){


        //setting up game layout
        Board board = new Board(1000, 600);

        Rectangle left_side = new Rectangle(0,0,500,600, "BLUE");
        Rectangle right_side = new Rectangle(500,0,500,600, "BLUE");
        board.addRectangle(left_side);
        board.addRectangle(right_side);

        Line mid_line = new Line(497.5, 0, 497.5, 600, 10, "LIGHTGREY");
        board.addLine(mid_line);

        

        //adding corners to each corners

        Ball[] corners = new Ball[4];
        int xPlacement = 0;
        for(int i=0; i<2; i++){
            int yPlacement = 0;
            for(int j=0; j<2; j++){
                corners[i] = new Ball(xPlacement, yPlacement, 100, "WHITE");
                board.addBall(corners[i]);
                yPlacement = yPlacement + 600;
            }
            xPlacement = xPlacement + 1000;
        }


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
        Player player1 = new Player(250, 300, 50, "BLACK");
        Player player2 = new Player(750, 300, 50, "BLACK");
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

        
        //adding goals text
        String score = left_goal.getGoals() + ":" + right_goal.getGoals();
        Text scoreDisplay = new Text(score, 50, 450, 50, "WHITE",2 );
        board.addText(scoreDisplay);
        
        while(true){
            player1.setXSpeed(1);
            player1.setYSpeed(1);
            player2.setXSpeed(1);
            player2.setYSpeed(1);
            
            //Player2 Movement
            if (board.upPressed() == true && player2.getYPosition() > 25){
                player2.setYSpeed(-10);
                player2.move(0,-10);
            }
            
            if (board.downPressed() == true && player2.getYPosition() < 575){
                player2.setYSpeed(10);
                player2.move(0,10);
            }
            
            if (board.leftPressed() == true && player2.getXPosition() > 525){
                player2.setXSpeed(-10);
                player2.move(-10,0);
            }
            
            if (board.rightPressed() == true && player2.getXPosition() < 975){
                player2.setXSpeed(10);
                player2.move(10,0);
            }
            

            //Player 1 Movement
            if (board.letterPressed('w') == true && player1.getYPosition() > 25){
                player1.setYSpeed(-10);
                player1.move(0,-10);
            }
            
            if (board.letterPressed('s') == true && player1.getYPosition() < 575){
                player1.setYSpeed(10);
                player1.move(0,10);
            }
            
            if (board.letterPressed('a') == true && player1.getXPosition() > 25){
                player1.setXSpeed(-10);
                player1.move(-10,0);
            }
            
            if (board.letterPressed('d') == true && player1.getXPosition() < 475){
                player1.setXSpeed(10);
                player1.move(10,0);
            }
            
            
            player1.checkCollides(puck);
            player2.checkCollides(puck);
           
            if (left_goal.checkGoal(puck) == true || left_goal.checkGoal(player1) == true ){
                score = left_goal.getGoals() + ":" + right_goal.getGoals();
                scoreDisplay.setText(score);
                board.reset(magnets, player1, player2, puck, 2);
            }
            if (right_goal.checkGoal(puck) == true || right_goal.checkGoal(player2) == true || player2.getMagnetCount() >= 2){
                score = left_goal.getGoals() + ":" + right_goal.getGoals();
                scoreDisplay.setText(score);
                board.reset(magnets, player1, player2, puck, 1);
            }

            for (int i=0; i<3; i++){
                if (player1.collides(magnets[i] )== true){
                    player1.checkCollides(magnets[i]);
                    player1.addMagnet();
                }
                if (player2.collides(magnets[i] )== true){
                    player2.checkCollides(magnets[i]);
                    player2.addMagnet();
                }
                magnets[i].checkCollides(puck);
            }

            for(int i=0; i<3; i++){
                magnets[i].keepmove();
            }
            puck.keepmove();
            board.pause();
        }

    }
}