package 라이브_행렬구현;

import java.util.Arrays;

public class Practice {
	
	public static void main(String[] args) {
		
		int N = 5;
		int M = 6;
		
		// N by M 행렬
		int[][] hotDog = new int[N][M];
		
		int cnt = 1;
		
		//지그재그 순회하면서 자연수를 1부터 순서대로 넣어보자
		//숏코딩으로 간다
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				hotDog[i][j*((i+1)%2)+(M-1-j)*(i%2)] = cnt;
				cnt++;		
			}
		}
		
		//배열안에 배열을 담는 것인데 담을 때 사실 행 안에 담는 것이라 생각하면 된다. 
		//사실 대칭적이긴한데, 생각하는 방향을 한쪽으로 고정시켜놓고 하면 될 듯 싶다.
		//나는 [][] 앞부분을 행 index로 생각하기로 했다.
		//hotDog 내부정보
		for (int[] i : hotDog) {
			System.out.println(Arrays.toString(i));
		}
		
		System.out.println("=================열지그재그==================");
		
		//열 지그재그 순회
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				
				//숏코딩
//				System.out.printf("%3d", hotDog[i*((j+1)%2)+(N-1-i)*(j%2)][j]);
				
				
				//가독성
				if (j%2 == 0) {
					System.out.printf("%3d", hotDog[i][j]);
				} else {
					System.out.printf("%3d", hotDog[N-1-i][j]);
				}
				
				
				
			}
			System.out.println();
			
		}
		
		System.out.println("=================구분선==================");
		//hotDog 내부정보
				for (int[] i : hotDog) {
					System.out.println(Arrays.toString(i));
				}
		
		System.out.println("=================오른쪽위방향대각선==================");
		
		//대각 순회
		//ㄱ자 혹은 ㄴ자로 시작점을 읽어서 출발한다
		//오른쪽 위 방향 대각선으로
		int n = 0;
		int m = 0;
		
		while (n < N-1) {
			//n-i >= 0 && m+i < N 이게 막다른 길에 다다랐음을 의미한다.
			for (int i = 0; n-i >= 0 && m+i < M; i++) {
				System.out.printf("%3d", hotDog[n-i][m+i]);
			}
			n++;
			System.out.println();
		}
		
		while (m < M) {
			for (int i = 0; n-i >= 0 && m+i < M; i++) {
				System.out.printf("%3d", hotDog[n-i][m+i]);
			}
			m++;
			System.out.println();
		}
		
		
		
		
		System.out.println("=================왼쪽아래방향대각선==================");
		//왼쪽 아래 방향 대각선으로
		int n2 = 0;
		int m2 = 0;
		
		while (m2 < M-1) {
			for (int i = 0; m2-i >= 0 && n2+i < N; i++) {
				System.out.printf("%3d", hotDog[n2+i][m2-i]);
			}
			m2++;
			System.out.println();
		}
		
		while (n2 < N) {
			//n-i >= 0 && m+i < N 이게 막다른 길에 다다랐음을 의미한다.
			for (int i = 0; m2-i >= 0 && n2+i < N; i++) {
				System.out.printf("%3d", hotDog[n2+i][m2-i]);
			}
			n2++;
			System.out.println();
		}
			
		
		
		
		
		
		//이제 핫도그케찹(대각 지그재그) 순회를 시작해보자
		
		
		
		// 시작 좌표는 (0, 0), 대각 순회를 활용한다
		// 그냥 행렬 지그재그 순회처럼 똑같이 하고 싶은데,
		// 행렬의 열길이가 더 기냐 행길이가 더 기냐에 따라 문제가 발생하므로
		// 확장 정사각 행렬을 만들어서 그걸로 돌린다.
		int x = 0;
		int y = 0;
		
		int L = Math.max(N, M);
		int[][] hotDogExtended = new int[L][L];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				hotDogExtended[i][j] = hotDog[i][j];
			}
		}
		
		System.out.println("=================확장핫도그==================");
		
		for (int[] i : hotDogExtended) {
			System.out.println(Arrays.toString(i));
		}
		
		System.out.println("=================대각지그재그==================");
		
		
		while (x < N-1) {
			for (int i = 0; x-i>= 0 && y+i < M; i++) {
				
				// 확장되서 생긴 원소들은 0으로 초기화돼있기 때문에
				// 0이 아닐때만 읽어주면 OK
				if (hotDogExtended[x-i][y+i] != 0 && hotDogExtended[y+i][x-i] != 0) {
					if ((x+y)%2 == 0) {
						System.out.printf("%3d", hotDogExtended[x-i][y+i]);
						
					//이렇게 대각 거꾸로로 하면 시작점이 반대로 될 때 문제가 발생할 수 있는데,
					//정사각 행렬로 확장시키고서 하면 시작점 문제가 발생하지 않는다.
					} else {
						System.out.printf("%3d", hotDogExtended[y+i][x-i]);
					}
				}
				
			}
			
			System.out.println();
			x++;
		}
		
		//대각조회시에 while문 두개 안의 코드가 겹치는데 하나로 만들 방법은 없을까?
		while (y < M) {
			for (int i = 0; x-i>= 0 && y+i < M; i++) {
				
				if (hotDogExtended[x-i][y+i] != 0 && hotDogExtended[y+i][x-i] != 0)
				if ((x+y)%2 == 0) {
					System.out.printf("%3d", hotDogExtended[x-i][y+i]);
				} else {
					System.out.printf("%3d", hotDogExtended[y+i][x-i]);
				}
				
			}
			
			System.out.println();
			y++;
		}
			
		
		
		
		
		
//		//포인터는 N*M만큼 이동하여야 한다.
//		int count = 0;
//		
//		while (count < N*M) {
//			
//			//1. 오른쪽 위로 가다가 막힐 경우 => 오른쪽으로 가되, 오른쪽으로도 못가면 아래로 간다.
//			
//			//2. 왼쪽 아래로가다가 막힐 경우
//			
//			//3. 
//			
			
			
			
			
			
			
			
		
		
		
		
		
	}

}
