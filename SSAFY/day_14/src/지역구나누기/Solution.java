package 지역구나누기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스 수
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			//마을 구역의 숫자
			int N = sc.nextInt();
			
			//전체 구역 리스트를 초기화시켜놓고 다시 구역들을 넣어놓는다.
			universe  = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				universe.add(i);
			}
			
			//최솟값 초기화
			min = Integer.MAX_VALUE;
			
			//마을 간 연결 상태 입력을 위한 Map 생성
			graph = new HashMap<>();
			for (int i = 1; i <= N; i++) {
				graph.put(i, new ArrayList<Integer>());
			}
			
			//마을 간 연결 상태 입력
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int input = sc.nextInt();
					if (input != 0) {
						//input이 1이라면 i와 연결된 마을 목록에 j를 추가한다.
						//서로 연결돼있긴 하지만,j에 관한 연결목록은 어차피 뒷부분에서 모두 등장할 것이므로 하나만 추가하면 된다.
						graph.get(i).add(j);
					}
					
				}
			}
			
			//마을의 인구 수 입력
			population = new int[N+1];
			//i번 마을의 인구수가 population[i]가 된다.
			for (int i = 1; i <= N; i++) {
				population[i] = sc.nextInt(); 
			}
			
			//조합이기때문에, 선택한 구역과 그 외의 구역들이 대칭적이므로
			//N의 절반까지만 탐색해보면 된다.
			for (int i = 1; i <= (N+1)/2; i++) {
				bruteForce(N, i);
			}
			
			if (min == Integer.MAX_VALUE) {
				System.out.println("어떤 경우에도 두 개의 지역구로 분할하는 게 불가능합니다.");
			} else {
				System.out.printf("#%d %d\n", tc, min);
			}
			
			
		}
	
		
	}
	//전체 마을 구역 static으로 선언
	static ArrayList<Integer> universe  = new ArrayList<>();
	static Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
	static ArrayList<Integer> visited = new ArrayList<>();
	static int min;
	static int[] population;
	
	//특정 마을구역들을 골랐을 때, 그 마을구역을 제외한 구역들을 출력하는 메서드 구현
	public static ArrayList<Integer> complement(ArrayList<Integer> list){
		ArrayList<Integer> temp = new ArrayList<>();
		for (int i = 0; i < universe.size(); i++) {
			temp.add(universe.get(i));
		}
		//전체 구역을 temp로 복사한 후 list에 있는 모든 원소들을 삭제
		temp.removeAll(list);
		return temp;
	}
	
	//특정 마을구역들을 골랐을 때, DFS를 통해 그 마을 구역들의 첫번째 구역과
	//연결된 마을들을 반환하는 메서드 구현
	//list가 비어있는 경우에는 isConnected메서드를 통해 고려한다.
	public static ArrayList<Integer> connectedList(ArrayList<Integer> list, int root) {
		//root를 포함하고 있다면 null을 반환하고 종료
		if (visited.contains(root)) {
			return null;
		} else {
			//root를 포함하고 있지 않을때 방문목록에 추가한다.
			visited.add(root);
			int S = graph.get(root).size();
			
			for (int i = 0; i < S; i++) { 
				//root와 연결된 구역들에 대해서 DFS를 돌리면서
				//모두 순회를 시킬건데,
				//list에 속해 있는 구역에 대해서만 DFS를 돌린다.
				if (list.contains(graph.get(root).get(i))) {
					connectedList(list, graph.get(root).get(i));
				}
			}
		}
		
		return visited;
	}
	
	//특정 구역과 반대 구역이 연결됐는지 확인하는 메서드 구현
	public static boolean isConnected(ArrayList<Integer> list) {
		//list나 list의 complement가 비어있다면 false를 반환한다.
		if (list.isEmpty() || complement(list).isEmpty()) {
			return false;
		} else {
		//둘다 비어있지 않다면,
		//둘 다 연결돼있을 때 true를 반환해야 한다.
			boolean isListConnected = true;
			boolean isComplementConnected = true;
			int root1 = list.get(0);
			int root2 = complement(list).get(0);
			//root1과 연결된 구역들의 리스트의 크기가 주어진 구역들의 크기와 같지 않다면 구역들이 연결돼있지 않다.
			if (connectedList(list, root1).size() != list.size()) {
				isListConnected = false;
			}
			//connectedList메서드에서 visited를 사용하므로 한번 초기화
			visited.clear();
			if (connectedList(complement(list), root2).size() != complement(list).size()) {
				isComplementConnected = false;
			}
			
			visited.clear();
			return (isListConnected && isComplementConnected);
		}
		
	}
	
	
	//조합을 통해 완전탐색을 구현하여 두 마을 간 유권자 수가 최소가 될 때를 출력한다.
	//N개중에서 R개를 뽑는 조합 구현
	static ArrayList<Integer> combination = new ArrayList<>();
	
	public static void bruteForce(int N, int R) {
		
		if (R == 0) {
			//조합으로 선택한 구역들과, 그 나머지 구역들이 연결돼있을 때
			//유권자 수의 차이를 구하고 최솟값을 갱신한다.
			//만약에 어떤 선택에 대해서도 연결돼있지 않다면
			//min이 Integer.MAX.VALUE로 출력될 것이다.
			if (isConnected(combination)) {
				int popul1 = 0;
				int popul2 = 0;
				for (int i = 0; i < combination.size(); i++) {
					popul1 += population[combination.get(i)];
				}
				for (int i = 0; i < complement(combination).size(); i++) {
					popul2 += population[complement(combination).get(i)];
				}
				
				if (Math.abs(popul1-popul2) < min) {
					min = Math.abs(popul1-popul2);
				}	
			}

			combination.remove(combination.size()-1);
		} else {
			
			for (int i = N; i >= R; i--) {
				combination.add(i);
				bruteForce(i-1, R-1);
			}
			
			if (!(combination.isEmpty())) {
				combination.remove(combination.size()-1);
			}
		}
		
	}
	
	
	
	

}
