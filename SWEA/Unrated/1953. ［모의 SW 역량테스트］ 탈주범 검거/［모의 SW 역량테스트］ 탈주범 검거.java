import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	//상 하 좌 우
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] map;
	static int N;
	static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테스트 수
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			//세로크기 N, 가로크기 M, 
			N = sc.nextInt();
			M = sc.nextInt();
			
			//탈주범이 들어간 맨홀 위치
			//R : 가로위치, C : 세로위치 (0부터 시작)
			int R = sc.nextInt();
			int C = sc.nextInt();
			
			//탈출 후 소요된 시간 (그 중 1시간은 이미 들어가는데 소요)
			int L = sc.nextInt();
			
			//지하터널 지도 입력
			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			//방문배열 
			boolean[][] visited = new boolean[N][M];
			
			//BFS를 위한 큐
			Queue<Integer> q = new LinkedList<>();
			q.add(R);
			q.add(C);
			//경과된 시간
			q.add(1);
			int cnt = 0;
			
			//BFS 구현
			while (!q.isEmpty()) {
				int r = q.poll();
				int c = q.poll();
				int t = q.poll();
				
				//시간 L을 초과했으면 멈춘다
				if (t == L+1) {
					break;
				}
				
				//이미 방문한 곳이면 스킵
				if (visited[r][c]) {
					continue;
				}
				
				//방문처리
				visited[r][c] = true;
				cnt++;
				
				//델타탐색
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (rangeCheck(nr, nc)) {
						continue;
					} else {
					
						//방문하지않았고, 갈 수 있는 곳이고
						//서로 연결되었다면 큐에 추가
						if (!visited[nr][nc] && isConnect(r, c, i)) {
							q.add(nr);
							q.add(nc);
							q.add(t+1);
						}
					}
					
				}
			}
			
			System.out.printf("#%d %d\n", tc, cnt);
			
			
			
			
			
			
		}
		
	}
	
	static boolean rangeCheck(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
			return true;
		}
		
		return false;
	}
	
	//d방향과 map[r][c]가 연결돼있는가를 체크
	static boolean isConnect(int r, int c, int d) {
		int nr = r+dr[d];
		int nc = c+dc[d];
		if (map[r][c] == 0) {
			return false;
		}
		
		switch (map[r][c]) {
		case 1:
			switch (d) {
			//상
			case 0:
				if (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 5 || map[nr][nc] == 6) {
					return true;
				}
				return false;
			//하
			case 1:
				if (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 7) {
					return true;
				}
				return false;
			//좌
			case 2:
				if (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 5) {
					return true;
				}
				return false;
			//우
			case 3:
				if (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 6 || map[nr][nc] == 7) {
					return true;
				}
				return false;
			
			}
			break;
		case 2:
			switch (d) {
			//상
			case 0:
				if (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 5 || map[nr][nc] == 6) {
					return true;
				}
				return false;
			//하
			case 1:
				if (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 7) {
					return true;
				}
				return false;
			//좌
			case 2:
				return false;
			//우
			case 3:
				return false;
				
			}
			break;
		case 3:
			switch (d) {
			//상
			case 0:
				return false;
			//하
			case 1:
				return false;
			//좌
			case 2:
				if (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 5) {
					return true;
				}
				return false;
			//우
			case 3:
				if (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 6 || map[nr][nc] == 7) {
					return true;
				}
				return false;
			
			}
			break;
		case 4:
			switch (d) {
			//상
			case 0:
				if (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 5 || map[nr][nc] == 6) {
					return true;
				}
				return false;
			//하
			case 1:
				return false;
			//좌
			case 2:
				return false;
			//우
			case 3:
				if (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 6 || map[nr][nc] == 7) {
					return true;
				}
				return false;
				
			}
			break;
		case 5:
			switch (d) {
			//상
			case 0:
				return false;
			//하
			case 1:
				if (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 7) {
					return true;
				}
				return false;
			//좌
			case 2:
				return false;
			//우
			case 3:
				if (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 6 || map[nr][nc] == 7) {
					return true;
				}
				return false;
			}
			break;
		case 6:
			switch (d) {
			//상
			case 0:
				return false;
				//하
			case 1:
				if (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 7) {
					return true;
				}
				return false;
				//좌
			case 2:
				if (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 5) {
					return true;
				}
				return false;
				//우
			case 3:
				return false;
			}
			break;
		case 7:
			switch (d) {
			//상
			case 0:
				if (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 5 || map[nr][nc] == 6) {
					return true;
				}
				return false;
				//하
			case 1:
				return false;
				//좌
			case 2:
				if (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 5) {
					return true;
				}
				return false;
				//우
			case 3:
				return false;
			}
			break;
		}
		
		
		
		
		
		return false;
	}
	
	
}
