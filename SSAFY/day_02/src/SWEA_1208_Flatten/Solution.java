package SWEA_1208_Flatten;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 0; t < 10; t++) {
		
			int N = sc.nextInt();
			
			int[] boxHeight = new int[100];
			
			for (int i = 0; i < 100; i++) {
				
				int num = sc.nextInt();
				
				boxHeight[i] = num;
				
			}
			
			
			int[] sortHeight  = new int[100];
			sortHeight = sortArray(boxHeight);
			int diff = sortHeight[99]-sortHeight[0];
			
			for (int i = 0; i < N; i++) {
				
				
				if (diff == 0) {
					break;
				} else {
					sortHeight[99] = sortHeight[99]-1;
					sortHeight[0] = sortHeight[0]+1;
				}
				
				sortHeight = sortArray(sortHeight);
				diff = sortHeight[99] - sortHeight[0];
						
//				System.out.print(diff+" ");
				
			}
			
			System.out.println("#"+(t+1)+" "+diff);
			
		}
		
		
		
		
		
	}
	
	
	//카운트 정렬을 메서드로 정의
	public static int[] sortArray(int[] arr) {
		
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		
		int N = arr.length;
		
		int[] count = new int[max+1];
		
		//각 숫자별로 카운팅을 해준다
		for (int i = 0; i < arr.length; i++) {	
			count[arr[i]]++;
			
		}
		
		//안정정렬 구현
		//인덱스를 구하기위한 sum 구하기
		for (int i = 1; i < max+1; i++) {
			count[i] += count[i-1];	
		}
		
		int[] result = new int[N];
		
		//뒤에서부터 정렬
		for (int i = N-1; i >= 0; i--) {
			result[--count[arr[i]]] = arr[i];

		}
		
		return result;
		
		
		
		
		
		
	}
	
	
	

}
