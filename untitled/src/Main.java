import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 테스트 케이스 1
        int[] numbers1 = {2, 3, 3, 5};
        int[] result1 = solution(numbers1);
        System.out.println("테스트 케이스 1 결과: " + Arrays.toString(result1)); // 예상 출력: [3, 5, 5, -1]

        // 테스트 케이스 2
        int[] numbers2 = {9, 1, 5, 3, 6, 2};
        int[] result2 = solution(numbers2);
        System.out.println("테스트 케이스 2 결과: " + Arrays.toString(result2)); // 예상 출력: [-1, 5, 6, 6, -1, -1]
    }

    public static int[] solution(int[] numbers) {
        int[] arr=new int[numbers.length];
        ArrayDeque<IndexAndValue> stack=new ArrayDeque<>();
        //스택을 쓰더라도 이중반복문 형태 아닌가, 왜 스택이; 의미가 있다는거지

        //느낌이 43149에서 숫자 n개 지워서 젤 큰수만들기랑 비슷한거 같은데 <<<<
        //이 느낌 뭔가 예전에도 느꼇엇던이 느낌이 삘이 중요한가 , 무슨 느낌이엇더라 이런가ㅏ

        for (int i = 0; i <numbers.length ; i++) {
            int n=numbers[i];
            /// w지금 당장 넣는 얘라면 i로 인덱스알수있지만 이미 스택에 있던 얘면 인덱스 정보 알아올 방법이 있나,
            IndexAndValue newElement=new IndexAndValue(i,n);
            if(stack.isEmpty()){
                stack.push(newElement);
            }
            else{
                //주인공이 누구인지 생각해보면
                //인덱스 정보도 알아야할것같은데,< 새로운 클래스 안만들고 할수있는 방법있나

                //계속 pop시켜야하잖아 반복문 돌리나
//                IndexAndValue insideStack=stack.peek();
                while(!stack.isEmpty()&& stack.peek().value<newElement.value){
                    IndexAndValue insideStack=stack.pop();
                    arr[insideStack.index]=newElement.value;

                }
                stack.push(newElement);
                //isEmpty체크는 ?
            }

        }
//        if(!stack.isEmpty()){
//            while ()
//        }
//        else{
//            return arr;
//        } <<<<<굳이 분기점 만들필요없이 while이 조건문 역할도 한다는점으로 봣을떄 ?

        while(!stack.isEmpty()){
            IndexAndValue indexAndValue=stack.pop();
            arr[indexAndValue.index]=-1;
        }
        return arr;



    }
}

class IndexAndValue{
    int index;
    int value;
    public IndexAndValue(int index,int value){
        this.index=index;
        this.value=value;
    }
}