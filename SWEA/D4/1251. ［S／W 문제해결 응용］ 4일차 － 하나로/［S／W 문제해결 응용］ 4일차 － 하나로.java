import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
	
	//섬들의 좌표를 담을 배열
	static int[][] islands;
	
	//각 섬들의 부모를 담을 배열
	static int[] p;
	
	//간선정보를 담을 배열
	static double[][] edges;
	
	//환경부담세율
	static double E;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테스트케이스 개수 입력
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			//섬의 개수
			int N = sc.nextInt();
			
			//0번 : x좌표, 1번 : y좌표, 2번: 환경세율
			islands = new int[N+1][2];
			
			
			//섬의 x좌표를 담기
			for (int i = 1; i <= N; i++) {
				islands[i][0] = sc.nextInt();
			}
			
			//섬의 y좌표를 담기
			for (int i = 1; i <= N; i++) {
				islands[i][1] = sc.nextInt();
			}
			
			//환경세율 입력
			E = sc.nextDouble();
			
			//간선배열을 이용하여
			//간선 정보입력
			//총 간선의 개수는 N*(N-1)/2
			//시작점 x1, y1 끝점 x2, y2 이렇게 4개 입력하고 환경 세율까지 5개
			edges = new double[(N*(N-1)/2)][7];
			int idx = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = i+1; j <= N; j++) {
					double x1 = 1.0*islands[i][0];
					double y1 = 1.0*islands[i][1];
					double x2 = 1.0*islands[j][0];
					double y2 = 1.0*islands[j][1];
					
					edges[idx][0] = x1;
					edges[idx][1] = y1;
					edges[idx][2] = x2;
					edges[idx][3] = y2;
					//메서드로 4번엔 환경부담비를 넣는다.
					cost(edges[idx]);
					//5번과 6번엔 간선 정보(몇번째 섬과 몇번째 섬을 연결하였는가?)를 저장한다
					edges[idx][5] = i; 
					edges[idx][6] = j; 
					idx++;

				}
			}
			
//			System.out.println("==========정렬전=========");
//			for (double[] i : edges) {
//				System.out.println(i);
//			}
			
			//선형 자료구조에만 적용가능하다?
			Arrays.sort(edges, new Comparator<double[]>(){

				@Override
				public int compare(double[] o1, double[] o2) {
					return (int)(Math.signum((o1[4]-o2[4])));
				}
				//환경부담비 오름차순으로 정렬

				
			});
			
//			System.out.println("==========정렬후=========");
//			for (double[] i : edges) {
//				System.out.println(i);
//			}
			
			//모든 정보를 입력했으니 크루스칼 알고리즘 사용
			p = new int[N+1];
			
			//makeSet
			for (int i = 1; i <= N; i++) {
				p[i] = i;
			}
			
			//최소환경부담비
			double min = 0;
			int pick = 0; //N-1개의 간선을 선택하면된다.
			idx = 0;
			while (pick < (N-1) && idx < N*(N-1)/2) {
				//
				int x = (int) (edges[idx][5]);
				int y = (int) (edges[idx][6]);
				
				int px = findSet(x);
				int py = findSet(y);
				
				//사이클이 생긴게 아니라면
				if (px != py) {
					union(px, py);
					min += edges[idx][4];
					pick++;
					
				}
				
				idx++;

			}
			
			long roundMin = (long) (Math.round(min));
			
			System.out.printf("#%d %d\n", tc, roundMin);
			
			
		}

	}
	static int findSet(int x) {
		if (x != p[x]) {
			p[x] = findSet(p[x]);
		}
		
		return p[x];
	}
	
	static void union(int px, int py) {
		//y의 대표자를 x의 대표자로 변경
		p[py] = findSet(px);
	}
	
	
	//환경부담비 계산 메서드
	static void cost(double[] edge) {
		
		double L = dist(edge[0], edge[1], edge[2],edge[3]);
		double cost = E*L*L;
		edge[4] = cost;
	}
	
	//두 섬 사이에 거리 구하기 메서드
	static double dist(double x1, double y1, double x2, double y2) {
		//피타고라스 정리, 1.0을 곱해주어 double로 변환
		return Math.sqrt(1.0*((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)));
	}

}
