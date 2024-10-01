package BOJ_1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class Main0 {
	static class Node implements Comparable<Node> {
		int v, w; //끝점, 가중치
		
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
		//내림차순
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}

		
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int N, M;
	
	//인접리스트를 사용한다.
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]); //마을의 수
		M = Integer.parseInt(input[1]); //도로의 수
		int X = Integer.parseInt(input[2]); //목표마을
		
		//ArrayList라는 객체의 배열
		List<Node>[] adjList = new ArrayList[N+1]; //1번마을부터 시작 //주어진 정점과 연결된 간선들을 모으고, 정점이 여러개이므로 그 배열
		for (int i = 1; i < N+1; i++) {
			adjList[i] = new ArrayList<Node>();
		} //초기화&생성 시켜놓고 시작
		
		List<Node>[] trspList = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			trspList[i] = new ArrayList<Node>();
		} //초기화&생성 시켜놓고 시작
		
		
		for (int i = 0; i < M; i++) {
			String[] inputRoad = br.readLine().split(" ");
			int A = Integer.parseInt(inputRoad[0]); //시작마을
			int B = Integer.parseInt(inputRoad[1]); //도착마을
			int T = Integer.parseInt(inputRoad[2]); //소요시간(가중치)
			
			//A마을에 도로를 추가한다
			
			adjList[A].add(new Node(B, T));
			trspList[B].add(new Node(A, T));
		} //도로입력까지 완료
		
		int[] dist = new int[N+1]; //최단거리를 저장할 배열
		int[] dist2 = new int[N+1];
		Arrays.fill(dist, INF); // 무한대로 채워놓고
		Arrays.fill(dist2, INF);
		
		dijkstra(X, adjList, dist);
//		System.out.println(Arrays.toString(dist));
		
		dijkstra(X, trspList, dist2);
//		System.out.println(Arrays.toString(dist2));
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			
			if (dist[i]+dist2[i] > max) {
				max = dist[i]+dist2[i];
			}
			
		}
		System.out.println(max);
		
		
		
	}
	
	
	
	//시작점으로부터 각 정점까지의 최단 경로를 구한다.
	static void dijkstra(int start, List<Node>[] adjList, int[] dist) {
		boolean[] visited = new boolean[N+1];
		
		dist[start] = 0;
		//매번 소요시간이 가장 작은 정점을 뽑으면서 모든 정점을 돌건데
		//마지막 건 안돌아도 문제가 없으므로
		for (int i = 1; i <= N-1; i++) {
			int min = INF;
			int idx = 0;
			for (int j = 1; j <= N; j++) {
				if (!visited[j] && min > dist[j]) {
					min = dist[j];
					idx = j;
				}		
			}
			
			if (idx == 0) {
				break;
			}
			
			visited[idx] = true; //거리가 가장 작은 놈을 선택하고 //일단 첫단계에선 0이 선택된다
			//현재 min=dist[j]이고 이건 시작점에서 j번째 까지의 최단거리를 의미하고있음.
			//다음 단계 : 연결된 놈들을 다 돌아보면서 dist 배열을 갱신한다.
			for (int j = 0; j < adjList[idx].size(); j++) {
				Node node = adjList[idx].get(j);
				//방문을 안했고,
				//가려고하는 정점 v에 저장된 최단경로의 길이보다
				//현재선택된 지점까지의 경로의 길이+가는데 걸리는 가중치가 작으면 갱신
				if (!visited[node.v] && dist[node.v] > min+node.w) {
					dist[node.v] = min+node.w;
				}
				
			}
			
			
			
			
		}
		
		
		
	}
	

}
