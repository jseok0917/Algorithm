import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	//각 톱니바퀴의 상태
	static int[][] gears;
	
	//톱니바퀴의 개수
	final static int N = 4;
	
	//톱니의 개수
	final static int M = 8;
	
	//회전 횟수
	static int K;
	
	
	public static void main(String[] args) {
		
		//입력받을 준비
		Scanner sc = new Scanner(System.in);
		
		gears = new int[N][M];
		
		//톱니의 상태 입력
		//N극은 0, S극은 1
		for (int i = 0; i < N; i++) {
			
			String input = sc.next();
			
			for (int j = 0; j < M; j++) {
				gears[i][j] = Integer.parseInt(input.substring(j, j+1));
			}
			
		}
		
//		for (int[] i : gears) {
//			System.out.println(Arrays.toString(i));
//		}
		
		//회전 횟수 입력
		K = sc.nextInt();
		
		//회전 로직
		for (int i = 0; i < K; i++) {
			//회전할 톱니바퀴와 회전방향을 정한다
			int num = sc.nextInt();
			
			//0번부터 번호매기므로
			num = num-1;
			int dir = sc.nextInt();
			
			int leftDir = dir;
			int rightDir = dir;
			
			//회전할때 각 톱니바퀴들이 미리 회전할지 말지 판단해야한다..
			//회전해야하면 true, 아니면 false
			boolean[] isRotate = new boolean[N];
			int[] rotateDir = new int[N];
			
			//주어진 톱니바퀴는 반드시 회전
			isRotate[num] = true;
			rotateDir[num] = dir;
			
			
			//톱니바퀴의 번호 기준으로 왼쪽과 오른쪽으로 나눈다(서로 독립적이므로 가능)
			//왼쪽 톱니바퀴
			for (int j = num; j > 0; j--) {
				
				//같은 극이라면 아무것도 하지않고 break
				if (isSamePole(j, -1)) {
					
					for (int k = j-1; k >= 0; k--) {
						isRotate[k] = false;
					}
					
					break;
				
				//다른 극이라면 방향을 반대로 하여 회전시키기
				} else {
					isRotate[j-1] = true;
					//반대방향으로 회전하므로, -1을 곱하여 회전방향 저장
					leftDir = (-1)*leftDir;
					rotateDir[j-1] = leftDir;
				}
			}
				
			//오른쪽 톱니바퀴
			for (int j = num; j < N-1; j++) {
				//같은 극이라면 아무것도 하지않고 break
				if (isSamePole(j, 1)) {
					
					for (int k = j+1; k < N; k++) {
						isRotate[k] = false;
					}
					
					break;
				
				//다른 극이라면 방향을 반대로 하여 회전시키기
				} else {
					isRotate[j+1] = true;
					//반대방향으로 회전하므로, -1을 곱하여 회전방향 저장
					rightDir = (-1)*rightDir;
					rotateDir[j+1] = rightDir;
				}
			}
				
				
			//톱니바퀴들을 회전시킨다
			
			for (int j = 0; j < N; j++) {
				if (isRotate[j]) {
					rotate(j, rotateDir[j]);
				}
			}
			
			
//			System.out.println("===========회전 결과==========");
//			for (int[] g : gears) {
//				System.out.println(Arrays.toString(g));
//			}
			
		}
		
		
		//점수 합계
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			//12시 방향 기어가 N극(0)이면 0점, S극(1)이면 1,2,4,8점
			if (gears[i][0] == 1) {
				sum = sum + (int)Math.pow(2, i);
			}
			
		}
		
		System.out.println(sum);
		
		
	}
	
	//회전하는 톱니바퀴의 번호와 회전 방향
	//1은 시계, -1은 반시계
	public static void rotate(int num, int dir) {
		
		//톱니바퀴를 불러온다
		int[] gear = gears[num];
		int first = gear[0];
		int last = gear[M-1];
		
		switch (dir) {
		
			//시계방향
			case 1 : {
				
				for (int i = M-1; i > 0; i--) {
					gear[i] = gear[i-1]; 
				}
				
				gear[0] = last;
				break;
			}
			
			//반시계방향
			default : {
				
				for (int i = 0; i < M-1; i++) {
					gear[i] = gear[i+1];
				}
				
				gear[M-1] = first;
				break;
			}	
		}	
	}
	
	//주어진 톱니바퀴가 왼쪽 톱니바퀴/오른쪽 톱니바퀴와 맞닿은 부분이 다른극인지 같은극인지
	//왼쪽은 -1, 오른쪽은 1
	//다른 극이면 false, 같은 극이면 true를 반환  
	public static boolean isSamePole(int num, int dir) {
		int[] gear = gears[num];
		
		switch (dir) {
			//왼쪽에 맞닿은 기어
			case -1 : {
				int[] leftGear = gears[num-1];
				if (leftGear[2] == gear[6]) {
					return true;
				} else {
					return false;
				}
			}
			
			//오른쪽에 맞닿은 기어
			default : {
				
				int[] rightGear = gears[num+1];
				if (rightGear[6] == gear[2]) {
					return true;
				} else {
					return false;
				}
			}
			
		
		}
		
		
	}

	

}
