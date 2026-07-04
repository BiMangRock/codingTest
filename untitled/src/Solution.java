import java.util.ArrayList;
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

        ArrayList<Integer> integerArrayList=new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(visited[i][j] || arr[i][j]==0){
                    if(visited[i][j] ){
                        System.out.println(String.format("새로운 후보의 좌표:(%d,%d)는 visited임", i,j));
                    }
                    else{
                        System.out.println(String.format("새로운 후보의 좌표:(%d,%d)는 석유없음(0)임", i,j));
                    }
                    continue;
                }
                else{
//                    System.out.println("===============");
                    System.out.println(String.format("################현재의 좌표:(%d,%d)#################", i,j));

                    visited[i][j]=true; //<<<<<<<<<<<<<<<<<<


                    int num=f(i,j,visited,arr);
                    integerArrayList.add(num);
                    //석유의 갯수말고 크기를 확인하려고 하면, <사실 이건 너무 쉽지 크기만 리턴하라고 하면 걍 이중 for문쓰면 되니깐,
//                    그러니까 석유의 분야별 이름 라벨링이랑, 크기를 하던지 원본 수정해서, 라벨링 시키기 ?
                    //
//                    System.out.println("===============");
                    sum++;
                }


            }
        }
        System.out.println("석유의 크기들"+integerArrayList);
        return sum;

    }




    private int f(int r,int c,boolean[][] visited, int[][] arr){
        System.out.println(String.format("현재의 좌표:(%d,%d)", r,c));
        int[] moveR={0,0,-1,1};
        int[] moveC={1,-1,0,0};
        int limitR=arr.length-1;
        int limitC=arr[0].length-1;
        if(r==1 && c==5){
//            System.out.println("#####(1,5)지점########");
        }
//        int z=0;
        int sum=1;
        for (int i = 0; i <moveC.length ; i++) {
            int newR=moveR[i]+r;
            int newC=moveC[i]+c;
//            z++;
            System.out.println(String.format("(%d,%d)로 이동",moveR[i],moveC[i] ));
//            System.out.println(String.format("현재의 좌표:(%d,%d)",newR,newC ));

            if(newR<0 || newR>limitR || newC<0 || newC>limitC){

                continue;
            }

            //원본 수정하지않는방식이라도 1인지 확인은 해야하는거겟지 >
            if(!visited[newR][newC] && arr[newR][newC]==1){
                printArr(visited);
                visited[newR][newC]=true;
                sum+=f(newR,newC,visited,arr);
//                return 1+f(newR,newC,visited,arr); //여기서 무조건 리턴을 해버리니깐, 4가지 방향으로 못가는거였네,

            }





//            else{
//                if(r==1 && c==5){
////                    System.out.println("@@@@(1,5)지점@@@@");
//                    if(visited[newR][newC]){
////                        System.out.println(z);
////                        System.out.println(String.format("새로운 후보인(%d,%d)는 visited임", newR,newC));
//                    }
//                    else if(arr[newR][newC]==0){
////                        System.out.println(z);
////                        System.out.println(String.format("새로운 후보인(%d,%d)는 석유없음(0)임", newR,newC));
//                    }
//                }
//            }


        }

        System.out.println(String.format("현재의 좌표:(%d,%d)", r,c)+"사방둘러봐도 석유없음");
        //일단 자기자신은 석유인거잖아, 이 재귀함수로 왔다는건
        //이까지 내려왔다면 뭐지 ? ??
        //4방향 가봣는데 아무것도 없다는건가 뭐지 <아마? 만약 한군대라도 있엇더라면 그전에 return되서 나왔겟지 ?
        return sum;


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
























