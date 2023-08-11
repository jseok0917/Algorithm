package SWEA_1954_달팽이숫자;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_재귀버전 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int Tcase = sc.nextInt();
		
		for (int t = 1; t <= Tcase; t++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			
			//변의 길이 N으로 출발한 배열 map
			//시작 숫자 1
			//시작 좌표 (0,0)
			//달팽이 출바아아아아알~
			snail(N,1, map, 0, 0);
			
			//확인용
//			for (int[] i : map) {
//				System.out.println(Arrays.toString(i));
//			}
			
			System.out.printf("#%d\n", t);
			for (int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(map[i][j]+" ");
				}
				
				System.out.println();
			}
			
			
		}

	}
	
	
	
	
	//N은 처음 주어진 배열의 크기
	//r과 c는 시작점의 좌표
	//arr는 주어진 2차원 배열
	//start 순회할 숫자
	public static void snail(int N, int start, int[][] map, int r, int c) {
		
		if (N == 1) {
			map[r][c] = start;
			return;

		} else if (N == 2){
			map[r][c++] = start++;
			map[r++][c] = start++;
			map[r][c--] = start++;
			map[r][c] = start++;
			return;

		} else {
		//N이 3이상일 때
		//우측으로 쭉 적고
		//아래쪽으로 쭉 적고
		//좌측으로 쭉 적고
		//위쪽으로 쭉 적는다.
			
			
			
			
			//우측 쫘아아아아아아악
			int i = 0;
			while (i < N) {		
				map[r][c+i] = start++;
				i++;
			}
			
			//열좌표 고정 하기 위해서
			i--;
			c = c+i;
			
			//아래로 쫘아아아아악
			i = 1;
			while (i < N) {
				map[r+i][c] = start++;
				i++;
			}
			
			//행좌표 고정하기 위해서
			i--;
			r = r+i;



			//왼쪽으로 쫘악
			i = 1;
			while (i < N) {
				map[r][c-i] = start++;
				i++;
			}
			//열좌표 고정
			i--;
			c = c-i;

			
			


			//이건 시작지점이 (0, 0)이라는 가정하에 작성하는 것임
			//인덱스 범위를 N-1로 하는 이유
			//위로 쫘아악
			i = 1;
			while (i < N-1) {
				map[r-i][c] = start++;
				i++;
			}
			//행좌표 고정
			i--;
			r = r-i;
			
			//출발점 설정
			c++;

			
			//재귀를 하려면 반복할때마다 N값을 2만큼 줄여아한다.
			N = N-2;
			
			snail(N,start, map, r, c);
			
		}
		
	}

}
