package BOJ_1920_수찾기;

import java.io.*;
import java.util.*;

public class Main {
	
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		
		String[] input = br.readLine().split(" ");
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(A);
		
		
		int M = Integer.parseInt(br.readLine());
		input = br.readLine().split(" ");
		
//		System.out.println("1123");
		
		StringBuilder answer = new StringBuilder();
		
		for (int i = 0; i < M; i++) {
			if (binarySearch(Integer.parseInt(input[i]))) {
				answer.append(1+"\n");
			} else {
				answer.append(0+"\n");
			}
		}
		
		System.out.println(answer);
		
		
	}
	
	//M안의 숫자 m이 A안에 존재하는지 확인
	public static boolean binarySearch(int m) {
		
		int start = 0;
		int end = A.length;
		int mid = (start+end)/2;
		boolean disc = false;
		
		while (start < end) {
			int x = A[mid];
			
			if (x == m) {
				disc = true;
				break;
			} else if (x < m) {
				start = mid + 1;
			} else {
				end = mid;
			}
			
			mid = (start+end)/2;
		}
		
		if (start-1 >= 0 && A[start-1] == m) {
			disc = true;
		}
		
		return disc;
		
		
	}
	

}
