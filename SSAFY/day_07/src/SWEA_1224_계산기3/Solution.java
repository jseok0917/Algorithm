package SWEA_1224_계산기3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
		
			//후위표기식 변환을 위한 스택
			List<String> stack = new ArrayList<>();
			String result = "";
			
			//후위표기식 연산을 위한 스택(계산기)
			List<Integer> stackForCal = new ArrayList<>();
			
			//주어진 문자열의 길이 입력
			int L = sc.nextInt();
			
			//문자열 입력(입력할 때, 마지막에 스택에 남은 연산자들을 처리해주기 위해서, 양끝에 괄호 두개를 추가)
			String inputString = sc.next();
			String[] input = ("("+inputString+")").split("");
			
			for (int i = 0; i < input.length; i++) {
				result = postFix(input[i], stack, result);
			}
			
			String[] postfixResult = result.split("");
			
			
			//다음에 구현할 때는 한글자씩 구현하지말고 한번에 String입력받아서
			//메서드 내에서 stack을 구현해서 해보기
			for (int i = 0; i < result.length(); i++) {
				stackForCal = calculator(stackForCal, postfixResult[i]);
			}
			
			for (int i : stackForCal) {
				System.out.printf("#%d %d\n",t, i);
			}
		
		}
	}
	
	//후위표기식으로 변환하기위한 메서드 생성
	//메각각의 연산자별로 우선순위를 지정해줘야된다.
	//곱하기/나누기는 동등, 더하기 빼기는 동등  곱하기 > 더하기
	// )를 만나면 (가 나올 때 까지 남은 연산자를 모두 POP
	
	//메서드에서 result에 추가된 값을 저장해주기 위해서
	//result를 return해야한다(더 많은 이해가 필요)
	public static String postFix(String input, List<String> stack, String result) {
		
		
		//switch - case로 하는게 가독성이  더 좋았을 수도?
		if (input.equals("+") || input.equals("-")) {
		//+나 -를 만났을 때, stack의 peek에 동등연산자, 혹은 더 우선순위가 높은 연산자가 존재한다면 계속 pop하고, 이후 add한다
			while (stack.get(stack.size()-1).equals("+") || stack.get(stack.size()-1).equals("-")  || stack.get(stack.size()-1).equals("*")  || stack.get(stack.size()-1).equals("/")){
				result = result+stack.get(stack.size()-1);
				stack.remove(stack.size()-1);
			}
			stack.add(input);
		} else if (input.equals("*") || input.equals("/")){	
		//*나 /를 만났을 때, stack의 peek에 동등연산자가 존재한다면 계속 pop한다.
			while (stack.get(stack.size()-1).equals("*") || stack.get(stack.size()-1).equals("/")) {
				result = result+stack.get(stack.size()-1);
				stack.remove(stack.size()-1);
			}
			stack.add(input);
		} else if (input.equals("(")) {
			stack.add(input);
		} else if (input.equals(")")){
			//)를 만나면 (를 만날때까지 stack 쌓여있는 연산자를 모두 뱉어낸다.
			while (!(stack.get(stack.size()-1).equals("("))) {
				result = result+stack.get(stack.size()-1);
				stack.remove(stack.size()-1);
			}
			//while문이 종료됐다는 것은 (를 만났다는 것이므로 (도 제거
			stack.remove(stack.size()-1);
			
		} else {
		//숫자를 만나면 그냥 출력해야한다.
			result = result+input;
		}
		
		return result;

	
	}
	
	//후위표기식 계산기
	public static List<Integer> calculator(List<Integer> stack, String input) {
		if (input.equals("*")) {
			//팝을 두번해서 그거끼리 곱한걸 다시 stack에 집어넣으면된다~
			int A = stack.get(stack.size()-1);
			stack.remove(stack.size()-1);
			int B = stack.get(stack.size()-1);
			stack.remove(stack.size()-1);
			stack.add(A*B);
		} else if (input.equals("/")) {
			int A = stack.get(stack.size()-1);
			stack.remove(stack.size()-1);
			int B = stack.get(stack.size()-1);
			stack.remove(stack.size()-1);
			stack.add(A/B);
		} else if (input.equals("+")) {
			int A = stack.get(stack.size()-1);
			stack.remove(stack.size()-1);
			int B = stack.get(stack.size()-1);
			stack.remove(stack.size()-1);
			stack.add(A+B);
		} else if (input.equals("-")) {
			int A = stack.get(stack.size()-1);
			stack.remove(stack.size()-1);
			int B = stack.get(stack.size()-1);
			stack.remove(stack.size()-1);
			stack.add(A-B);
		} else {
			stack.add(Integer.parseInt(input));
		}
		
		//변경된 스택을 갖고서 다시 연산을 해야하므로
		return stack;
		
	}

}
