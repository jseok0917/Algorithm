package SWEA_1989_초심자의회문검사;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			String input = sc.next();
			int L = input.length();
			
			for (int i = 0; i <= (L-1)/2; i++) {
				
				if (input.charAt(i) != input.charAt(L-1-i)) {
					System.out.printf("#%d %d\n", t, 0);
					break;
				} 
				
				if (i == (L-1)/2) {
					System.out.printf("#%d %d\n", t, 1);
				}
				
				
			}
			
			
			
		}
		
		
	}

}
