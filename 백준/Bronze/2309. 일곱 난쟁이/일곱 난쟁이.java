import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] height = new int[9];
		for (int i = 0; i < 9; i++) {
			int h = sc.nextInt();
			height[i] = h;
		}
		
		int sum = 0;
		
		for (int i = 0; i < 9; i++) {
			sum = sum + height[i];
		}
		
		int[] remove = new int[2];
		
		
	f1:	for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - height[i] - height[j] == 100) {
					remove[0] = i;
					remove[1] = j;
					break f1;
				}
				
			}
		}
		
		height[remove[0]] = 0;
		height[remove[1]] = 0;
		
		Arrays.sort(height);
		
		for (int i = 2; i < 9; i++) {
			System.out.println(height[i]);
		}
		
		
		
		
		
	}
}
