package 기지국;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테스트케이스 개수
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			//최댓값 초기화
			max = Long.MIN_VALUE;
			
			//너비와 높이 입력
			W = sc.nextInt();
			H = sc.nextInt();
			
			//사용자 수를 넣는다
			users = new int[H*W+1];
			for (int i = 1; i <= H*W; i++) {
				users[i] = sc.nextInt();
			}
			
			
			
			relation = new int[H+2][W+2];
			//연결관계 메서드 구현을 위하여
			int cnt = 1;
			for (int i = 1; i <= H; i++) {
				for (int j = 1; j <= W; j++) {
					relation[i][j] = cnt++;
				}
			}
			
			//각 점이 위로 올라가있는지 아래로 내려가있는지 판별할 dcrm 초기화 및 생성
			dcrm = new boolean[H+2][W+2];
			for (int i = 1; i <= H; i++) {
				//첫번째 점은 무조건 위로 올라가 있다. 올라가 있는 점을 true로 나타내자
				//(0번째점은 false로 초기화돼있으므로)
				//그다음 나오는 점들은 모두 번갈아가면서 나오게 돼있으므로
				for (int j = 1; j <= W; j++) {
					dcrm[i][j] = !(dcrm[i][j-1]);
				}
			}
			
			//연결관계를 넣을 그래프 생성
			graph = new HashMap<>();
			for (int i = 1; i <= W*H; i++) {
				graph.put(i, new ArrayList<Integer>());
			}
			
			//연결관계를 넣는다.
			getGraph();
			
			for (int i = 1; i <= W*H; i++) {
				ArrayList<Integer> list = new ArrayList<>();
				ArrayList<Integer> visited = new ArrayList<Integer>();
				//기지국은 반드시 4개만 건설하므로
				maxBenefit(i, list, visited, 4);
			}
			
			int max2 = 0;
			for (int i = 1; i <= H; i++) {
				for (int j = 1; j <= W; j++) {
					if (dcrm[i][j] == true) {
						int sum2 = 0;
						for (int k = 0; k < 3; k++) {
							int tmp = relation[i+drEvenAdd[k]][j+dcEvenAdd[k]];
//tmp는 user수를 얻어와야하는 위치를 의미하고
=> //user수를 이렇게 따로 받아와야했다 int temp = users[tmp]
//그리고 아래 sum2 += temp; 이렇게 수정하면 정답이었다. 아...
							int tmp = relation[i+drEvenAdd[k]][j+dcEvenAdd[k]];
							sum2 += tmp;
						}
						if (max2 < sum2*sum2) {
							max2 = sum2*sum2;
						}
						
					} else if (dcrm[i][j] == false){
						int sum2 = 0;
						for (int k = 0; k < 3; k++) {
							//탐색한 방향의 원소가 0이 아닐때만 A의 연결목록에 해당 점을 추가해준다.
							
							int tmp = relation[i+drOddAdd[k]][j+dcOddAdd[k]];
							sum2 += tmp;
							
						}
						if (max2 < sum2*sum2) {
							max2 = sum2*sum2;
						}
						
					}
					
				}
			}
			
			
			max = Math.max(max, max2);
			System.out.printf("#%d %d\n",tc, max);
			
			
			
		}
		
		
	}
	
	static int[] users;
	static int W;
	static int H;
	static long max;
	
	static int[][] relation;
	static Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
	//너비와 높이가 주어졌을 때, 셀 간의 연결관계를 얻는 메서드 구현
	//relation의 (i,j)좌표의 점이 위로 올라가있으면 Even으로 움직이고
	//아래로 내려가있는 점이면 Odd으로 움직인다.
	static boolean[][] dcrm;
	
	static int[] drOdd = {-1, 0, 1, 1, 1, 0};
	static int[] dcOdd = {0, 1, 1, 0, -1, -1};
	static int[] drEven = {-1, -1, 0, 1, 0, -1};
	static int[] dcEven = {0, 1, 1, 0, -1, -1};
	
	static int[] drEvenAdd = {-1, -1, 1};
	static int[] dcEvenAdd = {-1, 1, 0};
	static int[] drOddAdd = {0, 0, 1};
	static int[] dcOddAdd = {-1, 1, 1};
	
	
	public static void getGraph() {
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j <= W; j++) {
				int A = relation[i][j];
				if (dcrm[i][j] == true) {
					for (int k = 0; k < 6; k++) {
						//탐색한 방향의 원소가 0이 아닐때만 A의 연결목록에 해당 점을 추가해준다.
						if (relation[i+drEven[k]][j+dcEven[k]] != 0) {
							graph.get(A).add(relation[i+drEven[k]][j+dcEven[k]]);
						}
					}
				} else if (dcrm[i][j] == false){
					for (int k = 0; k < 6; k++) {
						//탐색한 방향의 원소가 0이 아닐때만 A의 연결목록에 해당 점을 추가해준다.
						if (relation[i+drOdd[k]][j+dcOdd[k]] != 0) {
							graph.get(A).add(relation[i+drOdd[k]][j+dcOdd[k]]);
						}
					}
					
				}
				
			}
		}
		
		
	}
	

	//그래프의 모든 점에 대해서 DFS를 돌리고
	//DFS를 통해 정확하게 4번만 순회했을 때 멈추도록 구현한 후(기지국은 4번만 건설하므로)
	//최댓값을 구한다.
	public static void maxBenefit(int root, ArrayList<Integer> list, ArrayList<Integer> visited, int cnt) {
		
		if (cnt == 0) {
		//카운트가 0이되면 비용편익을 계산하고, 최댓값과 비교하여 더 큰 것을 구한다.
			int sum = 0;
			for (int i : list) {
				sum += users[i];
			}
			
			long costBenefit = (long) sum*sum;
			
			if (costBenefit> max) {
				max = costBenefit;
			}
			
			
			
		} else {
			if (visited.contains(root)) {
				return;
			} else {
				list.add(root);
				visited.add(root);
				//루트와 연결된 점들에 대해서 다시 재귀함수를 호출한다.
				//호출할 때 이미 방문한 점은 호출하지 않고, 추가하지도 않는다.
				int S = graph.get(root).size();
				for (int i = 0; i < S; i++) {
					if (visited.contains(graph.get(root).get(i))) {
						continue;
					} else {
						//깊은복사문제를 해결하기 위해 list와 visited를 복사한 후 보낸다
						ArrayList<Integer> tmpList = new ArrayList<Integer>();
						ArrayList<Integer> tmpVisited = new ArrayList<Integer>();
						for (int j : list) {
							tmpList.add(j);
						}
						
						for (int j : visited) {
							tmpVisited.add(j);
						}
						
						maxBenefit(graph.get(root).get(i), tmpList, tmpVisited, cnt-1);
					}
				}
			}
			
		}

	}
	
	
	
	
}
