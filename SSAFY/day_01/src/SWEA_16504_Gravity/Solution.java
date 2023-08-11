package SWEA_16504_Gravity;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
		
			int N = sc.nextInt();
			int[] box_list = new int[N];
			
			//상자의 최대높이를 미리 구해놓는다
			int height = 0;
			
			for (int i = 0; i < N; i++) {
				
				int temp = sc.nextInt();
				box_list[i] = temp;
		
				if (height <= temp) {
					height = temp;
				}	
	
			}
			
//			System.out.println(height);
			
			
			
			//1층부터 최대 높이까지 순차적으로 올라가면서 
			//낙차를 구한다
			
			int max = 0;
			
			for (int i = 1; i <= height; i++) {
				
				int cnt = 0;;
				LinkedList<Integer> list = new LinkedList<>();
				
				//각 층수를 가지고 있는 박스의 index를 기록한다.
				//또한 박스의 개수또한 센다
				for (int j = 0; j < N; j++) {
					if (i <= box_list[j]) {		
						list.add(j);
						cnt++;
					}
					
					
				}
				
				//낙폭은 각 층이 존재하기 시작하는 박스의 index와 가로의 길이의 차,
				//그리고 상자의 개수에만 의존한다
				//가로의 길이 - index - 상자의 개수가 낙폭이 된다
				if (N - list.peekFirst() - cnt >= max) {
					max = N - list.peekFirst()-cnt;
				}
				 
	
		
			}
			
			System.out.println("#"+t+" "+max);
		}
		
	}

}
