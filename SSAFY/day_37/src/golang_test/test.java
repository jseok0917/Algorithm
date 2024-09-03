package golang_test;

public class test {
	
	public static void main(String[] args) {
		
		int sum = 1;
		int sum2 = 1;
		
		for (; sum < 1000;) {
			sum += sum;
		}
		
		while (sum2 < 1000) {
			sum2 += sum2;
		}
		
		System.out.println(sum);
		System.out.println(sum2);
		System.out.printf("%d\n", sum);
		
	}

}
