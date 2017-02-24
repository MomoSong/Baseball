/**
 * Created by johnm on 2017-02-24.
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        System.out.println(game.getAnswer());

        System.out.println(getAr(game.inGame(123)));
        System.out.println(getAr(game.inGame(456)));
        System.out.println(getAr(game.inGame(789)));
        System.out.println(getAr(game.inGame(248)));
        System.out.println(getAr(game.inGame(976)));
        System.out.println(getAr(game.inGame(135)));


    }

    public static String getAr(int[] ar) {
        String str = "";
        for (int i = 0; i < ar.length; i++) {
            str += ar[i];
        }
        return str;
    }
}
