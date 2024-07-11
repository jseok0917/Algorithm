package BOJ_26216_은나무;

import java.util.*;
import java.io.*;

public class Main3 {
	
	static long K, H, Q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		K = Long.parseLong(input[0]);
		H = Long.parseLong(input[1]);
		Q = Long.parseLong(input[2]);
		
//		//메서드 확인용
//		System.out.println(changeDigit(77, 3));
		for (int i = 0; i < Q; i++) {
			input = br.readLine().split(" ");
			long A = Long.parseLong(input[0]);
			long B = Long.parseLong(input[1]);
			//파란 노드의 개수(최대번호-1)
			long N = (long) Math.pow((K+1), H);
			
			//존재하지 않을 경우
			if (A >= N || B >= N) {
				sb.append(-1+"\n");
				
			//같을 경우
			} else if (A == B) { 
				sb.append(0+"\n");
			} else {
			
				String a = changeDigit(A, K+1);
				String b = changeDigit(B, K+1);
				System.out.println("=========구분선 a, b=========");
				System.out.println(a);
				System.out.println(b);
				long heightA = height(A, K+1);
				long heightB = height(B, K+1);
				System.out.println("=========구분선 height=========");
				System.out.println(heightA);
				System.out.println(heightB);
				int maxheight = (int)Math.max(heightA, heightB);
				
				for (int h = maxheight+1; h < H+1; h++) {
					if (a.charAt(h) == b.charAt(h)) {
						System.out.println("=========구분선 h값=========");
						System.out.println(h);
						sb.append(2*h-heightA-heightB+"\n");
						break;
					}
				}
			}
			
		}
		
		System.out.println(sb.toString());

	}
	
	//주어진 숫자를 m진법으로 변환하는 메서드
	static String changeDigit(long N, long m) {
		StringBuilder sb = new StringBuilder();
		
		while (N != 0) {
//			//몫
//			long q = N/m;
//			//나머지
//			long r = N - m*q;
			//이렇게 구하는게 최소연산 아닌가...
			
			sb.append(N%m);
			
			N = N/m;
		}
		
		//높이 H이면 자릿수가 H+1개 생기는 게 맞다 (맨 첫자리는 반드시 0)
		while (sb.length() < H+1) {
			sb.append(0);
		}
		
		return sb.toString();	
	}
	
	//높이를 구하는 메서드
	static long height(long N, long m) {
		long height = 0;
		while (N > 0) {
			if (N%m == 0) {
				height++;
			} else {
				break;
			}
			N = N/m;
		}
		
		return height;
	}
	

}
