package SWEA_1248_공통조상;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스 입력
		int TC =sc.nextInt();
		for (int t = 1;  t <= TC; t++) {
			//정점의 개수
			int V = sc.nextInt();
			//간선의 개수
			int E = sc.nextInt();
			//공통 조상을 찾아야 하는 두 개의 정점 번호
			//러시아의 V1로켓이 떠오른다
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			//트리 클래스 구현을 위한 Map 선언
			//부모 - 자식관계가 명확하게 주어지므로
			//각 노드(index)의 부모를 얘기해주는 부모배열도 생성해준다.
			//Integer가 부모, ArrayList가 해당 부모가 갖고 있는 자식 리스트이다.
			Map<Integer, ArrayList<Integer>> tree = new TreeMap<>();
			
			for (int i = 1; i < V+1; i++) {
				tree.put(i, new ArrayList<Integer>());
			}
			
			int[] parent = new int[V+1];
			
			//트리 정보 입력
			for (int i = 0; i < E; i++) {
				int E1 = sc.nextInt();
				int E2 = sc.nextInt();
				
				//E1이 갖고 있는 자식 리스트에 E2를 추가
				tree.get(E1).add(E2);
				
				//두번째로 입력받는 E2의 부모가 E1이다.
				parent[E2] = E1;
				
			}
			
			
			//v1의 조상을 찾아주자
			ArrayList<Integer> ancestorOfv1 = new ArrayList<>();
			
			findAncestor(parent, v1, ancestorOfv1);
//			System.out.println(ancestorOfv1.toString()); 
			
			//v1과 v2의 공통조상 변수 선언
			int commonAncestor = 0;
			while (true) {
				
				//최초에 찾게되는 공통조상이 곧 가장 가까운 공통조상이 된다.
				if (ancestorOfv1.contains(parent[v2])) {
					commonAncestor = parent[v2];
					break;
				}
				
				v2 = parent[v2];
			}
			//테스트케이스마다 cnt가 초기화되야하므로 0으로 세팅
			cnt = 0;
			//구한 최초공통조상을 가지고 순회횟수를 카운트하는 메서드를 이용하여
			//순회횟수를 구한다.
			cntOrderTraverse(tree, commonAncestor); //여기서 cnt값이 바뀐다.
			System.out.printf("#%d %d %d\n", t, commonAncestor, cnt);

			
		}
		
	}
	
	//자신(idx)의 직계 조상을 모두 찾아주는 메서드 구현
	public static void findAncestor(int[] parent, int idx, ArrayList<Integer> ancestor) {
		//부모가 없는 놈에 다다를 때 까지
		if (idx != 0) {
			//idx의 부모를 조상에 추가하고
			ancestor.add(parent[idx]);
			
			//idx의 부모를 다시 idx로 설정 후 재귀
			idx = parent[idx];
			findAncestor(parent, idx, ancestor);
		}

	}
	
	//서브트리의 개수를 모두 세기 위한 순회 구현
	//개수를 세기 위한 카운트
	static int cnt = 0;
	public static void cntOrderTraverse(Map<Integer, ArrayList<Integer>> tree, int idx) {
		cnt++;
		if (tree.getOrDefault(idx, null) != null) {
			for (int i = 0; i < tree.get(idx).size(); i++) {
				cntOrderTraverse(tree, tree.get(idx).get(i));
			}
		}
		
	}


}
