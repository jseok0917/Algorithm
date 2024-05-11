import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] W = new int[N];		
		int[] V = new int[N];
		
		//무게와 가치 입력
		for (int i = 0; i < N; i++) {
			W[i] = sc.nextInt();
			V[i] = sc.nextInt();
		}
		
		int[][] dp = new int[N+1][K+1];
		for (int i = 1; i <= N; i++) {
			//i번째 물건의 무게와 가치
			int w = W[i-1];
			int v = V[i-1];
			
			for (int j = 0; j <= K; j++) {
				//i번째 물건을 담을 수 있다면
				if (j >= w) {
					if (dp[i-1][j] < (dp[i-1][j-w] + v)) {
						dp[i][j] = (dp[i-1][j-w] + v);
					} else {
						dp[i][j] = dp[i-1][j];
					}
				//i번째 물건을 담을 수 없다면
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}	
		}
		
		System.out.println(dp[N][K]);
		
		
	}

}
