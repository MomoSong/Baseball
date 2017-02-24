/**
 * Created by johnm on 2017-02-24.
 * <p>
 * BASEBALL 게임입니다.
 * 숫자입력은 x, x, x형식입니다. 각 숫자는 0~9사이를 넣어주세요.
 */


public class Game {
    private int strike;
    private int ball;
    private int out;

    private int[] gameNumber;
    private int[] inputNum;

    final int MAXBALL = 4;
    final int MAXOUT = 300;

    public Game() {
        setStrike(0);
        setBall(0);
        setOut(0);
        gameNumber = new int[3];
        generateNumber(gameNumber);
    }

    private void generateNumber(int[] arNum) {
        boolean flag = true;

        while(flag){
            for (int i = 0; i < arNum.length; i++) {
                arNum[i] = (int) (Math.random() * 9) + 1;
            }

            if(arNum[0] != arNum[1] && arNum[0] != arNum[2] || arNum[1] != arNum[2]){
                flag = false;
            }
        }





    }

    public String inPut(int[] inputNum) {
        for (int i = 0; i < inputNum.length; i++) {
            if (inputNum[i] < 1 && inputNum[i] > 9) {
                return "1~9까지 중복되지 않는 숫자를 넣어주세요.";
            }
        }

        for (int i = 0; i < inputNum.length; i++) {
            if (i < inputNum.length - 1) {
                if (inputNum[i] == inputNum[i + 1]) {
                    return "1~9까지 중복되지 않는 숫자를 넣어주세요.";
                }
            }else{
                if(inputNum[i] == inputNum[i-1]) {
                    return "1~9까지 중복되지 않는 숫자를 넣어주세요.";
                }else if(inputNum[i] == inputNum[i-2]){
                    return "1~9까지 중복되지 않는 숫자를 넣어주세요.";
                }
            }
        }


        return compare(inputNum);
    }

    private String compare(int[] arNum) {
        boolean flag = false;
        int count = 0;
        setStrike(0);
        setBall(0);

        for(int i=0; i<arNum.length; i++){
            if(arNum[i] == gameNumber[i]){
                count++;
            }

            if(count == arNum.length){
                return "전부 맞췄습니다. 승리!";
            }

        }

        for (int i = 0; i < this.gameNumber.length; i++) {
            for (int j = 0; j < arNum.length; j++) {
                if (gameNumber[i] == arNum[j]) {
                    if (j == i) {
                        setStrike(getStrike() + 1);
                        flag = true;
                    } else {
                        setBall(getBall() + 1);
                        flag = true;
                    }
                }
            }
        }

        if (flag == false) {
            setOut(getOut() + 1);
        }

        if (getBall() == MAXBALL) {
            setOut(getOut() + 1);
        }
        if (getOut() == MAXOUT) {
            setStrike(0);
            setBall(0);
            setOut(0);
            return "3아웃. 게임 오버입니다.";
        }

        return toString();

    }

    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getOut() {
        return out;
    }

    public void setOut(int out) {
        this.out = out;
    }

    public String getGameNumber() {
        return gameNumber[0] + "," + gameNumber[1] + "," + gameNumber[2];
    }

    @Override
    public String toString() {
        return strike + "스트라이크!, " +
                ball + "볼!, " +
                out + "아웃!";
    }
}
