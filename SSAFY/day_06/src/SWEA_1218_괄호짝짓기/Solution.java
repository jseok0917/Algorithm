package SWEA_1218_괄호짝짓기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			String[] input = sc.next().split("");
			List<String> stack = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				stack.add(input[i]);
				mating(stack);
		
			}
			
			
			if (stack.isEmpty()) {
				System.out.printf("#%d %d\n",tc,1);
			} else {
				System.out.printf("#%d %d\n",tc,0);
			}
			
		
		
		
		
		}

		
	}
	
	
	//괄호짝짓기되는 순간 짝짓기 모두 될 때까지 아래작업 반복
	public static void mating(List<String> stack) {
		
		int S = stack.size();
		if (S == 0) {
			return;
		} else if (stack.get(S-1).equals("}") && S > 1) {
			if (stack.get(S-2).equals("{")) {
				stack.remove(S-1);
				stack.remove(S-2);
				mating(stack);
			}
		} else if (stack.get(S-1).equals("]") && S > 1) {
			if (stack.get(S-2).equals("[")) {
				stack.remove(S-1);
				stack.remove(S-2);
				mating(stack);
			}
		} else if (stack.get(S-1).equals(">") && S > 1) {
			if (stack.get(S-2).equals("<")) {
				stack.remove(S-1);
				stack.remove(S-2);
				mating(stack);
			}
		} else if (stack.get(S-1).equals(")") && S > 1) {
			if (stack.get(S-2).equals("(")) {
				stack.remove(S-1);
				stack.remove(S-2);
				mating(stack);
			}
		} else {
			return;
		}
		
		
		
	}
	
	

}
