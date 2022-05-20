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

        //adding cushions to each corner 
        Cushion corner1 = new Cushion(0,0,100,"LIGHTGREY");
        Cushion corner2 = new Cushion(0,600,100,"LIGHTGREY");
        Cushion corner3 = new Cushion(1000,0,100,"LIGHTGREY");
        Cushion corner4 = new Cushion(1000,600,100,"LIGHTGREY");
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
        Magnet magnet1 = new Magnet(500, 180, 20, "WHITE");
        Magnet magnet2 = new Magnet(500, 300, 20, "WHITE");
        Magnet magnet3 = new Magnet(500, 420, 20, "WHITE");
        board.addBall(magnet1);
        board.addBall(magnet2);
        board.addBall(magnet3);
        

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