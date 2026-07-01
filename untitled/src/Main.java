import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 테스트 케이스 1: 원소가 1개일 때
        int[] nums1 = {7};
        List<List<Integer>> result1 = solution(nums1);
        System.out.println("테스트 케이스 1 결과: " + result1);
        // 예상 출력: [[], [7]] (출력 순서는 다를 수 있음)

        // 테스트 케이스 2: 원소가 2개일 때
        int[] nums2 = {4, 5};
        List<List<Integer>> result2 = solution(nums2);
        System.out.println("테스트 케이스 2 결과: " + result2);
        // 예상 출력: [[], [4], [5], [4, 5]] (출력 순서는 다를 수 있음)

        // 테스트 케이스 3: 원소가 3개일 때 (가장 일반적인 경우)
        int[] nums3 = {1, 2, 3};
        List<List<Integer>> result3 = solution(nums3);
        System.out.println("테스트 케이스 3 결과: " + result3);
        // 예상 출력: [[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]] (출력 순서는 다를 수 있음)
    }

    public static List<List<Integer>> solution(int[] nums) {
        // 이곳에 알맞은 리스트를 선언하고 재귀(백트래킹) 함수를 시작하세요.
        List<List<Integer>> outerList=new ArrayList<>();
        List<Integer> innerList=new ArrayList<>();
        int repeatNum=0;
        f(outerList,innerList,nums,0,repeatNum);
        return outerList;
    }

//이미 있는건 어케 확인하지, 추가 배열로 확인하기에는 nums의 크기가 커지면 힘들어지는데
//    /사전으로 해당 값들넣어두는것도 그렇고


    private static void f(List<List<Integer>> outerList,List<Integer> innerList,int[] arr,int index,int repeatNum){
        //종료조건은<<<<<<<<
        if(repeatNum>arr.length){
            List<Integer> temp=new ArrayList<>();
            for (int i = 0; i < innerList.size(); i++) {
                temp.add(innerList.get(i));
            }
            outerList.add(temp);
            return;

        }

        for (int i = index; i <arr.length ; i++) {
//            System.out.println("i는"+i);

            f(outerList,innerList,arr,index,repeatNum+1);
            //만약 리스트의 크기가 5로 정해져있었더라면 더 쉬웠을까나
            //이거 순서대로 하거나 순열처럼 2,3 3,2다르게 하ㅁ려면 visited필요하다고 햇던가

            innerList.add(arr[i]);
            f(outerList,innerList,arr,index+1,repeatNum+1);
            innerList.remove(innerList.size()-1);
        }

    }


}
//이전 합 구하기 문제와 달리 특정 합(sumLimit)이나 개수(limit) 제한이 없습니다. 즉, 재귀 함수가 호출될 때마다 현재 innerList 상태의 복사본을 무조건 result에 추가하고 탐색을 계속하면 됩니다.
//<뭔소리지 아 걍 이건 np문제에서 무조건 다 돌아봐야한다는 그뜻인가
//근데 그러면 재귀마다 추가하는건 아니잖아, 그러면 중복 아닌가 <어떤 분기점 있어야하지않나