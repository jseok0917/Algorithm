import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		long B = sc.nextLong(); 
		
		int[][] A = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		if (B == 1L) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(A[i][j]%1000+" ");
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			
		} else {
			int[][] result = power(A, B);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(result[i][j]+" ");
				}
				sb.append("\n");
			}
			
			System.out.println(sb.toString());
		}
		
		
	}
	static int N;
	
	public static int[][] power(int[][] A, long B) {
		
		if (B == 1L) {
			return A;
		} else {
			
			int[][] temp = power(A, B/2);
			
			if (B%2 == 0) {
				return multiple(temp, temp);	
			} else {
				return multiple(multiple(temp,temp), A);
			}

		}
		
	}
	
	//N by N 정사각 행렬 A와 B의 곱 구현
	public static int[][] multiple(int[][] A, int[][] B) {
		
		int[][] calc = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int sum = 0;
				for (int k = 0; k < N; k++) {
					//행렬곱의 (i,j) 좌표는
					//앞의 행렬의 i행의 성분과 뒤의 행렬의 j열의 성분을
					//순차적으로 곱한 것들의 합이다.
					sum += (A[i][k] * B[k][j])%1000;
				}
				calc[i][j] = sum%1000;	
			}
		}
		
		return calc;
		
	}
	
}
