import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //테스트 케이스 숫자
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            //지역의 크기
            N = sc.nextInt();
            max = -1;
             
 
            //위치번호매기기
            numbering = new int[N+2][N+2];
            int idx = 1;
            //디저트 카페 위치 및 정보 입력
            //가장 먼저 시작하는 놈을 1번째 마지막 놈을 N*N index로 생각할  수 있다.
             
            area = new int[N+2][N+2]; //델타 탐색 시 인덱스범위 오류 안나게하려고
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    area[i][j] = sc.nextInt();
                    numbering[i][j] = idx;
                }
            }
                 
            for (int m = 1; m <= N; m++) {
                for (int n = 1; n <= N; n++) {
                    A = m;
                    B = n;
                    boolean[][] visited = new boolean[N+2][N+2];
                    boolean[] sorts = new boolean[101];
                    //방문하면 true
                    visited[m][n] = true;
                    sorts[area[m][n]] = true;
                    int cnt = 1;
                    DFS(m+dr[0], n+dc[0], sorts, visited, 0, cnt);
  
                }
            }
             
 
            System.out.printf("#%d %d\n", tc, max);
             
             
     
        }
 
    }
     
    //대각선 4방향 시계방향 탐색 구현
    static int[] dr = {1, 1, -1, -1};
    static int[] dc = {1, -1, -1, 1};
    
    //대각선 4방향 반시계방향 탐색 구현
    static int[] dr2 = {1, 1,-1, -1};
    static int[] dc2 = {-1, 1, 1, -1};
    static int[][] numbering;
    static int N;
     
    static int[][] area;
    //카운트
    static int cnt;
     
    static int max;
    //출발점
    static int A;
    static int B;
     
    //DFS구현
    //출발점, 방문리스트, 방향변화카운트, 방향전환을 알기위해 필요한 델타탐색변수
    public static void DFS(int m, int n, boolean[] sorts, boolean[][] visited , int k, int cnt) {
        //범위밖을 벗어나면 재귀종료
        if (m <= 0 || m > N || n <= 0 || n > N || k == 4) { 
            return;
        }
        
        //출발점으로 돌아왔다면
        if (k == 3 && m == A && n == B) {
        	if (cnt > max) {
        		max = cnt;
        	}
        }
        
        
        //방문한건 걸러야한다
        if (visited[m][n] == true || sorts[area[m][n]] == true) {
        	return;
        }
        
        //위 조건에 문제가 없었다면 방문처리
        visited[m][n] = true;
        sorts[area[m][n]] = true;
  
        //델타탐색으로 DFS
        for (int i = k; i <= k+1; i++) {
        	if (i == 4) {
        		return;
        	}
        	
        	boolean[][] tempVisited = new boolean[N+2][N+2];
        	boolean[] tempSorts = new boolean[101];
        	
        	for (int j = 1; j <= N; j++) {
        		tempVisited[j] = visited[j].clone();
        	}
        	
        	
        	tempSorts = sorts.clone();
        	
        	DFS(m+dr[i], n+dc[i], tempSorts, tempVisited, i, cnt+1);
            
        }

    }
    

     
 
}