package BOJ_9251_LCS;

import java.util.Arrays;

public class Main2 {
	
	static int start = 0;
	
	public static void main(String[] args) {
		
		int N = 3;
		int M = 5;
		
		int[][] arr = new int[N][M];
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = start++;
			}
		}
		
		for (int[] i : arr) {
			System.out.println(Arrays.toString(i));
		}
		
	}

}
