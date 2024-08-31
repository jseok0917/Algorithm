package Softeer_LEVEL3_함께하는효도;

import java.io.*;
import java.util.*;

public class Main {

    //땅의 크기
    static int n;
    //인원 수
    static int m;
    //열매수확량
    static int[][] map;
    //각 인원의 위치정보
    static int[][] position;
    //최대 이동횟수
    static final int t = 3;
    
    
    //델타탐색 - 상하좌우순
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][n];
        visited = new boolean[n][n];
        //k번째 친구의 0번째 항은 x좌표, 1번째 항은 y좌표
        //map의 좌표에 맞도록 1씩 빼주어서 입력
        position = new int[m][2];

        //map 입력값 할당
        for (int i = 0; i < n; i++){
            input = br.readLine().split(" ");

            for (int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
            
        }

        //각 친구의 위치정보
        for (int i = 0; i < m; i++){
            input = br.readLine().split(" ");
            //x좌표 할당
            position[i][0] = Integer.parseInt(input[0]) - 1;
            //y좌표 할당
            position[i][1] = Integer.parseInt(input[1]) - 1;
        }

        // //확인용
        // for (int[] arr : position) {
        //     System.out.print(arr[0] + " " + arr[1]);
        //     System.out.println("");
        // }

        //첫 수확량은 모두 더해준 상태로 출발
        int sum = 0;
        
        for (int i = 0; i < m; i++){
            int x = position[i][0];
            int y = position[i][1];
            sum += map[x][y]; 
            visited[x][y] = true;
        }

        findMax(position, 0, 0, sum, visited);
        
        System.out.println(max);
     
    }

    //최대수확량
    static int max = 0;
    static boolean[][] visited;

    public static void findMax (int[][] position, int friend ,int time, int harvested, boolean[][] visited) {
        //한 명의 친구가 3초동안 탐색했다면
        if (time == t) {

            //아직 이동시킨 친구의 숫자가 m명이 되지 않았다면
            if (friend < m-1) {
                findMax (position, friend + 1, 0, harvested, visited);

            } else {
                if (max <= harvested) {
                    max = harvested;
                }
            }
            return;
        } else {
            //수확하고 이동시키고 수확하고 이동시키고
            //각 친구들이 자기 자리에서 수확한다
            //각 친구들을 이동시킨다
            //일단 각 친구들의 방문이력은 고려하면 리소스 줄일 수 있음(메모리는 좀 더 쓰지만)
            //그래도 주어진 시간내에 연산하기엔 충분 (최대 64 * 64 * 64)
            for (int i = 0; i < 4; i++) {
                int x = position[friend][0];
                int y = position[friend][1];

                //방문하지 않았다면 수확하고 방문처리
                // if (visited[x][y] != true) {
                //     harvested += map[x][y];
                //     visited[x][y] = true;
                // } 

                //수확 후 다음에 이동시킬 곳 생각
                int nx = position[friend][0] + dr[i];
                int ny = position[friend][1] + dc[i];

                //가독성을 위해 따로 처리
                //맵밖을 벗어나면 continue 
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                } else {
                    position[friend][0] = nx;
                    position[friend][1] = ny;

                    boolean isVisited = visited[nx][ny];

                    if (isVisited != true) {
                        harvested += map[nx][ny];
                        visited[nx][ny] = true;
                    } 

                    findMax(position, friend, time+1, harvested, visited);
                    //돌아온 후엔 다시 제자리로 만들어야함
                    position[friend][0] = x;
                    position[friend][1] = y;

                    if (isVisited != true) {
                        harvested -= map[nx][ny];
                        visited[nx][ny] = false;
                    }
                    
                }
                
                
            }


            
        }
        
        
        
    }

    


    
}
