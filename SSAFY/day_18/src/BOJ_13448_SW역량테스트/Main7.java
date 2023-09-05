package BOJ_13448_SW역량테스트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main7 {
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
		
		M = new int[N+1];
		P = new int[N+1];
		R = new int[N+1];
		
		String[] inputM = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			M[i] = Integer.parseInt(inputM[i-1]);
		}
		
		String[] inputP = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			P[i] = Integer.parseInt(inputP[i-1]);
		}
		
		String[] inputR = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			R[i] = Integer.parseInt(inputR[i-1]);
		}
		
		System.out.println(Arrays.toString(M));
		System.out.println(Arrays.toString(P));
		System.out.println(Arrays.toString(R));
		
		//P/R값을 기준으로 각 배열들을 내림차순으로 조정한다.
		//선택정렬을 사용한다.
		for (int i = 1; i <= N; i++) {
			long maxP = P[i];
			long maxR = R[i];
			int idx = i;
			for (int j = i+1; j <= N; j++) {
				if (maxP*R[j] < maxR*P[j]) {
					maxP = P[j];
					maxR = R[j];
					idx = j;
				}
			}
			System.out.println("idx값 "+idx+" ");
			System.out.println("idx값에서 p/r값 "+P[idx]*1.0/R[idx]+" ");
			
			
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
		System.out.println("정렬 후");
		for (int i = 1; i <= N; i++) {
			System.out.print(P[i]*1.0/R[i]*1.0+" ");
		}
		System.out.println();
		System.out.println(Arrays.toString(M));
		System.out.println(Arrays.toString(P));
		System.out.println(Arrays.toString(R));
		
		
		//DP알고리즘 구현
		long[][] dp = new long[N+1][T+1];
		int[][] timeSum = new int[N+1][T+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= T; j++) {
				//M값은 중요하지 않다.
				//일단 풀 시간이 없으면 그냥 받아온다.
				if (R[i] > j) {
					dp[i][j] = dp[i-1][j];
					timeSum[i][j] = timeSum[i-1][j];
				} else {  
					int t = timeSum[i-1][j-R[i]];
					long temp = dp[i-1][j-R[i]]+M[i]-((long) (t+R[i])*P[i]);
					if (dp[i-1][j] < temp) {
						dp[i][j] = temp;
						timeSum[i][j] = timeSum[i-1][j-R[i]]+R[i];
					} else {
						dp[i][j] = dp[i-1][j];
						timeSum[i][j] = timeSum[i-1][j];
					}
					
				}
				
				
			}
		}
		
		for (long[] i : dp) {
			System.out.println(Arrays.toString(i));
		}
		
		System.out.println("============timeSum==========");
		for (int[] i : timeSum) {
			System.out.println(Arrays.toString(i));
		}
		
		System.out.println(dp[N][T]);
		
		
		
	
		
		
	}
	
	static int[] M;
	static int[] P;
	static int[] R;

	




}
