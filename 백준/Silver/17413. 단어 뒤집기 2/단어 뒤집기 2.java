import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		String input = bf.readLine();
		char[] in_arr = input.toCharArray();
		boolean[] in_dcrm = new boolean[in_arr.length];

		// 현재 주어진 char가 <> 내부에 있을땐 true, 외부에 있을땐 false를 저장
		// 이제 내부에 있는 char는 그대로 출력하고, 외부에 있는 char는 따로 모아뒀다가 한번에 거꾸로 출력할거임
		// 코드가 좀 복잡하다...
		if (in_arr[0] == '<') {
			in_dcrm[0] = true;
		} else {
			in_dcrm[0] = false;
		}

		for (int i = 1; i < in_arr.length; i++) {
			
			// <나 >를 만나는 경우를 제외하고는 자신 바로 앞의 true false값을 복사한다
			if (in_arr[i] == '<') {
				in_dcrm[i] = true;
				continue;
			} else if (in_arr[i] == '>') {
				in_dcrm[i] = true;
				// i가 마지막이 아닐때는 다음거까지(다음거가 '<' 요게 아니라면) false로 정한다
				if (i != in_arr.length-1 && in_arr[i+1] != '<') {
					in_dcrm[++i] = false;
					continue;	
					
				}
				continue;
			} else {
				in_dcrm[i] = in_dcrm[i-1];
			}
		}
		
		//잘 돌아가는지 확인용 출력문
//		for (boolean i : in_dcrm) {
//			System.out.print(i+" ");
//		}
		
		
		f1: for (int i = 0; i < in_arr.length;) {
			
			ArrayList<Character> temp = new ArrayList<>();
			
			while (in_dcrm[i] == false) {
				if (in_arr[i] == ' ') {		
					for (int j = 0; j < temp.size(); j++) {
						System.out.print(temp.get(temp.size() - j - 1));
					}
					System.out.print(" ");
					i++;
					continue f1;
				}

				temp.add(in_arr[i]);
				i++;
				if (i == in_arr.length) {
					break;
				}
			}
			
			if (temp != null) {
				for (int j = 0; j < temp.size(); j++) {
					System.out.print(temp.get(temp.size() - j - 1));
				}
				
			}
			
			if (i == in_arr.length) {
				break;
			}
			
			
			while (in_dcrm[i] == true) {
				System.out.print(in_arr[i]);
				i++;
				if (i == in_arr.length) {
					break;
				}
			}

		}

	}
}
