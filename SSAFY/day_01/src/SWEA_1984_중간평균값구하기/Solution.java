package SWEA_1984_중간평균값구하기;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		
		for (int t = 0; t < T; t++) {
			
			int[] nums = new int[10];
			
			for (int n = 0; n < 10; n++) {
				nums[n] = sc.nextInt();
			}
			
		
		
			//버블정렬을 이용한다. arrays.sort를 이용해도 되긴하지만
			for (int i = 10; i > 0; --i) {
				
				for (int j = 0; j < i-1; j++) {
					
					if (nums[j] >= nums[j+1]) {
						int temp = nums[j+1];
						nums[j+1] = nums[j];
						nums[j] = temp;
					}
					
				}
				
				
			}
			
			int sum = 0;
			for (int i = 1; i < 9; i++) {
				sum +=nums[i];
			}
			
			// int에 1.0을 곱해주어 double로 묵시적 형변환을 시켜준다.
			// Math.round 로 소수점 첫째자리에서 반올림하거나, 다른 소수점 자리에서 반올림이 필요할 경우
			// String.format("%.0f", 숫자); 를 이용한다.
			System.out.println("#"+(t+1)+" "+Math.round((sum*1.0/8*1.0)));
		
		}
		
	
		
		
	}

}
