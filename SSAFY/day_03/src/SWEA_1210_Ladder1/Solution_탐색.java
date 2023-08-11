package SWEA_1210_Ladder1;

import java.util.Scanner;

public class Solution_탐색 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 0; t < 10; t++) {
		
			int T =  sc.nextInt();
			sc.nextLine();
			
			//인덱스 문제 안생기게 좌우로 한칸 씩 늘려놓는다.
			int[][] ladder = new int[100][102];
			
			//입력 받기
			for (int i = 0; i < 100; i++) {
				for(int j = 1; j < 101; j++) {
					ladder[i][j] = sc.nextInt();
				}
			}
			
			//도착 지점 기록
			int arrival = 0;
			
			for (int j = 1; j < 101; j++) {
				if (ladder[99][j] == 2){
					arrival = j;
				}
			}
			
			//도착지점에서 출발하여 거꾸로 진행하는 것으로 생각
			
			//임의의 점이 주어졌을 때
			//그 점은 상, 좌, 우를 탐색하여 좌나 우가 있을경우 그쪽방향으로 진행하고
			//좌우가 없으면 위로만 가야한다
			//행 index가 0이 되면 반복문을 멈춰야한다.
			
			int n = arrival;
			int m = 99;
			
			while (m > 0) {
				
				if (ladder[m][n-1] == 1) {
					while (ladder[m][n-1] == 1) {
						n--;
					}
				} else if (ladder[m][n+1] == 1) {	
					while (ladder[m][n+1] == 1) {
						n++;
					}
				}
				
				m--;
			}
			
			System.out.printf("#%d %d", t+1, n-1);
			System.out.println();
		
		
		
		}
		
		
	}

}
