import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
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
		
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (ground[i][j] == true) {
					cnt++;
				}
				
			}
		}
		
		System.out.println(cnt);
		
		
		
		
		
		
		
		
	}
}
