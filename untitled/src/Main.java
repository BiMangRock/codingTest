import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 테스트 케이스 1
        String s1 = "baabaa";
        int result1 = solution(s1);
        System.out.println("테스트 케이스 1 결과: " + result1); // 예상 출력: 1

        // 테스트 케이스 2
        String s2 = "cdcd";
        int result2 = solution(s2);
        System.out.println("테스트 케이스 2 결과: " + result2); // 예상 출력: 0
    }

    public static int solution(String s) {
        ArrayDeque<Character> stack=new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            Character wantToEnterStackC=s.charAt(i);
            if(stack.isEmpty()){
                stack.push(wantToEnterStackC);
            }
            else{
                Character insideStackC=stack.peek();
                if(insideStackC==wantToEnterStackC){
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()){
            return 1;
        }
        return 0;


    }
}