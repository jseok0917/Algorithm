package SWEA_5432_쇠막대기자르기;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		
		for (int tc = 1; tc <= TC; tc++) {
			String[] input = sc.next().split("");
			List<String> stack = new ArrayList<>();
			
			for (int i = 0; i < input.length; i++) {
				stack.add(input[i]);
				mating(stack);
			}
			
			System.out.printf("#%d %d\n",tc, sum);
			sum = 0;
			isRazer = true;
			
		}
		
		
		
	}
	
	//짝짓기가 된 바로 직 후에 또 mating이 된다면 +1
	//짝짓기가 됐을 때, 바로 직전에 pop을 한 상황이 아니었다면 그 땐 stack의 사이즈를 출력
	//레이저로 자르는 건지, 아니면 레이저로 자른 후에 남은 조각을 세는건지를 위와같이 구분해주어야한다.
	static int sum = 0;
	static boolean isRazer = true;
	
	public static void mating(List<String> stack) {
		
		int S = stack.size();
		
		//인덱스 에러를 피하기 위해 if문 안에 if문을 넣는 방식으로
		if (stack.isEmpty()) {
			isRazer = true;
			return;
		} else if (stack.get(S-1).equals(")")) {
			if (stack.get(S-2).equals("(")) {
				if (isRazer == true) {
					stack.remove(S-1);
					stack.remove(S-2);
					sum += stack.size();
					//한번 레이저를 만나면 레이저 판독기 false
					isRazer = false;
				} else {
					stack.remove(S-1);
					stack.remove(S-2);
					sum++;
				}
			}
		} else {
			//한번 레이저했다가 직후 바로 Pop이 되는게 아니라면
			//레이저 판별기 초기화
			isRazer = true;
			return;
		}
		
		
	}

}
