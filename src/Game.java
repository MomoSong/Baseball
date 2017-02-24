/**
 * Created by johnm on 2017-02-24.
 * <p>
 * BASEBALL 게임입니다.
 */


public class Game {
    int[] anSource; //1~9까지 담을 배열
    int[] answer;
    int[] guess;
    int[] arSbo; //Strike, ball, out 배열

    public Game(){
        answer = new int[3];
        guess = new int[3];
        arSbo = new int[3];
        anSource = new int[9];
        for(int i=1; i<anSource.length; i++){
            anSource[i] = i;
        }

        makeAnswer();
    }

    //중복되지 않는 숫자를 만들기 위해 1~9배열을 섞어서 앞에서부터 옮겨담는다.
    private void makeAnswer(){
        int tmp;
        for(int i=0; i<anSource.length; i++){
            int j = (int)(Math.random()*8)+1;
            tmp = anSource[i];
            anSource[i] = anSource[j];
            anSource[j] = tmp;
        }

        for(int i=0; i<answer.length; i++){
            answer[i] = anSource[i];

        }
    }

    //본게임에서 넘어온 숫자를 배열로 저장해 비교한다.
    public int[] inGame(int num){
        boolean flag = false;

        for(int i=0; i<arSbo.length-1; i++){
            arSbo[i] = 0;
        }

        for(int i=guess.length-1; i>=0; i--){
            guess[i] = num % 10;
            num /= 10;
        }

        for(int i=0; i<guess.length; i++){
            System.out.println(guess[i]);
        }

        //생각한 숫자와 정답 비교
        for(int i=0; i<answer.length; i++){
            for(int j=0; j<guess.length; j++){
                if(answer[i] == guess[j]){
                    if(i==j){
                        arSbo[0]++;
                        flag = true;
                    }else{
                        arSbo[1]++;
                        flag = true;
                    }
                }
            }
        }

        if(flag == false) arSbo[2]++;
        return arSbo;
    }

    public String getAnswer(){
        String str = "";
        for(int i=0; i<answer.length; i++){
            str += answer[i];
        }
        return str;
    }
}
