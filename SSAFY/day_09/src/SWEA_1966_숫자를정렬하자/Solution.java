package SWEA_1966_숫자를정렬하자;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		//삽입정렬을 이용하자.
		Scanner sc = new Scanner(System.in);
		//테스트케이스
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			//입력 숫자
			int N = sc.nextInt();
			
			//삽입 정렬을 위한 배열 생성
			int[] nums = new int[N];
			
			//첫 원소는 일단 넣어놓는다.
			nums[0] = sc.nextInt();
			
			//삽입 정렬을 구현
			for (int i = 1; i < N; i++) {
				//삽입할 숫자 입력
				int input = sc.nextInt();
				//삽입할 곳을 찾기위한 인덱스값 선언
				int j = i;
				//오름차순 정렬을 할 것이다.
				//삽입할 숫자가 바로 앞의 숫자보다 작다면
				//바로 앞의 숫자를 뒤로 밀고,
				//삽입할 숫자의 인덱스를 앞으로 한 칸 당겨야 한다.
				
				//주의해야될 문제인게
				//nums[j-1] 인덱스 문제를 처리하기 위해
				//j > 0이라는 조건을 주었는데
				//nums[j-1]조건문을 앞에 주는 경우
				//j = 0일 때 j > 0조건을 먼저 판정하는 게 아니라 
				//nums[j-1] 조건을 먼저 판정하여 인덱스범위가 벗어났다는 에러가 뜬다.
				while (j > 0 && input < nums[j-1]) {
					//삽입할 위치를 찾음과 동시에
					//뒤로 밀어버리는 작업을 진행한다.
					nums[j] = nums[j-1];
					j--;
				}
				//while문은 input이 바로 앞의 숫자보다 크거나 같으면 멈추기 때문에
				//(또는, 앞의 숫자가 존재하지 않아도 멈춘다.)
				//(순서대로 정렬을 받고, 뒤에서부터 삽입하므로 중복값의 앞뒤순서가 유지된다.)
				//안정정렬이 되고, 곧 삽입해야할 위치이다.
				nums[j] = input;
				
			}
			
			System.out.print("#"+tc);
			for (int i = 0; i < N; i++) {
				System.out.print(" "+nums[i]);
			}
			System.out.println();

		}
		
		
		
	}

}
