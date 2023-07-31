import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		
		Stack<Integer> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			
			String input = br.readLine();
			String[] input_list = input.split(" ");
			
			if (input_list[0].equals("push")) {
				int num = Integer.parseInt(input_list[1]);
				stack.push(num);
			} else if (input_list[0].equals("pop")) {
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.pop());
				}
				
				
			} else if (input_list[0].equals("size")) {
				
				System.out.println(stack.size());
				
			} else if (input_list[0].equals("empty")) {
				if (stack.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				
			} else if (input_list[0].equals("top")) {
				if (stack.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(stack.peek());
				}
				
			}
			
			
			
			
			
			
		}
		
		
		
		
		
	}

}
