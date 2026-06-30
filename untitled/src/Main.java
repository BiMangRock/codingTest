import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 테스트 케이스 1
        String s1 = "banana";
        int[] result1 = solution(s1);
        System.out.println("테스트 케이스 1 결과: " + Arrays.toString(result1)); // 예상 출력: [-1, -1, -1, 2, 2, 2]

        // 테스트 케이스 2
        String s2 = "foobar";
        int[] result2 = solution(s2);
        System.out.println("테스트 케이스 2 결과: " + Arrays.toString(result2)); // 예상 출력: [-1, 1, -1, -1, -1, -1] //<입출력 예시 맞나 ?-1,1아닌가
    }

    public static int[] solution(String s) {
        //이게 앞이랑 뒤의 차이가 뭐인거지 <<<<<<<
        //뭔가 계수배열로 26개의 배열 만들어서 할수있을것같은데
//        int k=26;
        int k=200; //몇갱지모르겟지만
        int[] arr=new int[k];
        int[] result=new int[s.length()];
        for (int i = 0; i <k ; i++) {
            arr[i]=-1;

        }



        for (int i = 0; i < s.length(); i++) {

            char c=s.charAt(i);

            if(arr[c]==-1){
                arr[c]=i;
                result[i]=-1;
            }
            else{
//                arr[c]=i;순서문제 ?
                result[i]=i-arr[c];
                arr[c]=i;
            }
        }
        return result;



    }
}