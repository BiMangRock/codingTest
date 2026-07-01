import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 테스트 케이스 1
        int k1 = 3;
        int n1 = 7;
        List<List<Integer>> result1 = solution(k1, n1);
        System.out.println("테스트 케이스 1 결과: " + result1);
        // 예상 출력: [[1, 2, 4]]

        // 테스트 케이스 2
        int k2 = 3;
        int n2 = 9;
        List<List<Integer>> result2 = solution(k2, n2);
        System.out.println("테스트 케이스 2 결과: " + result2);
        // 예상 출력: [[1, 2, 6], [1, 3, 5], [2, 3, 4]]
    }

    public static List<List<Integer>> solution(int k, int n) {
        List<List<Integer>> result = new ArrayList<>(); //이런것도 주지말라고 <<<<<<<<<<
        List<Integer> innerList=new ArrayList<>();
        //이차원 형태의 리스트이면 안쪽 리스트 생성은 언제 해야하는거지
        f(result,innerList,0,0,k,n);
        return result;
    }

    //갯수 영어로\
    //관련 문제<<<<<주솟값 공유문제
    private static void f(List<List<Integer>> result,List<Integer> innerList,int sum,int nowNum,int limit,int sumLimit){
//        System.out.println("list:"+innerList+"  listSize"+innerList.size()+"  limit"+limit+"   sum"+sum+"    sumLimit"+sumLimit);
//        System.out.println("전체 list의상태 :"+result+"   innerREsult"+innerList);


        if(sum==sumLimit && innerList.size()==limit){
            ArrayList<Integer> temp=new ArrayList<>();
            for (int i = 0; i < innerList.size(); i++) {
                temp.add(innerList.get(i));
            }
            result.add(temp);



        }
        else if(sum>sumLimit){
            //이거 innerList의 주소공유문제 해결하려면 객체를 생성해야하는데 이 객체 생성의 시점이 언제가 되어야하는거지 ?
            return;//이러면 재귀만 멈추는거잖아
        }

        if(innerList.size()>limit){
            return;
        }
        //잘못된 경우에는 리스트 객체 새로 생성하면 안되겟지 ?

        //미로찾기가 그랫듯이, 재귀안에서 반복문이 피료하던가
        for (int i = nowNum+1; i <=9 ; i++) {//이거 경곗값 부분<<<<<<<<<<<<<<<<

            innerList.add(i);
            sum+=i;

            nowNum=i;
            f(result, innerList, sum, nowNum,limit,sumLimit);

            sum-=i;
            innerList.remove(innerList.size()-1);

        }









    }
}











