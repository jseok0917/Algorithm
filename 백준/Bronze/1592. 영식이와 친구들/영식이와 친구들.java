import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;

public class Main {
	
	// a를 b로 나눌 때
	public static int div(int a, int b) {
		
		if (a < 0 && b > 0) {
			return (a%b)+b;
		} else {
			return a%b;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input = bf.readLine();
		String[] input_list = input.split(" ");
		int[] input_num = new int[input_list.length];
		
		for (int i = 0; i < input_list.length; i++) {
			input_num[i] = Integer.parseInt(input_list[i]);
		}
		
		int N = input_num[0];
		int M = input_num[1];
		int L = input_num[2];
		
		int ord = 0;
		int cnt = 0;
		int[] cnt_list = new int[N];
		
		
	f1 :while (ord < N) {
			cnt_list[ord] = cnt_list[ord] + 1;
			for (int i = 0; i < N; i++) {
				if (cnt_list[i] == M) {
					break f1;
				}	
			}
			
			
			if (cnt_list[ord] % 2 == 0) {
				ord = div(ord - L, N);
			} else {
				ord = div(ord + L, N);
			} 


			cnt++;		
//			System.out.print(ord+" ");
//			System.out.print(cnt_list[ord]+" ");
//			System.out.println(cnt);
			
		}
		
		System.out.println(cnt);
		
		
		
		
		
		
	}

}
