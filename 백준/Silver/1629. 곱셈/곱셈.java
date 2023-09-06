import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long A =sc.nextLong();
		long B =sc.nextLong();
		long C =sc.nextLong();
		
		System.out.println(power(A,B,C));
		
	}
	
	//분할 정복을 이용하여 A*B을 C로 나눈 나머지를 출력해야한다.
	//그런데 자연수 범위상
	//C로 나누지 않은채로, 혹은 C로 나눈다고 해도 자연수를 3번연속으로 곱하면
	//long 범위 또한 초과할 수 있으므로 주의해야 한다.
	public static long power(long A, long B, long C) {
		
		if (C == 1) {
			return 0;
		}
		
		if (B == 1) {
			return A%C;
		}
		
		long temp = power(A, B/2, C);
		
		if (B%2 == 0) {
			return (temp*temp)%C;
		} else {
			return (((temp*temp)%C)*(A%C))%C;
		}
		
		
	}

}
