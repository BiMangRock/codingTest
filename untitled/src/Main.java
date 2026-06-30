import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 테스트 케이스 1
        int n1 = 7;
        int k1 = 3;
        int[] result1 = solution(n1, k1);
        System.out.println("테스트 케이스 1 결과: " + Arrays.toString(result1)); // 예상 출력: [3, 6, 2, 7, 5, 1, 4]

        // 테스트 케이스 2
        int n2 = 5;
        int k2 = 2;
        int[] result2 = solution(n2, k2);
        System.out.println("테스트 케이스 2 결과: " + Arrays.toString(result2)); // 예상 출력: [2, 4, 1, 5, 3]
    }

    public static int[] solution(int n, int k) {
        //근데 큐로하면, 이게 스케쥴링이랑 다르게, 1번이 계속 1번이어야하는데 그냥 arraylist쓰면 안되나
        //<다음 동작이 다시 처음으로 돌아가는게 아니구나
        ArrayDeque<Integer> queue=new ArrayDeque<>();
        int[] arr=new int[n];
        for (int i = 1; i <=n ; i++) {
            queue.add(i);
        }
        int index=0;
        int copiedK=k;
        while (!queue.isEmpty()){

            copiedK--;
            int poppedNumber=queue.pollFirst();

            if(copiedK==0){
                arr[index]=poppedNumber;
                index++;
                copiedK=k;
            }
            else{
                queue.add(poppedNumber);
            }


        }


        return arr;
    }
}