package BOJ_13448_SW역량테스트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
	//Dp + 조합
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
		sortM = new int[N+1];
		sortP = new int[N+1];
		sortR = new int[N+1];
		//병합정렬을 통한 내림차순 정렬을 위해
		//arr배열 추가
		int[] arr = new int[N+1];
		
		String[] inputM = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			M[i] = Integer.parseInt(inputM[i-1]);
		}
		
		String[] inputP = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			P[i] = Integer.parseInt(inputP[i-1]);
			arr[i] = P[i];
		}
		
		String[] inputR = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			R[i] = Integer.parseInt(inputR[i-1]);
		}
		
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(M));
		System.out.println(Arrays.toString(P));
		System.out.println(Arrays.toString(R));
		mergeSort(arr, 1, N);
		System.out.println(Arrays.toString(sortM));
		System.out.println(Arrays.toString(sortP));
		System.out.println(Arrays.toString(sortR));
		
		//DP알고리즘 구현
//		int[][] dp = new int[N+1][T+1];
//		
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= T; j++) {
//				//M값은 중요하지 않다.
//				//일단 풀 시간이 없으면 그냥 받아온다.
//				if (R[j] > j) {
//					dp[i][j] = dp[i-1][j];
//				} else {
//					
//					Math.max(dp[i-1][j], dp[i-1][j-R[i]]+);
//					
//				}
//				
//				
//			}
//		}
//		
		
		
	
		
		
	}
	
	static int[] M;
	static int[] P;
	static int[] R;
	static int[] sortM;
	static int[] sortP;
	static int[] sortR;
	
	//병합 정렬을 구현한다.
	//오름차순으로 구현한다.
	public static void mergeSort(int[] arr, int L, int R) {
		
		if (L < R) {
			
			int mid = (L+R)/2;
			
			mergeSort(arr, L, mid);
			mergeSort(arr, mid+1, R);
			merge(arr, L, R, mid);
			
		}
		
	}
	
	public static void merge(int[] arr, int left, int right, int mid) {
		
		int idx = left;
		int l = left;
		int r = mid+1;
		
		while (l < mid+1 && r < right+1) {
			if (arr[l] >= arr[r]) {
				//내림차순이므로 이 때는 그대로간다
				sortP[idx] = P[l];
				sortM[idx] = M[l];
				sortR[idx] = R[l];
				idx++;
				l++;
				
			} else {
				//이거는 바꿔치기
				sortP[idx] = P[r];
				sortM[idx] = M[r];
				sortR[idx] = R[r];
				idx++;
				r++;
			}
		}
		
		if (l < mid+1) {
			while (l != mid +1) {
				sortP[idx] = P[l];
				sortM[idx] = M[l];
				sortR[idx] = R[l];
				idx++;
				l++;
				
			}
			
		} else if (r < right+1) {
			while (r < right+1) {
				sortP[idx] = P[r];
				sortM[idx] = M[r];
				sortR[idx] = R[r];
				idx++;
				r++;
				
			}
		}
		
		for (int i = 1; i < right+1; i++) {
			arr[i] = sortP[i];
		}
		
		System.out.println("실험용"+Arrays.toString(arr));
		
		
		
	}


}
