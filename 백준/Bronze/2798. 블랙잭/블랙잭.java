import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String input = bf.readLine();
		String[] numst = input.split(" ");
		int[] N_M = new int[numst.length];
		for (int i = 0; i < numst.length; i++) {
			N_M[i] = Integer.parseInt(numst[i]);
		}
		
		int N = N_M[0];
		int M = N_M[1];
	
		
		
		String input2 = bf.readLine();
		String[] numst2 = input2.split(" ");
		int[] N_list = new int[numst2.length];
		for (int i = 0; i < numst2.length; i++) {
			N_list[i] = Integer.parseInt(numst2[i]);
		}
		
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N-2; i++) {
			for (int j = i+1; j < N-1; j++) {
				for (int k = j+1; k < N; k++) {
					if (N_list[i] + N_list[j] + N_list[k] <= M && N_list[i] + N_list[j] + N_list[k] > max) {
						max = N_list[i] + N_list[j] + N_list[k];
					}
					
				}
			}

		
		}
		
		System.out.println(max);
	}

}
