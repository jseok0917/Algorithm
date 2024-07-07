package BOJ_2512_예산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, min, max;
	static int[] reqBudget;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//지방의 수
		N = Integer.parseInt(br.readLine());
		
		//지방의 예산 요청
		reqBudget = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		//예산 요청 담기
		for (int i = 0; i < N; i++) {
			reqBudget[i] = Integer.parseInt(st.nextToken());
			if (max < reqBudget[i]) {
				max = reqBudget[i];
			}
		}
		
		//총 예산
		int M = Integer.parseInt(br.readLine());
		
		//Upper Bound를 이용한다.
		//범위를 예산요청의 최솟값과 최댓값으로 잡아버리면
		//아예 배정자체를 못하는 경우가 생길 수도 있다.
		min = 0;
		max = max+1;
		int mid = 0;
		while (min < max) {			
			mid = (min+max)/2;
			//배정된 예산안이 현재 예산보다 크면
			//예산안을 줄여야한다.
//			System.out.println(budget(mid));
			if (budget(mid) > M) {
				max = mid;
			//배정된 예산안이 현재 예산보다 작거나 같으면
			//예산안을 늘려야한다.
			} else {
				min = mid+1;
			}		
//			System.out.println("min : "+min);
//			System.out.println("max : "+max);
		}
		
		int upperBound = max;
		
		System.out.println(max-1);
		

		
//		//배정된 예산들 중 최댓값인 정수를 출력해야하므로
//		//index를 이용한다.
//		
//		Arrays.sort(reqBudget);
//		
//		min = 0;
//		max = N;
//		int mid = 0;
//		
//		while (min < max) {
//			mid = (min+max)/2;
//			
//			if (budget)
//			
//			
//		}
		

		
	}
	
	//주어진 총 예산에 대해 필요한 금액
	static int budget(int M) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			if (reqBudget[i] <= M) {
				sum += reqBudget[i];
			} else {
				sum += M;
			}
		}
		
		return sum;
		
	}

}
