package BOJ_10974_모든순열;

import java.util.*;

public class Main {
	
	static int[] nums;
	static int N;
	static int R;
	static List<int[]> list;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//입력값
		N = sc.nextInt();
		nums = new int[N];
		list = new ArrayList<>();
		R = 3;
		//1~N까지 할당
		for (int i = 0; i < N; i++) {
			nums[i] = i+1;
		}
		
		perm(0);
		
		System.out.println(list.size());
		
		for (int[] tmp : list) {
			System.out.println(Arrays.toString(tmp));
		}
		
		
	}
	
	//
	public static void perm(int idx) {
		
		if (idx == N) {
			
			int[] tmp = new int[N];
			tmp = nums.clone();
			list.add(tmp);
			return;
		}
		
		for (int i = idx; i < N; i++) {
			swap(i, idx);
			perm(idx+1);
			swap(i, idx);
		}
		
		
	}
	
	public static void swap (int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
	
	public static void combi(int idx) {
		
	}
	
	
	
	
}
