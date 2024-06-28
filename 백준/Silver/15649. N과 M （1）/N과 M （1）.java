import java.util.*;
import java.io.*;

public class Main {
	
	public static int N;
	public static int M;
	public static int[] nums;
	public static int[] results;
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		visited = new boolean[N];
		results = new int[M];
		
		//순열을 구할 배열
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = i+1;
		}
		
		permutation(0, visited);
//		System.out.println(idx);
		
	}
	
	static boolean[] visited;
	static int idx = 0;
	
	//depth는 뽑은 개수
	static void permutation(int depth, boolean[] visited) {
		
		if (depth == M) {
			
			for (int i : results) {
				System.out.print(i + " ");
			}
			System.out.print("\n");
			return;
		} else {
			for (int i = 0; i < N; i++) {
				//이미 뽑은거면 스킵(중복순열 아니니까)
				if (visited[i]) {
					continue;
				}
				int tmp = results[depth];
				
				visited[i] = true;
				results[depth] = nums[i];
				permutation(depth+1, visited);
				visited[i] = false;
//				results[depth] = tmp; //어차피 덮어씌워져서 이게 없어도 순열은 잘 작동
			}
		}
	}
	

}
