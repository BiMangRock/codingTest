import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {

        HashMap<String,Integer> h=new HashMap<>();
        //자동으로 0으로 초기화되던가 ? a
        for(int i=0; i<participant.length; i++){
            if(!h.containsKey(participant[i])){
                h.put(participant[i],1);
            }
            else{
//                h.put( participant[i],h.get(participant[i])+1);
//                h[   participant[i]  ]=h.get(participant[i])+1; //왜안되지
                h.put(participant[i],h.get(participant[i]+1));
                //h.get()할떄 에러가 나는건가 키가 없으면 ?
            }


        }

        for(int i=0; i<completion.length; i++){
            if(!h.containsKey(completion[i])){
                return completion[i];
            }
            else{
//                h[completion[i]]=h.get(completion[i])-1;
            //이건 파이썬식 문법이고 걍 있으면 put하면 되나 ?
                h.put(completion[i],h.get(completion[i]) -1 );
            }
        }
        //키돌면서 <<어케 순회하지
        // 0이하인녀석이 정답

        for(String s: h.keySet()){
            if(h.get(s)<=0){
                return s;
            }
        }
    }
}































