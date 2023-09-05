package BOJ_1789_수들의합;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long S = sc.nextLong();
		
		
		//S = 1 <- 1개
		//S = 2 <- 1개
		//2*S보다 커지는 순간 그 순간 바로 앞의 부분이 성립할 때를 찾아주는 것이기 때문에
		//2*S보다 작거나 같을 때 while문을 돌려줘야 한다.
		//while문의 부등호에 등호를 겹쳐서 줘야 한다.
		
		//S = 3 <- 2개 // 잘 작동
		long N = 1;
		while (N*(N+1) <= 2*S ) {
			N++;
		}
		
		System.out.println(N-1);
		
		
		
	}

}
