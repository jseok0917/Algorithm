package SWEA_5356_의석이의세로로말해요;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
				
		for (int t = 0; t < T; t++) {

			String[][] grd = new String[5][15];
			
			for (int i = 0; i < 5; i++) {
				
				String input = br.readLine();
				
				for (int j = 0; j < input.length(); j++) {
					
					grd[i][j] = input.substring(j, j+1);
					
					
				}
				
			}
			
			
			
			
			System.out.print("#"+(t+1)+" ");
			
			for (int i = 0; i < 15; i++) {
				
				for (int j = 0; j < 5; j++) {
					
					if (grd[j][i] != null) {
					
						System.out.print(grd[j][i]);
					}
					
				}
				
				
			}
			
			System.out.println("\n");
		
		
		}
		
	}

}
