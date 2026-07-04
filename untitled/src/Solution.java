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

//        // 예시 2
//        int[][] arr2 = {
//                {1, 0, 1},
//                {1, 0, 1},
//                {1, 0, 1}
//        };
//
//        System.out.println("예시 2 결과: " + sol.solution(arr2));
//
//        // 예시 3
//        int[][] arr3 = {
//                {1, 1},
//                {1, 1}
//        };
//
//        //왜되냐 ??
//        System.out.println("예시 3 결과: " + sol.solution(arr3));
    }

    public int solution(int[][] arr) {
        //visited만 쓰는 버전 ㅁ
        int r=arr.length;
        int c=arr[0].length;

        boolean[][] visited=new boolean[r][c];
        int sum=0;

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(visited[i][j] || arr[i][j]==0){
                    continue;
                }
                else{
                    System.out.println("===============");
                    System.out.println(String.format("현재의 좌표:(%d,%d)", i,j));
                    printArr(visited);

                    f(i,j,visited,arr);
                    System.out.println("===============");
                    sum++;
                }


            }
        }
        return sum;

    }




    private void f(int r,int c,boolean[][] visited, int[][] arr){

        int[] moveR={0,0,-1,1};
        int[] moveC={1,-1,0,0};
        int limitR=arr.length-1;
        int limitC=arr[0].length-1;

        for (int i = 0; i <moveC.length ; i++) {
            int newR=moveR[i]+r;
            int newC=moveC[i]+c;

//            System.out.println(String.format("현재의 좌표:(%d,%d)",newR,newC ));

            if(newR<0 || newR>limitR || newC<0 || newC>limitC){
                continue;
            }
            //원본 수정하지않는방식이라도 1인지 확인은 해야하는거겟지 >
            if(!visited[newR][newC] && arr[newR][newC]==1){
                System.out.println(String.format("현재의 좌표:(%d,%d)는 방문되지않았고, 석유가 있으니깐 재귀로 들어감",newR,newC ));
                printArr(visited);
                visited[newR][newC]=true;

                f(newR,newC,visited,arr);
            }
        }


    }
    private void printArr(boolean[][] arr){
        System.out.println("현재의 visited 상태(O는 방문함):");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                if(arr[i][j]){
                    System.out.print("0 ");
                }
                else{
                    System.out.print("x ");
                }
//                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }



}
























