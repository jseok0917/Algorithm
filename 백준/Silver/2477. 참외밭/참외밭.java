import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[] D_list = new int[9]; // 입력된 값에 대한 방향 저장
		int[] L_list = new int[9]; // 입력된 값에 대한 길이 저장
		

		// 입력값 저장
		String input_M = bf.readLine();
		int M = Integer.parseInt(input_M);
		
		for (int i = 0; i < 6; i++) {
			String input = bf.readLine();
			String[] input_list = input.split(" ");
			int D = Integer.parseInt(input_list[0]); // 방향
			int L = Integer.parseInt(input_list[1]); // 길이
			D_list[i] = D;
			L_list[i] = L;
		}
		
		
		// 가로, 세로 전체길이 구하기
		int max_width = 0;
		int max_length = 0;
		for (int i = 0; i < 6; i+=2) {
			if (L_list[i] >= max_width) {
				max_width = L_list[i];
			}
			
		}
		
		for (int i = 1; i < 6; i+=2) {
			if (L_list[i] >= max_length) {
				max_length = L_list[i];
			}	
		}
		
		long area = max_width*max_length;
//		System.out.println(max_width);
//		System.out.println(max_length);
//		System.out.println(area);
		
		// 가장 핵심적인 부분!!! 빈 직사각형의 넓이 구하기
		// 사전준비
		for (int i = 0; i < 3; i++) {
			D_list[i+6] = D_list[i];
			L_list[i+6] = L_list[i];
		}
		
		long empty = 0; // 빈 부분 0으로 세팅
		
		for (int i = 1; i < 7; i++) {
			if (D_list[i] == D_list[i+2] && D_list[i-1] == D_list[i+1]) {
				empty = L_list[i]*L_list[i+1];
			}		
		}
//		System.out.println(empty);
		
		System.out.println(M*(area - empty));
		
		

	}


}
