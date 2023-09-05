package BOJ_7576_토마토;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//상자의 크기 입력
		M = sc.nextInt();
		N = sc.nextInt();
		
		//인덱스범위 벗어남을 방지하기 위해
		//상하좌우로 늘려서 생각한다.
		tomato = new int[N+2][M+2];
		//테두리 부분은 토마토가 없는 곳으로 생각한다.
		int n = 0;
		int m = 0;
		for (int j = 0; j <= M+1; j++) {
			tomato[n][j] = -1;
		}
		for (int i = 0; i <= N+1; i++) {
			tomato[i][m] = -1;
		}

		n = N+1;
		m = M+1;
		for (int j = 0; j <= M+1; j++) {
			tomato[n][j] = -1;
		}
		for (int i = 0; i <= N+1; i++) {
			tomato[i][m] = -1;
		}
		
		
		//토마토의 정보를 입력
		//테스트케이스마다 큐 갱신
		queue  = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				tomato[i][j] = sc.nextInt();
				
				//입력 시에 익은 토마토의 좌표를 행,열좌표 순으로 큐에 넣어놓는다.
				if (tomato[i][j] == 1) {
					queue.add(i);
					queue.add(j);
				}
			}
		}
		
		
		//가능한한 모든 토마토가 익을 때까지 며칠이 걸리는지 카운트한다.
		int cnt = 0;
		//queue가 비어있을 때까지 BFS를 계속돌린다.
		while (BFS(queue.size())) {
			cnt++;
//			System.out.println("카운트횟수 : "+cnt+"큐의 상태 : "+queue.toString());
		}
		
//		for (int[] i : tomato) {
//			System.out.println(Arrays.toString(i));
//		}
		if (isAllRipe()) {
			System.out.println(cnt-1);
		} else {
			System.out.println(-1);
		}
		
		
		
	}
	
	static int[][] tomato;
	static int M;
	static int N;
	
	
	//상하좌우 탐색 구현
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	//BFS구현
	//BFS구현을 위한 queue
	static Queue<Integer> queue;
	
	//입력을 두개씩 받으므로
	//큐의 사이즈의 절반만큼 for문을 돌리면 된다.
	//BFS를 돌릴 때마다, 돌리면서 큐의 사이즈가 바뀌므로
	//큐의 사이즈도 같이 메서드변수에 넣어준다.
	public static boolean BFS(int S) {
		Queue<Integer> temp = new LinkedList<Integer>();
		//queue에는 익은 토마토들을 넣는다.
		//익은 토마토 하나 당 좌표정보 두 개가 queue에 들어가므로
		//익은 토마토 개수 *2만큼 반복문을 돌리면 된다.
		
		//큐가 비었으면 BFS를 돌릴 수 없으므로 false를 반환한다.
		if (queue.isEmpty()) {
			return false;
		} else {
			//한번에 두개씩 입력받으므로 i를 2씩 증가시킨다.
			for (int i = 0; i < S; i+=2) {
				//익은 토마토를 뽑아서 델타탐색을 돌린다.
				//행좌표
				int A = queue.poll();
				//열좌표
				int B = queue.poll();
				for (int j = 0; j < 4; j++) {
					//익은 토마토 상하좌우의 상태를 불러온다.
					int state = tomato[A+dr[j]][B+dc[j]];
					//주변의 토마토가 익었거나, 토마토가 없으면 아무것도 하지않는다.
					//안익었으면 익은걸로 바꾸고 익은 토마토의 좌표를 
					//임시 큐에 추가한다.
					if (state == 0) {
						tomato[A+dr[j]][B+dc[j]] = 1;
						temp.add(A+dr[j]);
						temp.add(B+dc[j]);
					}
				}
				
				
			}
			//for문이 끝났을 때 queue는 비어있는 상태다.
			//새롭게 익게 된 토마토가 존재하지않으면 은 아직 고려 X
			//temp의 모든 원소를 queue에 넣는다.
			while (!(temp.isEmpty())) {
				queue.add(temp.poll());
			}
			
			return true;
		}
		
	}
	
	//모든 토마토가 익어있는지 확인하는 메서드 구현
	public static boolean isAllRipe() {
		//하나라도 익지 않은 토마토가 있다면 false를 반환한다.
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (tomato[i][j] == 0) {
					return false;
				}
				
			}
		}
		
		//위에서 메서드가 끝나지 않았다면 모든 토마토가 익은 토마토 이므로 true를 반환
		return true;
	}
	
	

}
