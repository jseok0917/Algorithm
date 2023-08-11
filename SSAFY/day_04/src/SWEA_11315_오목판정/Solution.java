package SWEA_11315_오목판정;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			sc.nextLine();
			
			//오목판 입력
			//인덱스 문제를 생각하지 않기 위해 상하좌우로 1칸씩 늘려서 생각한다.
			boolean[][] omok = new boolean[N+2][N+2];
			
			for (int i = 1; i <= N; i++) {
				String[] input = sc.nextLine().split("");
				
				//어차피 input length가 N과 동일하므로
				for (int j = 1; j <= N; j++) {
					if (input[j-1].equals("o")) {
						omok[i][j] = true;
					} else if (input[j-1].equals(".")){
						omok[i][j] = false;
					}
	
				}
			}
			
			//오목판정자
			boolean isOmok = false;
			
			//이제 행탐색 열탐색 대각탐색을 진행한다.
			//각 탐색마다 연속된 돌의 개수를 count한다.
			
		f1:	for (int i = 1; i <= N; i++) {
				int cnt = 0;
				int j = 1;
				
				//j가 N+1이 될때 까지해야 벽 끝에서 카운트가 초기화되지 않는걸 막을 수 있다.
				while (j <= N+1) {
					if (omok[i][j] == true) {
						cnt++;
						j++;
					} else {
						if (cnt >= 5) {
							isOmok = true;
							break f1;
						}
						//가다가 놓인 돌이 없으면
						//오목인지 판정하고 카운트를 초기화해야한다
						cnt = 0;
						j++;
					}
					
				}
			}

			
			
			
			//세로열 탐색도 똑같이 진행하면 됨
			// index i 와 j의 위치만 뒤바꾸면 된다.
		f2:	for (int i = 1; i <= N; i++) {
				int cnt = 0;
				int j = 1;
				
				//j가 N+1이 될때 까지해야 벽 끝에서 카운트가 초기화되지 않는걸 막을 수 있다.
				while (j <= N+1) {
					if (omok[j][i] == true) {
						cnt++;
						j++;
					} else {
						if (cnt >= 5) {
							isOmok = true;
							break f2;
						}
						//가다가 놓인 돌이 없으면
						//오목인지 판정하고 카운트를 초기화해야한다
						cnt = 0;
						j++;
					}
					
				}
			}
	
			//대각선 탐색을 진행한다.
			//양의 방향으로 탐색 음의 방향으로 탐색 두 방향으로
			//대각 탐색을 위해 ㄴ자 탐색을 이용한다.
			//탐색을 위한 출발위치는 오목판의 왼쪽 상단 끝에서 출발
			//아래로 먼저 내려가고 그다음에 오른쪽으로 쭉 간다.
			
			//양의 방향 탐색
			int m = 1;
			int n = 1;
			
			while (m < N) {
				
				int cnt = 0;
				
				//이거 넘어갔을때 까지 해야한다.
				for (int i = 0; m-i >= 0 && n+i <= N+1; i++) {
					if (omok[m-i][n+i] == true) {
						cnt++;
					} else {
						if (cnt >= 5) {
							isOmok = true;
						}
						cnt = 0;
					}
				}
				
				m++;
			}
			
			
			
			while (n <= N) {
				
				int cnt = 0;
				for (int i = 0; m-i >= 0 && n+i <= N+1; i++) {
					if (omok[m-i][n+i] == true) {
						cnt++;
					} else {
						if (cnt >= 5) {
							isOmok = true;
						}
						cnt = 0;
					}
				}
				
				n++;
			}
			
			
			//음의 방향 탐색
			//뒤집은 기역자로 대각선 탐색
			
			
			//양의방향과 다르게 출발점은 왼쪽 가장 하단이다
			
			m = N;
			n = 1;
			
			while (m > 1) {
				
				int cnt = 0;
				for (int i = 0; m+i <= N+1 && n+i <= N+1; i++) {
					if (omok[m+i][n+i] == true) {
						cnt++;
					} else {
						if (cnt >= 5) {
							isOmok = true;
						}
						cnt = 0;
					}
				}
				
				m--;
			}
			
			while (n <= N) {
				
				int cnt = 0;
				for (int i = 0; m+i <= N+1 && n+i <= N+1; i++) {
					if (omok[m+i][n+i] == true) {
						cnt++;
					} else {
						if (cnt >= 5) {
							isOmok = true;
						}
						cnt = 0;
					}
				}
				
				n++;
			}
			
			
			if (isOmok == true) {
				System.out.println("#"+t+" YES");
			} else {
				System.out.println("#"+t+" NO");
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
	}

}
