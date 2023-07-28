import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int[] sum_list = new int[10];
		int index_fin = 0;
		
		for (int n = 0; n < 10; n++) {
			
			int N = sc.nextInt();
			sum = sum + N;
			sum_list[n] = sum;
			if (sum >= 100) {
				break;
			}
			if (index_fin == 9) {
				break;
			}
			index_fin++;
		}
		
		if (index_fin == 0) {
			System.out.println(sum_list[0]);
		} else {
			if (sum_list[index_fin] - 100 > 100 - sum_list[index_fin-1]) {
				System.out.println(sum_list[index_fin-1]);
			} else {
				System.out.println(sum_list[index_fin]);
			}
			
			
		}
		
		
		
		
	}
}
