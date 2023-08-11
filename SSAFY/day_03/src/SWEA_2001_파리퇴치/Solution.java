package SWEA_2001_파리퇴치;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int t = 1; t <= T; t++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			sc.nextLine();
			
			
			//인덱스 처리가 귀찮다. 
			//인덱스 문제를 생각하지 않기 위해, 시작점을 파리채의 끝점으로 놓고 순회한다.
			//(N-M-1) 크기의 행렬로 생각
			int[][] grd = new int[N][N];
			
			
			
			//입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					grd[i][j] = sc.nextInt();	
				}
			}
			
			
			//시작점
			//m이 행, n이 열
			int m = M-1;
			
			int max = Integer.MIN_VALUE;
			
			while (m < N) {
				int n = M-1;
				while (n < N) {
					int sum = 0;
					for (int i = 0; i < M; i++) {
						for (int j = 0; j < M; j++) {
							sum += grd[m-i][n-j];
							
							
						}
						
					}
					if (sum > max) {
						max = sum;
					}
					n++;
				}
				
				m++;
			}
			
			System.out.printf("#%d %d\n", t, max);

		}
		
	}

}