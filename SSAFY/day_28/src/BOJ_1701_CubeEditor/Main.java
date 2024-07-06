package BOJ_1701_CubeEditor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//접미사 배열과 LCP(가장 긴 접두사 길이를 이용한다)
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		int L = input.length();
		
		//접미사 배열
		String[] suffixArr = new String[L];
		
		//모든 접미사를 저장한다.
		//그러면 모든 부분문자열이 저장된다.
		for (int i = 0; i < L; i++) {
			suffixArr[i] = input.substring(i, L);
		}
		
		//접미사 배열을 사전 순으로 정렬
		Arrays.sort(suffixArr);
		
//		System.out.println(Arrays.toString(suffixArr));
		
		//LCP(Longest Common Prefix) 계산
		int[] ArrayForLCP = new int[L-1];
		
		for (int i = 0; i < L-1; i++) {
			//사전순으로 배열된 접미사 배열에서
			//인접한 두 문자열의 공통된 접두사가 곧,
			//두 번 이상 나타나는 문자열을 의미한다.
			//문자열의 길이가 다르기 때문에 겹치는 문자는 반드시 두 번 이상 나타나는 문자일 수 밖에 없다.
			//또한, 인접한 문자열의 길이만 구하면 되는 이유는
			//임의의 N번째와 N보다 큰 M번째 문자열이 최장 길이를 갖고 있다면
			//그 사이의 모든 문자열도 같은 길이를 갖고 있을 것이기 때문이다.(사전순으로 정렬돼있기 때문에)
			String A = suffixArr[i];
			String B = suffixArr[i+1];

			int cnt = 0;
			for (int j = 0; j < A.length(); j++) {
				if (A.charAt(j) == B.charAt(j)) {
					cnt++;
				} else {
					break;
				}
			}
			ArrayForLCP[i] = cnt;
		}
		
		int LCP = 0;
		for (int i = 0; i < L-1; i++) {
			if (LCP < ArrayForLCP[i]) {
				LCP = ArrayForLCP[i];
			}
		}
		
//		System.out.println(Arrays.toString(ArrayForLCP));
		System.out.println(LCP);
		
		
		
		
		
		
	}

}
