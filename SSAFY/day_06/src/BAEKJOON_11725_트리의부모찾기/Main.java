package BAEKJOON_11725_트리의부모찾기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//노드의 개수 입력
		int N = Integer.parseInt(br.readLine());
		
		//트리 클래스 구현
		TreeMap<Integer, List<Integer>> tree = new TreeMap<>();
		for (int i = 1; i <= N; i++) {
			//각 i마다 객체를 형성하여 tree에 넣어준다.
			tree.put(i, new ArrayList<Integer>());
		}
		
		//트리의 연결구조 입력
		for (int i = 0; i < N-1; i++) {
			
			String[] input = br.readLine().split(" ");
			
			int A = Integer.parseInt(input[0]);
			int B = Integer.parseInt(input[1]);
			
			tree.get(A).add(B);
			tree.get(B).add(A);
		}
		
		//방문했는지 확인하는 배열 생성
		boolean[] visited = new boolean[N+1];
		
		//각 숫자의 부모를 저장할 부모배열 생성
		int[] parentNode = new int[N+1];
		
		//숫자를 저장하고 꺼낼 큐 생성(FIFO여야함)
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		
		treeBFS(tree, visited, parentNode, q);
		
		for (int i = 2; i < N+1; i++) {
			System.out.println(parentNode[i]);
		}
		
		
		

		
		
	}
	
	//BFS 구현
	public static void treeBFS(TreeMap<Integer, List<Integer>> tree, boolean[] visited, int[] parentNode, Queue<Integer> q) {
		
		//큐에 있는걸 꺼내놓는다
		int[] nums = new int[q.size()];
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = q.poll();
		}
		
		//꺼내놓은 숫자마다 연결된 노드들을 다시 큐에 넣어야 한다. 넣을 때 꺼내놓은 숫자는 방문목록에 추가한다.
		//큐에 넣을 때, 이미 방문한 노드가 있다면 큐에 추가해서는 안되고, 그 방문한 노드는 넣은 숫자의 부모 노드가 된다.
		for (int i = 0; i < nums.length; i++) {
			visited[nums[i]] = true;
			for (int j : tree.get(nums[i])) {
				if (visited[j] == true) {
					parentNode[nums[i]] = j;
				} else {
					q.add(j);
				}
			}
		}
		
		//큐에 넣어져있는 목록이 없다면 함수를 종료한다.
		if (q.isEmpty()) {
			return;
		}

		treeBFS(tree, visited, parentNode, q);
		
		
		
		
		
	}
	
	
	
	
	

}
