import java.util.Scanner;

public class Main {
	
	//N이하의 숫자
	static int N;
	
	//K개의 숫자의 합으로 N을 만들어야함
	static int K;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		int[][] dp = new int[K+1][N+1];
		
		//1개를 사용해서 각 숫자를 만드는 경우의 수는 반드시 1가지
		for (int i = 0; i <= N; i++) {
			dp[1][i] = 1;
		}
		
		for (int k = 2; k <= K; k++) {
			for (int n = 0; n <= N; n++) {
				for (int i = 0; i <= n; i++) {
					dp[k][n] += dp[k-1][i];
					if (dp[k][n] >= 1000000000) {
						dp[k][n] = dp[k][n]%1000000000; 
					}
				}
			}
		}
		
		System.out.println(dp[K][N]);
		
		
		
		
	}
	

}
