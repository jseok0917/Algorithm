import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		boolean[][] ground = new boolean[100][100];
		
		for (int n = 0; n < num; n++) {
			
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			// 색종이 좌표 입력
			
			for (int i = x; i < x+10; i++) {
				for (int j = y; j < y+10; j++ ) {
					if (ground[i][j] == false) {
						ground[i][j] = true;
					}
					
				}
			}
		}
		
		// 상하좌우 1칸씩 여백을 더 추가한 이차원 배열 생성
		boolean[][] exground = new boolean[102][102];
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				exground[i+1][j+1] = ground[i][j];
				
			}
		}
		
		int cnt = 0;
		
		// 세로탐색
		for (int i = 1; i < 102; i++) {
			for (int j = 1; j < 102; j++) {
				if (exground[i][j] != exground[i][j-1]) {
					cnt++;
				}
				
			}
		}
		
		// 가로탐색
		for (int j = 1; j < 102; j++) {
			for (int i = 1; i < 102; i++) {
				if (exground[i][j] != exground[i-1][j]) {
					cnt++;
				}
				
			}
		}
		
		
		
		System.out.println(cnt);
		
		
		
		
		
		
		
		
	}
}
