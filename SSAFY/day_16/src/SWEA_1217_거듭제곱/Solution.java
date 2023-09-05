package SWEA_1217_거듭제곱;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		for (int tc = 1; tc <= 10; tc++) {
			//테스트번호
			int t = sc.nextInt();
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int result = power(N, M);
			System.out.printf("#%d %d\n", t, result);
			
			
		}
		
		
	}
	//거듭제곱 재귀함수 구현
	public static int power(int N, int M) {
		//기저조건
		if (M == 1) {
			return N;
		}
		
		
		//재귀조건
		if (M%2 == 0) {
			int temp = power(N, M/2);
			return temp*temp;
		} else {
			int temp = power(N, (M-1)/2);
			return temp*temp*N;
		}
		
		
	}
	

}
