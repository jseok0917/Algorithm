package SWEA_1206_View;

import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//테스트케이스 10개
		
		for (int n = 1; n < 11; n++) {
		
			//건물의 개수
			int N = sc.nextInt();
			
			//높이 리스트
			int[] h_list = new int[N]; 
			
			//높이들을 입력받아 높이 리스트에 넣는다
			for (int i = 0; i < N; i++) {
				
				h_list[i] = sc.nextInt();
				
			}
			
			//조망권 존재여부
			int cnt = 0;
			
			
			
			for (int i = 2; i < N-2; i++) {
				
				//i층이 양쪽 2개층사이에서 가장 높은 층일 때만 조망권이 확보되고,
				//이때 i층과 양 옆 2개층 중에서 가장 높은 층 사이의 층 수 차이를
				//min으로 넣는다.
				//여기서 i가 돌때마다 min은 초기화되어야하므로  for문안에 선언해준다
				int min = Integer.MAX_VALUE;
				if (h_list[i-1] < h_list[i] && h_list[i-2] < h_list[i] && h_list[i+1] < h_list[i] && h_list[i+2] < h_list[i]) {
					
					for (int j = 1; j < 3; j++) {
						
						if (h_list[i] - h_list[i-j] < min) {
							min = h_list[i] - h_list[i-j];
						}
						
						if (h_list[i] - h_list[i+j] < min) {
							min = h_list[i] - h_list[i+j];
						}
						
						
					}
					
					cnt+=min;
					
					//확인용
	//				System.out.print(h_list[i]+" "); 
	//				System.out.print(min+" ");
	//				System.out.print(cnt+" ");
					
				}
				
				
			}
			
			System.out.println("#"+n+" "+cnt);
			
			
			
			
			
		}
	}

}
