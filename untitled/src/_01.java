import java.util.ArrayDeque;

public class _01 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.solution("1924"));

    }
}

class Solution {
    public int solution(String number) {

        //1924
        ArrayDeque<Integer> queue=new ArrayDeque<>();
        int num=Integer.valueOf(number);
        int exp=1;
        while(num/exp>0){
            //1234 /1000 >>1
            exp*=10;
        }
        exp=exp/10; //<<??

        while (exp>0){

            int n=(num/exp)%10;
            //1234 /1000 >1
            //num은 안바뀌잖아
            //1000 100 10 1 0
            queue.add(n);
            exp=exp/10;
        }


        ArrayDeque<Integer> copyedQueue=new ArrayDeque<>();
        while (!queue.isEmpty()){
            int w= queue.removeFirst();
            int w2= queue.peekFirst();
            //null은 어케 ?
            if(w<w2){

            }
            else{
                copyedQueue.add(w);
            }
        }
        String s="";
        while(!copyedQueue.isEmpty()){
            int t=copyedQueue.removeFirst();
            s+=(String.valueOf(t));
        }


        return Integer.valueOf(s);



    }
}