package SWEA_1248_공통조상;

import java.util.Scanner;

public class Solution2 {
	
	//트리 구현을 위한 Node클래스 생성
	private static class Node {
		
		int data;
		//사실상 링크의 역할을 한다.
		Node left;
		Node right;
		//공통조상을 찾는 문제이므로
		//부모노드까지 연결하는 직접작성 커스터마이징
		Node parentNode;
		
		//data값을 넣어줘야만 생성가능
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		};

	}

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
			
			
			
			
			
			
			
			
			
		}
		
	}

}
