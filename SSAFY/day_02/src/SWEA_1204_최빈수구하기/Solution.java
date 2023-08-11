package SWEA_1204_최빈수구하기;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); //테스트케이스 숫자
		sc.nextLine();
		
		for (int t = 0; t < T; t++) {
			
			int ord = sc.nextInt(); //테스트케이스 번호
			sc.nextLine();
			
			int[] gradeList = new int[1000];
			int[] count = new int[101];
			
			for (int i = 0; i < 1000; i++) {
				gradeList[i] = sc.nextInt();
				count[gradeList[i]]++;
			}
			
			
			int idx = 0; // count에서의 인덱스가 곧 점수이다.
			int max = 0;
			
			for (int i = 0; i < 101; i++) {
				
				if (max <= count[i]) {
					idx = i;
					max = count[i];
					
				}

			}
			
			System.out.println("#"+ord+" "+idx);
			
			
			
			
		}
		
		
	}

}
