import java.util.Scanner;

/**
 * Created by johnm on 2017-02-24.
 */
public class Main {
    public static void main(String[] args) {
        int n1 = 0, n2 = 0, n3 = 0;
        int[] inputNum = new int[3];
        boolean flag = true;

        Game myGame = new Game();
        System.out.println(myGame.getGameNumber());
        Scanner myscan = new Scanner(System.in);

        while (flag) {
            for(int i=0; i<inputNum.length; i++){
                inputNum[i] = myscan.nextInt();
                myscan.nextLine();
            }
            System.out.println(myGame.inPut(inputNum));
        }

    }
}
