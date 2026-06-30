import javax.security.auth.callback.CallbackHandler;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//
//        String s="12345";
//        System.out.println(s.substring(1,3));

        // 테스트 케이스 1
        String s1 = "[](){}";
        int result1 = solution(s1);
        System.out.println("테스트 케이스 1 결과: " + result1); // 예상 출력: 3

        // 테스트 케이스 2
        String s2 = "}()[]{";
        int result2 = solution(s2);
        System.out.println("테스트 케이스 2 결과: " + result2); // 예상 출력: 2
    }


    public static int solution(String s) {
        String subString;
        int count=0;
        for (int i = 0; i < s.length(); i++) { //이거 경곗갑 ㅅ설정 왜 이렇게 해야하는거지
            subString=s.substring(i,s.length())+s.substring(0,i); //포함여부 -1인가//i부터 시작이 있으니 끝부분인 i가 포함되면 두번 포함되는건가
            //1234
//            System.out.println("i는"+i+"subSting:"+subString);
            if(isRepeat(subString)){
                count++;
            }
        }
        return count;
    }
    public static boolean isRepeat(String s){
        System.out.println("==========현재의 subString:"+s+"===============");
        ArrayDeque<Character> stack=new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {

            Character outSideC=s.charAt(i);
            System.out.println("i는"+i+"stack:"+stack);

//            System.out.println("현재의 c:"+outSideC);
            if(stack.isEmpty()){
                if(outSideC==']' || outSideC=='}' || outSideC==')'){
                    System.out.println("!!");
                    return false;
                }
                stack.push(outSideC);
            }


            else{
                //6가지 분기점을 만드어야하나
                Character insideStackC=stack.peek();
                if(insideStackC=='[' && outSideC==']' ||      insideStackC=='{' && outSideC=='}' || insideStackC=='(' && outSideC==')' ){
                    stack.pop();
                }



                else{
                    if(outSideC=='[' || outSideC=='{' || outSideC=='('){
                        stack.push(outSideC);
                    }
                    else{
                        System.out.println("!");
                        return false;
                    }
                }
            }
        }
        System.out.println("현재의 스택:"+stack);
        if(stack.isEmpty()){
            System.out.println("true");
            return true;
        }
        else{
            System.out.println("false");
            return  false;
        }

    }
}
//왜 회전 횟수는 n-1인거지
//반복문 만들어서 매번 substring만들고 알맞는 문자라면 ++시키는 형식으로 하는가