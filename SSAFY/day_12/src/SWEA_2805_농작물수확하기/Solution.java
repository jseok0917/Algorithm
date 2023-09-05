package SWEA_2805_농작물수확하기;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테스트케이스 입력
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int sum = 0;
			//농장의 크기
			int N = sc.nextInt();
			//농장만들기
			int[][] ground = new int[N][N];
			
			//농장 입력
			for (int i = 0; i < N; i++) {
				String[] input = sc.next().split("");
				for (int j = 0; j < N; j++) {
					ground[i][j] = Integer.parseInt(input[j]);
				}
			}
			
			//농작물수확하기
			int m = 0;
			int n = (N-1)/2;
			
			
			//시작점은 (m,n)
			//상단 중앙점(m = 0, n = (N-1)/2) 으로 넣어볼거긴함.
			//반복시에는 N값을 줄이고 m값을 늘려가며 n은 고정
			while (N > 1) {
				//우하향 대각순회
				for (int i = 0; i <= (N-1)/2; i++) {
					sum += ground[m+i][n+i];
				}
				
				//시작점을 오른쪽 중앙으로 고정
				
				m += (N-1)/2;
				n += (N-1)/2;
				
				//좌하향 대각순회
				//다음거부터 넣어야하므로 i=1부터 시작
				for (int i = 1; i <= (N-1)/2; i++) {
					sum += ground[m+i][n-i];
				}
				//시작점을 하단 중앙으로 고정
				m += (N-1)/2;
				n -= (N-1)/2;
				
				//좌상향 대각순회
				for (int i = 1; i <= (N-1)/2; i++) {
					sum += ground[m-i][n-i];
				}
				
				//시작점을 좌측 중앙으로 고정
				m -= (N-1)/2;
				n -= (N-1)/2;
				
				//우상향 대각순회
				for (int i = 1; i < (N-1)/2; i++) {
					sum += ground[m-i][n+i];
				}
				//시작점을 한칸 내려간 상단 중앙으로 고정
				m = m-(N-1)/2+1;
				n = n + (N-1)/2;
				
				
				//반복할때마다 N값이 2씩 줄어들어야한다.
				N = N-2;
			}
			
			// N = 1일 때
			sum += ground[m][n];
			
			
			System.out.printf("#%d %d\n", tc, sum);
			//절댓값으로 구하는게 아주 신박한 방법인듯
		
		}

		
	}



}
