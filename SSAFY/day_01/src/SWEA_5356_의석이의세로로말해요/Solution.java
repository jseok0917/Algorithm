package SWEA_5356_의석이의세로로말해요;

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		
		String[][] grd = new String[5][15];
		
		for (int i = 0; i < 5; i++) {
			
			String input = sc.nextLine();
			
			for (int j = 0; j < input.length(); j++) {
				
				grd[i][j] = input.substring(j, j+1);
				
				
			}
			
		}
		
		
	
		
		
		
		for (int i = 0; i < 15; i++) {
			
			for (int j = 0; j < 5; j++) {
				
				if (grd[j][i] != null) {
				
					System.out.print(grd[j][i]);
				}
				
			}
			
			
		}
		
		
		//검증용
//		for (int n = 0; n < 5; n++) {
//		
//			System.out.println(Arrays.toString(grd[n]));
//		}
		
		
		
	}

}
