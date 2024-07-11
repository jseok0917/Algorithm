package BOJ_26216_은나무;

import java.util.*;
import java.io.*;

public class Main2 {
	
	static long K, H, Q;
	
	public static void main(String[] args) throws IOException {
		System.out.println(changeDigit(1000000000L, 22));

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
		
		sb.reverse();
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
