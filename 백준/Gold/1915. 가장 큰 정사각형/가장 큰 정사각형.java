import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[][] matrix;
	static int n;
	static int m;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		//행의 크기
		n = Integer.parseInt(input[0]);
		//열의 크기
		m = Integer.parseInt(input[1]);
		
		//이차원 배열에 객체 할당
		matrix = new int[n][m];
		
		
		//숫자 입력
		for (int i = 0; i < n; i++) {
			
			String nums = br.readLine();
			
			for (int j = 0; j < m; j++) {
				int A = nums.charAt(j)-48;
				matrix[i][j] = A;
			}
			
			
		}	
		
		//DP를 이용한다.
		
		
		//특정 좌표에 들어갈 수 있는 정사각형의 최대 크기를 지정한다.
		//(해당 좌표를 가장 끝점으로 가지는 정사각형을 가정할 때)
		//이렇게 하면 귀납적으로 생각했을 때
		//그 좌표에 넣을 값을 일일이 탐색하면서 넣는게 아니라
		//해당 좌표 r,c 라고하면, 위, 왼쪽, 왼쪽 위 3개만 체크를 하면 된다.
		//이렇게 했을 때 3개에 들어가는 정사각형의 크기의 최솟값이
		//다음좌표로 넘겨줄 수 있는 정사각형의 크기의 최댓값이 된다.
		//3개의 좌표를 끝점으로 갖는 정사각형을 크기를 2로 하여 구체적으로
		//머릿속으로 그려보자!
		/* 예시
		 1 1 1 1 0 1
		 1 2
		 0
		 1 
		  
		 
		 */
		
		//즉, 좌우로 뒤집은 ㄱ자 모양을 순차적으로 탐색해간다.
		//
		
		
		int r = 1;
		int c = 1;
		
		while (r < n && c < m) {
			
			int nr = r;
			int nc = c;
			
			while (nc < m) {
				//1일 때는 귀납적으로 더해주지만
				//해당 좌표가 0일 경우에는 정사각형 형성 자체가 불가능하다.
				//따라서 값을 건드려주지 않는다.
				if (matrix[nr][nc] == 1) {
					
					matrix[nr][nc] += min(matrix[nr-1][nc], matrix[nr][nc-1], matrix[nr-1][nc-1]);
				}
				
				nc++;
			}
			
			//ㄱ자 탐색을 위해 다시 초기화 
			nc = c;
			
			while (nr < n) {
				if (matrix[nr][nc] == 1) {
					matrix[nr][nc] += min(matrix[nr-1][nc], matrix[nr][nc-1], matrix[nr-1][nc-1]);
				}
				
				nr++;
			}
			
			r++;
			c++;
		}
		
		
		//전체 탐색해서 최댓값을 찾는다.
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (max < matrix[i][j]) {
					max = matrix[i][j];
				}
			}
		}
		
		System.out.println(max*max);
		
		
		
		
	}
	
	static int min(int A, int B, int C) {
		
		//B와 C중 작은걸 B에 할당
		if (B > C) {
			B = C;
		}
		
		//A와 B중 작은 걸 A에 할당
		if (A > B) {
			A = B;
		}
		
		return A;
	}

}
