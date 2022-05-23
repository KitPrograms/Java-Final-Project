import java.util.Random;
public class test {

    public static void main(String[]args){
        Random rd = new Random();
        while(true){
            System.out.println(rd.nextInt(2));
        }
    }
}
