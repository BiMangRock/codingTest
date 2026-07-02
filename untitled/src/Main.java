import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 테스트 케이스 1: 일반적인 조합 (4개 중 2개 고르기)
        int n1 = 4;
        int m1 = 2;
        List<List<Integer>> result1 = solution(n1, m1);
        System.out.println("테스트 케이스 1 결과: " + result1);
        // 예상 출력: [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]

        // 테스트 케이스 2 [예외]: 모든 숫자를 다 고르는 경우 (3개 중 3개 고르기)
        int n2 = 3;
        int m2 = 3;
        List<List<Integer>> result2 = solution(n2, m2);
        System.out.println("테스트 케이스 2 결과: " + result2);
        // 예상 출력: [[1, 2, 3]]

        // 테스트 케이스 3 [예외]: 0개를 고르는 경우 (4개 중 0개 고르기)
        int n3 = 4;
        int m3 = 0;
        List<List<Integer>> result3 = solution(n3, m3);
        System.out.println("테스트 케이스 3 결과: " + result3);
        // 예상 출력: [[]] (빈 리스트가 딱 하나 들어있어야 함)

        // 테스트 케이스 4 [예외]: 가진 숫자보다 더 많이 고르라고 하는 황당한 경우 (3개 중 5개 고르기)
        int n4 = 3;
        int m4 = 5;
        List<List<Integer>> result4 = solution(n4, m4);
        System.out.println("테스트 케이스 4 결과: " + result4);
        // 예상 출력: [] (아무것도 고를 수 없으므로 완전히 텅 빈 리스트 반환)
    }

    public static List<List<Integer>> solution(int n, int m) {
        // 이 부분을 구현하여 결과를 반환하세요.
        // 위에 있는 4가지 까다로운 테스트 케이스를 모두 통과해야 합니다!
        List<List<Integer>> outerList=new ArrayList<>();
        List<Integer> innerList=new ArrayList<>();
        f(outerList,innerList,n,m,1);
        return outerList;
    }
    private static void f(List<List<Integer>> outerList,List<Integer> innerList,int n,int m,int nowIndex){

        if(innerList.size()==m){
            List<Integer> temp=new ArrayList<>();
            for (int i = 0; i < innerList.size(); i++) {
                temp.add(innerList.get(i));
            }
            outerList.add(temp);
            return;
        }

        for (int i = nowIndex; i <=n ; i++) {

            innerList.add(i);
            f(outerList,innerList,n,m,i+1);
            //f(outerList,innerList,n,m,nowIndex+1);<이면 왜안되는거지

            innerList.remove(innerList.size()-1);
        }



    }

}





























