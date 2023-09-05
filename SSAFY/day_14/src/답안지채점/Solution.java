package 답안지채점;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테스트케이스 입력
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			//학생수
			int N = sc.nextInt();
			//문제수
			int M = sc.nextInt();
			
			//정답 입력
			int[] answer = new int[M];
			for (int i = 0; i < M; i++) {
				answer[i] = sc.nextInt();
			}
			
			//성적 최솟값 최댓값 판별을 위한 변수 생성
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			//학생 수만큼 답안지 채점
			for (int n = 0; n < N; n++) {
				//각 답안지마다 m개의 문제 채점
				//채점을 위한 cnt 생성
				int cnt = 0;
				//각 학생의 점수를 판단하기 위한 변수 생성
				int sum = 0;
				for (int m = 0; m < M; m++) {
					//맞거나 틀리거나 둘 중 하나
					//정답이면
					int choice = sc.nextInt();
					
					if (choice == answer[m]) {
						sum += ++cnt;
					//정답이 아니면
					//카운트를 초기화한다.
					} else {
						cnt = 0;
					}
					
				}
				//채점 후에 최소인지 최대인지 판단.
				if (sum < min) {
					min = sum;
				}
				
				if (sum > max) {
					max = sum;
				}

			}
			
			//최댓값과 최솟값의 차이 출력
			System.out.printf("#%d %d\n",tc,max - min);
			
			
		}
		
		
		
	}

}
