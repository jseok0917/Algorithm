package SWEA_1232_사칙연산;

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			//정점의 개수 입력
			int N = Integer.parseInt(sc.nextLine());
			
			//인덱스가 정점의 번호가 될 것이고,
			//2차원 배열로 만들어서 0번 행을 왼쪽노드, 1번 행을 오른쪽 노드로 생각
			int[][] tree = new int[2][N+1];
			
			//정점의 데이터는 String배열로 생성
			String[] data = new String[N+1];
		
			
			//인덱스 저장할 변수 생성
			int idx = 0;
			//정점의 정보 입력
			for (int i = 0; i < N; i++) {
				String[] input = sc.nextLine().split(" ");
				switch (input.length) {
				case 4 :
					idx = Integer.parseInt(input[0]);
					data[idx] = input[1];
					tree[0][idx] = Integer.parseInt(input[2]);
					tree[1][idx] = Integer.parseInt(input[3]);
					break;
				case 2 :
					idx = Integer.parseInt(input[0]);
					data[idx] = input[1];
					break;
				}
				
				
			}
			
			postOrderTraverse(tree, data, 1, stack);
			System.out.println("#"+tc+" "+stack.pop());
			
			
			
		}
		
	}
	
	//
	static Stack<String> stack = new Stack<>();
	
	//후위순회 구현
	public static void postOrderTraverse(int[][] tree, String[] data, int idx, Stack<String> stk) {
		//자식 노드가 0이 될 때는 순회를 하지않고
		//바로 함수를 끝내야한다.
		//0이 아닐때만 재귀
		if (idx != 0) {
			
			//LRV순
			postOrderTraverse(tree, data, tree[0][idx], stack);
			postOrderTraverse(tree, data, tree[1][idx], stack);
			
			//팝을 할때 LIFO이고
			//연산 순서는 먼저들어간거부터 시작해야하므로 A와 B의 위치를 바꿔주어야한다.
			if (data[idx].equals("+")) {
				int A = Integer.parseInt(stack.pop());
				int B = Integer.parseInt(stack.pop());
				stack.add((B+A)+"");
			} else if (data[idx].equals("-")) {
				int A = Integer.parseInt(stack.pop());
				int B = Integer.parseInt(stack.pop());
				stack.add((B-A)+"");
			}  else if (data[idx].equals("*")) {
				int A = Integer.parseInt(stack.pop());
				int B = Integer.parseInt(stack.pop());
				stack.add((B*A)+"");
			} else if (data[idx].equals("/")) {
				int A = Integer.parseInt(stack.pop());
				int B = Integer.parseInt(stack.pop());
				stack.add((B/A)+"");
			} else {
				stack.add(data[idx]);
			}
		}
		
		
		
	}
	

}
