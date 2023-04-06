import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        int[] comArr = new int[3]; // 컴퓨터가 뽑은 숫자를 저장할 배열
        int[] userArr = new int[3]; // 사용자가 입력한 숫자를 저장할 배열
        int tryCount = 0; // 시도 횟수를 저장할 변수
        boolean isEnd = false; // 게임 종료 여부를 저장할 변수

        // 컴퓨터가 뽑은 3자리 숫자를 생성
        for (int i = 0; i < comArr.length; i++) {
            comArr[i] = (int) (Math.random() * 10); // 0~8 사이의 난수에 1을 더해 1~9 사이의 수를 생성
            // 중복된 숫자가 있을 경우 다시 뽑기
            for (int j = 0; j < i; j++) {
                if (comArr[i] == comArr[j]) {
                    i--;
                    break;
                }
            }
        }
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        Scanner sc = new Scanner(System.in);

        while (!isEnd) {
            tryCount++; // 시도 횟수 증가
            int strikeCount = 0; // S의 개수를 저장할 변수
            int ballCount = 0; // B의 개수를 저장할 변수

            // 사용자로부터 3자리 숫자 입력 받기
            System.out.print("숫자 3개를 입력하세요: ");
            int inNum = sc.nextInt(); //321
            userArr[0] = (inNum)/100; //3
            inNum = inNum-((inNum)/100)*100; //21
            userArr[1] = (inNum)/10; //2
            userArr[2] = (inNum)%10; //1

            // 숫자와 위치가 일치하는 경우 S의 개수를 증가
            for (int i = 0; i < comArr.length; i++) {
                if (userArr[i] == comArr[i]) {
                    strikeCount++;
                }
            }

            // 숫자는 일치하지만 위치가 다른 경우 B의 개수를 증가
            for (int i = 0; i < comArr.length; i++) {
                for (int j = 0; j < userArr.length; j++) {
                    if (comArr[i] == userArr[j] && i != j) {
                        ballCount++;
                    }
                }
            }

            // 게임 종료 여부 확인
            if (strikeCount == 3) {
                isEnd = true;
                System.out.println("축하합니다! " + tryCount + "번 만에 맞추셨습니다.");
            } else {
                System.out.println(strikeCount + "S " + ballCount + "B");
            }
        }

        System.out.println("게임을 종료합니다.");
        sc.close();
    }
}

