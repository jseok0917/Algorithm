import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static class Node {
		int v, w;
		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
		
	}
	
	static List<Node>[] adjList;
	static int[] dist;
	static boolean[] visited;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테스트케이스 입력
		int T = 10;
		
		for (int tc = 1; tc <= T; tc++) {
			//데이터의 길이
			int L = sc.nextInt();
			
			//시작 번호
			int start = sc.nextInt();
			
			adjList = new ArrayList[101];
			for (int i = 0; i < 101; i++) {
				adjList[i] = new ArrayList<Node>();
			}
			
			for (int i = 0; i < L; i += 2) {
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				adjList[A].add(new Node(B, 1));
			}
			
			dist = new int[101];
			visited = new boolean[101];
			
			for (int i = 0; i < 101; i++) {
				dist[i] = INF;
			}
			
			dist[start] = 0;
			
			for (int i = 1; i < 100; i++) {
				
				int min = INF;
				int idx = -1;
				
				//방문한 거 제외하고서 최솟값 찾기
				
				for (int j = 1; j < 101; j++) {
					if (!visited[j] && dist[j] < min) {
						min = dist[j];
						idx = j;
					}
				}
				
				//연결된 그래프가 아닐 수도 있어서
				if (idx == -1) {
					break;
				}
				
				//찾은 것을 방문처리
				visited[idx] = true;
				//찾은 것과 연결된 것들 중 갱신
				
				List<Node> tempList = adjList[idx];
				for (Node j : tempList) {
//					System.out.print("현재 선택된 정점과 연결된 노드들의 번호 : "+j.v+" ");
//					System.out.println();
//					System.out.print(dist[j.v]+" ");
//					System.out.print(min+" ");
//					System.out.print(dist[j.w]);
//					System.out.println();
					if (!visited[j.v] && dist[j.v] > min+j.w) {
						dist[j.v] = min+j.w;
					}
				}

				
			}
//			System.out.println();
//			System.out.println(Arrays.toString(dist));
//			System.out.println(1);
			int max = 0;
			int idx = -1;
			for (int i = 1; i < 101; i++) {
				if (dist[i] != INF && dist[i] >= max) {
					max = dist[i];
					idx = i;
				}
			}
			System.out.printf("#%d %d\n",tc,idx);
			

			
			
		}

	}

}
