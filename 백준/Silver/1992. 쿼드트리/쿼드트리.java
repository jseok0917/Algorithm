import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//크기입력
		int N = sc.nextInt();
		
		quad = new String[N][N];
		compressQuad = new String[N][N];
		
		//영상정보 입력
		for (int i = 0; i < N; i++) {
			String[] input = sc.next().split("");
			for (int j = 0; j < N; j++) {
				quad[i][j] = input[j];
			}
		}
		
		if (N == 1) {
			System.out.println(quad[0][0]);
		} else {
			divide(N, 0, 0);
			System.out.println(compressQuad[0][0]);
		}
		
		
		
	}
	
	static String[][] quad;
	
	//영상 압축 재귀함수 구현
	public static void divide(int N, int U, int L) {
		
		
		
		//기저조건
		if (N > 1) {
		
			//절반값 구하기
			int M = N/2;
			
			divide(M, U, L);
			divide(M, U+M, L);
			divide(M, U, L+M);
			divide(M, U+M, L+M);
			compress(M, U, L);
		}
	}
		
	//압축용 2차원 배열 생성
	static String[][] compressQuad;
	public static void compress(int M, int U, int L) {
		
		if (M == 1) {
			//왼쪽 위
			String a = quad[U][L];
			//오른쪽 위
			String b = quad[U][L+M];
			//왼쪽 아래
			String c = quad[U+M][L];
			//오른쪽 아래
			String d = quad[U+M][L+M];
			if (a.equals("1") && b.equals("1") && c.equals("1") && d.equals("1")) {
				compressQuad[U][L] = "1";			
			} else if (a.equals("0") && b.equals("0") && c.equals("0") && d.equals("0")) {
				compressQuad[U][L] = "0";
			} else {
				compressQuad[U][L] = "("+a+b+c+d+")";
			}
		} else {
			String a = compressQuad[U][L];
			String b = compressQuad[U][L+M];
			String c = compressQuad[U+M][L];
			String d = compressQuad[U+M][L+M];
			if (a.equals("1") && b.equals("1") && c.equals("1") && d.equals("1")) {
				compressQuad[U][L] = "1";			
			} else if (a.equals("0") && b.equals("0") && c.equals("0") && d.equals("0")) {
				compressQuad[U][L] = "0";
			} else {
				compressQuad[U][L] = "("+a+b+c+d+")";
			}
		}
		
		
		

	}
		

	
}
