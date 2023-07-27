import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String N_str = bf.readLine();
		int N = Integer.parseInt(N_str);
		
		for (int n = 0; n < N; n++) {
		
			String input = bf.readLine();
			String[] input_list = input.split(" ");
			
			
			for (String i : input_list) {
				
				
				char[] temp = i.toCharArray();
				char[] backwards = new char[temp.length];
				for (int j = 0; j < temp.length; j++) {
					backwards[temp.length-j-1] = temp[j]; 
				}
				
				String str_bwds = new String(backwards);
				
				if (i.equals(input_list[input_list.length-1])) {
					System.out.println(str_bwds);
				} else {
					System.out.print(str_bwds+" ");
				}
			}
		}
		
		
	}
}