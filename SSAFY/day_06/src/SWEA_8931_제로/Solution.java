package SWEA_8931_제로;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int k = 1; k <= TC; k++) {
			
			int K = sc.nextInt();
			List<Integer> stack = new ArrayList<>();
			
			for (int i = 0; i < K; i++) {
				//0일때는 지울 수 있는 수가 있음이 보장되므로
				int input = sc.nextInt();
				if (input != 0) {
					stack.add(input);
				} else {
					stack.remove(stack.size()-1);
				}

			}
			
			int sum = 0;
			for (int i : stack) {
				sum += i;
			}
			
			
			
			System.out.printf("#%d %d\n",k,sum);
			

		}
		
	}

}
