import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			
			int T = sc.nextInt();
			char[][] plate = new char[100][100];
			
			for (int i = 0; i < 100; i++) {
				String input = sc.next();
				for (int j = 0; j < 100; j++) {
					plate[i][j] = input.charAt(j);
				}
	
			}
			//여기까지 입력
			//회문의 최대길이는 100이므로
			//100의 길이부터 시작해서 회문을 찾으면 바로 종료
			
			int Lmax = 0;
			
			//회문의 길이 100일때부터 
		f0:	for (int l = 100; l > 0; l--) {
				
				//행부터
				for (int i = 0; i < 100; i++) {
					//시작점 설정
					for (int j = 0; j <= 100-l; j++) {
						//회문검사
						for (int k = 0; k <= (l-1)/2; k++) {
							if (plate[i][j+k] != plate[i][j+l-1-k]) {
								break;
							}
							
							//회문을 찾으면 바로 반복문을 종료한다.
							if (k == (l-1)/2) {
								Lmax = l;
								break f0;
							}
							
						}
						
					}
				}
			
				
			
				for (int j = 0; j < 100; j++) {
					//시작점 설정
					for (int i = 0; i <= 100-l; i++) {
						//회문검사
						for (int k = 0; k <= (l-1)/2; k++) {
							if (plate[i+k][j] != plate[i+l-1-k][j]) {
								break;
							}
							
							if (k == (l-1)/2) {
								Lmax = l;
								break f0;
							}
							
						}
						
					}
				}
				
					
	
			}
			
			System.out.printf("#%d %d\n", t, Lmax);
			
			
			
			
			
			
		}
		
		
	}

}
