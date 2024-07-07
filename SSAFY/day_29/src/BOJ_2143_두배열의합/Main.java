package BOJ_2143_두배열의합;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int T;
	static int[] A, B;
	static int n, m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//배열의 합
		T = sc.nextInt();
		
		//배열 A의 크기
		n = sc.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		
		//배열 B의 크기
		m = sc.nextInt();
		B = new int[m];
		for (int i = 0; i < m; i++) {
			B[i] = sc.nextInt();
		}
		
		//A의 부배열의합 리스트
		List<Integer> pA = new ArrayList<>();
		//B의 부배열의합 리스트
		List<Integer> pB = new ArrayList<>();
		
		//배열 A로 부 배열의 합 만들기
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j <= n; j++) {
				//시작 위치 i와 끝 위치 j (i <= .. < j)를 지정
				//구할 합
				int sum = 0;
				for (int k = i; k < j; k++) {
					sum += A[k];
				}
				pA.add(sum);
			}
		}
		
		//배열 B로 부 배열의 합 만들기
		for (int i = 0; i < m; i++) {
			for (int j = i+1; j <= m; j++) {
				//시작 위치 i와 끝 위치 j (i <= .. < j)를 지정
				//구할 합
				int sum = 0;
				for (int k = i; k < j; k++) {
					sum += B[k];
				}
				pB.add(sum);
			}
		}
		
		//이분탐색을 위한 B를 정렬
		Collections.sort(pB);
		int UpperBound = 0;
		int LowerBound = 0;
		
		long cnt = 0;
		
		for (int i = 0; i < pA.size(); i++) {
			//탐색해야되는 숫자
			int S = T-pA.get(i);
			
			int min = 0;
			int max = pB.size();
			int mid = 0;
			
			//upper bound부터 찾는다.
			while (min < max) {
				
				mid = (min+max)/2;
				
				if (pB.get(mid) > S) {
					max = mid;
				} else {
					min = mid+1;
				}
			}
			
			UpperBound = max;
			
			
			min = 0;
			max = pB.size();
			
			//lower bound부터 찾는다.
			while (min < max) {
				
				mid = (min+max)/2;
				
				if (pB.get(mid) >= S) {
					max = mid;
				} else {
					min = mid+1;
				}
			}
			
			LowerBound = min;
			
			cnt += (UpperBound-LowerBound);
		}
		
		System.out.println(cnt);
		
	}

}
