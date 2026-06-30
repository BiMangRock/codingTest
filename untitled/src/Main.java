import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 테스트 케이스 1
        int[] priorities1 = {2, 1, 3, 2};
        int location1 = 2;
        int result1 = solution(priorities1, location1);
        System.out.println("테스트 케이스 1 결과: " + result1); // 예상 출력: 1

        // 테스트 케이스 2
        int[] priorities2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;
        int result2 = solution(priorities2, location2);
        System.out.println("테스트 케이스 2 결과: " + result2); // 예상 출력: 5
    }

    public static int solution(int[] priorities, int location) {
        // TODO: 이 메소드를 완성하세요.

        ArrayDeque<IndexAndValue> queue=new ArrayDeque<>();
        PriorityQueue<IndexAndValue> priorityQueue=new PriorityQueue<>(Comparator.reverseOrder()); //기본적으로 민힙이라서 ??<<<<<<<<첫번째

        for (int i = 0; i < priorities.length; i++) {
            IndexAndValue indexAndValue=new IndexAndValue(i,priorities[i]);
            queue.add(indexAndValue);
            priorityQueue.add(indexAndValue);
            //아무튼 알아서 재구성 해준다는거잖아,
        }

        int order=1;
        //이러면 뭐가 큰지 compareto로 넘겨줘야하나 오버라이딩을 해줘야하나 ????<<<<<<<<두번쨰
//        System.out.println("queue"+queue);
//        System.out.println("priorityQueue"+priorityQueue);

        while (!queue.isEmpty() && !priorityQueue.isEmpty()){
//            System.out.println("==================");
            IndexAndValue indexAndValue=queue.pollFirst();

//            System.out.println("queue에서 뽑힌 녀석:"+indexAndValue);
            IndexAndValue maxIndexAndValue=priorityQueue.peek();


            //equals해야하나 아미녀 equlato도 오버라이딩을 해야하나, 두 멤버변수가 같으면 같도록 ?
            if(indexAndValue.equals(maxIndexAndValue)){
//
//                System.out.println("queue"+queue);
//                System.out.println("priorityQueue"+priorityQueue);
                priorityQueue.poll();

//                System.out.println("큐에서 제거후");
//                System.out.println("queue"+queue);
//                System.out.println("priorityQueue"+priorityQueue);
                if(indexAndValue.index==location){
                    return order;
                }
                order++;
            }
            else{
//                System.out.println("queue"+queue);
//                System.out.println("priorityQueue"+priorityQueue);

                queue.add(indexAndValue);

//                System.out.println("다시 큐에 추가 ");
//                System.out.println("queue"+queue);
//                System.out.println("priorityQueue"+priorityQueue);
            }

//            order++;<<<<<<<<<<<세번쨰 여기있으면 안되고

        }
        //자료구조를 리스트랑 큐 두개로 하지않고 하는방법없나
//        한바퀴돌면서 넣고뺴면 되나, 시작지점의 index랑 value이면 멈추도록 하면 되나 ?
  //그러면 최댓값찾기에는 적절하지않으니깐, 다른 자료구조를 찾압좌야하나
  //아니면 큐를 두개를 만들어서, 하나는 입출력 큐, 하나는 최댓값을 제어하는 큐로 만들기 ? <<그래서 민, 맥스 힙쓴다는건가
  //자료구조 사용방법
  //겨ㅛㄹ국 두가지 자료구조 사용해야하ㅓ는건가 <큐랑 맥스힙 ?


        //return 0;
        return order;
    }


}
class IndexAndValue implements Comparable<IndexAndValue>{
    int index;
    int value;
    public  IndexAndValue(int index,int value){
        this.index=index;
        this.value=value;
    }

    @Override
    public int compareTo(IndexAndValue other) {
        return this.value-other.value;
    }

    @Override
    public String toString() {
        return String.format("(index:%d, value: %d)", index,value);
    }
}

