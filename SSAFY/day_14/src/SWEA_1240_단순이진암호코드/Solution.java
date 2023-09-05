package SWEA_1240_단순이진암호코드;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			//입력을 받을 배열 생성
			//char로 받는다.
			char[][] chars = new char[N][M];
			int crypRow = 0;
			int crypCol = 0;
			
			for (int i = 0; i < N; i++) {
				String input = sc.next();
				
				for (int j = 0; j < M; j++) {
					chars[i][j] = input.charAt(j);
					//1이 존재하는 마지막 행과 열을 저장해놓는다.
					//비트연산자 이용
					if (((chars[i][j]-48) & 1) == 1) {
						crypRow = i;
						crypCol = j;
					}
				}
				
			}
			
			//마지막 문자에서 거꾸로 7개씩 읽어나가며 암호문을 해독한다.
			int[] plain = new int[8];
			int cnt = 0;
			for (int i = 0; i < 8; i++) {
				String sum = "";
				for (int j = 0; j < 7; j++) {
					sum += chars[crypRow][crypCol-cnt]+"";
					cnt++;
				}
				plain[i] = crypToPlain(sum);
			}
			
			
			
			int A = 0;
			int B = 0;
			//홀수번째 자리수의 합을 구한다.
			//짝수번째 자리수의 합을 구한다.
			for (int i = 7; i >= 0; i--) {
				if (i%2 == 1) {
					//홀수번째 자리수의 합
					A += plain[i];
				} else {
					//짝수번째 자리수의 합
					B += plain[i];
				}
			}
			
			if ((A*3+B)%10 == 0) {
				System.out.printf("#%d %d\n", tc, A+B);
			} else {
				System.out.printf("#%d %d\n", tc, 0);
			}
			
			
			
		}
		
		
	}
	static int crypToPlain(String input) {
		switch (input) {
		case "1011000" :
			return 0;
		case "1001100" :
			return 1;
		case "1100100" :
			return 2;
		case "1011110" :
			return 3;
		case "1100010" :
			return 4;
		case "1000110" :
			return 5;
		case "1111010" :
			return 6;
		case "1101110" :
			return 7;
		case "1110110" :
			return 8;
		case "1101000" :
			return 9;
		default : 
			return -1;
		}
		
	}
	
	
	static char[] stack = new char[56];
	//front는 마지막에 넣은 위치
	static int front = -1;
	
	public static boolean isEmpty() {
		return front == -1;
	}
	
	public static void add(char item) {
		stack[++front] = item;
	}
	
	public static char pop() {
		if (isEmpty()) {
			//null값을 의미하는 0
			return 0;
		} else {
			return stack[front--];
		}
		
		
	}
	
	

}
