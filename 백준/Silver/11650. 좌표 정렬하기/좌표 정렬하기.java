import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] coordinates = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			
			//X좌표 입력
			coordinates[i][0] = Integer.parseInt(input[0]);
			//Y좌표 입력
			coordinates[i][1] = Integer.parseInt(input[1]);
		}
		
		Arrays.sort(coordinates, new Comparator<int[]>(){

			@Override
			public int compare(int[] c1, int[] c2) {
				if (c1[0] == c2[0]) {
					return c1[1]-c2[1];
				}
				
				return c1[0]-c2[0];
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			sb.append(coordinates[i][0]+" "+coordinates[i][1]+"\n");
		}
		
		System.out.println(sb.toString());
		
		
		
		
	}
}
