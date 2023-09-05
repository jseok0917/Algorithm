package SWEA_18630_스켜끄;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//스위치의 개수 입력
		int N = sc.nextInt();
		
		//스위치
		int[] input = new int[N];
		swtch = input;
		
		//스위치 상태 입력
		for (int i = 0; i < N; i++) {
			swtch[i] = sc.nextInt();
		}
		
		//학생 숫자 입력
		int M = sc.nextInt();
		
		for (int i = 0; i < M; i++) {
			//학생의 성별 입력
			int gender = sc.nextInt();
			//학생이 들어야할 명령
			int command = sc.nextInt();
			
			switch (gender) {
			case 1:
				for (int j = 0; j < N; j++) {
				//index가 j이면 j+1번째를 의미
				//남학생의 경우:
				//j+1번째가 command의 배수이면
				//상태를 바꾸기
					if ((j+1)%command == 0) {
						changeSwitch(j);
					}
				}
				break;
			case 2:
				
				int k = 0;
				while (command-1-k >= 0 && command-1+k < N && swtch[command-1-k]==swtch[command-1+k]) {
				//상태를 바꾸기
				//command번째이면 index상으로는 command-1임
					//k=0일때는 한번만 바꾸자
					if (k == 0) {
						changeSwitch(command-1+k);
					} else {
						changeSwitch(command-1+k);
						changeSwitch(command-1-k);
					}
					k++;
					
				}
				
				break;
			}
			
			
		}
		
		for (int i : swtch) {
			System.out.print(i+" ");
		}
		
		
		
		
		
		
	}
	
	static int[] swtch;
	
	//j번째 스위치 상태변경 메서드
	public static void changeSwitch(int j) {
		if (swtch[j] == 1) {
			swtch[j] = 0;
		} else if (swtch[j] == 0) {
			swtch[j] = 1;
		}
		
	}
	
	

}
