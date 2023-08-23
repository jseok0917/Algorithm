import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			//정점의 개수 입력
			int N = sc.nextInt();
			sc.nextLine();
			//인덱스 - 정점의 번호
			//0번 행 : 왼쪽 노드 번호링크
			//1번 행 : 오른쪽 노트 번호링크
			
			//데이터값을 따로 담아두기
			int[][] tree = new int[2][N+1];
			String[] data = new String[N+1];
			int idx = 0;
			
			
			for (int i = 0; i < N; i++) {
				String[] input = sc.nextLine().split(" ");
				switch (input.length) {
				case 2 : 
					idx = Integer.parseInt(input[0]);
					data[idx] = input[1];
					break;
				case 3 :
					idx = Integer.parseInt(input[0]);
					data[idx] = input[1];
					tree[0][idx] = Integer.parseInt(input[2]);
					break;
				case 4 :
					idx = Integer.parseInt(input[0]);
					data[idx] = input[1];
					tree[0][idx] = Integer.parseInt(input[2]);
					tree[1][idx] = Integer.parseInt(input[3]);
					break;

				}
			}
			
			System.out.print("#"+tc+" ");
			inOrderTraverse(tree, data, 1);
			System.out.println();
			
			
			
		}
		
		
		
	}
	
	//중위순회 구현
	public static void inOrderTraverse(int[][] tree, String[] data, int idx) {
		
		//현재 자식 노드가 없는 곳은 반드시 0을 찾아가게 되므로 0일때는 재귀를 멈추게 해야한다.
		if (idx != 0) {
			inOrderTraverse(tree, data, tree[0][idx]);
			System.out.print(data[idx]);
			inOrderTraverse(tree, data, tree[1][idx]);
		}
		
		
	}

}
