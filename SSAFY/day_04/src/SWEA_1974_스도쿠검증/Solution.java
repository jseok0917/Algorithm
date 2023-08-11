package SWEA_1974_스도쿠검증;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int tc = 1; tc <= T; tc++) {
			
			//스도쿠판 입력받기
			int[][] sudoku = new int[9][9];
			
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}
			
			//행 탐색, 열 탐색, 블록탐색 순서로 스도쿠 검증을 진행한다.
			boolean isSudoku = true;
			
			//행탐색
			for (int i = 0; i < 9; i++) {
				//해시셋을 이용하여 중복을 검증한다.
				Set<Integer> nums = new HashSet<>();
				for (int j = 0; j <9; j++) {
					nums.add(sudoku[i][j]);
				}
				
				if (nums.size() != 9) {
					isSudoku = false;
					break;
				}
					
			}
			
			//열탐색
			for (int i = 0; i < 9; i++) {
				//해시셋을 이용하여 중복을 검증한다.
				Set<Integer> nums = new HashSet<>();
				for (int j = 0; j <9; j++) {
					nums.add(sudoku[j][i]);
				}
				
				if (nums.size() != 9) {
					isSudoku = false;
					break;
				}
					
			}
			
			
			//블록탐색
			//시작점을 잡고 순차적으로 블록을 돌면서 탐색한다.
			//시작점의 좌표는 m, n으로 구분한다.
			int m = 0;
			while (m < 9) {
				//해시셋을 이용하여 중복을 검증한다.
				Set<Integer> nums = new HashSet<>();
				int n = 0;
				while (n < 9) {
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							nums.add(sudoku[m+i][n+j]);
						}
					}
					
					if (nums.size() != 9) {
						isSudoku = false;
						break;
					}
					n += 3;
				}
				m += 3;
			}
		
		if (isSudoku == true) {
			System.out.printf("#%d %d\n", tc, 1);
		} else {
			System.out.printf("#%d %d\n", tc, 0);
		}
			
		}
		
		
	}

}
