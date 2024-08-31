package Softter_LEVEL3_효도여행;

import java.io.*;
import java.util.*;

public class Main {

    //정점의 개수
    static int N;
    //아버지가 선호하는 문자열과 그 길이;
    static int M;
    static String S;
    //인접리스트 사용
    static List<ArrayList<Integer>> adjList; 
    
    //도로이름을 저장하는 인접행렬 사용
    static String[][] adjMatrix;
    
    //BFS할 때 방문확인용
    static boolean[] visited;

    //각 노드들의 route를 저장할 배열
    static String[] routes;
    
    //LCS용
//    static int[] LCS;
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        //문자열 입력
        S = br.readLine();
        //인접행렬 초기화
        adjMatrix = new String[N+1][N+1];
        //인접리스트 초기화
        adjList = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        //각 노드들의 route를 저장할 배열
        routes = new String[N+1];
        //루트의 route는 없으므로 
        routes[1] = "";
        
        visited = new boolean[N+1];
//        LCS = new int[N+1];
        //LCS구하기용
        int max = 0;
       
        
        //입력
        for (int i = 1; i < N; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            String road = input[2];
            
            ArrayList<Integer> tmp_x = adjList.get(x);
            tmp_x.add(y);
            ArrayList<Integer> tmp_y = adjList.get(y);
            tmp_y.add(x);
                
            adjMatrix[x][y] = road;
            adjMatrix[y][x] = road;
        }

        //BFS를 활용, 루트인 1에서 출발
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> tmp = adjList.get(1);
        visited[1] = true;

        for (int i = 0; i < tmp.size(); i++) {
            //자식을 불러온다, 저장된 길을 불러온다
            int y = tmp.get(i);
            String road = adjMatrix[1][y];
            //루트를 갱신하고 큐에 새로 넣는다
            routes[y] = routes[1] + road;
            q.add(y);
        }
        
        
        
        //BFS
        while (!q.isEmpty()) {
            //꺼내서 위 과정을 반복
            int x = q.poll();
            //꺼낼때 방문처리
            visited[x] = true;
            //재할당
            tmp = adjList.get(x);
            
            //리프노드라면(1을 제외하면 연결된 노드가 단 하나) LCS 적용
            if (tmp.size() == 1) {
            	String T = routes[x];
            	int s = S.length();
            	int t = T.length();
            	
            	int[][] dp = new int[t+1][s+1];

            	
            	for (int i = 1; i <= t; i++) {
            		//i번째 문자를 가져온다
//            		String sub_T = T.substring(i-1, i);
            		char sub_T = T.charAt(i-1);
            		for (int j = 1; j <= s; j++) {
            			char sub_S = S.charAt(j-1);
            			//같다면 연속된 문자이므로 대각선 위에서 +1
            			if (sub_T == sub_S) {
            				dp[i][j] = dp[i-1][j-1] + 1;
            			//다르다면 왼쪽이나 위에 것 중에 큰거 가져오면됨
            			} else {
            				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            			}
            			
            		}       		
            	}
            	
            	//최댓값 갱신
            	if (max < dp[t][s]) {
            		max = dp[t][s];
            	};
            	
                
            } else {
                //리프노드가 아니라면 큐에 넣는과정을 반복
                for (int i = 0; i < tmp.size(); i++) {
                    //자식을 불러온다, 저장된 길을 불러온다
                    int y = tmp.get(i);
                    //이미 방문한 노드는 스킵(거꾸로 올라가는거 방지)
                    if (visited[y]) {
                    	continue;
                    }
                    
                    String road = adjMatrix[x][y];
        
                    //루트를 갱신하고 큐에 새로 넣는다
                    routes[y] = routes[x] + road;
                    q.add(y);
                }
            }
            
        }
        
        System.out.println(max);
        
    }
    
    
}
