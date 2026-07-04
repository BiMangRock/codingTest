import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();

        // 예시 1
        int[][] arr1 = {
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}
        };
        System.out.println("예시 1 결과: "+sol.solution(arr1));

        // 예시 2
        int[][] arr2 = {
                {1, 0, 1},
                {1, 0, 1},
                {1, 0, 1}
        };

        System.out.println("예시 2 결과: " + sol.solution(arr2));

        // 예시 3
        int[][] arr3 = {
                {1, 1},
                {1, 1}
        };

        //왜되냐 ??
        System.out.println("예시 3 결과: " + sol.solution(arr3));
    }

    public int solution(int[][] arr) {
        int r=arr.length;
        int c=arr[0].length;
        boolean[][] visited=new boolean[r][c];//근데 이 visited배열은, 이게 루프끝나면 다시 false로 바뀌지 않던가
        //기존 배열인 arr에서 석유있는부분을 0으로 수정해야하나

        //시작점은 어케 해야하지 ??
//        int startR=0;
//        int startC=0;

        int sum=0;
        //근데 이러면 모든 격자판을 다 살피는 꼴이 되잖아
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(arr[i][j]==0){
                    continue;
                }
                else{
                    f(i,j,visited,arr);
                    sum++;
                }
            }
        }
        return sum;
    }
    //중첩되서 안세아리게 하려면 어케 해야하지
    //각 열마다 dfs를 할필요는없이, 이미 발견한 석유는 뭔가 라벨을 따로 붙여서 관리하면 되지않나


    //boolean return하지 않도록 해도되나
    private void f(int r,int c,boolean[][] visited, int[][] arr){
        int[] moveR={0,0,-1,1};
        int[] moveC={-1,1,0,0};
        int R=arr.length-1;
        int C=arr[0].length-1;
        for(int i=0; i<moveC.length; i++){
            int newR=moveR[i]+r;
            int newC=moveC[i]+c;
            if(newR<0 || newR>R || newC<0 || newC>C){
                continue;
            }
            if(!visited[newR][newC] && arr[newR][newC]==1){
                //근데 그러면 뭐 연결되어있으면 처리는 어케 하지
                visited[newR][newC]=true;
                f(newR,newC,visited,arr);
                arr[newR][newC]=0;
                visited[newR][newC]=false;
            }
        }

        //그래서 크기 더해주는건 어케 함



    }

//    private boolean isValid(int r,int c,int limitR,int limitC){
//
//    }

}


//이 땅속에 존재하는 석유 덩어리의 총 개수를 구하는 프로그램을 작성하세요.























