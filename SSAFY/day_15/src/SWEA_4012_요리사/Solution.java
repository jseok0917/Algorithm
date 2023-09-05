package SWEA_4012_요리사;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테스트 개수 입력
		int T = sc.nextInt();
		
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
	
			//시너지 정보 입력
			int[][] synergy = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					synergy[i][j] = sc.nextInt();
				}
			}

			
			int min = Integer.MAX_VALUE;
			
			//완전 탐색
			for (int i = 0; i < (1 << N); i++) {
				//0번째~N-1번째원소 뽑을지 말지
				//음식 A의 요리 재료 모음
				int[] A = new int[N/2+1];
				//음식 B의 요리 재료 모음
				int[] B = new int[N/2+1];
				int cntA = 0;
				int cntB = 0;
				for (int j = 0; j < N; j++) {
					if (cntA > N/2 || cntB > N/2) {
						break;
					}
					
					
					if ((i & (1 << j)) != 0) {
						A[cntA++] = j;
						
					} else {
						B[cntB++] = j;
					}					
				}
				if (cntA == N/2 && cntB == N/2) {
					int sumA = 0;
					int sumB = 0;
					for (int m = 0; m < N/2; m++) {
						for (int n = m; n < N/2; n++) {
							sumA += synergy[A[m]][A[n]]+synergy[A[n]][A[m]];
							sumB += synergy[B[m]][B[n]]+synergy[B[n]][B[m]];
							
						}
					}
					
					if (min > Math.abs(sumA-sumB)) {
						min = Math.abs(sumA-sumB);
					}
					
				}
			}
			System.out.printf("#%d %d\n", tc, min);
			
			
			
		}

	}

}
