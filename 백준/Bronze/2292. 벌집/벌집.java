import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long N = sc.nextInt();
		
		for (long n = 2;;n++) {
			if (N == 1) {
				System.out.println(1);
				break;
			} else if (3*(n-1)*(n-2)+1 < N && N <= 3*n*(n-1)+1) {
				System.out.println(n);
				break;
			}
			
			
		}
		
	}

}
