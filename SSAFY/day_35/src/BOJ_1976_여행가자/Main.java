package BOJ_1976_여행가자;

import java.util.*;
import java.io.*;

public class Main {
	
	//도시의 수
	static int N;
	//여행 계획에 속한 도시의 수
	static int M;
	//각 도시의 부모 도시(처음에 자기자신을 부모로 초기화시켜놓아야함)
	static int[] p;
	//여행 계획
	static int[] plan;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		p = new int[N];
		plan = new int[M];
		//부모도시배열 초기화
		makeset(p);
		
		//연결정보 입력
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			
			for (int j = 0; j < N; j++) {
				int isConnected = Integer.parseInt(input[j]);
				if (isConnected == 1) {
					union(i, j);
				}
			}
		}
		
		String[] input = br.readLine().split(" ");
		//여행계획 입력
		//0번부터 시작하게 - 1해서 입력
		for (int i = 0; i < M; i++) {
			plan[i] = Integer.parseInt(input[i]) - 1;
		}
		
//		System.out.println(Arrays.toString(p));
		
		//첫번째 도시가 속해있는 그룹의 대표도시 찾기
		int city = findset(plan[0]);
		boolean isPossible = true;
		
		//나머지 여행플랜 도시들의 대표도시가 첫번째 도시와 같은지 체크
		for (int i = 1; i < M; i++) {
			int tmp = findset(plan[i]);
			
			if (city != tmp) {
				isPossible = false;
				break;
			}
		}
		
//		System.out.println(Arrays.toString(p));
		
		if (isPossible) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
		
		
		
	}
	
	//초기화
	static void makeset(int[] set) {
		for (int i = 0; i < set.length; i++) {
			set[i] = i;
		}
	}
	
	static void union(int x, int y) {
		//x의 대표자와 y의 대표자를 찾는다
		int px = findset(x);
		int py = findset(y);
		
		//작은 값을 새로운 대표자로 정한다
		if (px < py) {
			p[py] = px;
		}
		
	}
	
	static int findset(int x) {
		
		//x 자기자신이 대표자라면 그대로 반환
		if (p[x] == x) {
			return x;
		
		//자기 자신이 아니라면, 자신의 부모의 대표자를 다시 찾아나가면서,
		//x의 대표자를 부모의 대표자로 변경시킨다(경로압축)
		} else {
			return p[x] = findset(p[x]);
		}
		
	}
	
	
	

}
