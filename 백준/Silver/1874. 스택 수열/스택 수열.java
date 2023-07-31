import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		
		//스택 객체 생성
		Stack<Integer> stack = new Stack<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력할 n
		int N = Integer.parseInt(br.readLine());
		
		// 초기정수값 선언
		int A = 0;
		
		// +- 출력할 값 정해놓은 배열 선언
		String[] output_list = new String[2*N];
		int ord = 0;
		
		
		for (int i = 0; i < N; i++) {
			
			int n = Integer.parseInt(br.readLine());
			
			
			// n을 입력받았을 때,
			// Empty Exception을 방지하기 위해 empty인 케이스를 고려
			// peek가 n보다 작으면 n까지 스택을 쌓는다.
			if (stack.isEmpty() || stack.peek() < n) {	
				while (A < n) {
					stack.push(A+1);
					output_list[ord++] = "+";
					A++;
				}
				
				stack.pop();
				output_list[ord++] = "-";
			
			// 가장 상단에 n이 존재한다면 바로 pop을 한다.
			} else if (stack.peek() == n) {
				stack.pop();
				output_list[ord++] = "-";
			
			// peek의 값이 입력한 n값보다 크면 꺼낼 수 없으므로 바로 NO를 출력하고 return을 통해 메인문 종료
			} else if (stack.peek() > n) {
				System.out.println("NO");
				return;
				
			}


			
		}
		
		for (String i : output_list) {
			System.out.println(i);
		}
		
		
		
		
	}
}
