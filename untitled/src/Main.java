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
//        int repeatNum=0;
        f(outerList,innerList,nums,0);
        return outerList;
    }

//이미 있는건 어케 확인하지, 추가 배열로 확인하기에는 nums의 크기가 커지면 힘들어지는데
//    /사전으로 해당 값들넣어두는것도 그렇고


    private static void f(List<List<Integer>> outerList,List<Integer> innerList,int[] arr,int index){
        //종료조건은<<<<<<<<반복문이 있으니깐 멈추게 되나 <<<<
        //근데 if로 분기점을 만들어야지 result <<외부반복문에 넣을타이밍이 생기는데 <<<<
        if(index>arr.length-1){
            //이러면 빈리스트나 리스트보다 크기가 작은건 캐치를 못하는데 그리고 뭔가 이상한데

            ArrayList<Integer> temp=new ArrayList<>();
            for (int i = 0; i < innerList.size(); i++) {
                temp.add(innerList.get(i));
            }
            outerList.add(temp);
        }

        for (int i = index; i <arr.length ; i++) {


            innerList.add(arr[i]);
            f(outerList,innerList,arr,index+1);

            innerList.remove(innerList.size()-1);
        }

    }


}
//이전 합 구하기 문제와 달리 특정 합(sumLimit)이나 개수(limit) 제한이 없습니다. 즉, 재귀 함수가 호출될 때마다 현재 innerList 상태의 복사본을 무조건 result에 추가하고 탐색을 계속하면 됩니다.
//<뭔소리지 아 걍 이건 np문제에서 무조건 다 돌아봐야한다는 그뜻인가
//근데 그러면 재귀마다 추가하는건 아니잖아, 그러면 중복 아닌가 <어떤 분기점 있어야하지않나