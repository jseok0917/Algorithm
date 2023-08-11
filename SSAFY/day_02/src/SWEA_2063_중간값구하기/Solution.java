package SWEA_2063_중간값구하기;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		
		int[] nums = new int[N];
		
		for (int i = 0; i < N; i++) {
			
			nums[i] = sc.nextInt();
			
		}
		
		
		for (int i = 0; i < (N+1)/2; i++) {
			
			//인덱스 초기값 i로 지정
			int minIdx = i;
			int min = Integer.MAX_VALUE;
			
			for (int j = i; j < N; j++) {
				if (min > nums[j]) {
					minIdx = j;
					min = nums[j];
				}
			}
			
			//선택정렬은 minIdx를 이용해 구현한다.
			int temp = nums[i];
			nums[i] = nums[minIdx];
			nums[minIdx] = temp;
//			System.out.print(nums[i]+" ");
			
		}
		
		System.out.println(nums[(N-1)/2]);
		
		
	}

}
