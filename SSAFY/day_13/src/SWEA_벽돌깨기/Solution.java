package SWEA_벽돌깨기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//N값의 범위가 매우 작기에
		//for문을 그냥 4번 돌리는 완전 탐색을 이용한다.
		//떨어뜨린 후 벽돌 상황을 return해주는 메서드를 재귀함수로 구현한다.
		
		//테스트케이스 입력
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			//떨어뜨릴 벽돌의 개수
			int N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			
			//이중배열로 입력받아서
			//열 별로 bricks에 집어넣는다
			int[][] input = new int[H][W];
					
			Map<Integer, ArrayList<Integer>> bricks = new HashMap<>();
			
			//열순회를 하면서 bricks에 다시 입력
			//넣을때 1층부터 거꾸로 넣어야한다.
			for (int j = 0; j < W; j++) {
				bricks.put(j, new ArrayList<Integer>());
				for (int i = H-1; i >= 0; i--) {
					bricks.get(j).add(input[i][j]);
				}
			}
			
			
			
			
			int max = 0;
			
			
			
			
			
		}
		
		
		
	}
	
	//factorial을 재귀함수로 구현
	public static void factorial() {
		
	}
	
	
	
	//벽돌의 너비는 W
	//벽돌의 높이는 H
	static int W;
	static int H;
	
	//현재 쌓여있는 벽돌+폭탄들의 상황을 map(bricks)으로 구현하자.
	//벽돌을 떨어뜨린 위치 0<= X < W이라 하자.
	//stack[X]이 X번위치에 쌓인 벽돌 수, H-stack[X]은 X번위치에서 터지는 폭탄의 index가 된다
	//즉, X번 위치에 떨어뜨리면
	//bricks.get(X) 이게 L번위치에 쌓인 벽돌들에 놓인 폭탄들의 리스트를 얘기하고
	//S = bricks.get(X).size(); 이건 쌓인 벽돌들의 수
	//bricks.get(X).get(S-1); << 이 위치의 폭탄이 터진다.
	//다음에 터질 폭탄들을 bombList(x,y를 넣는다)에 모아 재귀한다.
	public static void bombBrick(Map<Integer, ArrayList<Integer>> bricks, ArrayList<Integer> bombList) {
		
		//터질 폭탄들에 대해서 폭탄제거를 적용한다.
		
		//폭탄의 범위
		int bombRange = bricks.get(X).get(Y);
		
		//터진 
		bricks.get(X).remove(Y);
		
		//상하좌우로 벽돌 제거
		//벽돌을 제거할때 벽돌에 포함돼있던 폭탄을 폭탄리스트에 추가
		for (int i = 1; i < bombRange; i++) {
			//위쪽에 터질 폭탄이 있는가
			if (0 <= L && L < W && ) {
				
			}
			
			
		}
	
	}
	
	//폭탄이 터진 위치를 X, Y로 놓는다.
	//(X,Y)에 폭탄이 터질 때 변화
	// X가 열위치, Y가 행위치
	public static void bombBrick(Map<Integer, ArrayList<Integer>> bricks, int X, int Y) {
		
		//폭탄의 범위
		int bombRange = bricks.get(X).get(Y);
		
		
		//제거할 폭탄들 모아놓을 리스트
		Map<Integer, ArrayList<Integer>> removeList = new HashMap<>();
		for (int j = 0; j < W; j++) {
			removeList.put(X, new ArrayList<Integer>());
		}
		
		//처음 폭탄이 터진 위치를 추가
		removeList.get(X).add(Y);
		
		//상하로 폭탄 리스트 모으기
		for (int i = 1; Y+i >= 0 && Y+i < H && i < bombRange; i++) {
			removeList.get(X).add(Y+i);
			removeList.get(X).add(Y-i);
		}
		
		//좌우로 폭탄 리스트 모으기
		for (int i = 1; Y+i >= 0 && Y+i < H && i < bombRange; i++) {
			removeList.get(X+i).add(Y);
			removeList.get(X-i).add(Y);
		}
	
	}

}
