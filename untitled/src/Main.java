import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 테스트 케이스 1: 1부터 3까지의 숫자 중 1개 고르기
        int n1 = 3;
        int m1 = 1;
        List<List<Integer>> result1 = solution(n1, m1);
        System.out.println("테스트 케이스 1 결과: " + result1);
        // 예상 출력: [[1], [2], [3]]

        // 테스트 케이스 2: 1부터 3까지의 숫자 중 2개 고르기
        int n2 = 3;
        int m2 = 2;
        List<List<Integer>> result2 = solution(n2, m2);
        System.out.println("테스트 케이스 2 결과: " + result2);
        // 예상 출력: [[1, 2], [1, 3], [2, 1], [2, 3], [3, 1], [3, 2]] (출력 순서는 달라도 괜찮습니다)
    }

    public static List<List<Integer>> solution(int n, int m) {
        // 이 부분을 구현하여 결과를 반환하세요.
        List<Integer> innerList=new ArrayList<>();
        List<List<Integer>> outerList=new ArrayList<>();
        boolean[] visited=new boolean[n];
        f(outerList,innerList,n,m,visited);

        return outerList;
    }
    private static void f(List<List<Integer>> outerList, List<Integer> innerList,int n,int m,boolean[] visited){

        if(innerList.size()==m){
            List<Integer> temp=new ArrayList<>(m);
            for (int i = 0; i < innerList.size(); i++) {
                temp.add(innerList.get(i));
            }
            outerList.add(temp);
            return;
        }

        //이거 i-1을 visited에서 해야했던가
        for (int i = 1; i <=n ; i++) {

            if(!visited[i-1]){
                visited[i-1]=true;
                innerList.add(i);

                f(outerList,innerList,n,m,visited);

                innerList.remove(innerList.size()-1);
                visited[i-1]=false;


            }

        }











    }
}























