import java.util.Random;

public class Main {
    public static void main(String[]args){
        GameArena board = new GameArena(1000, 600);

        Rectangle left_side = new Rectangle(0,0,500,600, "BLUE");
        Rectangle right_side = new Rectangle(500,0,500,600, "BLUE");
        board.addRectangle(left_side);
        board.addRectangle(right_side);

        Line mid_line = new Line(497.5, 0, 497.5, 600, 10, "LIGHTGREY");
        board.addLine(mid_line);

        Ball corner1 = new Ball(0,0,100,"LIGHTGREY");
        Ball corner2 = new Ball(0,600,100,"LIGHTGREY");
        Ball corner3 = new Ball(1000,0,100,"LIGHTGREY");
        Ball corner4 = new Ball(1000,600,100,"LIGHTGREY");
        board.addBall(corner1);
        board.addBall(corner2);
        board.addBall(corner3);
        board.addBall(corner4);


        Ball left_goal = new Ball(40,300,60, "CYAN");
        Ball right_goal = new Ball(960, 300, 60, "CYAN");
        board.addBall(left_goal);
        board.addBall(right_goal);

        Ball magnet1 = new Ball(500, 180, 20, "WHITE");
        Ball magnet2 = new Ball(500, 300, 20, "WHITE");
        Ball magnet3 = new Ball(500, 420, 20, "WHITE");
        board.addBall(magnet1);
        board.addBall(magnet2);
        board.addBall(magnet3);
        
        Ball player1 = new Ball(120, 300, 50, "BLACK");
        Ball player2 = new Ball(880, 300, 50, "BLACK");
        board.addBall(player1);
        board.addBall(player2);

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

        while(true){
            //Player2 Movement
            if (board.upPressed() == true){
                player2.move(0,-10);
                
            }
            if (board.downPressed() == true){
                player2.move(0,10);
                
            }
            if (board.leftPressed() == true){
                player2.move(-10,0);
                
            }
            if (board.rightPressed() == true){
                player2.move(10,0);
                
            }


            //Player 1 Movement
            if (board.letterPressed('w') == true){
                player1.move(0,-10);
                
            }
            if (board.letterPressed('s') == true){
                player1.move(0,10);
                
            }
            if (board.letterPressed('a') == true){
                player1.move(-10,0);
                
            }
            if (board.letterPressed('d') == true){
                player1.move(10,0);
                
            }

            board.pause();
        }

    }
}