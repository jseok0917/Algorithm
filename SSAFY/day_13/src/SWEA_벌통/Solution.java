package SWEA_벌통;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테스트 케이스 입력
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			//벌통의 크기
			int N = sc.nextInt();
			
			//선택할 수 있는 벌통의 개수
			M = sc.nextInt();
			
			//꿀을 채취할 수 있는 최대 양 C
			C = sc.nextInt();
			
			//벌통 정보 입력
			int[][] beeHouse = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					beeHouse[i][j] = sc.nextInt();
				}
			}
			
			
			//완전탐색을 진행하면서
			//각 탐색에서의 최대수익을 구하기위해 DP를 사용한다.
			int max = 0;
			
			//가로로만 채취하므로
			//가로 탐색을 진행한다.
			//첫번째 일꾼의 시작점을 (i, j)로 생각
			for (int i = 0; i < N; i++) {
				
				int j = 0;
				//첫번째 일꾼의 시작점에 따라
				//두번째 일꾼의 탐색지점도 계속 고려해야한다.
				while (j+M-1 < N) {
					//첫번째 일꾼이 탐색한 벌통리스트
					int[] findHoney1 = new int[M];
					for (int m = 0; m < M; m++) {
						findHoney1[m] = beeHouse[i][j+m];
					}
	
					
					//두번째 일꾼의 시작지점 고려
					//첫번째 일꾼과 같은 행에서 시작하면 된다.
					//왜냐하면 첫번째 일꾼과 두번째 일꾼은
					//서로 바꿔치기해도 차이가 없기때문에
					//첫번째 일꾼이 고려한 벌통 이후만을 고려하면 된다.
					
					//첫번째 일꾼과 같은 행에서
					//벌꿀을 펄 수 있다면
					if (j+2*M-1 < N) {
						int j2 = j+M;
						//공간이 나는동안
						while (j2+M-1 < N) {
							int[] findHoney2 = new int[M];
							for (int m2 = 0; m2 < M; m2++) {
								findHoney2[m2] = beeHouse[i][j2+m2];
							}
							dp = new int[M+1][C+1];
							int profit1 = maxProfit(findHoney1);
							int profit2 = maxProfit(findHoney2);
							if (profit1+profit2 > max) {

								max = profit1+profit2;
							}
							j2++;
						}
						
					//첫번째 일꾼과 같은 행에서
					//벌꿀을 펄 수 없다면
					} 
					//첫번째 일꾼의 다음행부터 시작
					int i2 = i+1;
					while (i2 < N) {
						int j2 = 0;
						while (j2+M-1 < N) {
							int[] findHoney2 = new int[M];
							for (int m2 = 0; m2 < M; m2++) {
								findHoney2[m2] = beeHouse[i2][j2+m2];
							}
							//최대수익을 이제 구해야한다.
							dp = new int[M+1][C+1];
							int profit1 = maxProfit(findHoney1);
							int profit2 = maxProfit(findHoney2);
							if (profit1+profit2 > max) {

								max = profit1+profit2;
							}
							
							j2++;
						
						}
						i2++;
					}
					

					j++;
				}
			}
			
			
			System.out.printf("#%d %d\n",tc, max);
			
			
		}
		
		
	}
	
	//최대수익을 구하는 메서드 생성
	//DP알고리즘을 사용하기 위한 이중배열 생성
	static int M;
	static int C;
	static int[][] dp;
	
	public static int maxProfit(int[] list) {
		//배낭알고리즘을 이용한다.

		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= C; j++) {
				//i번째 개수를 배낭크기 j에넣을 수 없으면 
				//이중배열의 바로 윗행에서 element를 가져온다
				if (j < list[i-1]) {
					dp[i][j] = dp[i-1][j];
				} else {
				//i번째 개수를 배낭크기 j에 넣을 수 있다면
				//넣었을 때의 값과, 넣지 않았을 때의 값을 비교하여
				//큰 값을 넣는다.
					//넣었을 때의 값
					int A = dp[i-1][j-list[i-1]] + list[i-1]*list[i-1];
					//넣지 않았을 때의 값
					int B = dp[i-1][j];
					if (A > B) {
						dp[i][j] = A;
					} else {
						dp[i][j] = B;
					}
					
				}
				
				
			}
		}

		return dp[M][C];
	}
	

}
