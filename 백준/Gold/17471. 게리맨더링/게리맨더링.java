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
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			universe.add(i);
		}
		
		//그래프 구현을 위한 map 생성
		graph = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			graph.put(i, new ArrayList<Integer>());
		}
		
		
		//구역별 인구수 입력
		String[] populationInput = br.readLine().split(" ");
		population = new int[populationInput.length+1];
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
		
		
		//1개부터~N-1개까지의 뽑기에 대하여 bruteForce를 구현한 후 min을 출력한다.
		for (int i = 1; i <= N-1; i++) {
			bruteForce(N, i);
		}
		
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
		
		
		
		
	}
	
	
	//전체 구역 리스트
	static ArrayList<Integer> universe = new ArrayList<>();
	static Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
	static int[] population;
	static ArrayList<Integer> visited = new ArrayList<>();
	
	//구역의 개수
	static int N;
	
	//전체 구역에서 만들어져있는 구역의 리스트를 빼는 방법 구현(여집합)
	public static ArrayList<Integer> complement(ArrayList<Integer> list) {
		ArrayList<Integer> temp = new ArrayList<>();
		//깊은 복사 진행
		temp.addAll(universe);
		temp.removeAll(list);
		return temp;
	}
	
	
	//주어진 구역의 리스트가 연결되었는지 탐색 메서드를 통해 확인
	public static boolean isConnected(ArrayList<Integer> section) {
		if (!(section.isEmpty())) {
			
			int root = section.get(0);
			//root와 연결된 점들을 모두 모았을 때
			//구역의 점들의 개수와 같으면 연결된 구역이다.
			
			//connectedList를 두번이상쓰면 오류가 발생할 수 밖에 없다.
			return section.size() == connectedList(section, root).size();
			
			
		} else {
			return false;
		}
	}
	
	//DFS를 통해 특정 구역과 연결된 그래프 탐색
	public static ArrayList<Integer> connectedList(ArrayList<Integer> section, int root){
		//방문하지 않았다면 root를 추가한다.
		if (!(visited.contains(root))) {
			visited.add(root);
		//이미 방문했다면 더 이상 재귀하지 않도록 함수를 종료
		} else {
			return null;
		}
		//root와 연결된 그래프 상의 점들중, 구역 내의 점들에 대하여 재귀함수를 호출한다.
		if (!(graph.get(root).isEmpty())) {
			for (int i : graph.get(root)) {
				if (section.contains(i)) {
					connectedList(section, i);
				}
			}
		}
		//재귀가 모두 끝난 후 방문리스트를 반환
		return visited;
		
	}
	
	static ArrayList<Integer> combination = new ArrayList<>();
	static int min = Integer.MAX_VALUE;
	
	//조합을 통해 인구 수의 최솟값을 구해본다.
	//N개중 R개를 고르는 재귀함수
	public static void bruteForce(int N, int R) {
		//고를게 없어지면 이제 재귀를 진행할것이다
		if (R == 0) {
			//R개를 모두 뽑은 상황이다.
			//일단 뽑은 것과, 뽑은 것 제외한 나머지
			//둘 중 하나라도 연결된 그래프여야만 논의를 진행한다.
			
			if (isConnected(combination)) {
				//isConnected메서드는
				//visited 전역변수를 건드리기때문에 다시 쓰기전에 한번 초기화시켜줘야한다.
				visited = new ArrayList<>();
				if (isConnected(complement(combination))) {
					
					int sum1 = 0;
					int sum2 = 0;
					for (int i : combination) {
						sum1 += population[i];
					}
					
					for (int i : complement(combination)) {
						sum2 += population[i];
					}
					
					if (Math.abs(sum1-sum2) < min){
						min = Math.abs(sum1-sum2);
					}
				}
				
			}
			
			//메서드에 사용된 static 변수들을 초기화시켜준다.
			//방문목록 초기화
			visited = new ArrayList<>();
			
			//올바른 재귀를 위해 돌아갈 때마다 마지막 원소를 삭제시켜줘야 한다.
			combination.remove(combination.size()-1);
		} else {
			//우선 1개를 고른다.
			for (int i = N; i >= R; i--) {
				combination.add(i);
				//고르고 나면, 1개 택했으니까 나머지 중에서 R-1개를 고른다
				//i를 골랐으므로 i빼고 골라야 한다.
				bruteForce(i-1, R-1);
			}
			//올바른 재귀를 위해 for문 종료마다 마지막 원소를 삭제시켜줘야 한다.
			if (!(combination.isEmpty())) {
				combination.remove(combination.size()-1);
			}
			
			
		}
		
		
	}

	
}
