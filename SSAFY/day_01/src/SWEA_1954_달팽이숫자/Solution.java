package SWEA_1954_달팽이숫자;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		//입력할 달팽이판
		int[][] grd = new int[N][N];
		
		
		//각 행과 열을 이동할때마다 입력할 숫자 카운트
		int cnt = 1;
		
		
		//첫 시작은 [0][0] 에서 시작하므로
		int i = 0;
		int j = 0;
		
		//주어진 N값에 대하여
		//숫자는 총 2N-1번 ground의 각 행 또는 열을 순회하고
		//첫 순회는 동쪽, 두번째는 남쪽, 세번째는 서쪽, 네번째는 북쪽, 5번째부터는 기존 순회 순서가 반복되므로
		//4로 나눈 나머지가 0번째인 순회는 반드시 동쪽으로 순회하도록
		//1번째인 순회는 남쪽으로
		//2번째인 순회는 서쪽으로
		//3번째인 순회는 북쪽으로 순회하도록 코드를 작성한다
		for (int n = 0; n < 2*N-1; n++) {
		
			while (n%4 == 0) {
				
				grd[i][j] = cnt;
				cnt++;
				j++;
				
				if (j >= N) {
					j--;
					cnt--;
					break;
					
				} else if (grd[i][j] != 0) {
					j--;
					cnt--;
					break;	
				}
				
				
			}
			
			while (n%4 == 1) {
				
				grd[i][j] = cnt;
				cnt++;
				i++;
				
				if (i >= N) {
					i--;
					cnt--;
					break;
					
				} else if (grd[i][j] != 0) {
					i--;
					cnt--;
					break;	
				}
				
			}
			
			while (n%4 == 2) {
				
				grd[i][j] = cnt;
				cnt++;
				j--;
				
				if (j < 0) {
					j++;
					cnt--;
					break;
					
				} else if (grd[i][j] != 0) {
					j++;
					cnt--;
					break;	
				}
				
				
			}
			
			while (n%4 == 3) {
				
				grd[i][j] = cnt;
				cnt++;
				i--;
				
				if (i < 0) {
					i++;
					cnt--;
					break;
					
				} else if (grd[i][j] != 0) {
					i++;
					cnt--;
					break;	
				}
				
				
			}

			
		}
		
		for (int k = 0; k < N; k++) {
			
			for (int m = 0; m < N; m++) {
				
				System.out.print(grd[k][m]+" ");
				
			}
			
			System.out.print("\n");
			
		}
		
		
		
	}

}
