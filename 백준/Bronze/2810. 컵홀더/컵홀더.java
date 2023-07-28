import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String blank = br.readLine();
		String input = br.readLine();
		char[] input_list = input.toCharArray();
		
		int S_cnt = 0;
		int L_cnt = 0;
		
		for (char i : input_list) {
			if (i == 'L') {
				L_cnt++;
			} else if (i == 'S') {
				S_cnt++;
			}
		}
		
		int result = S_cnt+L_cnt/2+1;
		
		if (S_cnt == input_list.length) {
			System.out.println(S_cnt);
		} else {
			System.out.println(result);
		}
		
		
		
		
	}
}
