import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 테스트 케이스 1
        String s1 = "banana";
        int[] result1 = solution(s1);
        System.out.println("테스트 케이스 1 결과: " + Arrays.toString(result1)); // 예상 출력: [-1, 2, 2, 2, -1, -1]

        // 테스트 케이스 2
        String s2 = "foobar";
        int[] result2 = solution(s2);
        System.out.println("테스트 케이스 2 결과: " + Arrays.toString(result2)); // 예상 출력: [-1, 1, -1, -1, -1, -1]
    }

    public static int[] solution(String s) {
        int size='z'-'a';
        int N=s.length();
        int[] count=new int[size];
        int[] result=new int[s.length()];
        for (int i = 0; i <count.length ; i++) {
            count[i]=-1;
        }

        for (int i = N-1; i >=0; i--) {
            char c=s.charAt(i);
            int index=c-'a';

            System.out.println(String.format("현재의 (문자,i,count의 index):(%c,%d,%d)",c,i,index));

            if(count[index]==-1){
                result[i]=-1;
                count[index]=i;
            }
            else{
                result[i]=count[index]-i;
                count[index]=i;
            }

        }
        return result;
    }
}