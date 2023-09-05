package SWEA_1215_회문1;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		//테스트케이스별
		for (int t = 1; t <= 10; t++) {
			//찾아야하는 회문의 길이
			int L = sc.nextInt();
			
			
			char[][] input = new char[8][8];
			
			//글자판 입력
			for (int i = 0; i < 8; i++) {
				String inputLine = sc.next();
				for (int j = 0; j < 8; j++) {
					input[i][j] = inputLine.charAt(j);
				}
				
			}
			
			
			//회문개수 카운트
			int cnt = 0;
			
			
			
			//행방향
			for (int i = 0; i < 8; i++) {
				
				//시작점 설정
				for (int j = 0; j <= 8-L; j++) {
					
					//회문 확인
					for (int k = 0; k <= (L-1)/2; k++) {
						if (input[i][j+k] != input[i][j+L-1-k]) {
							break;
						}
						
						if (k == (L-1)/2) {
							cnt++;
						}
						
						
					}

				}
			}
			
			//열방향
			for (int j = 0; j < 8; j++) {
				//시작점 설정
				for (int i = 0; i <= 8-L; i++) {
					
					//회문 확인
					for (int k = 0; k <= (L-1)/2; k++) {

						if (input[i+k][j] != input[i+L-1-k][j]) {
							break;
						}
						
						if (k == (L-1)/2) {
							cnt++;
						}
						
						
					}

				}
				
			}
			
			System.out.printf("#%d %d\n",t, cnt);

		}
		
		
		
		
	}

}
