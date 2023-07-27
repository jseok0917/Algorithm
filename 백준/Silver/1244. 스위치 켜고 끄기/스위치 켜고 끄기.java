import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input_case = bf.readLine();
		//입력 스위치개수
		
		
		String input = bf.readLine();
		String[] input_list = input.split(" ");
		int[] input_num = new int[input_list.length];
		
		for (int j = 0; j < input_list.length; j++) {
			input_num[j] = Integer.parseInt(input_list[j]);
		}
		
		boolean[] swch = new boolean[input_num.length];
		for (int j = 0; j < input_num.length; j++) {
			if (input_num[j] == 0) {
				swch[j] = false;
			} else {
				swch[j] = true;
			}
		}
		
		// 스위치 상태저장
		
		
		String st_num = bf.readLine();
		int N = Integer.parseInt(st_num);
		// 학생 숫자 저장
		
		
		for (int j = 0; j < N; j++) {
			String gender_M = bf.readLine();
			String[] gM_str = gender_M.split(" "); 
			int[] gM_num = new int[gM_str.length];
			
			for (int k = 0; k < gM_str.length; k++) {
				gM_num[k] = Integer.parseInt(gM_str[k]);
			}
			
			int gender = gM_num[0];
			int M = gM_num[1];
			
			if (gender == 1) {
				for (int k = M-1; k < swch.length; k+=M)
				swch[k] = !swch[k];
				
			} else if (gender == 2) {
				for (int k = 0; M-k-1 >= 0 && M+k-1 < swch.length; k++) {
					if (k == 0) {
						swch[M-1] = !swch[M-1];
					} else if (swch[M-k-1] == swch[M+k-1]) {
						swch[M-k-1] = !swch[M-k-1];
						swch[M+k-1] = !swch[M+k-1];
					} else {
						break;
					}
				}
					
			}
			
		}
		
		// 입력된 학생들에 대해서 스위치 상태 변경
		int[] swch_num = new int[swch.length];
		for (int i = 0; i < swch.length; i++) {
			if (swch[i] == true) {
				swch_num[i] = 1;
			} else {
				swch_num[i] = 0;
			}
			
		}
		
		for (int i = 0; i < swch.length; i++) {
			if (i == swch.length-1) {
				System.out.print(swch_num[i]);
			} else if ((i+1)%20 == 0) {
				System.out.println(swch_num[i]);
			} else {
				System.out.print(swch_num[i]+" ");
			}
		}
			
			
			
		
		
		
	}

}
