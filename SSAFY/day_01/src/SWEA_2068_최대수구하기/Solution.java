package SWEA_2068_최대수구하기;

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
			
			System.out.println("#"+(t+1)+" "+nums[9]);
		
		}
		
		

		
	}

}
