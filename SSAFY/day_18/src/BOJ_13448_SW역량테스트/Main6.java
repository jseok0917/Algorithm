package BOJ_13448_SW역량테스트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main6 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		

		String[] input = br.readLine().split(" ");
		//문제의 개수 입력
		int N = Integer.parseInt(input[0]);
		//주어진 시간
		int T = Integer.parseInt(input[1]);
		
		//i번 문제에 할당된 점수 M
		//i번 문제 분당 차감 점수 P
		//i번 문제를 푸는데 걸리는 시간 R
		
		M = new int[N];
		P = new int[N];
		R = new int[N];
		
		String[] inputM = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			M[i] = Integer.parseInt(inputM[i]);
		}
		
		String[] inputP = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(inputP[i]);
		}
		
		String[] inputR = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			R[i] = Integer.parseInt(inputR[i]);
		}
		
		
		//P/R값을 기준으로 각 배열들을 내림차순으로 조정한다.
		//선택정렬을 사용한다.
		for (int i = 0; i < N; i++) {
			long maxP = P[i];
			long maxR = R[i];
			int idx = i;
			for (int j = i+1; j < N; j++) {
				if (maxP*R[j] < maxR*P[j]) {
					maxP = P[j];
					maxR = R[j];
					idx = j;
				}
			}
			
			
			int tempP = P[i];
			int tempM = M[i];
			int tempR = R[i];
			P[i] = P[idx];
			M[i] = M[idx];
			R[i] = R[idx];
			P[idx] = tempP; 
			M[idx] = tempM; 
			R[idx] = tempR; 
			
		}

		
		
		//DP알고리즘 구현
		long[][] dp = new long[N+1][T+1];
		int[][] timeSum = new int[N+1][T+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= T; j++) {
				//M값은 중요하지 않다.
				//일단 풀 시간이 없으면 그냥 받아온다.
				if (R[i-1] > j) {
					dp[i][j] = dp[i-1][j];
					timeSum[i][j] = timeSum[i-1][j];
				} else {  
					int t = timeSum[i-1][j-R[i-1]];
					long temp = dp[i-1][j-R[i-1]]+M[i-1]-((long) (t+R[i-1])*P[i-1]);
					
					//dp 알고리즘을 구현할때
					//위쪽에서만 비교하는 것이 아니라, 바로 옆의 값과도 비교를 해주어야 한다.
					if (dp[i-1][j] < temp) {
						if (temp < dp[i][j-1]) {
							dp[i][j] = dp[i][j-1];
							timeSum[i][j] = timeSum[i][j-1];
						} else {
							dp[i][j] = temp;
							timeSum[i][j] = timeSum[i-1][j-R[i-1]]+R[i-1];
						}
					} else {
						if (dp[i-1][j] < dp[i][j-1]) {
							dp[i][j] = dp[i][j-1];
							timeSum[i][j] = timeSum[i][j-1];
						} else {
							dp[i][j] = dp[i-1][j];
							timeSum[i][j] = timeSum[i-1][j];
						}
					}
					
				}
				
				
			}
		}
		
		System.out.println(dp[N][T]);
		
		
		
	
		
		
	}
	
	static int[] M;
	static int[] P;
	static int[] R;

	




}
