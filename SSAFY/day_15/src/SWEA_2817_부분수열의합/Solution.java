package SWEA_2817_부분수열의합;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테스트케이스 입력
		int T = sc.nextInt();
		for (int tc = 1; tc <= T;  tc++) {
			//주어지는 자연수의 개수
			int N = sc.nextInt();
			//합
			int K = sc.nextInt();
			
			//자연수 입력을 받을 배열
			int[] nums = new int[N];
			
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			
			//경우의수를 세기위한 카운트
			int cnt = 0;
			
			//비트마스킹을 통한 조합을 구현한다.
			//모든 부분집합이 i와 일대일대응돼있다. (완전탐색)
			for (int i = 0; i < (1<<N); i++) {
				int sum = 0;
				//i는 주어진 집합의 부분집합의 대응이고
				//집합의 각 원소와의 대응은 j로 구현한다. (1번째자리~N번째자리까지)
				for (int j = 0; j < N; j++) {
					if ((i & (1<<j)) != 0) {
						sum += nums[j];
					}
				}
				//뽑은 자연수들의 합이 같으면 카운트를 +한다.
				if (sum == K) {
					cnt++;
				}
				
			}
			
			System.out.printf("#%d %d\n", tc, cnt);
			
			
			
			
		}

		
	}

}
