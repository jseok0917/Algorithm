import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Main {
	
	// 두 선분 ab, cd가 주어질 때 겹치는 상황을 판별하는 판별자 메서드 생성
	public static int dscm_ab_cd(int a, int b, int c, int d) {
		if ((a < c && c < b)|| (a < d && d < b)) {
			return 0; //이건 선분끼리 겹칠 때  (c가 ab내부 or d가 ab내부)
		} else if (a > c && b < d) {
			return 0; //이건 선분끼리 겹칠 때 (ab가 cd내부에 존재할때)
		} else if (a == c || b == d) {
			return 0; // 이건 선분끼리 겹칠 때 (한쪽끝이 겹침)
		} else if (b == c || a == d) {
			return 1; // 이건 끝이 겹칠때
		} else {  
			return 2; // 아예 안겹칠때
		}
		
	}
	
	// XOR 메서드
	public static boolean XOR(boolean A, boolean B) {
		if (A != B) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		for (int n = 0; n < 4; n++) {
			String input = bf.readLine();
			String[] input_list = input.split(" ");
			int[] first = new int[4]; //첫번째 직사각형 좌표
			int[] second = new int[4]; //두번째 직사각형 좌표
			
			for (int i = 0; i < input_list.length; i++) {
				if (i <= 3) {
					first[i] = Integer.parseInt(input_list[i]);
				} else if (4 <= i){
					second[i-4] = Integer.parseInt(input_list[i]);
				}
			}
			
	//		// 첫번째 직사각형 좌표
	//		
	//		int X = 
	//		int Y =
	//		int P =
	//		int Q =
	//		
	//		// 두번째 직사각형 좌표
	//		
	//		int x =
	//		int y =
	//		int p =
	//		int q =
	//		
			
			
			//여기까지 입력완료
			
			// 가로선분이 겹치는지 판별
			int W = dscm_ab_cd(first[0], first[2], second[0], second[2]);
			
			// 세로선분이 겹치는지 판별
			int L = dscm_ab_cd(first[1], first[3], second[1], second[3]);
			
//			System.out.println(W);
//			System.out.println(L);
			
			if (W == 0 && L == 0) {
				System.out.println("a");
			} else if (W == 1 && L == 0) {
				System.out.println("b");
			} else if (W == 0 && L == 1) {
				System.out.println("b");
			} else if (W == 1 && L == 1) {
				System.out.println("c");
			} else if (W == 2 || L ==2) {
				System.out.println("d");
			}
		}
		
		
		
	}

}
