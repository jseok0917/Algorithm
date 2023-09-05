package SWEA_1213_String;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();
			String searchWord = sc.next();
			String input = sc.next();
			int L = searchWord.length();
			int N = input.length();
			
			//주어진 단어를 세줄 카운터
			int cnt = 0;;
			
			for (int i = 0; i < N-L+1; i++) {
				if (input.substring(i, i+L).equals(searchWord)) {
					cnt++;
				}
			}
			
			System.out.printf("#%d %d\n", t, cnt);
			
			
			
		}

	}

}
