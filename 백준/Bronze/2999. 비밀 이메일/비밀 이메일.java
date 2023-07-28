import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		char[] input_list = input.toCharArray();
		int N = input_list.length;
		int R = 1;
		int C = N;
		int[] R_list = new int[N];
		int cnt = 0;
		
		for (int i = 1; i <= N; i++) {
			
			if (N%i == 0) {
				R = i;
				R_list[cnt] = R;
				C = N/R;
				if (C < R) {
					R = R_list[cnt-1];
					C = N/R;
					break;
				}
				cnt++;
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = i; j < N; j+=R) {
				System.out.print(input_list[j]);
			}
			
		}
		
		
		
		
		
	}
}
