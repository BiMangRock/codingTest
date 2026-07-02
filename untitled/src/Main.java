import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 테스트용 격자판 (3 x 4 크기)
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        // 테스트 케이스 1: 존재하는 단어
        String word1 = "ABCCED";
        System.out.println("테스트 케이스 1 결과: " + solution(board, word1));
        // 예상 출력: true (A -> B -> C -> C -> E -> D 순으로 연결 가능)

//        // 테스트 케이스 2: 존재하는 단어
//        String word2 = "SEE";
//        System.out.println("테스트 케이스 2 결과: " + solution(board, word2));
//        // 예상 출력: true
//
//        // 테스트 케이스 3: 격자판에 알파벳은 다 있지만, 동일한 칸을 중복해서 써야만 하는 경우
//        String word3 = "ABCB";
//        System.out.println("테스트 케이스 3 결과: " + solution(board, word3));
//        // 예상 출력: false ('B'를 두 번 사용해야 하는데, 이미 방문한 'B'는 재사용 불가)
    }

    public static boolean solution(char[][] board, String word) {
        //String 으로 할필요없이 char 리스트로 해도되나 ?
        boolean[][] visited=new boolean[board.length][board[0].length];
        List<Character> list=new ArrayList<>();
//        int[] canGoX={1,-1,0,0};
//        int[] canGoY={0,0,1,-1};
        //이건 굳이 매개변수로 넘겨주지말고 ?

        return f(list,board,visited,0,0,word);
    }
    private static boolean f(List<Character> list,char[][] board,boolean[][] visited,int nowRowIndex,int nowColIndex,String s){

        int[] canGoRow={1,-1,0,0};
        int[] canGoCol={0,0,1,-1};

        //어차피 true면 자식으로 내려가지않았을테닊나 분기점을 앞부분에 설정할필요는 없을것같고 for문이 있는 부분에서 f호출한것을 true인지 f인지 보고 true이면 뭘하기 ???

//        if(nowRowIndex<0 || nowRowIndex>visited.length-1 || nowColIndex<0 || nowColIndex>visited[0].length-1){
//            return false;
//        } <<<이게 반복문 안에 있어야하나, 배열에 참조하기 직전에 ???


        if(list.size()>=s.length()){
            String myAnswer="";
            for (int i = 0; i <list.size() ; i++) {
                Character c=list.get(i);
                myAnswer+=(c+""); //아스키 코드가 40 <숫자로 바뀌나 ? 처음부터 String으로 저장해야하나
            }

            if(myAnswer.equals(s)){
                return true; //이 리턴 true 를 어케 이용할수있을까
            }
            else{
                return false;
            }
        }
        /// ////////////////

        for (int i = 0; i < canGoCol.length; i++) {
            for (int j = 0; j < canGoRow.length; j++) {

                int row=nowRowIndex+canGoRow[i];
                int col=nowColIndex+canGoCol[i];
                //if(visited[row][col]==false || row<0 || row>visited.length-1 || col<0 || col>visited[0].length-1 |순서중요하네
                if(row<0 || row>visited.length-1 || col<0 || col>visited[0].length-1 || visited[row][col]==true || list.size() >= s.length()){
                    continue;
                }
                //조건 'row<0'은(는) 항상 'false'입니다. <<왜지

                char nowC=board[row][col];
                System.out.println("현재의 char: "+nowC+"    현재의 list: "+list);

                list.add(nowC);
                visited[row][col]=true;

                if(f(list,board,visited,row,col,s)){
                    return true;
                }

                visited[row][col]=false;
                list.remove(list.size()-1);
            }
        }


        return false;


    }

}












