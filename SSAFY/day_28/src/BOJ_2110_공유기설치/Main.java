package BOJ_2110_공유기설치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		//집의 개수
		int N = Integer.parseInt(input[0]);
		
		//공유기의 개수
		int C = Integer.parseInt(input[1]);
		
		//집의 위치 저장할 배열
		int[] houses = new int[N];
		
		//가장 먼 집의 위치
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			houses[i] = Integer.parseInt(br.readLine());
			if (max < houses[i]) {
				max = houses[i];
			}
		}
		
		//정렬
		Arrays.sort(houses);
		
		int start = 0;
		int end = max;
		
		int mid = (start+end)/2;
		
		//가능한 공유기의 거리를 갖고서 이분탐색
		while (mid != start && mid != end) {
				
			//첫번째집은 무조건 설치할 것이므로 1로 시작
			int cnt = 1;
			
			//누적된 거리
			int distSum = 0;
			
			//모든 집을 순회하며 주어진 거리값(mid)으로
			//공유기를 설치해보고
			//C개의 공유기를 설치할 수 있는지 체크한다
			for (int i = 1; i < N; i++) {
				distSum += houses[i] - houses[i-1];
				
				//공유기를 설치할 수 있는 거리만큼 떨어졌다면
				//공유기를 설치하고, 누적거리 초기화
				if (distSum >= mid) {
					cnt++;
					distSum = 0;
				}
			}
			
			//C개의 공유기를 설치할 수 있다면
			//최대거리를 구해봐야하므로
			//더 높은 거리값으로 다시 설치해본다.
			if (cnt >= C) {
				start = mid;
			//설치할 수 없다면
			//더 낮은 거리값으로 설치를 시도해본다
			} else {
				end = mid;
			}	
			mid = (start+end)/2;
		}
		
		//첫번째집은 무조건 설치할 것이므로 1로 시작
		int cnt = 1;
		
		//누적된 거리
		int distSum = 0;
		
		//무조건 위값에서는 mid가 start로 반환되므로
		//end가 되는지 체크하고, 된다면 end를 출력 
		for (int i = 1; i < N; i++) {
			distSum += houses[i] - houses[i-1];
			
			if (distSum >= end) {
				cnt++;
				distSum = 0;
			}
		}
		
		//C개의 공유기를 설치할 수 있다면
		if (cnt >= C) {
			System.out.println(end);
		//설치할 수 없다면
		} else {
			System.out.println(start);
		}	
		
		
	}

}
