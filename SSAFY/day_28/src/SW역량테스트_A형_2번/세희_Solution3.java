package SW역량테스트_A형_2번;

import java.util.Arrays;
import java.util.Scanner;

public class 세희_Solution3 {
	// 문제 정보
	// N x N : 맵의 크기(가로, 세로 동일)
	// (1,1)에서 출발하여 (N,N)지점으로 최소한의 연료를 사용하여 도착하려고 한다.
	// 높은 위치에서 낮은 위치로 갈 때는 연료 0 소모
	// 같은 위치에서 이동할 때는 연료 1 소모
	// 낮은 위치에서 높은 위치로 이동할 때는 위치차이*2 소모
	// 입력값으로 N과 맵 정보가 주어진다. 맵 정보는 땅의 높이를 의미한다.
	
	static int N;
	static int[][] map, usage;
	
	//최소연료를 계산할 변수
	static int min;
	//방문체크
	static boolean[][] visited;
	//델타 탐색
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//맵의 크기 입력
		N = sc.nextInt();
		
		//맵 정보 초기화
		map = new int[N][N];
		usage = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				usage[i][j] = 987654321;
			}
		}
		
		//맵 정보 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		//최솟값 초기화 및 기본값 입력
		min = Integer.MAX_VALUE;
		
		//방문 배열 초기화
		visited = new boolean[N][N];
		
		//출발점은 방문처리를 하고 넘어간다.
		visited[0][0] = true;
		
		usage[0][0] = 0;
		//시작점 (0,0), 처음엔 사용한 연료가 없으니까 0
		bruteForce(0, 0);
		
//		System.out.println(min);
		for (int[] i : usage) {
			System.out.println(Arrays.toString(i));
		}

	}
	
	//모든 경로를 완전 탐색하여 확인한다.
	
	//현재 행 위치 : r
	//현재 열 위치 : c
	//지금까지 사용한 연료양 : used
	static void bruteForce(int r, int c) {
		//재귀 종료 조건 : 도착지점에 도달했을 경우
		if (r == N-1 && c == N-1) {
			
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			//다음에 갈 곳이 map 밖이라면 움직일 필요조차 없기 때문에
			//skip해야한다. 
			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				continue;
			}
			
			//이미 방문한 곳을 재방문할 경우 스킵
			if (visited[nr][nc]) {
				continue;
			}
			
			//방문처리
			visited[nr][nc] = true;
			
			
			//연료 계산
			int fuel = 0;
			if (map[r][c] > map[nr][nc]) {
				fuel = 0;
			} else if (map[r][c] == map[nr][nc]) {
				fuel = 1;
			} else {
				fuel = 2*(map[nr][nc] - map[r][c]);
			}
			
			//다음으로 진행
			if (fuel+usage[r][c] < usage[nr][nc]) {
				usage[nr][nc] = fuel+usage[r][c];
				bruteForce(nr, nc);
			}
			
			//방문처리 되돌리기
			visited[nr][nc] = false;
			
		}
		
		
		
		
		
	}
	
	
	
	

}
