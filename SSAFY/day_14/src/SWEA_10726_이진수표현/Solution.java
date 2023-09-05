package SWEA_10726_이진수표현;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테스트케이스 입력
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			boolean isOn = true; 
			
			// 30
			//1000000000000000000000011110
			//1000000000000000000000000000
			
			
			
			//1000000000000000000000000000000000000000000000000 = 0
			
			for (int i = 0; i < N; i++) {
				//돌다가 꺼져있는 비트를 발견하면 break
				if ((M & (1 << i)) == 0) {
					isOn = false;
					break;
				}
			}
			
			if (isOn) {
				System.out.printf("#%d %s\n", tc, "ON");
			} else {
				System.out.printf("#%d %s\n", tc, "OFF");				
			}
			
			
			
			
			
			
		}
		
		
	}

}
