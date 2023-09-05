package SWEA_벌통;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class TEST {
	public static void main(String[] args) {
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(3, 5);
		map.put(3, 7);
		map.put(3, 9);
		
		System.out.println(map.toString());
		
		M = 3;
		C = 10;
		dp = new int[M+1][C+1];
		
		int[] A = {5, 5, 7};
		
		System.out.println(maxProfit(A));
		for (int[] i : dp) {
			System.out.println(Arrays.toString(i));
		}
		
	}
	
	//최대수익을 구하는 메서드 생성
	//DP알고리즘을 사용하기 위한 이중배열 생성
	static int M;
	static int C;	
	static int[][] dp;
	
	public static int maxProfit(int[] list) {
		//배낭알고리즘을 이용한다.

		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= C; j++) {
				//i번째 개수를 배낭크기 j에넣을 수 없으면 
				//이중배열의 바로 윗행에서 element를 가져온다
				if (j < list[i-1]) {
					dp[i][j] = dp[i-1][j];
				} else {
				//i번째 개수를 배낭크기 j에 넣을 수 있다면
				//넣었을 때의 값과, 넣지 않았을 때의 값을 비교하여
				//큰 값을 넣는다.
					//넣었을 때의 값
					int A = dp[i-1][j-list[i-1]] + list[i-1]*list[i-1];
					//넣지 않았을 때의 값
					int B = dp[i-1][j];
					if (A > B) {
						dp[i][j] = A;
					} else {
						dp[i][j] = B;
					}
					
				}
				
				
			}
		}

		return dp[M][C];
	}

}
