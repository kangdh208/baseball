import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //입력기
        String gameNumber = ""; //문자열 변수 선언
        Set<Integer> set = new HashSet<>(); //컬렉션 생성 . 자료구조 중복금지 : Set 순서 필요 : HashSet
        while(true){ //자릿수 늘리기 자유로움 while vs for 차이
            int number = (int)(Math.random()*10); //숫자 무작위 선택
            set.add(number); // 컬렉션에 저장
            if(set.size()==3){ //필요한 숫자만큼 무작위 선택
                for(int item : set){ //향상된 for문 (변수타입 변수명 : 목록변수){연산}
                    String numberStr = Integer.toString(item); //숫자열을 문자열로 변경 toString
                    gameNumber+=numberStr; //gameNumber에 numberStr 추가
                }
                break; // 빠져나오기
            }
        }
        int chance = 1 ;
        while(true){
            int strike = 0;
            int ball = 0;

            System.out.print(chance+ "번째 도전 ! 3자리 숫자를 입력해주세요 : ");

            String answer = scanner.nextLine();

            for(int i=0;i<3;i++){ //
                if(gameNumber.charAt(i)==answer.charAt(i)){ //charAt 문자열의 위치를 파악
                    strike+=1;
                }else{
                    if(answer.indexOf(gameNumber.charAt(i))!=-1){//indexOf 자리의 위치를 찾는 메소드 단점 : 중복을 허용할때는 쓸수 없음
                        ball+=1;
                    }
                }
            }

            if(strike==3){ //정답일때 표시
                System.out.println(chance+"번 시도만에 정답입니다! 게임을 종료합니다!");
                break;
            }else{
                System.out.println("Strike : "+strike+", Ball :"+ball);
            }
            chance+=1;
        }
    }
}
