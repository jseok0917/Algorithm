import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	
	//달별 요일수 입력
	static int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int month1 = sc.nextInt();
			int day1 = sc.nextInt();
			int month2 = sc.nextInt();
			int day2 = sc.nextInt();
			
			//며칠째인지 계산할 변수 선언
			int sum = 0;
			
			for (int i = month1; i < month2; i++) {
				sum += months[i];
			}
			
			sum = sum - day1 + day2 + 1;
			
			System.out.printf("#%d %d\n",tc,sum);
			
			
			
		}
		
		
		
		
		
	}
}