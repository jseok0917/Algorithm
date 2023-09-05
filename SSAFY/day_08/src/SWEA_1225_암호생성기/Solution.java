package SWEA_1225_암호생성기;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		//배열을 통해 큐를 구현하지않고,
		//그냥 ArrayList를 큐처럼 사용
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt();
			ArrayList<Integer> nums = new ArrayList<>();
			
			for (int i = 0; i < 8; i++) {
				nums.add(sc.nextInt());
			}
			
			
		f1:	while (true) {
				//한싸이클은 5번
				//최대 5까지만 뺄 수 있고,
				//입력 숫자값이 10이상 차이나면 8자리가 될 수가 없는데,
				//이런 부분을 좀 문제 조건에서 명확하게 말해주면 좋겠다.
				for (int i = 1; i <= 5; i++) {
					//1을 뺀후 뒤로 복사
					//복사할 때 0보다 크면 그냥 넣고, 0보다 작아지면 0을 넣고 while문을 종료
					if (nums.get(0)-i > 0) {
						nums.add(nums.get(0)-i);
						//가장 앞에 있는 놈을 제거
						nums.remove(0);
					} else {
						nums.add(0);
						nums.remove(0);
						break f1;
					}
				}
				
				
			}
			
			System.out.print("#"+tc);
			for (int i : nums) {
				System.out.printf(" %d", i);
			}
			System.out.println();
			
			
		}
		

		
	}

}
