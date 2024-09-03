package BOJ_9251_LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] s1 = br.readLine().toCharArray();
		char[] s2 = br.readLine().toCharArray();
		
		//s1이 row
		//s2가 column
		int[][] dp = new int[s1.length+1][s2.length+1];
		
		//실제로 배열상에서는 i+1, j+1이 실제위치이고
		//String상에서는 i,j번째
		for (int i = 1; i <= s1.length; i++) {
			for (int j = 1; j <= s2.length; j++) {
				//현재문자를 사용하지 않았을 때 s1, s2 기준 이전문자까지의 lcs
				int LCS1 = dp[i-1][j-1];
				//s1과 s2의 각각의 현재위치(=i, j = 투포인터?)가 가리키는 문자가 동일하면 
				if (s1[i-1] == s2[j-1]) {
					LCS1++;
				}
				//현재문자를 사용했을 때(s1은 고정) s2에서 이전문자까지의 lcs,
				int LCS2 = dp[i-1][j];
				//s1의 이전 문자까지의 lcs, 현재 문자는 사용x
				int LCS3 = dp[i][j-1];
				
				int LCS = Math.max(LCS1, LCS2);
				LCS = Math.max(LCS, LCS3);
				dp[i][j] = LCS;
				
			}
		}
		
		System.out.println(dp[s1.length][s2.length]);
		
		
	}
	
}
