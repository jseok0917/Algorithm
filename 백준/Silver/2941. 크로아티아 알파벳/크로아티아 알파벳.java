import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		char[] input_list = input.toCharArray();
		int cnt = input_list.length;
		
		for (int i = 0; i < input_list.length; i++) {
			if (input_list[i] == '=') {
				if (i > 1 && input_list[i-1] == 'z' && input_list[i-2] == 'd') {
					cnt -= 2;
				} else {
					cnt -= 1;
				}
			} else if (input_list[i] == '-') {
				cnt -=1;
			} else if (input_list[i] == 'j') {
				if (i > 0 && (input_list[i-1] == 'l' || input_list[i-1] == 'n')) {
					cnt -= 1;
				}
			}
			
		}
		
		
		System.out.println(cnt);
		
		
		
	}
}
