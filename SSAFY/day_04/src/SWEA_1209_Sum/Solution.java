package SWEA_1209_Sum;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			
			int T = sc.nextInt();
			sc.nextLine();
			
			int max = 0;
			int[][] matrix = new int[100][100]; 
			
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					matrix[i][j] = sc.nextInt();
				}
			}
			
			//행 탐색
			for (int i = 0; i < 100; i++) {
				int sum = 0;
				for (int j = 0; j < 100; j++) {
					sum += matrix[i][j];
				}
				
				if (sum > max) {
					max = sum;
				}
				
			}
			
			//열 탐색
			for (int j = 0; j < 100; j++) {
				int sum = 0;
				for (int i = 0; i < 100; i++) {
					sum += matrix[i][j];
				}
				
				if (sum > max) {
					max = sum;
				}
				
			}
			
			//대각선 2개
			//시작점(0,0)일때
			
			int m = 0;
			int n = 0;
		
			int sum = 0;
			for (int i = 0; m+i < 100 && n+i < 100; i++) {
				sum += matrix[m+i][n+i];
			}
			
			if (sum > max) {
				max = sum;
			}
			
			//시작점(99,0)일때
			m = 99;
			n = 0;
		
			sum = 0;
			for (int i = 0; m-i >= 0 && n+i < 100; i++) {
				sum += matrix[m-i][n+i];
			}
			
			if (sum > max) {
				max = sum;
			}
			

			System.out.printf("#%d %d\n",T, max);
		}
		
	}
}
