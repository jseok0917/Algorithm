package BOJ_17471_게리맨더링;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		//구역의 개수
		int N = Integer.parseInt(br.readLine());
		
		//그래프 구현을 위한 map 생성
		Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			graph.put(i, new ArrayList<Integer>());
		}
		
		
		//구역별 인구수 입력
		String[] populationInput = br.readLine().split(" ");
		int[] population = new int[populationInput.length+1];
		for (int i = 1; i <= populationInput.length; i++) {
			population[i] = Integer.parseInt(populationInput[i-1]);
		}
		
		
		//i번째 구역과 인접한 구역의 개수 및 구역 입력
		for (int i = 1; i <= N; i++) {
			String[] input = br.readLine().split(" ");
			//i번째 구역과 인접한 구역의 개수 입력
			int M = Integer.parseInt(input[0]);
			for (int j = 1; j <= M; j++) {
				//i번째 구역의 인접 리스트 목록에 입력된 인접한 구역들을 추가한다.
				graph.get(i).add(Integer.parseInt(input[j]));
			}
		}
		
		//하나만 잡고 가면 된다. 그냥 루트를 1로 시작하자
		//BFS 구현
		//탐색할 때마다 visited를 제외한 나머지 리스트가 연결된 리스트인지 확인하고
		//연결된 리스트일 경우에는 인구수의 차이를 구한다.
		ArrayList<Integer> visited = new ArrayList<>();
		ArrayList<Integer> listForBFS = new ArrayList<>();
		for (int i : graph.get(1)) {
			
			
		}
		
		
		
	}
	//전체 구역에서 만들어져있는 구역의 리스트를 빼는 방법 구현(여집합)
	public static void complement(ArrayList<Integer> list,ArrayList<Integer> universe) {
		for (int i : list) {
			universe.removeAll(list);
		}
		
	}
	
	
	//주어진 구역의 리스트가 연결되었는지 확인
	public static void isConnected(ArrayList<Integer> sections, int root) {
		for (int i : sections) {
			
		}
		
		
	}
	
	//BFS 메서드 구현
	public static void BFS(ArrayList<Integer> list) {
		
		
		
	}

	
}
