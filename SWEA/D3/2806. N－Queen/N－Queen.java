import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();
			visited = new boolean[N][N];
			visitedRow = new boolean[N];
			cnt = 0;
			backTracking(0, 0);
			System.out.printf("#%d %d\n", tc, cnt);
			
		}
		
		
	}
	
	
	//유망성 검사 후
	//유망하다고 판단될때만 자식node로 진입한다.
	//boolean 대신 비트마스킹을 이용해보자
	static int N;
	static int cnt;
	//주어진 열을 방문했는지
	static boolean[][] visited;
	static boolean[] visitedRow;
	
	public static void backTracking(int idx, int col) {
		if (idx == N) {
			cnt++;
			return;
		} else {
			//유망성 검사
			
			
		f1:	for (int i = 0; i < N; i++) {
				if (visitedRow[i]) {
					continue;
				}
				
				//우하향 대각순회
				for (int k = 1; i+k < N && col+k <N; k++) {
					if (visited[i+k][col+k]) {
//						System.out.println("현재 체킹하는 좌표값 : "+i+", "+col);
//						System.out.println("현재 부딪힌 좌표값 : "+(i+k)+", "+(col+k));
						continue f1;
					}
				}
				//좌하향 대각순회
				for (int k = 1; i+k < N && col-k >= 0; k++) {
					if (visited[i+k][col-k]) {
//						System.out.println("현재 체킹하는 좌표값 : "+i+", "+col);
//						System.out.println("현재 부딪힌 좌표값 : "+(i+k)+", "+(col-k));
						continue f1;
					}
				}
				//좌상향 대각순회
				for (int k = 1; i-k >= 0 && col-k >= 0; k++) {
					if (visited[i-k][col-k]) {
//						System.out.println("현재 체킹하는 좌표값 : "+i+", "+col);
//						System.out.println("현재 부딪힌 좌표값 : "+(i-k)+", "+(col-k));
						continue f1;
					}
				}
				//우상향 대각순회
				for (int k = 1; i-k >= 0 && col+k < N; k++) {
					if (visited[i-k][col+k]) {
//						System.out.println("현재 체킹하는 좌표값 : "+i+", "+col);
//						System.out.println("현재 부딪힌 좌표값 : "+(i-k)+", "+(col+k));
						continue f1;
					}
				}
				
//				System.out.println("언제는 잘 도는가?"+i+", "+col+"몇개나 뽑았나? "+idx);
				visitedRow[i] = true;
				visited[i][col] = true;
				backTracking(idx+1, col+1);
				visitedRow[i] = false;
				visited[i][col] = false;
			}
				
				
			
			
		}
	}
	
}
