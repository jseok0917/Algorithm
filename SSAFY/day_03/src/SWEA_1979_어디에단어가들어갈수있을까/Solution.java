package SWEA_1979_어디에단어가들어갈수있을까;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//테스트케이스
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int t = 1; t <= T; t++) {
		
			//주어진 판의 가로세로 길이
			int N = sc.nextInt();
			int K = sc.nextInt();
			sc.nextLine();
			
			//주어진 숫자들을 이차원 배열에 입력받는다
			//인덱스 문제를 피하기위해서 상하좌우 한칸씩 늘려놓는다.
			int[][] grd = new int[N+2][N+2];
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					grd[i][j] = sc.nextInt();
				}
			}
			
			//행부터 탐색
			//행에서 개수 카운트
			int globalCount = 0;
			
			for (int i = 1; i <= N; i++) {
				//연속된 빈칸 카운트
				int cnt = 0;
				int j = 1;	
				//훑기
				while (j <= N+1) {
					
					//1일때는 카운트를 늘리되
					//0일때는 그때까지의 길이를 기록하여 K값과 판정하고
					//카운트를 초기화한다.
					//while의 범위를 N+1까지 해주는 이유는
					//globalCount가 0을 만날때만 늘려주기 때문에
					//끝에 1이 있는 경우에는 판정 불가하다.
					if (grd[i][j] == 1) {
						cnt++;
						j++;
					} else {
						if (cnt == K) {
							globalCount++;
						}
						cnt = 0;
						j++;
						
					}
					
				}
			}
			
			//열탐색
			
			for (int i = 1; i <= N; i++) {
				//연속된 빈칸 카운트
				int cnt = 0;
				int j = 1;	
				//훑기
				while (j <= N+1) {
					
					//정사각행렬이니까 i와 j만 바꿔치기 해주면된다
					if (grd[j][i] == 1) {
						cnt++;
						j++;
					} else {
						if (cnt == K) {
							globalCount++;
						}
						cnt = 0;
						j++;
						
					}
					
				}
			}
			
			System.out.printf("#%d %d\n", t, globalCount);
		
		
		}
		
		
		
		
		
	}

}
